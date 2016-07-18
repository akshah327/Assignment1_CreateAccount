/**
 * Class: ArrayStack
 * Author: Anuj Shah
 *
 * Purpose: The ArrayStack class provides methods and instance variables for
 * creating an array-based stack. Elements are added to the top, and removed
 * from the top, thus creating a "first in, last out" data structure. This
 * is a parameterized class, so any object may be placed into the stack.
 *
 * Constants: None.
 *
 * Class Methods:
 *  - public ArrayStack()
 *  - public ArrayStack(T[] stack)
 *  - public T top()
 *  - public T pop()
 *  - public void push(T element)
 *  - public int size()
 *  - public boolean isEmpty()
 *  - public boolean isFull()
 *  - public String toString()
 *
 * Instance Methods:
 *  - private T[] stack
 *  - private int countOfElements
 *
 */

package utils;


import Exceptions.emptyListException;
import Exceptions.fullListException;

public class ArrayStack<T> implements IArrayStack<T>
{
    /*
    private T[] stack - the array for the stack
    private int countOfElements - keeps track of the number of elements
        in the stack
     */

    private T[] stack;
    private int countOfElements = 0;

    /*-------------------------------------------------------------------
    | Method: ArrayStack()
    |
    | Efficiency: O(N)
    |
    | Purpose: Default constructor for the array-based stack.
    |
    | Pre-condition: None.
    |
    | Post-condition: Creates an array with 10 elements that is to be
    |   used as a stack.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/
    public ArrayStack()
    {
        this.stack = (T[]) new Object[10];
    }


    /*-------------------------------------------------------------------
    | Method: ArrayStack(T[] stack)
    |
    | Efficiency: O(N)
    |
    | Purpose: Explicit constructor for the array-based stack.
    |
    | Pre-condition: None.
    |
    | Post-condition: Creates an array with the number of elements
    |   designated by the user that is to be used as a stack.
    |
    | Parameters: T[] stack.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public ArrayStack(T[] stack)
    {
        this.stack = stack;
    }


    /*-------------------------------------------------------------------
    | Method: top()
    |
    | Efficiency: O(1)
    |
    | Purpose: Returns the element at the top of the stack.
    |
    | Pre-condition: The list is not empty.
    |
    | Post-condition: Returns either the element at the top of the stack,
    |   or throws an emptyListException and returns null.
    |
    | Parameters: None.
    |
    | Returns: stack[countOfElements-1], or null
    |
     -------------------------------------------------------------------*/

    @Override
    public T top()
    {
        try
        {
            if (isEmpty())
            {
                throw new emptyListException();
            }
            return stack[countOfElements-1];
        }
        catch (emptyListException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    /*-------------------------------------------------------------------
    | Method: pop()
    |
    | Efficiency: O(1)
    |
    | Purpose: Removes the element at the top of the stack.
    |
    | Pre-condition: The list is not empty.
    |
    | Post-condition: Removes the element at the top of the stack,
    |   or throws an emptyListException and returns null.
    |
    | Parameters: None.
    |
    | Returns: stack[countOfElements-1], or null
    |
     -------------------------------------------------------------------*/

    @Override
    public T pop()
    {
        try
        {
            if (isEmpty())
            {
                throw new emptyListException();
            }
            Object firstElement = stack[countOfElements-1];
            stack[countOfElements-1] = null;
            countOfElements--;
            return (T) firstElement;
        }
        catch (emptyListException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    /*-------------------------------------------------------------------
    | Method: push()
    |
    | Efficiency: O(1)
    |
    | Purpose: Adds an element to the top of the stack.
    |
    | Pre-condition: The list is not full.
    |
    | Post-condition: Adds an element to the top of the stack, or throws
    |   a fullListException.
    |
    | Parameters: T element.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public void push(T element)
    {
        try
        {
            if (isFull())
            {
                throw new fullListException();
            }
            stack[countOfElements] = element;
            countOfElements++;
        }
        catch (fullListException e)
        {
            System.out.println(e.getMessage());
        }
    }


    /*-------------------------------------------------------------------
    | Method: isEmpty()
    |
    | Efficiency: O(1)
    |
    | Purpose: Determines whether the stack is empty.
    |
    | Pre-condition: None.
    |
    | Post-condition: Returns true if the stack is empty, false if the
    |   stack contains any number of elements.
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
    | Purpose: Provides the user with the current number of elements in
    |   the stack.
    |
    | Pre-condition: None.
    |
    | Post-condition: Returns the number of elements currently in the
    |   stack.
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
    | Method: isFull()
    |
    | Efficiency: O(1)
    |
    | Purpose: Determines whether the stack is full.
    |
    | Pre-condition: None.
    |
    | Post-condition: Returns true if the stack is full, false if the
    |   stack contains any number of elements less than 10.
    |
    | Parameters: None.
    |
    | Returns: true or false.
    |
     -------------------------------------------------------------------*/

    @Override
    public boolean isFull()
    {
        return (countOfElements == stack.length);
    }


    /*-------------------------------------------------------------------
    | Method: toString()
    |
    | Efficiency: O(N)
    |
    | Purpose: Returns the elements of the stack in an easy-to-read
    |    format.
    |
    | Pre-condition: None.
    |
    | Post-condition: Prints the contents of the stack to the screen.
    |
    | Parameters: None.
    |
    | Returns: listString (a concatenated string of the stack elements)
    |
     -------------------------------------------------------------------*/

    @Override
    public String toString()
    {
        String listString = "";
        for (int i = 0; i < countOfElements; i++)
        {
            listString+="{"+stack[i]+"} ";
        }
        return listString;
    }
}
