package todolistmaster;
import java.io.Serializable;
import java.util.*;


/**
 This class represent a collection of tasks (list). All methods related to manipulation of the list should be here: remove task from an ArrayList, add new task to the list, sort tasks in the list per project and per date
*/

// TODO need to continue working on structuring this class.

public class TaskList implements Serializable {

    Task oneTask = new Task();
    // ArrayList to hold collection of tasks
    ArrayList<Task> todolist2 = new ArrayList<>();


// changed to void. Before: ArrayList
    public void getTodolist2() {
        System.out.println(todolist2);
        //return todolist2;
    }


    public void addToList(Task task) {
        todolist2.add(oneTask);
        // TODO do i really need this counter to be here?
        countOpenTask();
        countClosedTask();
        System.out.println(todolist2);
    }


    public void showTaskList()
    {
        // for all items in the list, loop
        System.out.println("in showTaskList");

        for (int i = 0; i < todolist2.size(); i++){
            // print the Task details
            oneTask.toString();
            // print a new line
            System.out.println();
        }

    }


    public void Sort(int x)
    {

        x = 0;

        switch(x)
        {
            case 1: // sort by duedate
                sort(new TaskComparator('d'));
                break;
            case 2: // sort by project name
                sort(new TaskComparator('p'));
                break;
                // TODO why cant i call printwelcome?
            // ? create default , in case user changes his mind?
        }
    }

    public void sort(Comparator<Task> c)
    {
        Collections.sort(todolist2, c);

    }



    public void displayTask()
    {
        //@param counter: ordered number to represent each task
        int counter = 1;

        for (int i = 0; i < todolist2.size() ; i++)
        {
            System.out.println(counter + "- " + todolist2.get(i));
            System.out.println();
            counter++;
        }
    }


    public Task getOneTask() {
        return oneTask;
    }


    public int countOpenTask()
    {
        int countOpen = 0;
        for (int i = 0; i < todolist2.size(); i++){
            if (oneTask.getStatus() == false) {
                countOpen = countOpen + 1;
            }
        }
        return countOpen;
    }


    public int countClosedTask()
    {
        int countClosed = 0;
        for (int i = 0; i < todolist2.size(); i++){
            if (oneTask.getStatus() == true) {
                countClosed = countClosed + 1;
            }
        }
        return countClosed;
    }



}



    /*public void removeTask() {

    }

    public void saveQuit() {
        // save to txt file
        // exit program. What does exit program means? TODO ask TA's

**/