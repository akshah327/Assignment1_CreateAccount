package Exceptions;

/**
 * Created by anujshah on 7/14/16.
 */
public class elementAlreadyExistsException extends Exception
{
    public elementAlreadyExistsException()
    {
        super("The element already exists.");
    }

    public elementAlreadyExistsException(String message)
    {
        super(message);
    }
}
