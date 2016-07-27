package LoginScreen;

import HospitalGUI.HospitalView;
import Model.User;
import Model.UserDB; //allows access to the ArrayList created to store users
import SignupScreen.SignupView; //allows us to instantiate a view of the Signup screen
import javafx.fxml.FXML;
//links TextField, PasswordField, and Label from the login screen to controls in this class
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * @author anuj
 *
 */
public class LoginController
{
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label invalidInput;

    /**
     *
     * @throws IOException
     */
    public void openSignUp() throws IOException
    {
        new SignupView();
    }

    /**
     *
     * @throws IOException
     */

    boolean exist=false;
    public void confirmEntry()
    {
        for(int i=0; i<UserDB.getUsers().size(); i++)
        {
            if (username.getText().equals(UserDB.getUsers().get(i).getUsername()) &&
                    password.getText().equals(UserDB.getUsers().get(i).getPassword()))
            {
                System.out.println("Welcome " +username.getText());
                try
                {
                    new HospitalView();
                }
                catch (IOException e)
                {
                    System.err.println("Error opening hospital list view!");
                    e.printStackTrace();
                }
                exist = true;
            }
            else
            {
                invalidInput.setText("Invalid username and/or password. Please try again.");
            }
        }

    }
}

//    public void confirmEntry() throws IOException
//    {
//        //for (int i = 0; i < UserDB.getUsers().size(); i++)
//        User userFromInput = new User(username.getText(),password.getText());
//        System.out.println("User From Input");
//        System.out.println(userFromInput);
//        User userFromDB = UserDB.getUsers().get(userFromInput);
//        System.out.println("User From DB");
//        System.out.println(userFromDB);
//        if(userFromDB!=null)
//        {
//            if (userFromDB.getUsername().equals(userFromInput.getUsername())
//                    && userFromDB.getPassword().equals(userFromInput.getPassword()))
//            {
//                new HospitalView();
//            }
//            else
//            {
//                invalidInput.setText("Invalid username and/or password. Please try again.");
//            }
//        } else {
//            invalidInput.setText("Username does not exist. Please try again, or sign up.");
//            System.out.println(UserDB.getUsers());
//        }
//
//    }