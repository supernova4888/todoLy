package todolistmaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
// assertNotEquals - method


class TaskListTest {


    // todo: how to test this one?
    @Test
    void assertAddTaskForOrderAgnosticEquality_ReturnsTrue() {


        Task t1 = new Task("firsttask", LocalDate.now(), "Brussels project");

        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        testListActual.addToList(t1);
        testListExpected.addToList(t1);

        assertEquals(testListExpected, testListActual);

        //assertTrue(testListActual.containsAll(testListExpected) && testListExpected.containsAll(testListActual));
    }


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

        testListExpected.addToList(t3);
        testListExpected.addToList(t2);
        testListExpected.addToList(t1);

        testListActual.sort(2);
        testListExpected.sort(2);

       // todo: just to check which assertion i should call - returning void?

       // Assertions.assertTrue(testListExpected.sort(2), testListActual.sort(2));

    }

    @Test
    void returnCorrectMessageWhenDisplayTaskWithIndexIsAppliedToEmptyList() {

        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        testListExpected.showTaskListWithoutIndex();

        Assertions.assertEquals("Your task list is empty", testListActual.displayTaskWithIndex());
    }


    @Test
    void returnCorrectOutputWhenDisplayTaskWithIndexIsNotEmptyList() {

        // todo: PASSED - is this correct?

        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        Task t1 = new Task("firsttask", LocalDate.now(), "Brussels project");

        testListActual.addToList(t1);
        testListExpected.addToList(t1);

        assertEquals(testListExpected.displayTaskWithIndex(), testListActual.displayTaskWithIndex());

    }

}