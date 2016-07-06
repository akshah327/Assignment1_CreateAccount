package SignupScreen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupView
{
    private static Stage signupStage = new Stage();

    public static Stage getSignupStage()
    {
        return signupStage;
    }

    public SignupView() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("SignupJavaFX.fxml"));
        signupStage.setTitle("Create Account");
        signupStage.setScene(new Scene(root, 800, 500));
        signupStage.show();
    }

}