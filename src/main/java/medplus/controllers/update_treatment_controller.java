package medplus.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;

public class update_treatment_controller {

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateEndDatePicker;

    @FXML
    private DatePicker dateStartDatePicker;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    private TextField treatmentDetailsTextField;

    @FXML
    private Pane updateTreatmentButton;

    @FXML
    void backToSearch(MouseEvent event) throws IOException{
        App.setRoot("search_treatment_screen");
    }

}
