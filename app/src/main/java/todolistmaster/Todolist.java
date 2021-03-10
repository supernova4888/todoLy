package todolistmaster;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 This is the core of the TodoLy command-line todolist app. It is divided in two parts. The first part display instructions,
 takes and validates user input. The second part executes based on validates user input and manipulates thet tasks in the ArrayList level: remove task from an ArrayList
removes task from an Arraylist
*/

// TODO need to review this entire class. Nothing seems to be working. NEED TO SIMPLIFY STUFF HERE! REMEMBER TO MAKE THE CORE WORK.

public class Todolist implements Serializable {

    private static Scanner scanner = new Scanner(System.in);
    private static int userOption;
    private static int[] intOptions;
    ArrayList<Task> listOfTasks = new ArrayList<>();

    // TODO fix this one too
    // intOptions = new int[] {1,2,3,4};


    public static void printWelcome() {
        System.out.println();
        System.out.println("Welcome to ToDoLy");
        System.out.println("You have " + "X - placeholder" + "tasks todo and " + "Y - placeholder" + "tasks are done!");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");

        userOption = scanner.nextInt();

    }

    public static int setUserCommand() {
        return userOption = scanner.nextInt();
    }

    public int getUserCommand() {
        return this.userOption = userOption;
    }

    // TODO this doesnt work - NEED TO REVIEW
    // checks if an 'int key' such as the userCommand is within the pre-defined Array of options named intOptions (as per displayed in the printWelcome)
    public static boolean contains(int[] intOptions, final int key) {
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

    // TODO: might need to open the file
    public void showTaskList() {
        System.out.println(listOfTasks);
    }


    // Create a task
    public void addTaskToArrayList() {
        Task t = new Task();
        t.createTask();
        listOfTasks.add(t);

    }

    public void editTask() {


        // TODO is there another way of doing this?
        System.out.println("Select which task you would like to edit:");
        showTaskList();


        int taskNumber = scanner.nextInt();

        System.out.println(listOfTasks.get(taskNumber - 1));
        System.out.println("Select which field you would like to edit:");
        System.out.println("(1) title");
        System.out.println("(2) Due Date");
        System.out.println("(3) Project name");
        System.out.println("(4) Status");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                listOfTasks.get(taskNumber - 1).setTitle(scanner.nextLine());
                break;
            case 2:
                listOfTasks.get(taskNumber - 1).setDueDate(scanner.nextLine()); // have to fix this later - Date issue
                break;
            case 3:
                listOfTasks.get(taskNumber - 1).setProjectName(scanner.nextLine());
                break;
            case 4:
                listOfTasks.get(taskNumber - 1).setStatus(scanner.nextBoolean()); //db if this actually works
                break;
        }
    }


    public void saveQuit() {
        // save to txt file
        // exit program. What does exit program means? TODO ask TA's

    }

}

