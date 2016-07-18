package Exceptions;

/**
 * Created by anujshah on 7/9/16.
 */
public class fullListException extends Exception
{
    public fullListException()
    {
        super("The list is full.");
    }

    public fullListException(String message)
    {
        super(message);
    }
}
