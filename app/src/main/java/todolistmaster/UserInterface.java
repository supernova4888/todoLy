package todolistmaster;
import java.util.ArrayList;
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


    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome to ToDoLy");
        System.out.println("You have " + "X - placeholder" + "tasks todo and " + "Y - placeholder" + "tasks are done!");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");

        // opt 2
        int x = Integer.parseInt(scanner.nextLine()); // I am happy -> throw an exception ParseException

        // opt1
        int userOption = scanner.nextInt(); //2     - the problem here is the empty line    //   2\n   t1
        scanner.nextLine();

        //opt3:
        int y = validateInt(1, 4); // this method connects to the one below

        String z = scanner.nextLine(); // ""
        // title
        // ""
        //


        // NEW METHOD: Add Task
        if (userOption == 2)
        {
            System.out.println("Write a title for your task:"); // print instruction on terminal
            String title = (scanner.nextLine()); // capture the user input and set to variable title

            System.out.println("Write a Project for your task:");
            String project = (scanner.nextLine());

            System.out.println("Write a date in format YYYY-MM-DD for your task");
            setDueDate(userInput.nextLine());

            Task t = new Task(title, project, ...);
            todolist.add(t); //opt1
            todolist.add(title, project ,... ); // opt2 : this will call the task constructor.

        }
    }


// i should create one for each type. ValidateInt for user options. I can have a validateString.
    public int validateInt(int min, int max)
    {
        ///
        while(true)
        {
            try
            {
                int x = Integer.parseInt(scanner.nextLine());
                if (x < min) {
                    System.out.println("you enter a number that is ...");
                    continue;
                }
                return x;
            }
            catch(NumberFormatException e )
            {
                System.out.println("please enter a correct number");
            }



        }
    }


    /** Set tasks title, project and date according to user input * */

    public void createTask() {
        Scanner userInput = new Scanner(System.in); // create a Scanner object

        System.out.println("Write a title for your task:"); // print instruction on terminal
        setTitle(userInput.nextLine()); // capture the user input and set to variable title

        System.out.println("Write a Project for your task:");
        setProjectName(userInput.nextLine());

        System.out.println("Write a date in format YYYY-MM-DD for your task");
        setDueDate(userInput.nextLine());

        userInput.close();


    }




}

// TODO: check this older code and see if i can re-use some of it
// checks if an 'int key' such as the userCommand is within the pre-defined Array of options named intOptions (as per displayed in the printWelcome)
    /*public static boolean contains(int[] intOptions, final int key) {
        return Arrays.stream(intOptions).anyMatch(i -> i == key);
    }

    // if method 'contains' return false then ask for user input again. Else: process user command
    public void displayInputInvalid() {
        if (!contains(intOptions, setUserCommand())) {
            System.out.println("Invalid command, please select one of these options: (1), (2), (3), (4)");
            setUserCommand();
        } else {
            processUserCommand();
        }
    }

    private void processUserCommand() {
        if (userOption == 1) {
            showTaskList();
        } else if (userOption == 2) {
            addTaskToArrayList();
        } else if (userOption == 3) {
            editTask();
        } else if (userOption == 4) {
            saveQuit();
        }
    }