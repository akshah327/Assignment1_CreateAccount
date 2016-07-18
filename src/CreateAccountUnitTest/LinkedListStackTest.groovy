package CreateAccountUnitTest

import org.junit.Test
import utils.LinkedListStack

import static org.junit.Assert.*

/**
 * Created by anujshah on 7/13/16.
 */
class LinkedListStackTest
{
    public static final String EXPECTED_STRING_PUSH = "List:\n Andrew\n Bobby\n Calvin\n David\n";

    @Test
    void testTop()
    {
        LinkedListStack stack = new LinkedListStack();
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
        LinkedListStack stack = new LinkedListStack();
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        System.out.println("After push x 4: " + stack);
        assertEquals("pop method failed", "Andrew", stack.pop());
    }

    @Test
    void testPush()
    {
        LinkedListStack stack = new LinkedListStack();
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        System.out.println("After push x 4: \n" + stack);
        assertEquals("push method failed", EXPECTED_STRING_PUSH, stack.toString());
    }

    @Test
    void testIsEmpty()
    {
        LinkedListStack stack = new LinkedListStack();
        assertEquals("size method failed", true, stack.isEmpty());
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        assertEquals("isEmpty method failed", false, stack.isEmpty());
    }

    @Test
    void testSize()
    {
        LinkedListStack stack = new LinkedListStack();
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        assertEquals("size method failed", 4, stack.size());
    }

    @Test
    void testToString()
    {
        LinkedListStack stack = new LinkedListStack();
        stack.push("David");
        stack.push("Calvin");
        stack.push("Bobby");
        stack.push("Andrew");
        System.out.println("After push x 4: " + stack);
        assertEquals("push method failed", EXPECTED_STRING_PUSH, stack.toString());
    }
}
