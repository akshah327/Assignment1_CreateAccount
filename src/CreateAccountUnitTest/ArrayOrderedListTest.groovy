package CreateAccountUnitTest

import org.junit.Test
import utils.ArrayOrderedList

import static org.junit.Assert.*

/**
 * Created by anujshah on 7/14/16.
 */
class ArrayOrderedListTest<T>
{
    public static final String EXPECTED_STRING_ADD = "List:\n Andrew\n Bobby\n Calvin\n David\n";
    public static final String EXPECTED_STRING_REMOVE = "List:\n Andrew\n Calvin\n David\n";

    @Test
    void testEnlarge()
    {
        ArrayOrderedList list = new ArrayOrderedList(5);
        list.add("Jim");
        list.add("Ivan");
        list.add("Hank");
        list.add("Greg");
        list.add("Fred");
        System.out.println("After add x 5: " + list.toString());
        System.out.println("Size: " + list.size() + "\n");
        list.add("Evan");
        System.out.println("After another add: " + list.toString());
        assertEquals("enlarge method failed", 6, list.size());
    }

    @Test
    void testAdd()
    {
        ArrayOrderedList list = new ArrayOrderedList();
        list.add("David");
        list.add("Calvin");
        list.add("Bobby");
        list.add("Andrew");
        System.out.println("After add x 4: " + list);
        assertEquals("add method failed", EXPECTED_STRING_ADD, list.toString());
    }

    @Test
    void testRemove()
    {
        ArrayOrderedList list = new ArrayOrderedList();
        list.add("David");
        list.add("Calvin");
        list.add("Bobby");
        list.add("Andrew");
        System.out.println("After add x 4: " + list);
        list.remove("Bobby");
        System.out.println("After remove Bobby: " + list);
        assertEquals("remove method failed", EXPECTED_STRING_REMOVE, list.toString());
    }

    @Test
    void testContains()
    {
        ArrayOrderedList list = new ArrayOrderedList();
        list.add("David");
        list.add("Calvin");
        list.add("Bobby");
        list.add("Andrew");
        System.out.println("After add x 4: " + list);
        assertEquals("contains method failed", true, list.contains("Bobby"));
        assertEquals("contains method failed", false, list.contains("Evan"));
    }

    @Test
    void testIsEmpty()
    {
        ArrayOrderedList list = new ArrayOrderedList();
        assertEquals("isEmpty method failed", true, list.isEmpty());
        list.add("David");
        list.add("Calvin");
        list.add("Bobby");
        list.add("Andrew");
        System.out.println("After add x 4: " + list);
        assertEquals("isEmpty method failed", false, list.isEmpty());
    }

    @Test
    void testSize()
    {
        ArrayOrderedList list = new ArrayOrderedList();
        assertEquals("size method failed", 0, list.size());
        list.add("David");
        list.add("Calvin");
        list.add("Bobby");
        list.add("Andrew");
        System.out.println("After add x 4: " + list);
        assertEquals("size method failed", 4, list.size());
    }

    @Test
    void testGet()
    {
        ArrayOrderedList list = new ArrayOrderedList();
        list.add("David");
        list.add("Calvin");
        list.add("Bobby");
        list.add("Andrew");
        System.out.println("After add x 4: " + list);
        assertEquals("get method failed", "Bobby", list.get("Bobby"));
    }

    @Test
    void testReset()
    {

    }

    @Test
    void testGetNext()
    {
        ArrayOrderedList list = new ArrayOrderedList();
        list.add("Andrew");
        list.add("Bobby");
        list.add("Calvin");
        list.add("David");
        System.out.println("After add x 4: " + list);
        assertEquals("getNext method failed", "Andrew", list.getNext());
        assertEquals("getNext method failed", "Bobby", list.getNext());
    }

    @Test
    void testToString()
    {
        ArrayOrderedList list = new ArrayOrderedList();
        list.add("David");
        list.add("Calvin");
        list.add("Bobby");
        list.add("Andrew");
        System.out.println("After add x 4: " + list);
        assertEquals("add method failed", EXPECTED_STRING_ADD, list.toString());
    }
}
