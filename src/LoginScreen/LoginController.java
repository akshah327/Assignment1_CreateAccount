package LoginScreen;

import LoginSuccessful.LoginSuccessfulView;
import Model.UserDB;
import SignupScreen.SignupView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController
{
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label invalidInput;

    public void openSignUp() throws IOException
    {
        new SignupView();
    }

    public void confirmEntry() throws IOException
    {
        for (int i = 0; i < UserDB.getUsers().size(); i++)
        {
            if (username.getText().equals(UserDB.getUsers().get(i).getUsername())
                    && password.getText().equals(UserDB.getUsers().get(i).getPassword()))
            {
                new LoginSuccessfulView();
            }
            else
            {
                invalidInput.setText("Invalid username and/or password. Please try again.");
            }
        }
    }
}