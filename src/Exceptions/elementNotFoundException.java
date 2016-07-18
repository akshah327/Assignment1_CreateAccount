package Exceptions;

/**
 * Created by anujshah on 7/10/16.
 */
public class elementNotFoundException extends Exception
{
    public elementNotFoundException()
    {
        super("Element not found.");
    }

    public elementNotFoundException(String message)
    {
        super(message);
    }
}
