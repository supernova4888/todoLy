package todolistmaster;

import java.sql.SQLOutput;
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
        System.out.println("(" + 1 + ")" + "Show Task List (by date or project)");
        System.out.println("(" + 2 + ")" + "Add New Task");
        System.out.println("(" + 3 + ")" + "Edit Task (update, mark as done, remove)");
        System.out.println("(" + 4 + ")" + "Save and Quit");

    }

    public void setUserCommand(Integer userOption) {
        userOption = scanner.nextInt();

    }

    public int getUserCommand(Integer userOption) {
        // if loop validating user command as well as connecting to the appropriate course of action
        // if command invalid then display error and call method printWelcome again }
        return this.userOption = userOption;

    }


    public void processUserCommand() {
     //   int[] displayedOptions = {1, 2, 3, 4};
        if (userOption == 1) {
            showTaskList();
        } else if (userOption == 2) {
            addTaskToArrayList();
        } else if (userOption == 3) {
            // call method edit task
        } else if (userOption == 4) {
            // call save and quit
        } else {
            // return error and display options again
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
