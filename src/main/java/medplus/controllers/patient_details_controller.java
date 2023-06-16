package medplus.controllers;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.PatientData;
import medplus.tableModels.PatientTableDataModel;

public class patient_details_controller extends patient_controller {
    @FXML
    private Pane analysisButton;
    @FXML
    private Pane diagnosisButton;
    @FXML
    private Pane treatmentButton;

    @FXML
    private Pane dashboardbutton;
    @FXML
    private Text GenderText;

    @FXML
    private Text dateOfBirthText;

    @FXML
    private Text patientsNameText;
    @FXML
    private Text bloodTypeText;
    @FXML
    private Text heightText;
    @FXML
    private Text weightText;

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
    public void initialize() {
        // Format f = new SimpleDateFormat("dd MMM yy");
        String strDate = PatientData.initPatientData.getPatientDateOfBirth()
                .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        System.out.println(PatientData.initPatientData.getPatientName());
        patientsNameText.setText(PatientData.initPatientData.getPatientName());
        GenderText.setText(PatientData.initPatientData.getPatientGender());
        dateOfBirthText.setText(strDate);

        // dateOfBirthText.setText(PatientData.initpatientData.getPatientDateOfBirth().toString());
        bloodTypeText.setText(PatientData.initPatientData.getPatientBloodType());

        heightText.setText(Double.toString(PatientData.initPatientData.getPatientHeight()));
        weightText.setText(Double.toString(PatientData.initPatientData.getPatientWeight()));

    }

    public void setPatientDetails(String gender, String name, String dateOfBirth) {
        this.GenderText.setText(gender);
        this.patientsNameText.setText(name);
        this.dateOfBirthText.setText(dateOfBirth);
    }

    @FXML
    void changedToAnalysis(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen_analysis");

    }

    @FXML
    void changedToDiagnosis(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen_diagnosis");

    }

    @FXML
    void changedToTreatment(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen_treatment");

    }
}
