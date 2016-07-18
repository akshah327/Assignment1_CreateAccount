package CreateAccountUnitTest

import org.junit.Test
import utils.ArrayQueue

import static org.junit.Assert.*

/**
 * Created by anujshah on 7/13/16.
 */
class ArrayQueueTest<T>
{
    public static final String EXPECTED_STRING_INSERT = "{David} {Calvin} {Bobby} {Andrew} ";

    @Test
    void testInsertInQueue()
    {
        ArrayQueue queue = new ArrayQueue();
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
        ArrayQueue queue = new ArrayQueue();
        queue.insertInQueue("David");
        queue.insertInQueue("Calvin");
        queue.insertInQueue("Bobby");
        queue.insertInQueue("Andrew");
        System.out.println("After insertInQueue x 4: " + queue);
        assertEquals("deQueue method failed", "David", queue.deQueue());
        System.out.println("After deQueue: " + queue);
    }

    @Test
    void testSize()
    {
        ArrayQueue queue = new ArrayQueue();
        queue.insertInQueue("David");
        queue.insertInQueue("Calvin");
        queue.insertInQueue("Bobby");
        queue.insertInQueue("Andrew");
        System.out.println("After insertInQueue x 4: " + queue);
        assertEquals("size method failed", 4, queue.size());
    }

    @Test
    void testIsEmpty()
    {
        ArrayQueue queue = new ArrayQueue();
        assertEquals("isEmpty method failed", true, queue.isEmpty());
        queue.insertInQueue("David");
        queue.insertInQueue("Calvin");
        queue.insertInQueue("Bobby");
        queue.insertInQueue("Andrew");
        System.out.println("After insertInQueue x 4: " + queue);
        assertEquals("isEmpty method failed", false, queue.isEmpty());
    }

    @Test
    void testIsFull()
    {
        ArrayQueue queue = new ArrayQueue();
        assertEquals("isEmpty method failed", false, queue.isFull());
        queue.insertInQueue("Jim");
        queue.insertInQueue("Ivan");
        queue.insertInQueue("Hank");
        queue.insertInQueue("Greg");
        queue.insertInQueue("Fred");
        queue.insertInQueue("Evan");
        queue.insertInQueue("David");
        queue.insertInQueue("Calvin");
        queue.insertInQueue("Bobby");
        queue.insertInQueue("Andrew");
        System.out.println("After insertInQueue x 4: " + queue);
        assertEquals("isFull method failed", true, queue.isFull());
    }

    @Test
    void testToString()
    {
        ArrayQueue queue = new ArrayQueue();
        queue.insertInQueue("David");
        queue.insertInQueue("Calvin");
        queue.insertInQueue("Bobby");
        queue.insertInQueue("Andrew");
        System.out.println("After insertInQueue x 4: " + queue);
        assertEquals("toString method failed", EXPECTED_STRING_INSERT, queue.toString());
    }
}
