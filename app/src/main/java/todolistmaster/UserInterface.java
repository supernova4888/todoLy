package todolistmaster;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


/***
 This is where all the messages to be displayed, user command, command validation will occur.
 Everything related to scanner will also be in this Class. In other words this class is the central interface between
 the user and the command execution*/

// TODO loop the app and allow for adding tasks, editing, etc. without crashing. See method #printmenu

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
        // todo fix this to the new method in TaskList
        int [] taskCounts = collection.countTasks();
        System.out.println("You have " + taskCounts[0] + " tasks open, " + taskCounts[1] + " tasks closed.");
                //+ " tasks to-do and " + todolist.countClosedTask() + " tasks are done!");

    }


    public int printMenu() {
        System.out.println("Pick an option:");

        // All options except "edit" returns to the main menu after execution
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove) or return to Main Menu");
        System.out.println("(4) Save and Quit");

        // this method connects  to the one below
        return validateInt(1,4);
    }



    public void showTask()
    {
        System.out.println("in ShowTask");

        // should print the list in default order
        if (collection.showTaskListWithoutIndex() == 0) {
            System.out.println("The list is empty, nothing to show");
            return;
        }
        // if showTaskList() != 0
        // execute the showTaskList code then show more sorting options
        System.out.println("Type (1) to sort by due date or (2) to sort alphabetically by project or (3) Changed my mind, return to Main Menu");

        int userOption = validateInt(1, 3);

        if (userOption == 3) {
            return;
        } else {
            collection.sort(userOption);
            System.out.println(collection.displayTaskWithIndex());
        }
    }


    public void addTask()
    {

        System.out.println("Write a title for your task:");
        String title = (scanner.nextLine());

        System.out.println("Write a date in format DD/MM/YYYY for your task");
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


    public LocalDate getStringDateSetLocalDate() {

    // Validates the dateLocalDate inserted by user, transforms to LocalDate type and passes to the @param: dateLocalDate */

        String dueDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateLocalDate = null;
        boolean success = true;
        while (success) {

            try {
                dueDate = (scanner.nextLine());
                dateLocalDate = LocalDate.parse(dueDate, formatter);
                success = false;

            } catch (DateTimeParseException e) {
                System.out.println("The value for dateLocalDate, month or year is invalid");
            }
        }
        return dateLocalDate;
    }

    public void editTaskMenu() {

        // Step 1. display tasks
        System.out.println(collection.displayTaskWithIndex());
        // Step 2. ask user to type number of task she wants to edit
        System.out.println("Pick the number representing the task you want to edit: ");

        // get the index of the task after validating the user input and store in @param: taskIndex
        int taskIndex = validateInt(1, collection.maxSize()) - 1;

        // Get the Task based on the index
        Task taskToEdit = collection.getTaskAtIndex(taskIndex);
        // print the task to command line
        taskToEdit.toString();

        // ask user to select what to edit (mark as done, remove or update field) or return to main menu
        System.out.println("Pick an editing option: ");
        System.out.println("(1) Mark as closed");
        System.out.println("(2) Remove");
        System.out.println("(3) Update field - Title -");
        System.out.println("(4) Update field - Due Date -");
        System.out.println("(5) Update field - Project Name -");
        System.out.println("(6) Changed my mind, return to Main Menu");


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
                System.out.println("Write a new Due Date for this task");
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

// i should create one for each type. ValidateInt for user options. I need a validateString for ???
    public int validateInt(int min, int max)
    {
        while(true)
        {
            try
            {
                int userInput = Integer.parseInt(scanner.nextLine());

                if (userInput < min) {
                    System.out.println("You entered a number below" + min +"Please enter a number between" + min + "-" + max + ", inclusive");
                    continue;
                }
                if (userInput > max) {
                    System.out.println("You entered a number above" + max + "Please enter a number between" + min + "-" + max + ", inclusive");
                    continue;
                }
                return userInput;
                // todo: do i need to 'exit' the while loop or this is enough?
            }
            // catch if they enter wrong number or string rather than a valid int
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
                    //Todo file handler is saving and then reading correctly. Only the counter is not working.

                    file.writeAsObject(collection.list);
                    System.out.println("Bye. See you later alligator!");
                    hasFinished = true;
                }
            }

        }

    }
}

