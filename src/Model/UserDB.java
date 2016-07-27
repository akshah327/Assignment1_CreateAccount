package Model;

import utils.LinkedListOrderedList;
import utils.LinkedListStack;

import java.util.ArrayList;

/**
 * Created by anujshah on 6/30/16.
 */
public class UserDB
{
    private static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getUsers()
    {
        return users;
    }

    public static void setUsers(ArrayList<User> users)
    {
        UserDB.users = users;
    }
}
