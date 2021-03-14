package todolistmaster;
import java.io.Serializable;
import java.util.*;


/**
 This class represent a collection of tasks (list). All methods related to manipulation of the list should be here: remove task from an ArrayList, add new task to the list, sort tasks in the list per project and per date
*/

// TODO need to continue working on structuring this class.

public class TaskList implements Serializable {

    // ArrayList to hold collection of tasks
    ArrayList<Task> todolist2 = new ArrayList<>();


// changed to void. Before: ArrayList
    public void getTodolist2() {
        System.out.println(todolist2);
        //return todolist2;
    }

    /** Adds a new task to the ArrayList */
    public void addToList(Task task) {
        todolist2.add(task);
    }


    public int showTaskListWithoutIndex()
    {
        // for all items in the list, loop
        System.out.println("in showTaskList");

        if (todolist2.size() == 0) {
            return 0;
        }
        for (Task task : todolist2)
        {
            System.out.println(task);
        }
        return 1;
    }


    public void Sort(int x)
    {

        switch(x) {
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


    /**
    Append a number to each task and returns all tasks in the list
    */
    public String displayTaskWithIndex() {

        //@param counter: ordered number to represent each task
        StringBuilder stringBuilder = new StringBuilder();

        if (todolist2.size() == 0) {
            return "Your task list is empty";
        } else
            {
            for (int i = 0; i < todolist2.size(); i++) {
                stringBuilder.append("\n (" + (i+1) + ") " + todolist2.get(i));
                // System.out.println(counter + "- " + todolist2.get(i));
            }
            return stringBuilder.toString();
        }
    }


    /** Count total of tasks open that will be updated as the users interacts with the app*/

    public int[] countTasks()
    {
        // 'open' Task = false : All tasks are created with 'open' status
        // 'closed' Task = true
        int countOpenTasks = 0;
        int countClosedTasks = 0;
        for (int i = 0; i < todolist2.size(); i++){
            if (todolist2.get(i).getStatus() == false) {
                countOpenTasks = countOpenTasks + 1;
            }
            else
                countClosedTasks++;
        }
        return new int[]{countOpenTasks, countClosedTasks};
    }

    // old format of CountOpenTask and CountClosedTask
    /*
    public int countOpenTask()
    {
        int countOpen = 0;
        for (int i = 0; i < todolist2.size(); i++){
            if (todolist2.get(i).getStatus() == false) {
                countOpen = countOpen + 1;
            }
        }
        return countOpen;
    }

    // Count total of tasks closed that will be updated as the users interacts with the app
    public int countClosedTask()
    {
        int countClosed = 0;
        for (int i = 0; i < todolist2.size(); i++){
            if (todolist2.get(i).getStatus() == true) {
                countClosed = countClosed + 1;
            }
        }
        return countClosed;
    }*/


    public int maxSize()
    {
        return todolist2.size();
    }


}

    /*public void removeTask() {

    }*/
