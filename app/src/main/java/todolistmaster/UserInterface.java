package todolistmaster;
import java.text.ParseException;
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

    // ArrayList<Task> listOfTasks = new ArrayList<>();

    public void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to ToDoLy");
    }

    public void printStatus()
    {
        System.out.println("You have " + todolist.countOpenTask() + "tasks todo and " + todolist.countClosedTask() + "tasks are done!");

    }

    public void printMenu() {
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");

        // this method connects  to the one below
        int userOption = validateInt(1, 4);

    }


    public void printBye()
    {
        // TODO
        // connect to file handler - to savefile
        // do i need to close all scanners here?
        System.out.println("See you later alligator!");
    }


    public void showTask()
    {
        todolist.Sort();
    }


    public void addTask(int userOption)
    {
        String dueDate = "";
        this.userOption = userOption;

        if (userOption == 2)
        {
            // instantiate Task
            Task newTask = new Task();

            System.out.println("Write a title for your task:");
            String title = (scanner.nextLine());

            boolean success = true;
            while (success) {

                try {
                    System.out.println("Write a date in format DD/MM/YYYY for your task");
                    dueDate = (scanner.nextLine());

                    newTask.setDueDate(dueDate);
                    success = false;

                } catch (ParseException e) {
                    System.out.println("An error occurred during parsing");

                } catch (DateTimeParseException e) {
                    System.out.println("The value for date, month or year is invalid");
                }
            }

            System.out.println("Write a Project for your task:");
            String project = (scanner.nextLine());

            // call and update the Task constructor
            newTask = new Task(title, dueDate, project);


           todolist.addToList(newTask);
           System.out.println("Task successfully saved to list");

           // TODO test if open Tasks/Closed Tasks counter works.
            printStatus();
            printMenu();

        }
    }


    public void editTask()
    {
        // Step 1. display tasks
        // Step 2. ask user to select which task she wants to edit
        // Step 3. ask user to select what to edit (mark as done, remove or update field)
        todolist.displayTask();
        System.out.println("Pick the number representing the task you want to edit: ");
        // get the task;
        // find a way to find the min and max to facilitate life
        userOption = validateInt(todolist.getFirstTask(), todolist.getLastTask());
        // how to bring min int and max int
        userOption = validateInt()

        todolist.getOneTask();
        System.out.println("Pick an editing option: ");
        System.out.println("(1) Mark as done");
        System.out.println("(2) Remove");
        System.out.println("(3) Update field");




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



// i should create one for each type. ValidateInt for user options. I need a validateString for date.
    public int validateInt(int min, int max)
    {
        while(true)
        {
            try
            {
                int userOption = Integer.parseInt(scanner.nextLine());
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
            // catch if they enter a string rather than an int
            catch(NumberFormatException e )
            {
                System.out.println("Format invalid. Please enter a number between" + min + "-" + max + ", inclusive");
            }
        }
    }



}

