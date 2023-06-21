package medplus.controllers;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.DiagnosisData;
import medplus.models.Diagnosis;

public class add_diagnosis_controller {

    @FXML
    private Pane addDiagnosisButton;

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateOfBirthSelector;

    @FXML
    private TextField medAmountTextField;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_diagnosis_screen");
    }

    @FXML
    void addDiagnosis(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {
            List<Diagnosis> diagnosisList = DiagnosisData.fetchDiagnosisDataFromDatabase();
            int newDiagnosisId = Integer.parseInt(diagnosisList.get(diagnosisList.size() - 1).getDiagnosisId().substring(1))
                    + 1;
            String newDiagnosisIdFormatted = String.format("D%03d", newDiagnosisId);

            Diagnosis newDiagnosis = new Diagnosis(newDiagnosisIdFormatted, patientNameTextField.getText(),
                    staffIDTextField.getText(),
                    dateOfBirthSelector.getValue(),
                    medAmountTextField.getText());
            DiagnosisData.addNewDiagnosis(newDiagnosis);
            App.setRoot("search_diagnosis_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (patientNameTextField.getText().isEmpty() || staffIDTextField.getText().isEmpty()
                || dateOfBirthSelector.getValue() == null || medAmountTextField.getText().isEmpty()){
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }

        return errorMessage;
    }

}
