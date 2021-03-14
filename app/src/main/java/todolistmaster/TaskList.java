package todolistmaster;
import java.io.Serializable;
import java.util.*;


/**
 This class represent a collection of tasks (list). All methods related to manipulation of the list should be here: remove task from an ArrayList, add new task to the list, sort tasks in the list per project and per date
*/

// TODO need to continue working on structuring this class.

public class TaskList implements Serializable {

    // ArrayList to hold collection of tasks
    ArrayList<Task> list = new ArrayList<>();


    /** Adds a new task to the ArrayList */
    public void addToList(Task task) {
        list.add(task);
    }


    public int showTaskListWithoutIndex()
    {
        // for all items in the list, loop
        System.out.println("in showTaskList");

        if (list.size() == 0) {
            return 0;
        }
        for (Task task : list)
        {
            System.out.println(task);
        }
        return 1;
    }


    public void sort(int x)
    {
        TaskComparator comp = new TaskComparator('d');

        if (x == 2) {
            comp = new TaskComparator('p');
        }
        Collections.sort(list, comp);
    }


    /**
    Append a number to each task and returns all tasks in the list
    */
    public String displayTaskWithIndex() {

        //@param counter: ordered number to represent each task
        StringBuilder stringBuilder = new StringBuilder();

        if (list.size() == 0) {
            return "Your task list is empty";
        } else
            {
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append("\n (" + (i+1) + ") " + list.get(i)); }
            return stringBuilder.toString();
        }
    }

    // todo: NEW 14/march, needs to be checked
    public Task getTaskAtIndex(int taskIndex) {

        Task taskToEdit;
        taskToEdit = list.get(taskIndex);
        return taskToEdit;

    }



    /** Count total of tasks open that will be updated as the users interacts with the app*/

    //todo: check if this is incorporated correctly in the count tasks menu (and after each user interaction)
    public int[] countTasks()
    {
        // 'open' Task = false : All tasks are created with 'open' status
        // 'closed' Task = true
        int countOpenTasks = 0;
        int countClosedTasks = 0;
        for (Task task : list) {
            if (!task.getStatusAsBoolean()) {
                countOpenTasks = countOpenTasks + 1;
            } else
                countClosedTasks++;
        }
        int[] totalTaskCount = {countOpenTasks, countClosedTasks};
        return totalTaskCount;
    }


    public int maxSize() {
        return list.size();
    }


    public void removeTask(Task t) {
        list.remove(t);
    }
}
