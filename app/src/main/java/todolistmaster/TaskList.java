package todolistmaster;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


/**
 This class represent a collection of tasks (list). All methods related to manipulation of the list should be here: remove task from an ArrayList, add new task to the list, sort tasks in the list per project and per date
*/

// TODO need to continue working on structuring this class.

public class TaskList implements Serializable {

    Task test = new Task();

    // ArrayList to hold collection of tasks
    ArrayList<Task> todolist2 = new ArrayList<>();


    public void addToList(Task task) {

        todolist2.add(test);
    }

    public void showTaskList(ArrayList<Task> list) {

        System.out.println(todolist2);

    }

    public void Sort()
    {

        // get the list
        // get the 'project name'
        // sort the project per name
        System.out.println("Type 'd' to sort by due date or 'p' to sort alphabetically by project. Or type X to go back to the main menu");
        int x = 1;

        switch (x)
        {
            case 1: // sort by duedate
                sort(new TaskComparator('d'));
                break;
            case 2: // sort by project name
                sort(new TaskComparator('p'));
                break;
        }
    }

    public void sort(Comparator<Task> c)
    {
        Collections.sort(todolist2, c);

    }





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



}

