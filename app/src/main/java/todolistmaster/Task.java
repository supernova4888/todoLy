package todolistmaster;
import java.io.Serializable;
import java.time.LocalDate;

/**
// Class Task represents one task and all its fields. Several tasks will compose an ArrayList, which is in the Todolist class
 All methods related to the task belong here: create task, change fields, convert a task with all its fields to string
*/
public class Task implements Serializable {

    // attributes of one Task
    private String title;
    private String projectName;
    private boolean taskStatus;
    public LocalDate date;

    public Task() {}


    public Task(String title, LocalDate date1, String projectName) {
        this.title = title;
        // this.dueDate = dueDate;
        this.date = date1;
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

        return "Title: " + getTitle() + ", " + "Project: " + getProjectName() + ", Due date: " + getDueDate() + ", " + "Status: " + getStatusString();

    }
}