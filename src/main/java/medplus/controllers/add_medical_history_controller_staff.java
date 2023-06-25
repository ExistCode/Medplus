package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.MedicalHistoryData;
import medplus.data.StaffData;
import medplus.models.MedicalHistory;

public class add_medical_history_controller_staff {

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
    private Text errorMessageDisplay;

    @FXML
    void addNewMedHis(MouseEvent event) {
        String errorMessage = validateInput();

        if (errorMessage.isEmpty()) {
            List<MedicalHistory> medicalHistoryList = MedicalHistoryData
                    .fetchAllMedicalHistoryDataFromDatabase();
            int newMedHisId = Integer
                    .parseInt(medicalHistoryList.get(medicalHistoryList.size() - 1).getMedHisId().substring(2))
                    + 1;
            String newMedHisIdFormatted = String.format("MH%03d", newMedHisId);
            String patientId = patientIdTextField.getText();
            String staffId = staffIDTextField.getText();
            LocalDate date = medHisDatePicker.getValue();
            String result = resultTextField.getText();
            String observation = observationTextField.getText();
            String complication = complicationTextField.getText();

            MedicalHistory newMedicalHistory = new MedicalHistory(newMedHisIdFormatted, patientId, staffId, date,
                    LocalTime.now(), result,
                    observation, complication); // Empty medHisId parameter
            MedicalHistoryData.addNewMedicalHistory(newMedicalHistory);
            System.out.println("Medical History added");

            try {
                App.setRoot("staff_details_analysis_screen");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    @FXML
    void backToStaffDetails(MouseEvent event) throws IOException {
        App.setRoot("staff_details_screen");
    }

    private String validateInput() {
        String errorMessage = "";

        if (patientIdTextField.getText().isEmpty() || staffIDTextField.getText().isEmpty()
                || medHisDatePicker.getValue() == null || resultTextField.getText().isEmpty()
                || observationTextField.getText().isEmpty() || complicationTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled.";
            errorMessageDisplay.setText(errorMessage);
        }

        return errorMessage;
    }

    @FXML
    public void initialize() {
        staffIDTextField.setText(StaffData.initStaffData.getStaffId());
    }

}
