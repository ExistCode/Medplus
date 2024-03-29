package medplus.controllers;

import java.io.IOException;
import java.time.LocalTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.MedicalHistoryData;
import medplus.models.MedicalHistory;
import medplus.tableModels.PatientTableDataModel;
import medplus.tableModels.StaffTableDataModel;

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
    private ComboBox<String> patientIdComboBox;

    @FXML
    private TextField resultTextField;

    @FXML
    private ComboBox<String> staffIdComboBox;

    @FXML
    private Pane updateMedHisButton;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    void updateMedHis(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage.isEmpty()) {
            MedicalHistory updatedMedHis = new MedicalHistory(
                    MedicalHistoryData.initMedicalHistoryData.getMedHisId(),
                    patientIdComboBox.getSelectionModel().getSelectedItem(),
                    staffIdComboBox.getSelectionModel().getSelectedItem(),
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

    // Validate user input correct fields
    private String validateInput() {
        String errorMessage = "";

        if (staffIdComboBox.getSelectionModel().getSelectedItem().isEmpty() ||
                dateAnalysisDatePicker.getValue() == null ||
                resultTextField.getText().isEmpty() ||
                observationTextField.getText().isEmpty() ||
                complicationTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled.";
            errorMessageDisplay.setText(errorMessage);
        }

        return errorMessage;
    }

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen_analysis");
    }
    // Initialize the medical history details to be updated

    @FXML
    public void initialize() {
        patientIdComboBox.setValue(MedicalHistoryData.initMedicalHistoryData.getPatientId());
        staffIdComboBox.setValue(MedicalHistoryData.initMedicalHistoryData.getStaffId());
        dateAnalysisDatePicker.setValue(MedicalHistoryData.initMedicalHistoryData.getDate());
        resultTextField.setText(MedicalHistoryData.initMedicalHistoryData.getResult());
        observationTextField.setText(MedicalHistoryData.initMedicalHistoryData.getObservation());
        complicationTextField.setText(MedicalHistoryData.initMedicalHistoryData.getComplication());
        patientIdComboBox.setItems(fetchPatientName());
        staffIdComboBox.setItems(fetchStaffId());
    }
    // Fetch the patient name from the patient list

    ObservableList<String> fetchPatientName() {
        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();
        ObservableList<String> patientName = FXCollections.observableArrayList();
        for (PatientTableDataModel patient : patientDataList) {
            patientName.add(patient.getPatientId());
        }
        return patientName;
    }
    // Fetch the staff Id from the staff list

    ObservableList<String> fetchStaffId() {
        ObservableList<StaffTableDataModel> staffDataList = StaffTableDataModel
                .convertStaffDataToStaffTableDataModel();
        ObservableList<String> staffId = FXCollections.observableArrayList();
        for (StaffTableDataModel staff : staffDataList) {
            staffId.add(staff.getStaffId());
        }
        return staffId;
    }

}
