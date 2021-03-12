package todolistmaster;
import java.util.ArrayList;
import java.util.Collections;
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


    public int printWelcome() {
        System.out.println();
        System.out.println("Welcome to ToDoLy");
        System.out.println("You have " + "X - placeholder" + "tasks todo and " + "Y - placeholder" + "tasks are done!");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");

        // opt 2
        //int x = Integer.parseInt(scanner.nextLine()); // I am happy -> throw an exception ParseException

        // opt1
        // int userOption = scanner.nextInt(); //2     - the problem here is the empty line    //   2\n   t1
        //scanner.nextLine();

        //opt3:
        int userOption = validateInt(1, 4); // this method connects to the one below

    }

    public void showTask()
    {
        todolist.Sort();
    }


    public void addTask(int userOption)
    {
        this.userOption = userOption;
        if (userOption == 2)
        {
            System.out.println("Write a title for your task:"); // print instruction on terminal
            String title = (scanner.nextLine()); // capture the user input and set to variable title

            System.out.println("Write a date in format YYYY-MM-DD for your task");
            String dueDate = (scanner.nextLine());

            System.out.println("Write a Project for your task:");
            String project = (scanner.nextLine());

           Task newTask = new Task(title, dueDate, project);
           todolist.addToList(newTask);
           System.out.println("Task successfully saved to list");

           // TODO update count of the tasks and update printWelcome
           printWelcome();

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
        // userOption = validateInt(Collections.min(), todolist.getOneTask())
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



// i should create one for each type. ValidateInt for user options. I can have a validateString.
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

