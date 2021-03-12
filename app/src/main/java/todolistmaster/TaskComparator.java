package todolistmaster;
import java.util.Comparator;

public class TaskComparator implements Comparator<Task>
{

    private char type;

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

                // TODO fix the date issue;
                Integer date1 = t1.getDueDate();
                Integer date2 = t2.getDueDate();

                return date1.compareTo(date2);
                break;

            case 'p':
                return t1.getProjectName().toUpperCase().compareTo(t2.getProjectName().toUpperCase());
                break;

        }
        return 0;
    }

}
