package SignupScreen;

import Model.User;
import Model.UserDB;
import Model.UserIO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class SignupController
{
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField gender;
    @FXML
    DatePicker DOB;
    @FXML
    TextField SSN;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    PasswordField confirmPW;
    @FXML
    TextField email;
    @FXML
    TextField phoneNumber;
    @FXML
    TextField photo;
    @FXML
    Label errorLabel;

    String errorText = "";

    public static final String BLANK_FIELD_ERROR = "No blank fields allowed.";
    public static final String SSN_ERROR = "SSN must contain 9 digits.";
    public static final String PASSWORD_MISMATCH_ERROR = "Password and confirm password fields must match.";
    public static final String PASSWORD_PATTERN_ERROR = "Incorrect password format.";
    public static final String EMAIL_ERROR = "Incorrect email format.";
    public static final String PHONE_ERROR = "Phone number must use the format x-xxx-xxx-xxxx (including dashes).";

    boolean firstNameStatus = false;
    boolean lastNameStatus = false;
    boolean genderStatus = false;
    boolean dobStatus = false;
    boolean ssnStatus = false;
    boolean usernameStatus = false;
    boolean passwordStatus = false;
    boolean confirmPwStatus = false;
    boolean emailStatus = false;
    boolean phoneNumberStatus = false;
    boolean photoStatus = false;
    boolean allCorrect = false;


    public void findPhoto()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(SignupView.getSignupStage());
        photo.setText(selectedFile.getPath());
    }


    public void createNewAccount()
    {
        String emailPattern = "\\w+@\\w+\\.\\w{3}";
        String phonePattern = "\\d{1,2}-\\d{3}-\\d{3}-\\d{4}";
        String pwdPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[`~!@#$%^&*-_=+|<>?]).{8,})";
        String ssnPattern = "\\d{9}";

        errorText = "";

        resetBorders();

        firstNameStatus = (validate(firstName));
        lastNameStatus = (validate(lastName));
        genderStatus = (validate(gender));
        dobStatus = validate(DOB);
        ssnStatus = (validate(SSN));
        usernameStatus = (validate(username));
        passwordStatus = (validate(password));
        confirmPwStatus = (validate(confirmPW));
        emailStatus = (validate(email));
        phoneNumberStatus = (validate(phoneNumber));
        photoStatus = (validate(photo));


        if (!(firstNameStatus && lastNameStatus && genderStatus && ssnStatus
                && usernameStatus && passwordStatus && confirmPwStatus && emailStatus &&
                phoneNumberStatus && photoStatus))
        {
            errorText+=BLANK_FIELD_ERROR + "\n";
            if (!firstNameStatus)
            {
                firstName.setStyle("-fx-border-color: red");
            }
            if (!lastNameStatus)
            {
                lastName.setStyle("-fx-border-color: red");
            }
            if (!genderStatus)
            {
                gender.setStyle("-fx-border-color: red");
            }
            if (!dobStatus)
            {
                DOB.setStyle("-fx-border-color: red");
            }
            if (!ssnStatus)
            {
                SSN.setStyle("-fx-border-color: red");
            }
            if (!usernameStatus)
            {
                username.setStyle("-fx-border-color: red");
            }
            if (!passwordStatus)
            {
                password.setStyle("-fx-border-color: red");
            }
            if (!confirmPwStatus)
            {
                confirmPW.setStyle("-fx-border-color: red");
            }
            if (!emailStatus)
            {
                email.setStyle("-fx-border-color: red");
            }
            if (!phoneNumberStatus)
            {
                phoneNumber.setStyle("-fx-border-color: red");
            }
            if (!photoStatus)
            {
                photo.setStyle("-fx-border-color: red");
            }
        }
        if (!SSN.getText().matches(ssnPattern))
        {
            ssnStatus = false;
            errorText+=SSN_ERROR + "\n";
            SSN.setStyle("-fx-border-color: red");
        }
        if (!password.getText().equals(confirmPW.getText()))
        {
            passwordStatus = false;
            confirmPwStatus = false;
            errorText+=PASSWORD_MISMATCH_ERROR + "\n";
            password.setStyle("-fx-border-color: red");
            confirmPW.setStyle("-fx-border-color: red");
        }
        if (!password.getText().matches(pwdPattern))
        {
            passwordStatus = false;
            errorText+=PASSWORD_PATTERN_ERROR + "\n";
            password.setStyle("-fx-border-color: red");
        }
        if (!email.getText().matches(emailPattern))
        {
            emailStatus = false;
            errorText+=EMAIL_ERROR + "\n";
            email.setStyle("-fx-border-color: red");
        }
        if (!phoneNumber.getText().matches(phonePattern))
        {
            phoneNumberStatus = false;
            errorText+=PHONE_ERROR + "\n";
            phoneNumber.setStyle("-fx-border-color: red");
        }
        if (firstNameStatus && lastNameStatus && genderStatus && dobStatus && ssnStatus &&
                usernameStatus && passwordStatus && confirmPwStatus && emailStatus &&
                phoneNumberStatus && photoStatus)
        {
            errorText = "User Account Created.";
            User user = new User(firstName.getText(), lastName.getText(), gender.getText(), DOB.getPromptText(),
                    SSN.getText(), username.getText(), password.getText(), email.getText(),
                    phoneNumber.getText(), photo.getText());
            UserDB.getUsers().add(user);
            try
            {
                UserIO.writeUsers(UserDB.getUsers());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        errorLabel.setText(errorText);
    }


    private boolean validate(TextField tf)
    {
        boolean pass = false;
        ObservableList<String> styleClass = tf.getStyleClass();
        if (tf.getText().trim().length() == 0)
        {
            if (!styleClass.contains("error"))
            {
                styleClass.add("error");
            }
        }
        else
        {
            styleClass.removeAll(Collections.singleton("error"));
            pass = true;
        }
        return pass;
    }


    private boolean validate(PasswordField pf)
    {
        boolean pass = false;
        ObservableList<String> styleClass = pf.getStyleClass();
        if (pf.getText().trim().length() == 0)
        {
            if (!styleClass.contains("error"))
            {
                styleClass.add("error");
            }
        }
        else
        {
            styleClass.removeAll(Collections.singleton("error"));
            pass = true;
        }
        return pass;
    }


    private boolean validate(DatePicker dob)
    {
        boolean pass = false;
        ObservableList<String> styleClass = dob.getStyleClass();
        if (dob == null)
        {
            if (!styleClass.contains("error"))
            {
                styleClass.add("error");
            }
        }
        else
        {
            styleClass.removeAll(Collections.singleton("error"));
            pass = true;
        }
        return pass;
    }


    private void resetBorders()
    {
        firstName.setStyle("-fx-border-color: lightgrey");
        lastName.setStyle("-fx-border-color: lightgrey");
        gender.setStyle("-fx-border-color: lightgrey");
        DOB.setStyle("-fx-border-color: lightgrey");
        SSN.setStyle("-fx-border-color: lightgrey");
        username.setStyle("-fx-border-color: lightgrey");
        password.setStyle("-fx-border-color: lightgrey");
        confirmPW.setStyle("-fx-border-color: lightgrey");
        email.setStyle("-fx-border-color: lightgrey");
        phoneNumber.setStyle("-fx-border-color: lightgrey");
        photo.setStyle("-fx-border-color: lightgrey");
    }

}