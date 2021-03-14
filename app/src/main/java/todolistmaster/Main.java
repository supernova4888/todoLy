package todolistmaster;
import java.time.LocalDate;
import java.util.ArrayList;

/** This is where the program runs. This class calls the objects, instantiate and use/call methods for the todolist app execution in appropriate order
 **/

// TODO btw: what is the app package in my project?

public class Main {

    public static void main(String[] args) {

        // display initial instruction of TodoLy
        //int userOption = 0;

        UserInterface app = new UserInterface();


/*
        app.printWelcome();
        app.printStatus();
        app.printMenu();

        app.showTask(1);
        app.addTask(2);
        */

       // TaskList test = new TaskList();

        // todo re-change the global variables to private (Tasklist and LocalDate)
        Task t1 = new Task("t1,,,,,,,,,,,,,,,", LocalDate.of(2020, 10,10),"brother");
        Task t2 = new Task("duhhh", LocalDate.of(2020,05,01), "car");
        Task t3 = new Task("lala", LocalDate.of(2020, 01,01), "abc");

        app.todolist.addToList(t1);
        app.todolist.addToList(t2);
        app.todolist.addToList(t3);

        app.run();

       /* FileHandler fh = new FileHandler();
        fh.writeAsData(list);
        //ArrayList<Task> dataList = fh.readAsData();
        //System.out.println(dataList);

        System.out.println("-------------------");
        fh.writeAsObject(list);
        ArrayList<Task> objectList = fh.readAsObject();
        System.out.println(objectList);
*/


       /* test.addToList(one);
        test.addToList(two);
        test.addToList(three);*/



        // getTodolist2();

        // this is not working
//        app.printWelcome();
//        app.printStatus();
//        app.printMenu();
//        app.showTask(1);

    }
}

        // this doesnt work
       /* if (userOption == 1) {
            app.showTask();
        } else if (userOption == 2) {
            app.addTask();
        } else if (userOption == 3) {
            //
        } else if (userOption == 4) {
            //
        } else {
            System.out.println("Invalid option. Please select valid value of 1-4");
            app.printMenu();
        }
    }*/
















