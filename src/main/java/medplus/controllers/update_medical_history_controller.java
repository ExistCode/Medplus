package medplus.controllers;

import java.io.IOException;
import java.time.LocalTime;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.data.MedicalHistoryData;
import medplus.models.MedicalHistory;

public class update_medical_history_controller {

    @FXML
    private ImageView backButton;

    @FXML
    private TextField complicationTextField;

    @FXML
    private DatePicker dateAnalysisDatePicker;

    @FXML
    private TextField observationTextField;

    @FXML
    private TextField patientIdTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    private Pane updateMedHisButton;

    @FXML
    void updateMedHis(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage.isEmpty()) {
            MedicalHistory updatedMedHis = new MedicalHistory(
                    MedicalHistoryData.initMedicalHistoryData.getMedHisId(),
                    patientIdTextField.getText(),
                    staffIDTextField.getText(),
                    dateAnalysisDatePicker.getValue(),
                    LocalTime.now(),
                    resultTextField.getText(),
                    observationTextField.getText(),
                    complicationTextField.getText());

            MedicalHistoryData.updateMedicalHistory(updatedMedHis);
            App.setRoot("patients_details_screen_analysis");
        } else {
            System.out.println(errorMessage);
        }

    }

    private String validateInput() {
        String errorMessage = "";

        if (staffIDTextField.getText().isEmpty() ||
                dateAnalysisDatePicker.getValue() == null ||
                resultTextField.getText().isEmpty() ||
                observationTextField.getText().isEmpty() ||
                complicationTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled.";
        }

        return errorMessage;
    }

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen_analysis");
    }

    @FXML
    public void initialize() {
        patientIdTextField.setText(MedicalHistoryData.initMedicalHistoryData.getPatientId());
        staffIDTextField.setText(MedicalHistoryData.initMedicalHistoryData.getStaffId());
        dateAnalysisDatePicker.setValue(MedicalHistoryData.initMedicalHistoryData.getDate());
        resultTextField.setText(MedicalHistoryData.initMedicalHistoryData.getResult());
        observationTextField.setText(MedicalHistoryData.initMedicalHistoryData.getObservation());
        complicationTextField.setText(MedicalHistoryData.initMedicalHistoryData.getComplication());
    }

}
