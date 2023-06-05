package medplus.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import medplus.App;

import java.io.IOException;

public class LoginController {
    @FXML
    private PasswordField Password;

    @FXML
    private TextField Username;

    @FXML
    private Button button;
    @FXML
    private Label label;

    String username;
    String password;
    String adminUsername = "admin";
    String adminPassword = "admin123";

    @FXML
    void SignIn(ActionEvent event) throws IOException {
        try {
            username = Username.getText();
            password = Password.getText();
            if (!username.isEmpty() || !password.isEmpty()) {
                if (username.equals(adminUsername) && password.equals(adminPassword)) {
                    App.setRoot("homescreen");
                } else {
                    label.setText("!Wrong username or password. Try again.");
                }

            } else {
                label.setText("Username and password can't be empty.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
