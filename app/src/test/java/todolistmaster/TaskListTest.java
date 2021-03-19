package todolistmaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
// assertNotEquals - method


class TaskListTest {



    @Test
    void assertAddTaskForOrderAgnosticEquality_ReturnsTrue() {

        Task t1 = new Task("firsttask", LocalDate.of(2020,11,10), "Brussels project");

        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        testListActual.addToList(t1);
        testListExpected.addToList(t1);

        int[] a = testListActual.countTasks();
        int[] b = testListExpected.countTasks();

        Assertions.assertEquals(a[0], b[0]);

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
    void returnCorrectMessageWhenDisplayTaskWithIndexIsAppliedToEmptyList() {

        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        testListExpected.showTaskListWithoutIndex();

        Assertions.assertEquals("Your task list is empty", testListActual.displayTaskWithIndex());
    }


    @Test
    void returnCorrectOutputWhenDisplayTaskWithIndexHasOneTask() {

        TaskList testListActual = new TaskList();
        TaskList testListExpected = new TaskList();

        Task t1 = new Task("firsttask", LocalDate.now(), "Brussels project");

        testListActual.addToList(t1);
        testListExpected.addToList(t1);

        assertEquals(testListExpected.displayTaskWithIndex(), testListActual.displayTaskWithIndex());
    }
}