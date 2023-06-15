package medplus.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;

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

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_diagnosis_screen");
    }

}
