package medplus.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;

import java.io.IOException;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;

public class navigation_controller {
    // @FXML
    // private TextField Username;
    // @FXML
    // private PasswordField Password;

    @FXML
    private Button button;
    @FXML
    private Pane dashboardbutton;

    @FXML
    private Pane patientsbutton;

    @FXML
    private Pane searchbutton;

    @FXML
    private Pane staffButton;

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("home_screen");
    }

    // String username = Username.getText();
    // String password = Password.getText();

    @FXML
    void changedToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients_home_screen");

    }

    @FXML
    void changedToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_home_screen");
    }

    @FXML
    void changedToStaff(MouseEvent event) throws IOException {
        App.setRoot("staff_home_screen");
    }

}
