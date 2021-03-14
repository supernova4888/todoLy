package todolistmaster;
import java.util.Comparator;

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
        // check if it can be excluded later
        System.out.println("retuning the default based on title");
        return t1.getTitle().toLowerCase().compareTo(t2.getTitle().toLowerCase());

    }




}
