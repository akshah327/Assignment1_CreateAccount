package LoginScreen;

import LoginSuccessful.LoginSuccessfulView; //allows us to instantiate a view of the LoginSuccessful screen
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
    public void confirmEntry() throws IOException
    {
        //for (int i = 0; i < UserDB.getUsers().size(); i++)
        User userFromInput = new User(username.getText(),password.getText());
        System.out.println("User From Input");
        System.out.println(userFromInput);
        User userFromDB = UserDB.getUsers().get(userFromInput);
        System.out.println("User From DB");
        System.out.println(userFromDB);
        if(userFromDB!=null)
        {
            if (userFromDB.getUsername().equals(userFromInput.getUsername())
                    && userFromDB.getPassword().equals(userFromInput.getPassword()))
            {
                new LoginSuccessfulView();
            }
            else
            {
                invalidInput.setText("Invalid username and/or password. Please try again.");
            }
        } else {
            invalidInput.setText("Username does not exist. Please try again, or sign up.");
            System.out.println(UserDB.getUsers());
        }

    }
}