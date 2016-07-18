package Exceptions;

/**
 * Created by anujshah on 7/9/16.
 */
public class emptyListException extends Exception
{
    public emptyListException()
    {
        super("The stack is empty.");
    }

    public emptyListException(String message)
    {
        super(message);
    }
}
