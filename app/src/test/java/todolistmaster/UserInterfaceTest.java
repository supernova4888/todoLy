package todolistmaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertTrue;


class UserInterfaceTest {

//todo: check with TA's if the rational here is correct


    @Test
    void editTaskMenu() {

        // do 6 test cases invidually.



    }

    @Test
    void validateIntCheckIfNumberWithinRangeIsReturnedCorrectly() {

        UserInterface ui = new UserInterface();
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