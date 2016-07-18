package CreateAccountUnitTest

import org.junit.Test
import utils.LinkedListQueue

import static org.junit.Assert.*

/**
 * Created by anujshah on 7/14/16.
 */
class LinkedListQueueTest<T>
{

    public static final EXPECTED_STRING_INSERT = "List:\n David\n Calvin\n Bobby\n Andrew\n";

    @Test
    void testInsertInQueue()
    {
        LinkedListQueue queue = new LinkedListQueue();
        queue.insertInQueue("David");
        queue.insertInQueue("Calvin");
        queue.insertInQueue("Bobby");
        queue.insertInQueue("Andrew");
        System.out.println("After insertInQueue x 4: " + queue);
        assertEquals("insertInQueue method failed", EXPECTED_STRING_INSERT, queue.toString());
    }

    @Test
    void testDeQueue()
    {
        LinkedListQueue queue = new LinkedListQueue();
        queue.insertInQueue("David");
        queue.insertInQueue("Calvin");
        queue.insertInQueue("Bobby");
        queue.insertInQueue("Andrew");
        System.out.println("After insertInQueue x 4: " + queue);
        assertEquals("deQueue method failed", "David", queue.deQueue());
        System.out.println("After deQueue: " + queue);
    }

    @Test
    void testIsEmpty()
    {
        LinkedListQueue queue = new LinkedListQueue();
        assertEquals("isEmpty method failed", true, queue.isEmpty());
        queue.insertInQueue("David");
        queue.insertInQueue("Calvin");
        queue.insertInQueue("Bobby");
        queue.insertInQueue("Andrew");
        System.out.println("After insertInQueue x 4: " + queue);
        assertEquals("isEmpty method failed", false, queue.isEmpty());
    }

    @Test
    void testSize()
    {
        LinkedListQueue queue = new LinkedListQueue();
        assertEquals("size method failed", 0, queue.size());
        queue.insertInQueue("David");
        queue.insertInQueue("Calvin");
        queue.insertInQueue("Bobby");
        queue.insertInQueue("Andrew");
        System.out.println("After insertInQueue x 4: " + queue);
        assertEquals("size method failed", 4, queue.size());
    }

    @Test
    void testToString()
    {
        LinkedListQueue queue = new LinkedListQueue();
        queue.insertInQueue("David");
        queue.insertInQueue("Calvin");
        queue.insertInQueue("Bobby");
        queue.insertInQueue("Andrew");
        System.out.println("After insertInQueue x 4: " + queue);
        assertEquals("insertInQueue method failed", EXPECTED_STRING_INSERT, queue.toString());
    }
}
