package todolistmaster;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
// Class Task represents one task and all its fields. Several tasks will compose an ArrayList, which is in the Todolist class
 All methods related to the task belong here: create task, change fields, convert a task with all its fields to string
*/
public class Task implements Serializable {

    // attributes of one Task
    private String title;
    private String dueDate;
    private String projectName;
    private boolean taskStatus;

    public Task(){}

    public Task(String title, String dueDate, String projectName, boolean taskStatus) {
        this.title = title;
        this.dueDate = dueDate;
        this.projectName = projectName;
        this.taskStatus = false; // start a new task as false, as its always 'open'
    }

// Define getters & setters for each attribute

    public String setTitle(String title) {
        return this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    // TODO check how it works with the date
    public String setDueDate(String dueDate) {

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //return this.dueDate = LocalDate.parseDueDat(dueDate, formatter);
        return this.dueDate = dueDate;

    }

    public String getDueDate(){
        return this.dueDate;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName(){
        return this.projectName;
    }


    public void setStatus(boolean taskStatus) {
       this.taskStatus = taskStatus;
//        if (taskStatus.equals( "true")) {
//            open = Boolean.toString(true);
//        } else if (taskStatus = false) {
//            closed = Boolean.toString(false);
//        } else {
//           System.out.println("Task status not assigned");
//        }
    }

    public boolean getStatus() {
        return taskStatus;
    }


    public String toString() {

        return "Title:" + getTitle() + " Project:" + getProjectName() + " Due date: " + getDueDate() + " Status:" + getStatus();

    }
}