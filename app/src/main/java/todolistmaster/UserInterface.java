package todolistmaster;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/***
 This is where all the messages to be displayed, user command, command validation will occur.
 Everything related to scanner will also be in this Class. In other words this class is the central interface between
 the user and the command execution*/



public class UserInterface
{
    private Scanner scanner = new Scanner(System.in);
    TaskList todolist = new TaskList();
    private int userOption;

    // ArrayList<Task> listOfTasks = new ArrayList<>();


    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome to ToDoLy");
        System.out.println("You have " + "X - placeholder" + "tasks todo and " + "Y - placeholder" + "tasks are done!");
        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");

        // opt 2
        //int x = Integer.parseInt(scanner.nextLine()); // I am happy -> throw an exception ParseException

        // opt1
        // int userOption = scanner.nextInt(); //2     - the problem here is the empty line    //   2\n   t1
        //scanner.nextLine();

        //opt3:
        int userOption = validateInt(1, 4); // this method connects to the one below

    }

        public void addTask(int userOption) throws IOException {
            this.userOption = userOption;
            if (userOption == 2)
            {
                System.out.println("Write a title for your task:"); // print instruction on terminal
                String title = (scanner.nextLine()); // capture the user input and set to variable title

                System.out.println("Write a date in format YYYY-MM-DD for your task");
                String dueDate = (scanner.nextLine());

                System.out.println("Write a Project for your task:");
                String project = (scanner.nextLine());

               Task newTask = new Task(title, dueDate, project);
               todolist.addToList(newTask);
               System.out.println("Task successfully saved to list");

            }
        }




// i should create one for each type. ValidateInt for user options. I can have a validateString.
    public int validateInt(int min, int max)
    {
        while(true)
        {
            try
            {
                int userOption = Integer.parseInt(scanner.nextLine());
                if (userOption < min) {
                    System.out.println("You entered a number below 1. Please enter a number between 1-4, inclusive");
                    continue;
                }
                if (userOption > max) {
                    System.out.println("You entered a number above 4. Please enter a number between 1-4, inclusive");
                    continue;
                }
                return userOption;
            }
            // catch if they enter a string rather than an int
            catch(NumberFormatException e )
            {
                System.out.println("Format invalid. Please enter a number between 1-4, inclusive");
            }
        }
    }


    


}

