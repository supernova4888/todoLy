package todolistmaster;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 This class represent a collection of tasks (list). All methods related to manipulation of the list should be here: remove task from an ArrayList, add new task to the list, sort tasks in the list per project and per date
*/

// TODO need to continue working on structuring this class.

public class TaskList implements Serializable {

    Task test = new Task();

    // ArrayList to hold collection of tasks
    ArrayList<Task> todolist2;


    public void addToList(Task task) {

        todolist2.add(test);
    }

    public void showTaskList(ArrayList<Task> list) {

        System.out.println(todolist2);

    }

    // split this method in 2 part. The first part where it requires user command go to UserInterface Class. The second part which should be here is just 'pull' and 'saving' the task into an array.

    /*public void editTask() {
        System.out.println("Select which task you would like to edit:");
        showTaskList();

    }*/


    /*public void removeTask() {

    }

    public void saveQuit() {
        // save to txt file
        // exit program. What does exit program means? TODO ask TA's

    }

    public void sortTaskListPerProject(){
    }

    public void sortTaskListPerDate(){

    }*/


}

