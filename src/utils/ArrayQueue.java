/**
 * Class: ArrayQueue
 * Author: Anuj Shah
 *
 * Purpose: The ArrayQueue class provides methods and instance variables for
 * creating an array-based queue. Elements are added to the end of the queue
 * and removed from the beginning of the queue, thus creating a "first in,
 * first out" data structure. This is a parameterized class, so any object
 * may be placed into the queue.
 *
 * Constants: None.
 *
 * Class Methods:
 *  - public ArrayQueue()
 *  - public ArrayQueue(T[] queue)
 *  - public T insertInQueue()
 *  - public T deQueue()
 *  - public int size()
 *  - public boolean isEmpty()
 *  - public boolean isFull()
 *  - public String toString()
 *
 * Instance Methods:
 *  - private T[] queue
 *  - private int countOfElements
 *
 */

package utils;

import Exceptions.emptyListException;
import Exceptions.fullListException;

public class ArrayQueue<T> implements IArrayQueue<T>
{
     /*
    private T[] queue - the array for the queue
    private int countOfElements - keeps track of the number of elements
        in the queue
     */

    private T[] queue;
    private int countOfElements;


    /*-------------------------------------------------------------------
    | Method: ArrayQueue()
    |
    | Efficiency: O(N)
    |
    | Purpose: Default constructor for the array-based queue.
    |
    | Pre-condition: None.
    |
    | Post-condition: Creates an array with 10 elements that is to be
    |   used as a queue.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public ArrayQueue()
    {
        queue = (T[]) new Object[10];
    }


    /*-------------------------------------------------------------------
    | Method: ArrayQueue()
    |
    | Efficiency: O(N)
    |
    | Purpose: Explicit constructor for the array-based queue.
    |
    | Pre-condition: None.
    |
    | Post-condition: Creates an array with the number of elements
    |   designated by the user that is to be used as a stack.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public ArrayQueue(T[] queue)
    {
        this.queue = queue;
    }


    /*-------------------------------------------------------------------
    | Method: insertInQueue()
    |
    | Efficiency: O(1)
    |
    | Purpose: Adds an element at the end of the queue.
    |
    | Pre-condition: The list is not full.
    |
    | Post-condition: Adds an element at the end of the queue, or throws
    |   a fullListException.
    |
    | Parameters: T element.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public void insertInQueue(T element)
    {
        try
        {
            if (isFull())
            {
                throw new fullListException();
            }
            queue[countOfElements] = element;
            countOfElements++;
        }
        catch (fullListException e)
        {
            System.out.println(e.getMessage());
        }
    }


    /*-------------------------------------------------------------------
    | Method: deQueue()
    |
    | Efficiency: O(1)
    |
    | Purpose: Removes the first element of the queue.
    |
    | Pre-condition: The list is not empty.
    |
    | Post-condition: Removes and returns the first element of the
    |   queue, or throws a fullListException.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public T deQueue()
    {
        try
        {
            if (isEmpty())
            {
                throw new emptyListException();
            }
            T removedElement = queue[0];
            for (int i = 0; i < countOfElements-1; i++)
            {
                queue[i] = queue[i+1];
            }
            queue[countOfElements-1] = null;
            countOfElements--;
            return removedElement;
        }
        catch (emptyListException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    /*-------------------------------------------------------------------
    | Method: isEmpty()
    |
    | Efficiency: O(1)
    |
    | Purpose: Determines whether the queue is empty.
    |
    | Pre-condition: None.
    |
    | Post-condition: Returns true if the queue is empty, or false if
    |   the queue contains any number of elements.
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
    | Purpose: Provides the count of elements currently in the queue.
    |
    | Pre-condition: None.
    |
    | Post-condition: Provides the count of elements currently in the
    |   queue.
    |
    | Parameters: None.
    |
    | Returns: countOfElements.
    |
     -------------------------------------------------------------------*/

    public int size()
    {
        return countOfElements;
    }


    /*-------------------------------------------------------------------
    | Method: isEFull()
    |
    | Efficiency: O(1)
    |
    | Purpose: Determines whether the queue is full.
    |
    | Pre-condition: None.
    |
    | Post-condition: Returns true if the queue is full, or false if
    |   the queue contains any number of elements less than 10.
    |
    | Parameters: None.
    |
    | Returns: true or false.
    |
     -------------------------------------------------------------------*/

    @Override
    public boolean isFull()
    {
        return (countOfElements == queue.length);
    }


    /*-------------------------------------------------------------------
    | Method: toString()
    |
    | Efficiency: O(N)
    |
    | Purpose: Returns the elements of the queue in an easy-to-read
    |    format.
    |
    | Pre-condition: None.
    |
    | Post-condition: Prints the contents of the queue to the screen.
    |
    | Parameters: None.
    |
    | Returns: listString (a concatenated string of the queue elements)
    |
     -------------------------------------------------------------------*/

    @Override
    public String toString()
    {
        String listString = "";
        for (int i = 0; i < countOfElements; i++)
        {
            listString+="{"+queue[i]+"} ";
        }
        return listString;
    }
}
