package todolistmaster;
import java.io.Serializable;
import java.util.*;


/**
 This class represent a list of tasks. All methods related to manipulation of the list should be here: remove task from the list, add new task to the list, sort tasks in the list per project and per date
*/



public class TaskList implements Serializable {

    // ArrayList to hold collection of tasks
    ArrayList<Task> list = new ArrayList<>();


    /** Adds a new task to the ArrayList */
    public void addToList(Task task) {
        list.add(task);
    }



    /** Checks if list is empty, if yes returns 0, else returns 1 */
    public int showTaskListWithoutIndex()
    {
        // for all items in the list, loop
        if (list.size() == 0) {
            return 0;
        }
        for (Task task : list)
        {
            System.out.println(task);
        }
        return 1;
    }


    /** Retrieves user selection and sorts the list according to user choice and delegates the sorting function to the TaskComparator Class. List can be sorted by due date or project name. */
    public void sort(int sortSelection)
    {
        TaskComparator comp = new TaskComparator('d');

        if (sortSelection == 2) {
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


    public Task getTaskAtIndex(int taskIndex) {

        Task taskToEdit;
        taskToEdit = list.get(taskIndex);
        return taskToEdit;

    }


    /** Count total of tasks open that will be updated as the users interacts with the app*/
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
