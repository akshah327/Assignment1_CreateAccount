package Model;

import utils.LinkedListOrderedList;
import utils.LinkedListStack;

import java.util.ArrayList;

/**
 * Created by anujshah on 6/30/16.
 */
public class UserDB
{
    private static LinkedListOrderedList<User> users = new LinkedListOrderedList<>();

    public static LinkedListOrderedList<User> getUsers()
    {
        return users;
    }

    public static void setUsers(LinkedListOrderedList<User> users)
    {
        UserDB.users = users;
    }
}
