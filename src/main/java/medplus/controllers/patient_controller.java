package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.models.Diagnosis;
import medplus.models.MedicalHistory;
import medplus.models.Patient;
import medplus.tableModels.patient_table_data_model;
import medplus.tableModels.patient_table_model;

public class patient_controller {

    //
    @FXML
    private Pane analysisButton;

    @FXML
    private Pane diagnosisButton;
    @FXML
    private Pane treatmentButton;

    @FXML
    private Pane addNewButton;

    @FXML
    private TableView<patient_table_model> patientsTable;

    @FXML
    private TextField searchButton;

    @FXML
    void addNewPatientScreen(MouseEvent event) throws IOException {
        App.setRoot("add_patients_screen");
    }

    // @FXML
    // private TableColumn<patient_table_model, String> details;

    // @FXML
    // private TableColumn<patient_table_model, String> diseaseName;

    // @FXML
    // private TableColumn<patient_table_model, String> doctorId;

    // @FXML
    // private TableColumn<patient_table_model, String> patientId;

    // @FXML
    // private TableColumn<patient_table_model, String> patientName;

    // @FXML
    // private TableColumn<patient_table_model, String> status;

    // @FXML
    // private TableColumn<patient_table_model, Date> checkInDate;

    @FXML
    private Pane dashboardbutton;

    @FXML
    private Pane patientsbutton;

    @FXML
    private Pane searchbutton;

    @FXML
    private Pane staffButton;

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    void changedToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen");

    }

    @FXML
    void changedToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_home_screen");
    }

    @FXML
    void changedToStaff(MouseEvent event) throws IOException {
        App.setRoot("staff_all_home_screen");
    }

    @FXML
    void changedToAnalysis(MouseEvent event) {

    }

    @FXML
    void changedToDiagnosis(MouseEvent event) {

    }

    @FXML
    void changedToTreatment(MouseEvent event) {

    }

    @FXML
    public void initialize() {

        patient_table_data_model patientDatabase = new patient_table_data_model();
        TableColumn patientId = new TableColumn("Patient ID");
        TableColumn patientName = new TableColumn("Patient ");
        TableColumn checkInDate = new TableColumn("Patient ID");
        TableColumn diseaseName = new TableColumn("Patient ID");
        TableColumn doctorId = new TableColumn("Patient ID");
        TableColumn status = new TableColumn("Patient ID");
        TableColumn update = new TableColumn("Patient ID");
        TableColumn delete = new TableColumn("Patient ID");

        // Set cell value factories for each TableColumn
        patientId.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        patientName.setCellValueFactory(new PropertyValueFactory<>("name"));
        checkInDate.setCellValueFactory(new PropertyValueFactory<>("checkInDate"));
        diseaseName.setCellValueFactory(new PropertyValueFactory<>("diseaseName"));
        doctorId.setCellValueFactory(new PropertyValueFactory<>("doctorId"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        update.setCellValueFactory(new PropertyValueFactory<>("update"));
        delete.setCellValueFactory(new PropertyValueFactory<>("delete"));

        // Create a list to store the dummy patient data

        Patient patient1 = new Patient("P001", "John Doe", "1234567890", "Male",
                LocalDate.of(1990, 5, 15), 31, 175.0, 75.0, "O+", "New York", "1234567890");
        MedicalHistory medicalHistory = new MedicalHistory(patient1.getPatientId(), "S789012",
                LocalDate.of(2023, 6, 10), LocalTime.of(9, 30), "Positive", "No notable observations.", "None");
        Diagnosis diAgnosis = new Diagnosis("D987654", patient1.getPatientId(), "S789012", LocalDate.of(2023, 6, 10),
                "Flu",
                "Influenza");
        patientDatabase.addPatientData(patient1, medicalHistory, diAgnosis, "Ongoing");
        patientsTable.setItems(patientDatabase.getPatientData());
        patientsTable.getColumns().addAll(patientId, patientName, checkInDate,
                doctorId, diseaseName, status, update, delete);

        System.out.println("running anjeng");
    }

    @FXML
    private void deleteRowFromTable(ActionEvent event) {
        patientsTable.getItems().removeAll(patientsTable.getSelectionModel().getSelectedItems());
    }

}
