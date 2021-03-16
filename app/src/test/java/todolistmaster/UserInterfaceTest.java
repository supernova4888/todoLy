package todolistmaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;


class UserInterfaceTest {

//todo: check with TA's if the rational here is correct


    @Test
    void addTask() {

    // create a TaskList, create task then call the method to add the task to the list
    // return void, so use Assertion with void.


    }

    @Test
    void editTaskMenu() {

        // do 6 test cases invidually.



    }

    @Test
    void validateIntCheckIfNumberWithinRangeIsReturnedCorrectly() {


        UserInterface ui = new UserInterface();

        // Test for "Hello world"

        int min = 123;
        int max = 231;
        String userInput = "200";
        ui.setUserInput(userInput);

        Assertions.assertEquals(Integer.parseInt(userInput), ui.validateInt(min, max));


    }

    // Udalak will continue to think about this one. Very difficult.

   /* @Test
    void validateIntFromString() {

        // TODO this one is important to test a) min input b) max input c) invalid input as string

        // give a number out of the range
        // then return to the function
        // Assertions. // return the string as line 209.

        UserInterface ui = new UserInterface();

        // Test for "Hello world"

        int min = 123;
        int max = 231;
        String userInput = "test";
        ui.setUserInput(userInput);

        Assertions.assertThrows(NumberFormatException.class,
                () -> ui.validateInt(min, max));

    }*/

}