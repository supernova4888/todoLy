package todolistmaster;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


/***
 This is where all the messages to be displayed, user command, command validation will occur.
 Everything related to scanner will also be in this Class. In other words this class is the central interface between
 the user and the command execution*/



public class UserInterface
{
    private Scanner scanner = new Scanner(System.in);
    TaskList todolist = new TaskList();
    private int userOption;
    LocalDate date1;


    // ArrayList<Task> listOfTasks = new ArrayList<>();

    public void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to ToDoLy");
    }

    public void printStatus()
    {
        System.out.println("You have " + todolist.countOpenTask() + " tasks todo and " + todolist.countClosedTask() + " tasks are done!");

    }

    public void printMenu() {
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");

        // this method connects  to the one below
        userOption = validateInt(1,4);

    }


    public void printBye()
    {
        // TODO
        // connect to file handler - to savefile
        // do i need to close all scanners here?
        System.out.println("See you later alligator!");
    }


    public void showTask(int userOption)
    {

        // Step 1. print the current list of tasks (= collection)
            // this is showing position in memory. Check Task Class again
        // tried:
            //todolist.showTaskList(todolist.todolist2);
            // todolist.getTodolist2();
            // showtasklist w/o the for loop
            // showtasklist w/ for loop: it didnt return aything
            // print each object of the todolist (type tasklist)
            // last try: created internal method, call tasks, but no tasks were printed
        System.out.println("in ShowTask");


        todolist.showTaskList();

        System.out.println("Type (1) to sort by due date or (2) to sort alphabetically by project");


        // scanner to take in useroption - WORKS
        userOption = validateInt(1,2);

        // some obscure error here, scanner doesnt reconize int 1 or 2 when passed to the list
        // userOption = Integer.parseInt(scanner.nextLine());

        todolist.Sort(userOption);

    }


    public void addTask(int userOption)
    {
        String dueDate = "";
        this.userOption = userOption;

        if (userOption == 2)
        {
            // instantiate Task
            //Task newTask = new Task();

            System.out.println("Write a title for your task:");
            String title = (scanner.nextLine());

            System.out.println("Write a date in format DD/MM/YYYY for your task");
            validateDate();

            System.out.println("Write a Project for your task:");
            String project = (scanner.nextLine());

            Task newTask = new Task(title, date1, project);

            //System.out.println(newTask.toString());

            todolist.addToList(newTask);

           System.out.println("Task successfully saved to list");

           // TODO test if open Tasks/Closed Tasks counter works.
            printStatus();
            printMenu();

        }
    }

    public LocalDate validateDate() {


        // bring the date parser here from TASK
        // Loop and validation of the date inserted by user

        String dueDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        boolean success = true;
        while (success) {

            try {
                dueDate = (scanner.nextLine());
                // ** Removed type LocalDate
                date1 = LocalDate.parse(dueDate, formatter);
                success = false;

            } catch (DateTimeParseException e) {
                System.out.println("The value for date, month or year is invalid");
            }
        }
        return date1;
    }


    public void editTask()
    {
        // Step 1. display tasks
        // Step 2. ask user to select which task she wants to edit
        // Step 3. ask user to select what to edit (mark as done, remove or update field)
        todolist.displayTask();
        System.out.println("Pick the number representing the task you want to edit: ");
        // get the task;
        // how to bring min int and max int
        userOption = validateInt(1,4);

        todolist.getTask();
        System.out.println("Pick an editing option: ");
        System.out.println("(1) Mark as done");
        System.out.println("(2) Remove");
        System.out.println("(3) Update field");
        System.out.println("(4) Changed my mind, return to Main Menu");




        //    System.out.println("(3) Edit Task (update, mark as done, remove)");

        // Mark as done

            // TODO update count of the tasks and update printWelcome
            // go back to Welcome

        // Remove

            // TODO update count of the tasks and update printWelcome
            // go back to Welcome


        // Update field

            // print "select which field to edit"
            // print "enter new value"
            // substitute the value
            // print "change sucessfull"
            // go back to Welcome

    }



// i should create one for each type. ValidateInt for user options. I need a validateString for ???
    public int validateInt(int min, int max)
    {
        while(true)
        {
            try
            {
                userOption = Integer.parseInt(scanner.nextLine());
                if (userOption < min) {
                    System.out.println("You entered a number below" + min +"Please enter a number between" + min + "-" + max + ", inclusive");
                    continue;
                }
                if (userOption > max) {
                    System.out.println("You entered a number above" + max + "Please enter a number between" + min + "-" + max + ", inclusive");
                    continue;
                }
                return userOption;
            }
            // catch if they enter wrong number or string rather than a valid int
            catch(NumberFormatException e )
            {
                System.out.println("Format invalid. Please enter a number between" + min + "-" + max + ", inclusive");
            }
        }
    }



}

