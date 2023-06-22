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
import medplus.App;
import medplus.data.MedicalHistoryData;
import medplus.models.MedicalHistory;
import medplus.tableModels.PatientTableDataModel;
import medplus.tableModels.StaffTableDataModel;

public class update_medical_history_staff_controller {
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
            App.setRoot("staff_details_analysis_screen");
        } else {
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (staffIdComboBox.getSelectionModel().getSelectedItem().isEmpty() ||
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
        App.setRoot("staff_details_analysis_screen");
    }

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

    ObservableList<String> fetchPatientName() {
        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();
        ObservableList<String> patientName = FXCollections.observableArrayList();
        for (PatientTableDataModel patient : patientDataList) {
            patientName.add(patient.getPatientId());
        }
        return patientName;
    }

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
