/**
 * Class: LinkedListStack
 * Author: Anuj Shah
 *
 * Purpose: The LinkedListStack class provides methods and instance variables for
 * creating a linked list stack. Elements are added to the top, and removed
 * from the top, thus creating a "first in, last out" data structure. This
 * is a parameterized class, so any object may be placed into the stack.
 *
 * Constants: None.
 *
 * Class Methods:
 *  - public ArrayStack()
 *  - public ArrayStack(LinkedListNode top)
 *  - public T top()
 *  - public T pop()
 *  - public void push(T element)
 *  - public int size()
 *  - public boolean isEmpty()
 *  - public String toString()
 *
 * Instance Methods:
 *  - private LinkedListNode top
 *  - private int countOfElements
 *
 */

package utils;

import Exceptions.emptyListException;

/**
 * Created by anujshah on 7/6/16.
 */
public class LinkedListStack<T> implements InterfaceStack<T>
{
    /*
    private LinkedListNode top - Represents the top node of the stack.
    private int countOfElements - Keeps track of the number of elements
        in the stack.
     */

    private LinkedListNode top;
    private int countOfElements = 0;


    /*-------------------------------------------------------------------
    | Method: LinkedListStack()
    |
    | Efficiency: O(1)
    |
    | Purpose: Default constructor for the linked list stack.
    |
    | Pre-condition: None.
    |
    | Post-condition: Sets LinkedListNode top to null, and establishes
    |   the basis for the stack.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public LinkedListStack()
    {
        this.top = null;
    }


    /*-------------------------------------------------------------------
    | Method: LinkedListStack(LinkedListNode top)
    |
    | Efficiency: O(1)
    |
    | Purpose: Explicit constructor for the linked list stack.
    |
    | Pre-condition: None.
    |
    | Post-condition: Sets LinkedListNode top to the user specified
    |   node, and establishes the basis for the queue.
    |
    | Parameters: LinkedListNode top.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public LinkedListStack(LinkedListNode top)
    {
        this.top = top;
    }


    /*-------------------------------------------------------------------
    | Method: top()
    |
    | Efficiency: O(1)
    |
    | Purpose: Returns the element in the top node of the stack.
    |
    | Pre-condition: The list is not empty.
    |
    | Post-condition: Returns either the element at the top of the stack,
    |   or throws an emptyListException and returns null.
    |
    | Parameters: None.
    |
    | Returns: (T) top.getElement(), or null
    |
     -------------------------------------------------------------------*/

    @Override
    public T top()
    {
        try
        {
            if (isEmpty())
                throw new emptyListException();
            return (T) top.getElement();
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
    | Purpose: Removes the node at the top of the stack.
    |
    | Pre-condition: None.
    |
    | Post-condition: Removes the node at the top of the stack and
    |   returns its element, or returns null if the list is empty.
    |
    | Parameters: None.
    |
    | Returns: poppedNodeElement, or null
    |
     -------------------------------------------------------------------*/

    @Override
    public T pop()
    {
        T poppedNodeElement = (T) top.getElement();
        top = top.getPointer();
        countOfElements--;
        return poppedNodeElement;
    }


    /*-------------------------------------------------------------------
    | Method: push()
    |
    | Efficiency: O(1)
    |
    | Purpose: Adds a node to the top of the stack.
    |
    | Pre-condition: None.
    |
    | Post-condition: Adds a node to the top of the stack, and sets top
    |   to this new node.
    |
    | Parameters: T element.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public void push(T element)
    {
        LinkedListNode newTopNode = new LinkedListNode(element);
        newTopNode.setPointer(top);
        top = newTopNode;
        countOfElements++;
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
    |   stack contains any number of nodes.
    |
    | Parameters: None.
    |
    | Returns: true or false.
    |
     -------------------------------------------------------------------*/

    @Override
    public boolean isEmpty()
    {
        return(top == null);
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

    @Override
    public int size()
    {
        return countOfElements;
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

    public String toString()
    {
        String listString = "List:\n";
        LinkedListNode tracker = top;
        while (tracker != null)
        {
            listString = listString + " " + tracker.getElement() + "\n";
            tracker = tracker.getPointer();
        }
        return listString;
    }
}
