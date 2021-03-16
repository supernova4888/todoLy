package todolistmaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
// assertNotEquals - method


class TaskListTest {


    @Test
    void testsCorrectReturnValueWhenShowTaskListWithoutIndexIsEmpty() {

        // testing if empty TaskList returns 0
        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        Assertions.assertEquals(testListExpected.showTaskListWithoutIndex(), testListActual.showTaskListWithoutIndex());

    }

    @Test
    void testsCorrectReturnValueWhenShowTaskListWithoutIndexIsNotEmpty() {


        // testing if empty TaskList returns 1

        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        Task t1 = new Task("firsttask", LocalDate.now(), "Brussels project");

        testListActual.addToList(t1);

        testListExpected.addToList(t1);

        Assertions.assertEquals(testListExpected.showTaskListWithoutIndex(), testListActual.showTaskListWithoutIndex());

    }

    @Test
    void sortPerProjectSortsCorrectly() {

        // Todo - returns error - no idea what it means!

       TaskList testListActual = new TaskList();

       Task t1 = new Task("firsttask", LocalDate.now(), "Brussels project");
       Task t2 = new Task("secondtask", LocalDate.now(), "Another project");
       Task t3 = new Task("thirdtask", LocalDate.now(), "Some project name");

       testListActual.addToList(t1);
       testListActual.addToList(t2);
       testListActual.addToList(t3);

        TaskList testListExpected = new TaskList();

        testListExpected.addToList(t1);
        testListExpected.addToList(t2);
        testListExpected.addToList(t3);


       // todo: just to check which assertion i should call

       //Assertions.assertEquals(testListExpected.sort(2), testListActual.sort(2));

    }

    @Test
    void returnCorrectMessageWhenDisplayTaskWithIndexIsAppliedToEmptyList() {

        // todo: PASSED - is testing like this correct?

        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        testListExpected.showTaskListWithoutIndex();

        Assertions.assertEquals("Your task list is empty", testListActual.displayTaskWithIndex());

    }

    @Test
    void returnCorrectOutputWhenDisplayTaskWithIndexIsNotEmptyList() {

        // todo: how do i test for this one with stringbuilder?

        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        Task t1 = new Task("firsttask", LocalDate.now(), "Brussels project");

        testListActual.addToList(t1);
        testListExpected.addToList(t1);

        // call the method here for actual and expected.
        // double check the return type and Assertion type
        //Assertions.assertEquals(

    }

}