package Model;

import java.io.*;

/**
 * Created by anujshah on 6/30/16.
 */
public class UserIO<T>
{
    public static void writeUsers(Object data) throws IOException
    {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("users.dat"));
        output.writeObject(data);
    }

    public static Object readUsers() throws IOException, ClassNotFoundException
    {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("users.dat"));
        return input.readObject();
    }
}
