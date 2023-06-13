package medplus.controllers;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.PatientData;
import medplus.data.StaffData;

public class staff_details_controller {
    @FXML
    private Pane analysisButton;

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
        // Format f = new SimpleDateFormat("dd MMM yy");

        System.out.println(PatientData.initpatientData.getPatientName());
        staffName.setText(StaffData.initStaffData.getStaffName());
        staffGender.setText(StaffData.initStaffData.getStaffEmail());
        staffBirthday.setText(StaffData.initStaffData.getStaffContactNumber());
        staffDepartment.setText(StaffData.initStaffData.getStaffDepartment());
        staffSpecialty.setText(StaffData.initStaffData.getStaffJobTitle());

    }

}
