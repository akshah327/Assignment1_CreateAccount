/**
 * Class: LinkedListQueue
 * Author: Anuj Shah
 *
 * Purpose: The LinkedListQueue class provides methods and instance variables for
 * creating an linked list queue. Elements are added to the end of the queue
 * and removed from the beginning of the queue, thus creating a "first in,
 * first out" data structure. This is a parameterized class, so any object
 * may be placed into the queue.
 *
 * Constants: None.
 *
 * Class Methods:
 *  - public ArrayQueue()
 *  - public ArrayQueue(LinkedListNode head, LinkedListNode tail)
 *  - public T insertInQueue()
 *  - public T deQueue()
 *  - public int size()
 *  - public boolean isEmpty()
 *  - public String toString()
 *
 * Instance Methods:
 *  - private LinkedListNode head
 *  - private LinkedListNode tail
 *  - private int countOfElements
 *
 */

package utils;

/**
 * Created by anujshah on 7/6/16.
 */
public class LinkedListQueue<T> implements InterfaceQueue<T>
{
     /*
    private LinkedListNode head - points to the first node in the queue
    private LinkedListNode tail - points to the last node in the queue
    private int countOfElements - keeps track of the number of elements
        in the queue
     */

    private LinkedListNode head;
    private LinkedListNode tail;
    private int countOfElements;


    /*-------------------------------------------------------------------
    | Method: LinkedListQueue()
    |
    | Efficiency: O(1)
    |
    | Purpose: Default constructor for the linked list queue.
    |
    | Pre-condition: None.
    |
    | Post-condition: Sets the head and tail to null, and establishes
    |   the basis for the queue.
    |
    | Parameters: None.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public LinkedListQueue()
    {
        this.head = null;
        this.tail = null;
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
    | Post-condition: Sets LinkedListNode head and tail to the user
    |   specified nodes, and establishes the basis for the queue.
    |
    | Parameters: LinkedListNode head, LinkedListNode tail.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    public LinkedListQueue(LinkedListNode head, LinkedListNode tail)
    {
        this.head = head;
        this.tail = tail;
    }


    /*-------------------------------------------------------------------
    | Method: insertInQueue()
    |
    | Efficiency: O(1)
    |
    | Purpose: Adds a node with the user specified element at the end of
    |    the queue.
    |
    | Pre-condition: None.
    |
    | Post-condition: Adds a node with the user specified element at the
    |    end of the queue, and sets tail to this new node.
    |
    | Parameters: T element.
    |
    | Returns: None.
    |
     -------------------------------------------------------------------*/

    @Override
    public void insertInQueue(T element)
    {
        LinkedListNode newNode = new LinkedListNode(element);
        if (!isEmpty())
        {
            tail.setPointer(newNode);
        }
        else
        {
            head = newNode;
        }
        tail = newNode;
        countOfElements++;
    }


    /*-------------------------------------------------------------------
    | Method: deQueue()
    |
    | Efficiency: O(1)
    |
    | Purpose: Removes the first node of the queue.
    |
    | Pre-condition: None.
    |
    | Post-condition: Removes the first node and returns its element,
    |   or returns null if the list is empty. Also sets head to
    |   head.getPointer().
    |
    | Parameters: None.
    |
    | Returns: originalHeadElement.
    |
     -------------------------------------------------------------------*/

    @Override
    public T deQueue()
    {
        T originalHeadElement = (T) head.getElement();
        head = head.getPointer();
        countOfElements--;
        return originalHeadElement;

        //Returns whatever node is at the start of the list
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
    |   the queue contains any number of nodes.
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

        //if the head is null, then there are no nodes in the queue
    }


    /*-------------------------------------------------------------------
    | Method: size()
    |
    | Efficiency: O(1)
    |
    | Purpose: Provides the count of nodes currently in the queue.
    |
    | Pre-condition: None.
    |
    | Post-condition: Provides the count of nodes currently in the
    |   queue.
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
        String listString = "List:\n";
        LinkedListNode tracker = head;
        while (tracker != null)
        {
            listString = listString + " " + tracker.getElement() + "\n";
            tracker = tracker.getPointer();
        }
        return listString;
    }
}
