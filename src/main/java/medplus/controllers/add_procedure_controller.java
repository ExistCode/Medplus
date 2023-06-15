package medplus.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;

public class add_procedure_controller {

    @FXML
    private Pane addProcedureButton;

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateStartDatePicker;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField prodecureDetailsTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    private TextField timeTextField;

    @FXML
    private ComboBox<?> typeComboBox;

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_procedure_screen");
    }
    //cannot function

}
