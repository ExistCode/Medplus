package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.data.MedicalHistoryData;
import medplus.data.PatientData;
import medplus.models.MedicalHistory;

public class add_medical_history_controller {

    @FXML
    private Pane addMedHisButton;

    @FXML
    private ImageView backButton;

    @FXML
    private TextField complicationTextField;

    @FXML
    private DatePicker medHisDatePicker;

    @FXML
    private TextField observationTextField;

    @FXML
    private TextField patientIdTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen_analysis");
    }

    @FXML
    void addNewMedHis(MouseEvent event) {
        String errorMessage = validateInput();

        if (errorMessage.isEmpty()) {
            String patientId = patientIdTextField.getText();
            String staffId = staffIDTextField.getText();
            LocalDate date = medHisDatePicker.getValue();
            String result = resultTextField.getText();
            String observation = observationTextField.getText();
            String complication = complicationTextField.getText();

            MedicalHistory newMedicalHistory = new MedicalHistory(patientId, staffId, date, LocalTime.now(), result,
                    observation,
                    complication);
            MedicalHistoryData.addNewMedicalHistory(newMedicalHistory);

            try {
                App.setRoot("patients_details_screen_analysis");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (patientIdTextField.getText().isEmpty() || staffIDTextField.getText().isEmpty()
                || medHisDatePicker.getValue() == null || resultTextField.getText().isEmpty()
                || observationTextField.getText().isEmpty() || complicationTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled.";
        }

        return errorMessage;
    }

    @FXML
    public void initialize() {
        patientIdTextField.setText(PatientData.initPatientData.getPatientId());
    }

}
