package todolistmaster;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 This class represent a collection of tasks (list). All methods related to manipulation of the list should be here: remove task from an ArrayList, add new task to the list, sort tasks in the list per project and per date
*/

// TODO need to continue working on structuring this class.

public class TaskList implements Serializable {

    Task oneTask = new Task();

    // ArrayList to hold collection of tasks
    ArrayList<Task> todolist2 = new ArrayList<>();


    public ArrayList<Task> getTodolist2() {
        return todolist2;
    }
// TODO this thing is not working
    public int getFirstTask() {
        return todolist2.get(0);
    }

    public int getLastTask() {
        return todolist2.size(-1);
    }


    public void addToList(Task task) {

        todolist2.add(oneTask);
    }

    public void showTaskList(ArrayList<Task> list) {

        System.out.println(todolist2);

    }

    public void Sort()
    {

        System.out.println("Type (1) to sort by due date or (2) to sort alphabetically by project");
        int x = 1;

        switch(x)
        {
            case 1: // sort by duedate
                sort(new TaskComparator('d'));
                break;
            case 2: // sort by project name
                sort(new TaskComparator('p'));
                break;
                // TODO why cant i call printwelcome?
        }
    }

    public void sort(Comparator<Task> c)
    {
        Collections.sort(todolist2, c);

    }


    /*public void counter();
    {
     // update the count of tasks.
    }*/

    public void displayTask()
    {
        int counter = 1;

        for (int i = 0; i < todolist2.size() ; i++)
        {
            System.out.println(counter + " " + todolist2.get(i));
            counter++;
        }
    }

    public Task getOneTask() {
        return oneTask;
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

**/