package todolistmaster;
import java.time.LocalDate;
import java.util.Scanner;

/**
// Class Task represents one task and all its fields. Several tasks will compose an ArrayList, which is in the Todolist class
 All methods related to the task belong here: create task, change fields, convert a task with all its fields to string
*/
public class Task {

    // attributes of one Task
    private String title;
    private LocalDate dueDate;
    private String projectName;
    private boolean taskStatus;


    // Define getters & setters for each attribute

    public String setTitle(String title) {
        return this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDate setDueDate(LocalDate dueDate) {
        return this.dueDate = dueDate;
    }

    public LocalDate getDueDate(){
        return this.dueDate;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName(){
        return this.projectName;
    }


    public String setStatus(boolean taskStatus) {
        String open;
        String closed;

        taskStatus = true;
        open = Boolean.toString(true);
        if (taskStatus = false) {
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
        setDueDate(LocalDate.parse(userInput.nextLine()));

        userInput.close();
    }

    public String toString() {

        return "Title:" + getTitle() + " Project:" + getProjectName() + " Due date: " + getDueDate() + " Status:" + getStatus();

    }
}