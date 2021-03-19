package todolistmaster;
import java.io.Serializable;
import java.time.LocalDate;

/**
// Class Task represents one task and all its fields. Several tasks will compose an ArrayList, which is represented by the TaskList custom class
 All methods related to the attributes of a task object belong here: fields, getters and setters.
*/
public class Task implements Serializable {

    // attributes of Task

    // title of a task represent a short description of the task
    private String title;
    // represents the project related to the task: personal, work, school...
    private String projectName;
    // represents the status open or closed. New tasks are created with status open by default
    private boolean taskStatus;
    // represents the due date of when the task must be completed
    private LocalDate date;


    public Task() {}

    public Task(String title, LocalDate date1, String projectName) {
        this.title = title;
        this.date = date1;
        this.projectName = projectName;
        this.taskStatus = false;
    }


    // Define getters & setters for each attribute
    public void setTitle(String title) {
        this.title = title;
    }


    public String getTitle() {
        return this.title;
    }

    public void setDueDate(LocalDate date){
        this.date = date;
    }

    public String getDueDate(){
        return date.toString();
    }


    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getProjectName(){
        return this.projectName;
    }


    public void setStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;

    }

    public String getStatusString() {
        if (taskStatus){
            return "closed";
        }
        return "open";
    }

    public boolean getStatusAsBoolean(){
        return taskStatus;
    }



    //TODO consider format for when I need to parse this data
    public String toString() {

        return "Title: " + getTitle() + ", " + "Project: " + getProjectName() + ", Due date: " + getDueDate() + ", " + "Status: " + getStatusString() + "\n";

    }
}