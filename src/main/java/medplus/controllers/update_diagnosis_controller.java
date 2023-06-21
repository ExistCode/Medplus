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
import medplus.data.DiagnosisData;
import medplus.models.Diagnosis;
import medplus.tableModels.PatientTableDataModel;
import medplus.tableModels.StaffTableDataModel;

public class update_diagnosis_controller {

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateDiagnosedDatePicker;

    @FXML
    private TextField diagnosisTextField;

    @FXML
    private Pane updateDiagnosisButton;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    private ComboBox<String> staffIdComboBox;

    @FXML
    private ComboBox<String> patientNameComboBox;

    ObservableList<String> fetchPatientName() {
        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();
        ObservableList<String> patientName = FXCollections.observableArrayList();
        for (PatientTableDataModel patient : patientDataList) {
            patientName.add(patient.getName());
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

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_diagnosis_screen");
    }

    @FXML
    public void initialize() {
        patientNameComboBox.setValue(DiagnosisData.initdiagnosisData.getPatientName());
        staffIdComboBox.setValue(DiagnosisData.initdiagnosisData.getStaffId());
        dateDiagnosedDatePicker.setValue(DiagnosisData.initdiagnosisData.getDate());
        diagnosisTextField.setText(DiagnosisData.initdiagnosisData.getDiagnosis());
        patientNameComboBox.setItems(fetchPatientName());
        staffIdComboBox.setItems(fetchStaffId());
    }

    @FXML
    void updateDiagnosis(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {

            Diagnosis newDiagnosis = new Diagnosis(DiagnosisData.initdiagnosisData.getDiagnosisId(),
                    patientNameComboBox.getSelectionModel().getSelectedItem(),
                    staffIdComboBox.getSelectionModel().getSelectedItem(),
                    dateDiagnosedDatePicker.getValue(),
                    diagnosisTextField.getText());

            DiagnosisData.updateDiagnosis(newDiagnosis);
            App.setRoot("search_diagnosis_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }

    }

    private String validateInput() {
        String errorMessage = "";

        if (patientNameComboBox.getSelectionModel().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || dateDiagnosedDatePicker.getValue() == null || diagnosisTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }
        return errorMessage;
    }
}
