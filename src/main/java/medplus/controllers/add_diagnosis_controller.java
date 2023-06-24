package medplus.controllers;

import java.io.IOException;
import java.util.List;

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

public class add_diagnosis_controller {

    @FXML
    private Pane addDiagnosisButton;

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateOfDiagnosisSelector;

    @FXML
    private TextField diagnosisTextField;

    @FXML
    private ComboBox<String> patientNameComboBox;

    @FXML
    private ComboBox<String> staffIdComboBox;

    @FXML
    private Text errorMessageDisplay;

    ObservableList<String> fetchPatientName() {
        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();
        ObservableList<String> patientId = FXCollections.observableArrayList();
        for (PatientTableDataModel patient : patientDataList) {
            patientId.add(patient.getName());
        }
        return patientId;
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
    public void initialize() {
        patientNameComboBox.setValue(DiagnosisData.initdiagnosisData.getPatientName());
        patientNameComboBox.setItems(fetchPatientName());
        staffIdComboBox.setItems(fetchStaffId());
    }

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_diagnosis_screen");
    }

    @FXML
    void addDiagnosis(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {
            List<Diagnosis> diagnosisList = DiagnosisData.fetchDiagnosisDataFromDatabase();
            int newDiagnosisId = Integer
                    .parseInt(diagnosisList.get(diagnosisList.size() - 1).getDiagnosisId().substring(1))
                    + 1;
            String newDiagnosisIdFormatted = String.format("D%03d", newDiagnosisId);

            Diagnosis newDiagnosis = new Diagnosis(newDiagnosisIdFormatted,
                    patientNameComboBox.getSelectionModel().getSelectedItem(),
                    staffIdComboBox.getSelectionModel().getSelectedItem(),
                    dateOfDiagnosisSelector.getValue(),
                    diagnosisTextField.getText());
            DiagnosisData.addNewDiagnosis(newDiagnosis);
            App.setRoot("search_diagnosis_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (patientNameComboBox.getSelectionModel().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || dateOfDiagnosisSelector.getValue() == null || diagnosisTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }

        return errorMessage;
    }

}
