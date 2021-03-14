package todolistmaster;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


/***
 This is where all the messages to be displayed, user command, command validation will occur.
 Everything related to scanner will also be in this Class. In other words this class is the central interface between
 the user and the command execution*/

// TODO loop the app and allow for adding tasks, editing, etc. without crashing. See method #printmenu

public class UserInterface
{

    // global variables
    private Scanner scanner = new Scanner(System.in);

    // Object of type 'TaskList'. TaskList is an ArrayList that holds the Task objects.
    private TaskList todolist = new TaskList();


    public void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to ToDoLy");

    }


    public void printStatus()
    {
        System.out.println("You have " + todolist.countOpenTask() + " tasks todo and " + todolist.countClosedTask() + " tasks are done!");

    }


    public int printMenu() {
        System.out.println("Pick an option:");

        // All options except "edit" returns to the main menu after execution
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove) or return to Main Menu");
        System.out.println("(4) Save and Quit");

        // this method connects  to the one below
        int userOption = validateInt(1,4);

        // todo: why this is returning userOption?
        return userOption;
    }


    public void printBye()
    {
        // TODO connect to file handler - to savefile
        // do i need to close all scanners here?
        System.out.println("See you later alligator!");
    }


    public void showTask(int userOption)
    {

        if (userOption == 1) {

            System.out.println("in ShowTask");

            // should print the list in default order
            if (todolist.showTaskListWithoutIndex() == 0) {
                System.out.println("The list is empty, nothing to show");
                printMenu();
            }
            // if showTaskList() != 0
            // execute the showTaskList code then show more sorting options
            System.out.println("Type (1) to sort by due date or (2) to sort alphabetically by project");

            // scanner to take in useroption - WORKS
            userOption = validateInt(1, 2);

            // todo: some obscure error here, scanner doesnt reconize int 1 or 2 when passed to the list
            // userOption = Integer.parseInt(scanner.nextLine());

            todolist.Sort(userOption);

        }

    }


    public void addTask(int userOption)
    {


        if (userOption == 2)
        {

            System.out.println("Write a title for your task:");
            String title = (scanner.nextLine());

            System.out.println("Write a date in format DD/MM/YYYY for your task");
            LocalDate date1 = validateDate();

            System.out.println("Write a Project for your task:");
            String project = (scanner.nextLine());

            // instantiate Task with constructor
            Task newTask = new Task(title, date1, project);
            System.out.println(newTask.toString());
            todolist.addToList(newTask);

            System.out.println("Task successfully saved to list");

            printStatus();

        }
    }


    public LocalDate validateDate() {

        /** Validates the date inserted by user, transforms to LocalDate type and passes to the
         * @param: date1 */

        String dueDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = null;
        boolean success = true;
        while (success) {

            try {
                dueDate = (scanner.nextLine());
                date1 = LocalDate.parse(dueDate, formatter);
                success = false;

            } catch (DateTimeParseException e) {
                System.out.println("The value for date, month or year is invalid");
            }
        }
        return date1;
    }


    public void editTaskMenu() {

        // Step 1. display tasks
        // Step 2. ask user to type number of task she wants to edit
        todolist.displayTaskWithIndex();
        System.out.println("Pick the number representing the task you want to edit: ");

        // Step 3. ask user to select what to edit (mark as done, remove or update field) or return to main menu

        // get the task;
        int taskIndex = validateInt(1, todolist.maxSize()) - 1;
        // Add a new validate for here for the Editing options below

        // Review if this 'call' actually works
        //Task taskToEdit = todolist.getTaskAtIndex(taskIndex)

        // or this?
        //todolist.getTask();

        System.out.println("Pick an editing option: ");
        System.out.println("(1) Mark as done");
        System.out.println("(2) Remove");
        System.out.println("(3) Update field");
        System.out.println("(4) Changed my mind, return to Main Menu");

        // TODO create a switch that connects to the other methods below
        // int userOption = 1;
        // switch
        //  todolist.markasDone(taskToEdit);
            // removeTask()
            // ...

    }
// can go to the TaskList Class (or can stay here as well)
    public void markDone() {
        // change setStatus to false
        // (?) re-add the task to the array: JUST CHANGING STATUS
       // go back to Main Menu
       //...
    }

    // can go to the TaskList Class
    public void removeTask() {
        // take the task
        // remove from Array
        // go back to the main menu

    }

    public void updateField(){
        // take the test
        // Update field

            // print "select which field to edit"
            // print "enter new value"
            // substitute the value
            // (?) re-add the task to the Array: JUST CHANGING THE STATUS
            // print "change sucessfull"
            // go back to Welcome

    }
/**
Validates user input based on dynamic min and max int. It also catches exception if the int input is not valid/within the available range.
 @param min: min integer of a set of options displayed to user
 @param max: max integer of a set of options displayed to user
 */

// i should create one for each type. ValidateInt for user options. I need a validateString for ???
    public int validateInt(int min, int max)
    {
        while(true)
        {
            try
            {
                int userInput = Integer.parseInt(scanner.nextLine());

                if (userInput < min) {
                    System.out.println("You entered a number below" + min +"Please enter a number between" + min + "-" + max + ", inclusive");
                    continue;
                }
                if (userInput > max) {
                    System.out.println("You entered a number above" + max + "Please enter a number between" + min + "-" + max + ", inclusive");
                    continue;
                }
                return userInput;
                // todo: do i need to 'exit' the while loop or this is enough?
            }
            // catch if they enter wrong number or string rather than a valid int
            catch(NumberFormatException e )
            {
                System.out.println("Format invalid. Please enter a number between" + min + "-" + max + ", inclusive");
            }
        }
    }


// TODO this is the method that will make the program run - while true: loop, false: stops looping
    public void callMethods(){
        // do while == true
        // or exit program
        boolean hasFinished = false;

        while(hasFinished)
        {
            int option = printMenu();

            switch (option)
            {
                //case 1: addTask();
                case 4:
                    System.out.println("bye");
                    // save to file
                    //System.exit(0);
                    hasFinished = true;
            }

        }

    }

    /*public void saveQuit() {
        // save to txt file
        // exit program.
        TODO - this just exists everyhting
        there are a couple ways i can exit
             // type system.exit (0)
    }*/


}

