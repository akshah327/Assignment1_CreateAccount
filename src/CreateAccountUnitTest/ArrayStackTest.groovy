package CreateAccountUnitTest

import org.junit.Test
import utils.ArrayStack

import static org.junit.Assert.*

/**
 * Created by anujshah on 7/12/16.
 */
class ArrayStackTest<T>
{
    public static final EXPECTED_STRING_PUSH = "{David} {Calvin} {Bobby} {Andrew} ";

    @Test
    void testTop()
    {
        ArrayStack stack = new ArrayStack();
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        System.out.println("After push x 4: " + stack);
        assertEquals("top method failed", "Andrew", stack.top());
    }

    @Test
    void testPop()
    {
        ArrayStack stack = new ArrayStack();
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        System.out.println("After top x 4: " + stack);
        stack.pop();
        System.out.println("After pop: " + stack);
        assertEquals("pop method failed", "Bobby", stack.top());
    }

    @Test
    void testPush()
    {
        ArrayStack stack = new ArrayStack();
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        System.out.println("After push x 4: " + stack);
        assertEquals("push method failed", EXPECTED_STRING_PUSH, stack.toString());
    }

    @Test
    void testSize()
    {
        ArrayStack stack = new ArrayStack();
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        assertEquals("size method failed", 4, stack.size());
    }

    @Test
    void testIsEmpty()
    {
        ArrayStack stack = new ArrayStack();
        assertEquals("size method failed", true, stack.isEmpty());
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        assertEquals("size method failed", false, stack.isEmpty());
    }

    @Test
    void testIsFull()
    {
        ArrayStack stack = new ArrayStack();
        assertEquals("size method failed",false, stack.isFull());
        stack.push("Jim");
        stack.push("Ivan");
        stack.push("Hank");
        stack.push("Greg");
        stack.push("Fred");
        stack.push("Evan");
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        assertEquals("size method failed", true, stack.isFull());
    }

    @Test
    void testToString()
    {
        ArrayStack stack = new ArrayStack();
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        System.out.println("After push x 4: " + stack);
        assertEquals("push method failed", EXPECTED_STRING_PUSH, stack.toString());
    }

}
