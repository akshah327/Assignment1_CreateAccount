/**
 * Class: ArrayIndexedList
 * Author: Anuj Shah
 *
 * Purpose: The ArrayIndexedList class provides methods and instance variables
 * for creating an array-based and unbounded indexed list. Elements are added
 * based on the index provided alongside the element. For example, if the list
 * contains the elements A at index 1 and B at index 2, and the user wants to
 * add C at position 2, the list after addition will read A-C-B. The list is
 * enlarged if we add another element beyond its current capacity.
 *
 * Constants: None.
 *
 * Class Methods:
 *  - public ArrayOrderedList()
 *  - public ArrayOrderedList(int originalLimit)
 *  - public void enlarge()
 *  - public void add(T element)
 *  - public void set(int index, T element)
 *  - public void remove(T element)
 *  - public boolean contains(T element)
 *  - public int indexOf(T element)
 *  - public boolean isEmpty()
 *  - public int size()
 *  - public T get(T element)
 *  - public T get(T element)
 *  - public void reset()
 *  - public T getNext()
 *  - public String toString()
 *
 * Instance Methods:
 *  - private T[] queue
 *  - private int originalLimit
 *  - private T[] list
 *  - private int countOfElements
 *  - private int current
 *  - private boolean found
 *  - private int location
 *
 */

package utils;

import Exceptions.elementNotFoundException;

import java.util.Arrays;

public class ArrayIndexedList<T> implements IArrayIndexedList<T>
{

    /*
    private T[] list - the array for the list
    private int originalLimit - Keeps track of the original limit of the
        list, and can be used for enlarging the list by this increment
    private int countOfElements - keeps track of the number of elements
        in the list
    private int current - a marker for the current element being
        examined
    private boolean found - used for the contains method
    private int location - a marker for the location at which we will
        place or remove an element
     */

    private T[] list;
    private int originalLimit;
    private int countOfElements = 0;
    private int current;
    private boolean found;
    private int location;


    /*-------------------------------------------------------------------
    | Method: ArrayIndexedList()
    |
    | Efficiency: O(N)
    |
    | Purpose: Default constructor for the array-based indexed list.
    |
    | Pre-condition: None.
    |
    | Post-condition: Creates an array with 10 elements that is to be
    |   used as a list, and sets originalLimit to 10.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public ArrayIndexedList()
    {
        list = (T[]) new Object[10];
        originalLimit = 10;
    }


    /*-------------------------------------------------------------------
    | Method: ArrayIndexedList()
    |
    | Efficiency: O(N)
    |
    | Purpose: Explicit constructor for the array-based indexed list.
    |
    | Pre-condition: None.
    |
    | Post-condition: Creates an array with the number of elements
    |   equal to the originalLimit value designated by the user, to be
    |   used as an indexed list.
    |
    | Parameters: int originalLimit.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public ArrayIndexedList(int originalLimit)
    {
        list = (T[]) new Object[originalLimit];
        this.originalLimit = originalLimit;
    }


    /*-------------------------------------------------------------------
    | Method: add()
    |
    | Efficiency: O(N)
    |
    | Purpose: Adds an element to the array index specified by the user
    |   after pushing all elements from this index onwards back by 1
    |   place.
    |
    | Pre-condition: The index provided is greater than 0 and less
    |    than the current count of elements.
    |
    | Post-condition: Adds an element at the specified index after
    |   pushing all elements from this index onwards back by 1 place.
    |   Enlarges the list if needed.
    |
    | Parameters: int index, T element.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public void add(int index, T element)
    {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("The index provided is out of bounds.");
        if (countOfElements == list.length)
            enlarge();
        for (int i = countOfElements; i > index; i--)
            list[i] = list[i-1];
        list[index] = element;
        countOfElements++;
    }


    /*-------------------------------------------------------------------
    | Method: set()
    |
    | Efficiency: O(1)
    |
    | Purpose: Sets the value of an element at a specific index.
    |
    | Pre-condition: The index provided is greater than 0 and less
    |    than the current count of elements.
    |
    | Post-condition: Changes the element at the specified index and
    |   returns the replaced element.
    |
    | Parameters: int index, T element.
    |
    | Returns: replacedElement.
    |
     -------------------------------------------------------------------*/

    public T set(int index, T element)
    {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("The index provided is out of bounds.");
        T replacedElement = list[index];
        list[index] = element;
        return replacedElement;
    }


    /*-------------------------------------------------------------------
    | Method: enlarge()
    |
    | Efficiency: O(N)
    |
    | Purpose: Enlarges the list by the value of originalLimit (set upon
    |   creation of the list).
    |
    | Pre-condition: None.
    |
    | Post-condition: Creates a new array with a size equal to the size
    |   of the existing array plus the value of originalLimit. Copies
    |   all elements from the existing array to the larger array. Sets
    |   list equal to the larger array.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public void enlarge()
    {
        T[] largerArray = (T[]) new Object[list.length + originalLimit];
        for (int i = 0; i < list.length; i++)
        {
            largerArray[i] = list[i];
        }
        list = largerArray;
    }


    /*-------------------------------------------------------------------
    | Method: remove()
    |
    | Efficiency: O(N)
    |
    | Purpose: Removes the element at the specified index and shifts all
    |   elements following the removed element 1 place forward.
    |
    | Pre-condition: The index provided is greater than 0 and less
    |    than the current count of elements.
    |
    | Post-condition: Removes the element at the designated index from
    |   the list, or throws an indexOutOfBoundsException.
    |
    | Parameters: T element.
    |
    | Returns: removedElement.
    |
     -------------------------------------------------------------------*/

    @Override
    public T remove(int index)
    {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException("The index provided is out of bounds.");
        T removedElement = list[index];
        for (int i = index; i < countOfElements-1; i++)
        {
            list[i] = list[i + 1];
        }
        list[countOfElements-1] = null;
        countOfElements--;
        return removedElement;
    }


    /*-------------------------------------------------------------------
    | Method: indexOf()
    |
    | Efficiency: O(N)
    |
    | Purpose: Searches for the specified element and returns the index
    |   of that element.
    |
    | Pre-condition: The list contains the specified element.
    |
    | Post-condition: Returns the index of the specified element, or
    |   throws an indexOutOfBoundsException.
    |
    | Parameters: T element.
    |
    | Returns: location.
    |
     -------------------------------------------------------------------*/

    @Override
    public int indexOf(T element)
    {
        try
        {
            contains(element);
            if (!found)
                throw new elementNotFoundException();
            return location;
        }
        catch (elementNotFoundException e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public void add(T element)
    {

    }

    @Override
    public void remove(T element)
    {

    }


    /*-------------------------------------------------------------------
    | Method: contains()
    |
    | Efficiency: O(N)
    |
    | Purpose: Searches for an element in the indexed list.
    |
    | Pre-condition: None.
    |
    | Post-condition: Returns true if the list contains the element, and
    |   returns false if it does not.
    |
    | Parameters: T element.
    |
    | Returns: true or false.
    |
     -------------------------------------------------------------------*/

    @Override
    public boolean contains(T element)
    {
        location = 0;
        found = false;
        while (location < countOfElements)
        {
            if (list[location].equals(element))
            {
                found = true;
                return found;
            }
            else
            {
                location++;
            }
        }
        return found;
    }


    /*-------------------------------------------------------------------
    | Method: isEmpty()
    |
    | Efficiency: O(1)
    |
    | Purpose: Determines whether the list is empty.
    |
    | Pre-condition: None.
    |
    | Post-condition: Returns true if the list is empty, or false if
    |   the list contains any number of elements.
    |
    | Parameters: None.
    |
    | Returns: true or false.
    |
     -------------------------------------------------------------------*/

    @Override
    public boolean isEmpty()
    {
        return (countOfElements == 0);
    }


    /*-------------------------------------------------------------------
    | Method: size()
    |
    | Efficiency: O(1)
    |
    | Purpose: Provides the count of elements currently in the list.
    |
    | Pre-condition: None.
    |
    | Post-condition: Provides the count of elements currently in the
    |   list.
    |
    | Parameters: None.
    |
    | Returns: countOfElements.
    |
     -------------------------------------------------------------------*/

    @Override
    public int size()
    {
        return countOfElements;
    }


    /*-------------------------------------------------------------------
    | Method: get()
    |
    | Efficiency: O(1)
    |
    | Purpose: Gets a desired element from the list.
    |
    | Pre-condition: The list contains the element.
    |
    | Post-condition: Returns the desired element.
    |
    | Parameters: T element.
    |
    | Returns: desiredElement.
    |
     -------------------------------------------------------------------*/

    @Override
    public T get(T element)
    {
        try
        {
            contains(element);
            if(!found)
                throw new elementNotFoundException();
            return list[location];
        }
        catch (elementNotFoundException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    /*-------------------------------------------------------------------
    | Method: get()
    |
    | Efficiency: O(1)
    |
    | Purpose: Gets the element at the desired index from the list.
    |
    | Pre-condition: The index provided is greater than 0 and less
    |    than the current count of elements.
    |
    | Post-condition: Returns the element at the specified index.
    |
    | Parameters: int index.
    |
    | Returns: list[index].
    |
     -------------------------------------------------------------------*/

    @Override
    public T get(int index)
    {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException("The index provided is out of bounds.");
        return list[index];
    }


    /*-------------------------------------------------------------------
    | Method: getNext()
    |
    | Efficiency: O(1)
    |
    | Purpose: Gets the next element in the indexed list.
    |
    | Pre-condition: None.
    |
    | Post-condition: Returns the next element in the indexed list.
    |    Resets current to 0 if current has reached the end of the list,
    |    or increments current by 1.
    |
    | Parameters: None.
    |
    | Returns: nextElement.
    |
     -------------------------------------------------------------------*/

    @Override
    public T getNext()
    {
        T nextElement = list[current];
        if (current == countOfElements-1)
            current = 0;
        else
            current++;
        return nextElement;
    }


    /*-------------------------------------------------------------------
    | Method: reset()
    |
    | Efficiency: O(1)
    |
    | Purpose: Resets current to 0, allowing the user to advance through
    |    the list from the beginning using the method getNext.
    |
    | Pre-condition: None.
    |
    | Post-condition: Resets current to 0.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public void reset()
    {
        current = 0;
    }


    /*-------------------------------------------------------------------
    | Method: toString()
    |
    | Efficiency: O(N)
    |
    | Purpose: Returns the elements of the list in an easy-to-read
    |    format.
    |
    | Pre-condition: None.
    |
    | Post-condition: Prints the contents of the list to the screen.
    |
    | Parameters: None.
    |
    | Returns: listString (a concatenated string of the list elements)
    |
     -------------------------------------------------------------------*/

    @Override
    public String toString()
    {
        String listString = "List:\n";
        for (int i = 0; i < countOfElements; i++)
        {
            listString+=" " + list[i] + "\n";
        }
        return listString;
    }
}
