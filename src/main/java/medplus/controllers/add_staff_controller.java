package medplus.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;

public class add_staff_controller {

    @FXML
    private Pane addStaffButton;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField addressTextField1;

    @FXML
    private TextField addressTextField2;

    @FXML
    private ImageView backButton;

    @FXML
    private TextField contactNumberTextField;

    @FXML
    private TextField contactNumberTextField1;

    @FXML
    private DatePicker dateOfBirthSelector;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField nationalIdTextField;

    @FXML
    void addStaff(MouseEvent event) {

    }

    @FXML
    void backToStaff(MouseEvent event) throws IOException {
        App.setRoot("staff_all_home_screen");
    }

}
