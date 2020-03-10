package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.DataBaseHandler;
import sample.User;

import java.net.URL;
import java.util.ResourceBundle;

public class SingUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane loginSingUpButton;

    @FXML
    private TextField SignUpLName;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button inButton;

    @FXML
    private TextField login_field;

    @FXML
    private TextField SignUpFName;

    @FXML
    private TextField SignUpCountry;

    @FXML
    private CheckBox SignUpCheck1;

    @FXML
    private CheckBox SignUpCheck2;

    @FXML
    void initialize() {

        inButton.setOnAction(event ->
                singUpNewUser());
    }

    private void singUpNewUser() {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        String fname = SignUpFName.getText();
        String lname = SignUpLName.getText();
        String username = login_field.getText();
        String password = password_field.getText();
        String location = SignUpCountry.getText();
        String gender;

        if (SignUpCheck1.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";

        User user = new User(fname, lname, username, password, location, gender);

        dataBaseHandler.singUpUser(user);
    }
}

