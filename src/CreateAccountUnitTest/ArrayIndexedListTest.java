package CreateAccountUnitTest;

import org.junit.Test;
import utils.ArrayIndexedList;

import static org.junit.Assert.*;

/**
 * Created by anujshah on 7/16/16.
 */
public class ArrayIndexedListTest
{
    public static final String EXPECTED_STRING_ADD = "List:\n Calvin\n Andrew\n Bobby\n David\n";
    public static final String EXPECTED_STRING_SET = "List:\n Calvin\n Andrew\n Bobby\n Evan\n";
    public static final String EXPECTED_STRING_ENLARGE = "List:\n Calvin\n Andrew\n Bobby\n Evan\n David\n";

    @Test
    public void add() throws Exception
    {
        ArrayIndexedList list = new ArrayIndexedList();
        list.add(0, "Calvin");
        list.add(1, "Bobby");
        list.add(2, "David");
        list.add(1, "Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("add method failed", EXPECTED_STRING_ADD, list.toString());
    }

    @Test
    public void set() throws Exception
    {
        ArrayIndexedList list = new ArrayIndexedList();
        list.add(0, "Calvin");
        list.add(1, "Bobby");
        list.add(2, "David");
        list.add(1, "Andrew");
        System.out.println("List after add x 4: " + list);
        list.set(3, "Evan");
        assertEquals("add method failed", EXPECTED_STRING_SET, list.toString());
        System.out.println("List after set method: " + list);
    }

    @Test
    public void enlarge() throws Exception
    {
        ArrayIndexedList list = new ArrayIndexedList(4);
        list.add(0, "Calvin");
        list.add(1, "Bobby");
        list.add(2, "David");
        list.add(1, "Andrew");
        System.out.println("List after add x 4: " + list);
        list.add(3, "Evan");
        assertEquals("enlarge method failed", EXPECTED_STRING_ENLARGE, list.toString());
        System.out.println("List after set method: " + list);
    }

    @Test
    public void remove() throws Exception
    {
        ArrayIndexedList list = new ArrayIndexedList();
        list.add(0, "Calvin");
        list.add(1, "Bobby");
        list.add(2, "David");
        list.add(1, "Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("remove method failed", "Bobby", list.remove(2));
        System.out.println("List after remove: " + list);
    }

    @Test
    public void indexOf() throws Exception
    {
        ArrayIndexedList list = new ArrayIndexedList();
        list.add(0, "Calvin");
        list.add(1, "Bobby");
        list.add(2, "David");
        list.add(1, "Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("indexOf method failed", 2, list.indexOf("Bobby"));
    }

    @Test
    public void add1() throws Exception
    {

    }

    @Test
    public void remove1() throws Exception
    {

    }

    @Test
    public void contains() throws Exception
    {
        ArrayIndexedList list = new ArrayIndexedList();
        list.add(0, "Calvin");
        list.add(1, "Bobby");
        list.add(2, "David");
        list.add(1, "Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("contains method failed", true, list.contains("Bobby"));
        assertEquals("contains method failed", false, list.contains("Evan"));
    }

    @Test
    public void isEmpty() throws Exception
    {
        ArrayIndexedList list = new ArrayIndexedList();
        assertEquals("isEmpty method failed", true, list.isEmpty());
        list.add(0, "Calvin");
        list.add(1, "Bobby");
        list.add(2, "David");
        list.add(1, "Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("isEmpty method failed", false, list.isEmpty());
    }

    @Test
    public void size() throws Exception
    {
        ArrayIndexedList list = new ArrayIndexedList();
        assertEquals("size method failed", 0, list.size());
        list.add(0, "Calvin");
        list.add(1, "Bobby");
        list.add(2, "David");
        list.add(1, "Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("size method failed", 4, list.size());
    }

    @Test
    public void get() throws Exception
    {
        ArrayIndexedList list = new ArrayIndexedList();
        list.add(0, "Calvin");
        list.add(1, "Bobby");
        list.add(2, "David");
        list.add(1, "Andrew");
        System.out.println("List after add x 4: " + list);
        assertEquals("size method failed", "David", list.get(3));
    }

    @Test
    public void get1() throws Exception
    {

    }

    @Test
    public void getNext() throws Exception
    {
        ArrayIndexedList list = new ArrayIndexedList();
        list.add(0, "Calvin");
        list.add(1, "Bobby");
        list.add(2, "David");
        list.add(1, "Andrew");
        System.out.println("List after add x 4: " + list);
        list.reset();
        list.getNext();
        assertEquals("size method failed", "Andrew", list.getNext());
    }

    @Test
    public void reset() throws Exception
    {
        ArrayIndexedList list = new ArrayIndexedList();
        assertEquals("size method failed", 0, list.size());
        list.add(0, "Calvin");
        list.add(1, "Bobby");
        list.add(2, "David");
        list.add(1, "Andrew");
        System.out.println("List after add x 4: " + list);
        list.reset();
        assertEquals("size method failed", "Calvin", list.getNext());
    }

}