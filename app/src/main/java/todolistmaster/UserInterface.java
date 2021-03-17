package todolistmaster;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


/***
 This is where all the messages to the user are displayed, user command and command validation are handled by this Class. In other words all methods related to scanner will be in this Class. This class is the central interface between the user and the commands validation and execution*/


public class UserInterface implements Serializable
{

    // global variables
    private static final Scanner scanner = new Scanner(System.in);

    // Object of type 'TaskList'. TaskList is a custom object of type ArrayList that holds the Task objects.
    private final TaskList collection = new TaskList();



    public void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to ToDoLy");
    }


    public void printStatus()
    {
        int[] taskCounts = collection.countTasks();
        System.out.println("You have " + taskCounts[0] + " tasks open, " + taskCounts[1] + " tasks closed.");
    }


    public int printMenu() {
        System.out.println("Pick an option:");

        // All options except "edit" returns to the main menu after execution
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (mark as done, remove, update) or return to Main Menu");
        System.out.println("(4) Save and Quit");

        // this method connects  to the one below
        return validateInt(1,4);
    }


    // ask user to select what to edit
    public void displayEditOptions()
    {
        System.out.println("Pick an editing option: ");
        System.out.println("(1) Mark as closed");
        System.out.println("(2) Remove");
        System.out.println("(3) Update field: Title");
        System.out.println("(4) Update field: Due Date");
        System.out.println("(5) Update field: Project Name");
        System.out.println("(6) Changed my mind, return to Main Menu");
    }


    public void showTask()
    {
        System.out.println("in ShowTask");

        // should print the list in default order
        if (collection.showTaskListWithoutIndex() == 0) {
            System.out.println("The list is empty, nothing to show");
            return;
        }
        // if showTaskList() != 0 executes the showTaskList method then show more sorting options
        System.out.println("Type (1) to sort by due date or (2) to sort alphabetically by project or (3) Changed my mind, return to Main Menu");

        int userOption = validateInt(1, 3);

        if (userOption == 3) {
            return;
        } else {
            collection.sort(userOption);
            System.out.println(collection.displayTaskWithIndex());
        }
    }

    /** Takes user input and adds a new task to the list*/
    public void addTask()
    {
        System.out.println("Write a title for your task:");
        String title = (scanner.nextLine());

        System.out.println("Write a date in format yyyy/MM/dd for your task");
        LocalDate date1 = getStringDateSetLocalDate();

        System.out.println("Write a Project for your task:");
        String project = (scanner.nextLine());

        // instantiate Task with constructor
        Task newTask = new Task(title, date1, project);
        System.out.println(newTask.toString());
        collection.addToList(newTask);

        System.out.println("Task successfully saved to list");
        printStatus();
    }

    /*** Validates the dateLocalDate inserted by user, transforms to LocalDate type and passes to the @param: dateLocalDate */
    public LocalDate getStringDateSetLocalDate() {

        String dueDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dateLocalDate = null;
        boolean success = true;
        while (success) {

            try {
                dueDate = (scanner.nextLine());
                dateLocalDate = LocalDate.parse(dueDate, formatter);
                success = false;

            } catch (DateTimeParseException e) {
                System.out.println("The value for is invalid. Please use the yyyy/MM/dd format.");
            }
        }
        return dateLocalDate;
    }


    /**Takes in user input and executes the edit functions: mark as done, remove, update fields (title, due date and project name)
    */
    public void editTaskMenu() {

        // display tasks
        System.out.println(collection.displayTaskWithIndex());
        System.out.println("Pick the number representing the task you want to edit: ");

        // get the index of the task after validating the user input and store in @param: taskIndex
        int taskIndex = validateInt(1, collection.maxSize()) - 1;

        // Get the Task based on the index
        Task taskToEdit = collection.getTaskAtIndex(taskIndex);
        // print the task to command line
        taskToEdit.toString();

        // ask user to select what to edit
        displayEditOptions();

        // Add a new validate for here for the Editing options below
        int editOption = validateInt(1, 6);

        // transform the input to string
        switch (editOption) {
            case 1 -> {
                taskToEdit.setStatus(true);
                System.out.println("Status updated to: " + taskToEdit.getStatusString());
            }
            case 2 -> {
                collection.removeTask(taskToEdit);
                System.out.println("Successfully removed task");
            }
            case 3 -> {
                System.out.println("Write a new title for this task");
                Scanner scanner = new Scanner(System.in);
                String newTitle = scanner.nextLine();
                taskToEdit.setTitle(newTitle);
                System.out.println("Title updated to: " + newTitle);
            }
            case 4 -> {
                System.out.println("Write a new Due Date (yyyy/MM/dd) for this task");
                LocalDate newDate = getStringDateSetLocalDate();
                taskToEdit.setDueDate(newDate);
                System.out.println("Due Date updated to: " + newDate);
            }
            case 5 -> {
                System.out.println("Write a new Project Name for this task");
                Scanner scanner1 = new Scanner(System.in);
                String newProjectName = scanner1.nextLine();
                taskToEdit.setProjectName(newProjectName);
                System.out.println("Project Name updated to: " + newProjectName);
            }
            case 6 -> printMenu();
        }
    }



/**
Validates user input based on dynamic min and max int. It also catches exception if the int input is not valid/within the available range.
 @param min: min integer of a set of options displayed to user
 @param max: max integer of a set of options displayed to user
 */

    public int validateInt(int min, int max)
    {
        while(true)
        {
            try
            {
                int userInput = Integer.parseInt(scanner.nextLine());

                if (userInput < min) {
                    System.out.println("You entered a number below" + min +"Please enter a number between" + min + "-" + max + ", inclusive");
                    System.out.println("Please try again");
                    continue;
                }
                if (userInput > max) {
                    System.out.println("You entered a number above" + max + "Please enter a number between" + min + "-" + max + ", inclusive");
                    System.out.println("Please try again");
                    continue;
                }
                return userInput;
            }
            // catch if they enter string or other wrong format rather than a valid int
            catch(NumberFormatException e )
            {
                System.out.println("Format invalid. Please enter a number between" + min + "-" + max + ", inclusive");
            }
        }
    }


    public void run() {

        boolean hasFinished = false;

        FileHandler file = new FileHandler();
        collection.list = file.readAsObject();
        printWelcome();
        printStatus();

        while(!hasFinished)
        {
            int option = printMenu();

            switch (option) {
                case 1 -> showTask();
                case 2 -> addTask();
                case 3 -> editTaskMenu();
                case 4 -> {
                    file.writeAsObject(collection.list);
                    System.out.println("Bye. See you later alligator!");
                    hasFinished = true;
                }
            }
        }
    }
}

