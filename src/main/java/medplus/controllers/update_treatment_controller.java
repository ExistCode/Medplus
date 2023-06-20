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
import medplus.data.TreatmentData;
import medplus.models.Treatment;

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
    private Text errorMessageDisplay;

    @FXML
    void backToSearch(MouseEvent event) throws IOException{
        App.setRoot("search_treatment_screen");
    }

    @FXML
    void updateTreatment(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {

            Treatment newTreatment = new Treatment(TreatmentData.initTreatmentData.getTreatmentId(), patientNameTextField.getText(),
                    staffIDTextField.getText(),
                    dateStartDatePicker.getValue(),
                    dateEndDatePicker.getValue(),
                    treatmentDetailsTextField.getText());
            TreatmentData.updateTreatmentData(newTreatment);
            App.setRoot("search_treatment_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (patientNameTextField.getText().isEmpty() || staffIDTextField.getText().isEmpty()
                || dateStartDatePicker.getValue() == null || dateEndDatePicker.getValue() == null
                || treatmentDetailsTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }

        return errorMessage;
    }

    @FXML
    public void initialize() {
        patientNameTextField.setText(TreatmentData.initTreatmentData.getPatientName());
        staffIDTextField.setText(TreatmentData.initTreatmentData.getDoctorId());
        dateStartDatePicker.setValue(TreatmentData.initTreatmentData.getStartDate());
        dateEndDatePicker.setValue(TreatmentData.initTreatmentData.getEndDate());
        treatmentDetailsTextField.setText(TreatmentData.initTreatmentData.getTreatmentInfo());
    }
}
