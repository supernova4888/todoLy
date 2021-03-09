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
        //return this.dueDate = LocalDate.parse(dueDate, formatter);
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
        String open;
        String closed;

        if (taskStatus = true) {
            open = Boolean.toString(true);
        } else if (taskStatus = false) {
            closed = Boolean.toString(false);
        } else {
           System.out.println("Task status not assigned");
        }
    }

    public boolean getStatus() {
        return taskStatus;
    }


/** Set tasks title, project and date according to user input
 * */

    public void createTask() {
        Scanner userInput = new Scanner(System.in); // create a Scanner object

        System.out.println("Write a title for your task:"); // print instruction on terminal
        setTitle(userInput.nextLine()); // capture the user input and set to variable title

        System.out.println("Write a Project for your task:");
        setProjectName(userInput.nextLine());

        System.out.println("Write a date in format YYYY-MM-DD for your task");
        setDueDate(userInput.nextLine());

        userInput.close();
    }

    public String toString() {

        return "Title:" + getTitle() + " Project:" + getProjectName() + " Due date: " + getDueDate() + " Status:" + getStatus();

    }
}