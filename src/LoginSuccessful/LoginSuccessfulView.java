package LoginSuccessful;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginSuccessfulView
{


    public LoginSuccessfulView() throws IOException
    {
        Stage welcomeStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LoginSuccessfulJavaFX.fxml"));
        welcomeStage.setTitle("Welcome");
        welcomeStage.setScene(new Scene(root, 500, 300));
        welcomeStage.show();
    }

}
