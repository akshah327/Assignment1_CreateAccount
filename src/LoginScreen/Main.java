package LoginScreen;

import Model.User; //Used in loading ArrayList of established users
import Model.UserDB; //Same as above
import Model.UserIO; //Same as above
import javafx.application.Application; //allows main class to inherit from parent Application
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.LinkedListOrderedList;
import utils.LinkedListStack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        loadUserDB();
        Parent root = FXMLLoader.load(getClass().getResource("LoginJavaFX.fxml"));
        primaryStage.setTitle("Login or Sign Up");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.show();
    }

    private void loadUserDB()
    {
        try
        {
            UserDB.setUsers((LinkedListOrderedList<User>)UserIO.readUsers());
        }
        catch (IOException e)
        {
            System.out.println("Error1");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}

