package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.PatientData;
import medplus.data.StaffData;
import medplus.tableModels.MedicalHistoryTableDataModel;

public class staff_details_controller {
    @FXML
    private Pane deleteStaffButton;
    @FXML
    private Pane updateButton;
    @FXML
    private Pane editStaffButton;
    @FXML
    private Pane analysisButton;
    @FXML
    private Pane addMedicalHistoryButton;

    @FXML
    private Pane dashboardbutton;

    @FXML
    private Pane diagnosisButton;

    @FXML
    private Pane patientsbutton;

    @FXML
    private Pane searchbutton;

    @FXML
    private Text staffBirthday;

    @FXML
    private Pane staffButton;

    @FXML
    private Text staffDepartment;

    @FXML
    private Text staffGender;

    @FXML
    private Text staffName;

    @FXML
    private Text staffSpecialty;

    @FXML
    private Pane treatmentButton;

    @FXML
    private TableView<MedicalHistoryTableDataModel> patientMedicalHistoryTable;

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    void changedToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients_home_screen");

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
    void changedToAnalysis(MouseEvent event) throws IOException{
        App.setRoot("staff_details_analysis_screen");
    }

    @FXML
    void changedToDiagnosis(MouseEvent event) throws IOException{
        App.setRoot("staff_details_diagnosis_screen");
    }

    @FXML
    void changedToTreatment(MouseEvent event) throws IOException {
        App.setRoot("staff_details_treatment_screen");
    }

    @FXML
    void changedToAddMedicalHistory(MouseEvent event) throws IOException {
        App.setRoot("add_medical_history_screen_staff");
    }

    @FXML
    void deleteStaff(MouseEvent event) throws IOException {
        StaffData.deleteStaffById(StaffData.initStaffData.getStaffId());
        App.setRoot("staff_all_home_screen");
    }

    @FXML
    void editStaffDetails(MouseEvent event) throws IOException {
        // PatientData.initPatientData.setPatientId(PatientData.initPatientData.getPatientId());
        // PatientData.initPatientData.setPatientName(PatientData.initPatientData.getPatientName());
        // PatientData.initPatientData.setPatientNationalId("6789012345");
        // PatientData.initPatientData.setPatientGender(PatientData.initPatientData.getPatientGender());
        // PatientData.initPatientData.setPatientDateOfBirth(PatientData.initPatientData.getPatientDateOfBirth());
        // PatientData.initPatientData.setPatientAge(PatientData.initPatientData.getPatientAge());
        // PatientData.initPatientData.setPatientHeight(PatientData.initPatientData.getPatientHeight());
        // PatientData.initPatientData.setPatientWeight(PatientData.initPatientData.getPatientWeight());
        // PatientData.initPatientData.setPatientBloodType(PatientData.initPatientData.getPatientBloodType());
        // PatientData.initPatientData.setPatientAddress("Miami");
        // PatientData.initPatientData.setPatientContactNumber("60238343422");

        App.setRoot("update_staff_screen");

    }
    

    @FXML
    public void initialize() {
        // Format f = new SimpleDateFormat("dd MMM yy");

        System.out.println(PatientData.initPatientData.getPatientName());
        staffName.setText(StaffData.initStaffData.getStaffName());
        staffGender.setText(StaffData.initStaffData.getStaffEmail());
        staffBirthday.setText(StaffData.initStaffData.getStaffContactNumber());
        staffDepartment.setText(StaffData.initStaffData.getStaffDepartment());
        staffSpecialty.setText(StaffData.initStaffData.getStaffJobTitle());

    }

}
