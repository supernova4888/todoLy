package todolistmaster;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
// Class Task represents one task and all its fields. Several tasks will compose an ArrayList, which is in the Todolist class
 All methods related to the task belong here: create task, change fields, convert a task with all its fields to string
*/
public class Task implements Serializable {

    // attributes of one Task
    private String title;
    // TODO fix my date!!!
    private String dueDate;
    private String projectName;
    private boolean taskStatus;

    public Task(){ }

    public Task(String title, String dueDate, String projectName) {
        this.title = title;
        this.dueDate = dueDate;
        this.projectName = projectName;
        this.taskStatus = false;
    }


// Define getters & setters for each attribute

    public String setTitle(String title) {
        return this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public Date setDueDate(String dueDate) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = formatter.parse(dueDate);
        return date1;
    }

    public Date getDueDate(){
        Date date1 = new Date();
        return date1;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName(){
        return this.projectName;
    }


    public String setStatus(boolean taskStatus) {
        String status;
        this.taskStatus = taskStatus;
        if (taskStatus == true){
            return status = "closed";
        }
        return status = "open";
    }

    public boolean getStatus() {
        return taskStatus;
    }

    //TODO consider format for when I need to parse this data
    public String toString() {

        return "Title: " + getTitle() + " Project: " + getProjectName() + "Due date: " + getDueDate() + "Status: " + getStatus();

    }
}