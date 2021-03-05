package todolistmaster;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

   /* Integer show = 1;
    Integer add = 2;
    Integer edit = 3;
    Integer saveQuit = 4;*/

    String userOption;



    public static void printWelcome() {
        System.out.println();
        System.out.println("Welcome to ToDoLy");
        System.out.println("You have " + "X - placeholder" + "tasks todo and " + "Y - placeholder" + "tasks are done!");
        System.out.println("Pick an option:");
        System.out.println("(" + 1 + ")" + "Show Task List (by date or project)");
        System.out.println("(" + 2 + ")"+ "Add New Task");
        System.out.println("(" + 3 + ")" + "Edit Task (update, mark as done, remove)");
        System.out.println("(" + 4 + ")" + "Save and Quit");

    }
    public void setUserCommand(String userOption) {
        Scanner userCommand = new Scanner(System.in);
        getUserCommand(userCommand.nextLine());

    }

    public String getUserCommand(String userOption) {
        // if loop validating user command as well as connecting to the appropriate course of action
        // if command invalid then display error and call method printWelcome again }
        return this.userOption = userOption;

    }


    public processUserCommand(){
        switch (userOption == "1"){
            // call method Show Task list
            // break

            // call method add new Task
            // break

            // call method edit task
            // break

            // call save and quit
            // break
        }


    }



    // Create a task
    public void addTaskToArrayList() {
        Task t = new Task;
        t.createTask();

        ArrayList<Task> listOfTasks = new ArrayList<>();
        listOfTasks.add(t);

    }

    public void removeTaskfromArrayList(){
        // display array
        // select task by writing the id ?
        // remove id which removes the entire task

    }


    public static void main(String[] args) {

        // display initial instruction of TodoLy
        printWelcome();




    }

}





