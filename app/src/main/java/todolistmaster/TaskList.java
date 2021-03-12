package todolistmaster;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 This class represent a collection of tasks (list). All methods related to manipulation of the list should be here: remove task from an ArrayList, add new task, sort tasks in the list per project and per date
*/

// TODO need to continue working on structuring this class.

public class TaskList implements Serializable {


    public void showTaskList() {
        System.out.println(listOfTasks);
    }

    public void addTasktoArrayList() {

    }


    // split this method in 2 part. The first part where it requires user command go to UserInterface Class. The second part which should be here is just 'pull' and 'saving' the task into an array.

    public void editTask() {


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


    public void removeTask() {

    }

    public void saveQuit() {
        // save to txt file
        // exit program. What does exit program means? TODO ask TA's

    }

    public void sortTaskListPerProject(){
    }

    public void sortTaskListPerDate(){

    }
}





