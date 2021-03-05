package todolistmaster;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
// Class Task mirrors one task and all its fields. Several tasks will compose a Todolist.
 All methods related to the task are listed here.
*/
public class Task {

    // attributes of one Task
    private String title;
    private LocalDate dueDate;
    private String projectName;
    private boolean taskStatus; // always start as false = "open"



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

    public static void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName(){
        return this.projectName;
    }


    public void setStatus(boolean taskStatus) {
        this.taskStatus = false;
    }

    public boolean getStatus() {
        return this.taskStatus;
    }


/** Set taks title, project and date according to user input
 * */

    public void createTask() {
        Scanner userInput = new Scanner(System.in); // create a Scanner object

        System.out.println("Write a title for your task:"); // print instruction on terminal
        setTitle(userInput.nextLine()); // capture the user input and set to variable title

        System.out.println("Write a Project for your task:");
        setProjectName(userInput.nextLine());

        System.out.println("Write a date in format YYYY-MM-DD for your task");
        setDueDate(LocalDate.parse(userInput.nextLine()));
    }

    public String toString() {

        return "Title: " + getTitle() + "Project: " + getProjectName() + "Due date: " + getDueDate() + "Status: " + getStatus();

    }
}