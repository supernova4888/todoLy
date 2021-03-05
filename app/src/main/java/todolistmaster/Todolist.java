package todolistmaster;
import java.util.ArrayList;
import java.util.Scanner;

/**
Saves taks into an Arraylist (adds)
removes task from an Arraylist
displays the commands related to the todolist app
validate commands against pre-defined list and calls the other methods above
*/


public class Todolist {


    Integer userOption;
    ArrayList<Task> listOfTasks = new ArrayList<>();

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

    public void setUserCommand(Integer userOption) {
        userOption = scanner.nextInt();
    }


    public int getUserCommand(Integer userOption) {
        // if loop validating user command as well as connecting to the appropriate course of action
        // if command invalid then display error and call method printWelcome again }
        return this.userOption = userOption;

    }


    public void isNumber(Integer userOption) {


        // pass value to @userOption param if the value is an int
        // AND the value is between 1-4
        // do an array
        while (scanner.hasNextInt() &&

         // pull the .value method to check if nr is between 1-4.
        }

        // careful with opening and closing the scanner. Keep track of all scanners that i opened.
        // perhaps encapsulating into a class.
        scanner.close(); //why close?


    }

    public void processUserCommand() {
        if (userOption == 1) {
            showTaskList();
        } else if (userOption == 2) {
            addTaskToArrayList();
        } else if (userOption == 3) {
            break //method to come
        } else if (userOption == 4) {
            // call save and quit //method to come
        } else {
            break
        }
    }

    public void showTaskList() {
        System.out.println(listOfTasks);

    }


    // Create a task
    public void addTaskToArrayList() {
        Task t = new Task;
        t.createTask();

        listOfTasks.add(t);

    }

    public void removeTaskfromArrayList() {
        // display array
        // select task by writing the id ?
        // remove id which removes the entire task

    }

}











}
