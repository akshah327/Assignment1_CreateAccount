/**
 * Class: LinkedListOrderedList
 * Author: Anuj Shah
 *
 * Purpose: The LinkedListOrderedList class provides methods and instance
 * variables for creating an linked list based ordered list. Elements are
 * added based on their relation to other elements. For example, if the list
 * contains A and C, and we add B, then B will go between A and C (A-B-C).
 * This is a parameterized class, so any object may be placed into the list.
 * Because it is a linked list, there is no capacity limit.
 *
 * Constants: None.
 *
 * Class Methods:
 *  - public LinkedListOrderedList()
 *  - public LinkedListOrderedList(T element)
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
 *  - private int countOfElements;
 *  - private LinkedListNode<T> head;
 *  - private LinkedListNode<T> current;
 *  - private LinkedListNode<T> previous;
 *  - private boolean found;
 *
 */

package utils;

import Exceptions.elementAlreadyExistsException;
import Exceptions.elementNotFoundException;

import java.io.Serializable;

/**
 * Created by anujshah on 7/10/16.
 */

public class LinkedListOrderedList<T extends Comparable<T>>
        implements InterfaceList<T>, Serializable
{
    /*
    private int countOfElements - keeps track of the number of elements in
        the list
    private LinkedListNode<T> head - points to the head of the list
    private LinkedListNode<T> current - marker for a node we would like to
        observe or transform
    private LinkedListNode<T> previous - marker for the node before current
    private boolean found - used in the contains method
     */

    private int countOfElements;
    private LinkedListNode<T> head;
    private LinkedListNode<T> current;
    private LinkedListNode<T> previous;
    private boolean found;


    /*-------------------------------------------------------------------
    | Method: LinkedListOrderedList()
    |
    | Efficiency: O(1)
    |
    | Purpose: Default constructor for the linked list ordered list.
    |
    | Pre-condition: None.
    |
    | Post-condition: Sets head, current, and previous to null, and sets
    |   countOfElements to 0.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public LinkedListOrderedList()
    {
        countOfElements = 0;
        head = null;
        current = null;
        previous = null;
    }


    /*-------------------------------------------------------------------
    | Method: LinkedListOrderedList()
    |
    | Efficiency: O(1)
    |
    | Purpose: Explicit constructor for the linked list ordered list.
    |
    | Pre-condition: None.
    |
    | Post-condition: Sets head and current to a new node containing T
    |   element, sets previous to null, and sets countOfElements to 0.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public LinkedListOrderedList(T element)
    {
        LinkedListNode<T> newNode = new LinkedListNode<T>(element);
        countOfElements = 0;
        head = newNode;
        current = newNode;
        previous = null;
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
    | Pre-condition: The element does not already exist in the list.
    |
    | Post-condition: Adds an element to the ordered list while
    |   maintaining alphanumeric order, or throws an
    |   elementAlreadyExistsException if the element already exists.
    |
    | Parameters: T element.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public void add(T element)
    {
        try
        {
            if (contains(element))
                throw new elementAlreadyExistsException();
            reset();
            T listElement;
            while (current != null)
            {
                listElement = current.getElement();
                if (listElement.compareTo(element) < 0)
                {
                    previous = current;
                    current = current.getPointer();
                }
                else
                    break;
            }
            LinkedListNode<T> newNode = new LinkedListNode<T>(element);
            if (previous == null)
            {
                newNode.setPointer(head);
                head = newNode;
            }
            else
            {
                newNode.setPointer(current);
                previous.setPointer(newNode);
            }
            countOfElements++;
        }
        catch (elementAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
    }


    /*-------------------------------------------------------------------
    | Method: remove()
    |
    | Efficiency: O(N)
    |
    | Purpose: Searches for and removes an element from the ordered
    |   list.
    |
    | Pre-condition: The list must contain the element.
    |
    | Post-condition: Removes the designated element from the list,
    |   or throws an elementNotFoundException.
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
            contains(element);
            if (!found)
                throw new elementNotFoundException();
            else
            {
                if (head == current)
                    head = head.getPointer();
                else
                    previous.setPointer(current.getPointer());
            }
            countOfElements--;
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
    | Post-condition: Returns true if the list contains the element,
    |   and returns false if it does not.
    |
    | Parameters: T element.
    |
    | Returns: true or false.
    |
     -------------------------------------------------------------------*/

    @Override
    public boolean contains(T element)
    {
        reset();
        current = head;
        found = false;
        while (current != null)
        {
            if (current.getElement().equals(element))
            {
                found = true;
                break;
            }
            else
            {
                previous = current;
                current = current.getPointer();
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
        return (head == null);
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
    | Post-condition: Returns the desired element, or throws an
    |   elementNotFoundException.
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
            desiredElement = current.getElement();
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
        T nextElement = current.getElement();
        if (current.getPointer() == null)
            current = head;
        else
            current = current.getPointer();
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
    | Post-condition: Resets current to head.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public void reset()
    {
        current = head;
        previous = null;
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

    public String toString()
    {
        current = head;
        String listString = "List:\n";
        while (current != null)
        {
            listString = listString + " " + current.getElement() + "\n";
            current = current.getPointer();
        }
        return listString;
    }

}
