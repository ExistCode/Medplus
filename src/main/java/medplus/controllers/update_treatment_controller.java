package medplus.controllers;

import java.io.IOException;

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
import medplus.data.TreatmentData;
import medplus.models.Treatment;
import medplus.tableModels.PatientTableDataModel;
import medplus.tableModels.StaffTableDataModel;

public class update_treatment_controller {

    @FXML
    private ImageView backButton;

    @FXML
    private ComboBox<String> staffIdComboBox;

    @FXML
    private ComboBox<String> patientNameComboBox;

    @FXML
    private DatePicker dateEndDatePicker;

    @FXML
    private DatePicker dateStartDatePicker;

    @FXML
    private TextField treatmentInfoTextField;

    @FXML
    private Pane updateTreatmentButton;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_treatment_screen");
    }

    @FXML
    void updateTreatment(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {

            Treatment newTreatment = new Treatment(TreatmentData.initTreatmentData.getTreatmentId(),
                    patientNameComboBox.getSelectionModel().getSelectedItem(),
                    staffIdComboBox.getSelectionModel().getSelectedItem(),
                    dateStartDatePicker.getValue(),
                    dateEndDatePicker.getValue(),
                    treatmentInfoTextField.getText());
            TreatmentData.updateTreatmentData(newTreatment);
            App.setRoot("search_treatment_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }
    // Validating no empty and wrong input from user

    private String validateInput() {
        String errorMessage = "";

        if (patientNameComboBox.getSelectionModel().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || dateStartDatePicker.getValue() == null || dateEndDatePicker.getValue() == null
                || treatmentInfoTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }

        return errorMessage;
    }

    // Initializing the patient's treatment data
    @FXML
    public void initialize() {
        patientNameComboBox.setValue(TreatmentData.initTreatmentData.getPatientName());
        staffIdComboBox.setValue(TreatmentData.initTreatmentData.getStaffId());
        dateStartDatePicker.setValue(TreatmentData.initTreatmentData.getStartDate());
        dateEndDatePicker.setValue(TreatmentData.initTreatmentData.getEndDate());
        treatmentInfoTextField.setText(TreatmentData.initTreatmentData.getTreatmentInfo());
        patientNameComboBox.setItems(fetchPatientName());
        staffIdComboBox.setItems(fetchStaffId());
    }

    ObservableList<String> fetchPatientName() {
        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();
        ObservableList<String> patientName = FXCollections.observableArrayList();
        for (PatientTableDataModel patient : patientDataList) {
            patientName.add(patient.getName());
            System.out.println("done ga");
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
