package todolistmaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
// assertNotEquals - method


class TaskListTest {


    @Test
    void testsCorrectReturnValueWhenShowTaskListWithoutIndexIsEmpty() {

        // todo: PASSED - is testing like this correct?

        // if list is empty return 0

        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        testListExpected.showTaskListWithoutIndex();

        Assertions.assertEquals(0, testListActual.showTaskListWithoutIndex());

    }

    @Test
    void testsCorrectReturnValueWhenShowTaskListWithoutIndexIsNotEmpty() {


        // todo: PASSED - is testing like this correct?

        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        Task t1 = new Task("firsttask", LocalDate.now(), "Brussels project");

        testListActual.addToList(t1);

        testListExpected.addToList(t1);

        Assertions.assertEquals(1, testListActual.showTaskListWithoutIndex());

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


       testListActual.sort(2);
       testListExpected.sort(2);

       Assertions.assertEquals(testListExpected, testListActual);

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

        //Assertions.assertEquals("(1) ", testListActual.showTaskListWithoutIndex());

    }

}