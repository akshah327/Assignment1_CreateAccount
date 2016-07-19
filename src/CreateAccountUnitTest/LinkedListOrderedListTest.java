package CreateAccountUnitTest;

import org.junit.Test;
import utils.LinkedListOrderedList;

import static org.junit.Assert.*;

/**
 * Created by anujshah on 7/14/16.
 */
public class LinkedListOrderedListTest
{
    public static final String EXPECTED_STRING_ADD = "List:\n Andrew\n Bobby\n Calvin\n David\n";
    public static final String EXPECTED_STRING_REMOVE = "List:\n Andrew\n Calvin\n David\n";

    @Test
    public void add() throws Exception
    {
        LinkedListOrderedList list = new LinkedListOrderedList();
        list.add("Calvin");
        list.add("Bobby");
        list.add("David");
        list.add("Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("add method failed", EXPECTED_STRING_ADD, list.toString());
    }

    @Test
    public void remove() throws Exception
    {
        LinkedListOrderedList list = new LinkedListOrderedList();
        list.add("Calvin");
        list.add("Bobby");
        list.add("David");
        list.add("Andrew");
        System.out.println("List after add x 4: " + list);
        list.remove("Bobby");
        assertEquals("add method failed", EXPECTED_STRING_REMOVE, list.toString());
        System.out.println("List after remove: " + list);
    }

    @Test
    public void contains() throws Exception
    {
        LinkedListOrderedList list = new LinkedListOrderedList();
        list.add("Calvin");
        list.add("Bobby");
        list.add("David");
        list.add("Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("contains method failed", true, list.contains("Calvin"));
        assertEquals("contains method failed", false, list.contains("Evan"));
    }

    @Test
    public void isEmpty() throws Exception
    {
        LinkedListOrderedList list = new LinkedListOrderedList();
        assertEquals("isEmpty method failed", true, list.isEmpty());
        list.add("Calvin");
        list.add("Bobby");
        list.add("David");
        list.add("Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("isEmpty method failed", false, list.isEmpty());
    }

    @Test
    public void size() throws Exception
    {
        LinkedListOrderedList list = new LinkedListOrderedList();
        assertEquals("size method failed", 0, list.size());
        list.add("Calvin");
        list.add("Bobby");
        list.add("David");
        list.add("Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("size method failed", 4, list.size());
    }

    @Test
    public void get() throws Exception
    {
        LinkedListOrderedList list = new LinkedListOrderedList();
        list.add("Calvin");
        list.add("Bobby");
        list.add("David");
        list.add("Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("size method failed", "Andrew", list.get("Andrew"));
    }

    @Test
    public void getNext() throws Exception
    {
        LinkedListOrderedList list = new LinkedListOrderedList();
        assertEquals("size method failed", 0, list.size());
        list.add("Calvin");
        list.add("Bobby");
        list.add("David");
        list.add("Andrew");
        System.out.println("List after add x 4: " + list);
        list.reset();
        list.getNext();
        assertEquals("size method failed", "Bobby", list.getNext());
    }

    @Test
    public void reset() throws Exception
    {
        LinkedListOrderedList list = new LinkedListOrderedList();
        assertEquals("size method failed", 0, list.size());
        list.add("Calvin");
        list.add("Bobby");
        list.add("David");
        list.add("Andrew");
        System.out.println("List after add x 4: " + list);
        list.reset();
        assertEquals("size method failed", "Andrew", list.getNext());
    }

}