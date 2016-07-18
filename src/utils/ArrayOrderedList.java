/**
 * Class: ArrayOrderedList
 * Author: Anuj Shah
 *
 * Purpose: The ArrayOrderedList class provides methods and instance variables
 * for creating an array-based and unbounded ordered list. Elements are added
 * based on their relation to other elements. For example, if the list contains
 * A and C, and we add B, then B will go between A and C (A-B-C).This is a
 * parameterized class, so any object may be placed into the list. The list
 * is enlarged if we add another element beyond its current capacity.
 *
 * Constants: None.
 *
 * Class Methods:
 *  - public ArrayOrderedList()
 *  - public ArrayOrderedList(int originalLimit)
 *  - public void enlarge()
 *  - public void add(T element)
 *  - public void remove(T element)
 *  - public boolean contains(T element)
 *  - public boolean isEmpty()
 *  - public int size()
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
import Exceptions.emptyListException;

public class ArrayOrderedList<T> implements InterfaceList<T>
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
    | Method: ArrayOrderedList()
    |
    | Efficiency: O(N)
    |
    | Purpose: Default constructor for the array-based ordered list.
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

    public ArrayOrderedList()
    {
        list = (T[]) new Object[10];
        originalLimit = 10;
    }


    /*-------------------------------------------------------------------
    | Method: ArrayOrderedList()
    |
    | Efficiency: O(N)
    |
    | Purpose: Explicit constructor for the array-based ordered list.
    |
    | Pre-condition: None.
    |
    | Post-condition: Creates an array with the number of elements
    |   equal to the originalLimit value designated by the user, to be
    |   used as an ordered list.
    |
    | Parameters: int originalLimit.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public ArrayOrderedList(int originalLimit)
    {
        list = (T[]) new Object[originalLimit];
        this.originalLimit = originalLimit;
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
    | Method: add()
    |
    | Efficiency: O(N)
    |
    | Purpose: Searches for and adds an element to the proper place in
    |   the ordered list, maintaining alphanumeric order relative to
    |   existing elements.
    |
    | Pre-condition: None.
    |
    | Post-condition: Adds an element to the ordered list while
    |   maintaining alphanumeric order.
    |
    | Parameters: T element.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public void add(T element)
    {
        T listElement;
        location = 0;
        if (countOfElements == list.length)
            enlarge();
        while (location < countOfElements)
        {
            listElement = (T)list[location];
            if (((Comparable)listElement).compareTo(element) < 0)
                location++;
            else
                break;
        }
        for (int index = countOfElements; index > location; index--)
            list[index] = list[index-1];
        list[location] = element;
        countOfElements++;
    }


    /*-------------------------------------------------------------------
    | Method: remove()
    |
    | Efficiency: O(N)
    |
    | Purpose: Searches for and removes an element from the ordered
    |   list, and shifts all elements following the removed element 1
    |   place forward.
    |
    | Pre-condition: The list is not empty, and the list contains the
    |   element to remove.
    |
    | Post-condition: Removes the designated element from the list,
    |   throws an emptyListException, or throws an
    |   elementNotFoundException.
    |
    | Parameters: T element.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public void remove(T element)
    {
        try
        {
            if (countOfElements == 0)
                throw new emptyListException();
            contains(element);
            if (!found)
                throw new elementNotFoundException();
            for (int i = location; i < countOfElements-1; i++)
            {
                list[i] = list[i+1];
            }
            list[countOfElements - 1] = null;
            countOfElements--;
        }
        catch (emptyListException e)
        {
            System.out.println(e.getMessage());
        }
        catch (elementNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }


    /*-------------------------------------------------------------------
    | Method: contains()
    |
    | Efficiency: O(N)
    |
    | Purpose: Searches for an element in the ordered list.
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
        T desiredElement = null;
        try
        {
            contains(element);
            if (!found)
                throw new elementNotFoundException();
            desiredElement = list[location];
        }
        catch (elementNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        return desiredElement;
    }


    /*-------------------------------------------------------------------
    | Method: getNext()
    |
    | Efficiency: O(1)
    |
    | Purpose: Gets the next element in the ordered list.
    |
    | Pre-condition: None.
    |
    | Post-condition: Returns the next element in the ordered list.
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
