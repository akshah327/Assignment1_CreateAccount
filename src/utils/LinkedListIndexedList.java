/**
 * Class: LinkedListIndexedList
 * Author: Anuj Shah
 *
 * Purpose: The LinkedListIndexedList class provides methods and instance
 * variables for creating a linked list indexed list. Elements are added
 * based on the index provided alongside the element. For example, if the
 * list contains the elements A at index 1 and B at index 2, and the
 * user wants to add C at position 2, the list after addition will read
 * A-C-B. Because it is a linked list, there is no capacity limit.
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
 *  - private int countOfElements
 *  - private LinkedListNode<T> head
 *  - private LinkedListNode<T> current
 *  - private int location
 *  - private LinkedListNode<T> previous
 *  - private boolean found
 *
 */

package utils;

import Exceptions.elementAlreadyExistsException;
import Exceptions.elementNotFoundException;

/**
 * Created by anujshah on 7/10/16.
 */
public class LinkedListIndexedList<T extends Comparable<T>> implements InterfaceIndexedList<T>
{
    /*
    private int countOfElements - keeps track of the number of elements in
        the list
    private LinkedListNode<T> head - points to the head of the list
    private LinkedListNode<T> current - marker for a node we would like to
        observe or transform
    private int location - used for return statement in indexOf method
    private LinkedListNode<T> previous - marker for the node before current
    private boolean found - used in the contains method
     */

    private int countOfElements;
    private LinkedListNode<T> head;
    private LinkedListNode<T> current;
    private int location;

    private LinkedListNode<T> previous;

    private boolean found;


    /*-------------------------------------------------------------------
    | Method: LinkedListIndexedList()
    |
    | Efficiency: O(1)
    |
    | Purpose: Default constructor for the linked list indexed list.
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

    public LinkedListIndexedList()
    {
        countOfElements = 0;
        head = null;
        current = null;
        previous = null;
    }


    /*-------------------------------------------------------------------
    | Method: LinkedListIndexedList()
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

    public LinkedListIndexedList(T element)
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
    | Purpose: Adds an element to the position matching the index that
    |   is specified by the user, after pushing all elements from this
    |   index onwards back by 1 place.
    |
    | Pre-condition: The index provided is greater than 0 and less
    |    than the current count of elements.
    |
    | Post-condition: Adds an element to the position matching the index that
    |   is specified by the user, after pushing all elements from this
    |   index onwards back by 1 place.
    |
    | Parameters: int index, T element.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public void add(int index, T element)
    {
        try
        {
            if (index < 0 || index > size())
                throw new IndexOutOfBoundsException("The index provided is out of bounds.");
            if (contains(element))
                throw new elementAlreadyExistsException();
            LinkedListNode<T> newNode = new LinkedListNode<>(element);
            if (head == null)
            {
                head = newNode;
                current = newNode;
                previous = null;
            }
            else
            {
                reset();
                for (int i = 1; i < index; i++)
                {
                    previous = current;
                    current = current.getPointer();
                }
                newNode.setPointer(current.getPointer());
                current.setPointer(newNode);
                previous = current;
                current = newNode;
            }
            countOfElements++;
        }
        catch (elementAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }
    }


    /*-------------------------------------------------------------------
    | Method: set()
    |
    | Efficiency: O(N)
    |
    | Purpose: Sets the element of a node whose position matches the
    |   index provided by the user.
    |
    | Pre-condition: The index provided is greater than 0 and less
    |    than the current count of elements.
    |
    | Post-condition: Changes the element of a node and
    |   returns the replaced element.
    |
    | Parameters: int index, T element.
    |
    | Returns: replacedElement.
    |
     -------------------------------------------------------------------*/

    public void set(int index, T element)
    {
        if (index < 1 || index > size())
            throw new IndexOutOfBoundsException("The index provided is out of bounds.");
        reset();
        for (int i = 0; i < index; i++)
        {
            previous = current;
            current = current.getPointer();
        }
        current.setElement(element);
    }


    /*-------------------------------------------------------------------
    | Method: remove()
    |
    | Efficiency: O(N)
    |
    | Purpose: Removes the element at the specified position (index).
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
        if(index < 1 || index > size())
            throw new IndexOutOfBoundsException("The index provided is out of bounds.");
        reset();
        for (int i = 0; i < index; i++)
        {
            previous = current;
            current = current.getPointer();
        }
        T removedElement = current.getElement();
        current = current.getPointer();
        previous.setPointer(current);
        countOfElements--;
        return removedElement;
    }


    /*-------------------------------------------------------------------
    | Method: indexOf()
    |
    | Efficiency: O(N)
    |
    | Purpose: Searches for the specified element and returns the index
    |   (or position) of that element.
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
        reset();
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
    | Efficiency: O(N)
    |
    | Purpose: Gets a desired element from the list.
    |
    | Pre-condition: The list contains the element.
    |
    | Post-condition: Returns the desired element.
    |
    | Parameters: T element.
    |
    | Returns: current.getElement().
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
            return current.getElement();
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
    | Returns: current.getElement().
    |
     -------------------------------------------------------------------*/

    public T get(int index)
    {
        if(index < 1 || index > size())
            throw new IndexOutOfBoundsException("The index provided is out of bounds.");
        reset();
        for (int i = 0; i < index; i++)
        {
            previous = current;
            current = current.getPointer();
        }
        return current.getElement();
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
    |    Resets current to head if current has reached the end of the
    |    list, or sets current to current.getPointer().
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
        current = head;
        previous = null;
        location = 0;
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
