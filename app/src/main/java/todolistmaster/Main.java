package todolistmaster;

/** This is where the program runs. This class calls the objects, instantiate and use/call methods for the todolist app execution in appropriate order
 **/

public class Main {

    public static void main(String[] args) {

        // display initial instruction of TodoLy

        UserInterface app = new UserInterface();

        app.printWelcome();
        app.printStatus();
        app.printMenu();

      /*  TaskList test = new TaskList();

        // they are not being added to the Task counter
        Task one = new Task("title", "01/07/2021","brother");
        Task two = new Task("duhhh", "10/10/2021", "car");
        Task three = new Task("lala", "01/03/2021", "abc");

        test.addToList(one);
        test.addToList(two);
        test.addToList(three);*/

        app.addTask(2);


        // getTodolist2();

        // this is not working
        // app.showTask(1);





    }


}





