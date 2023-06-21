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
import medplus.App;
import medplus.data.AnalysisData;
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
    private ComboBox<String> staffIdComboBox;
    @FXML
    private ComboBox<String> patientIdComboBox;

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
        patientIdComboBox.setValue(AnalysisData.initanalysisData.getPatientName());
        staffIdComboBox.setValue(AnalysisData.initanalysisData.getStaffId());
        patientIdComboBox.setItems(fetchPatientName());
        staffIdComboBox.setItems(fetchStaffId());

    }

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_diagnosis_screen");
    }

}
