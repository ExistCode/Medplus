package medplus.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class update_diagnosis_controller {

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateDiagnosedDatePicker;

    @FXML
    private TextField diagnosisTextField;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    private Pane updateDiagnosisButton;

}
