package todolistmaster;
import java.util.Comparator;


/**
 This class executes the task sorting per project and per due date according to User Command.*/

public class TaskComparator implements Comparator<Task>
{

    private final char type;


    public TaskComparator(char type)
    {
        this.type = type;
    }

    @Override
    public int compare(Task t1, Task t2)
    {
        switch (type)
        {
            case 'd':
                return t1.getDueDate().compareTo(t2.getDueDate());
            case 'p':
                return t1.getProjectName().toLowerCase().compareTo(t2.getProjectName().toLowerCase());
        }
        System.out.println("retuning the default based on title");
        return t1.getTitle().toLowerCase().compareTo(t2.getTitle().toLowerCase());
    }

}
