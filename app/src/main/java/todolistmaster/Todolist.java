package todolistmaster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 This is the core of the TodoLy command-line todolist app. It is divided in two parts. The first part display instructions,
 takes and validates user input. The second part executes based on validates user input and manipulates thet tasks in the ArrayList level: remove task from an ArrayList
removes task from an Arraylist
*/


public class Todolist {

    private int userOption;
    ArrayList<Task> listOfTasks = new ArrayList<>();
    int[] intOptions = new int[] {1,2,3,4};
    static Scanner scanner = new Scanner(System.in);

    public static void printWelcome() {
        System.out.println();
        System.out.println("Welcome to ToDoLy");
        System.out.println("You have " + "X - placeholder" + "tasks todo and " + "Y - placeholder" + "tasks are done!");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");

    }

    public int setUserCommand() {
        userOption = scanner.nextInt();
    }

    public int getUserCommand() {
        return this.userOption = userOption;
    }

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
            // processUserCommand();
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


    public ArrayList showTaskList() {
        System.out.println(listOfTasks);
    }


    // Create a task
    public void addTaskToArrayList(); {
        Task t = new Task;
        t.createTask();
        listOfTasks.add(t);

    }

    public void editTask() {
        // see paper notes
    }

    /*public void removeTaskfromArrayList() {
        // display array
        // select task by writing the id ?
        // remove id which removes the entire task

    }*/


    public void saveQuit() {
    }

}











}
