package medplus.controllers;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.List;

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
import medplus.tableModels.MedicalHistoryTableDataModel;
import medplus.tableModels.PatientTableDataModel;

public class patient_details_controller extends patient_controller {
    @FXML
    private Pane deleteButton;
    @FXML
    private Pane updateButton;
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
    private Pane addMedicalHistory;

    @FXML
    private TableView<MedicalHistoryTableDataModel> patientMedicalHistoryTable;

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

    @FXML
    void changedToAddMedicalHistory(MouseEvent event) throws IOException {
        App.setRoot("add_medical_history_screen");

    }

    @FXML
    void deleteRow(MouseEvent event) {

    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) {

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
        initializeMedicalHistoryTable();

    }

    public void setPatientDetails(String gender, String name, String dateOfBirth) {
        this.GenderText.setText(gender);
        this.patientsNameText.setText(name);
        this.dateOfBirthText.setText(dateOfBirth);

    }

    @FXML
    public void initializeMedicalHistoryTable() {
        System.out.println("\nEnter Initialize Medical History Table");
        String patientId = PatientData.initPatientData.getPatientId();
        System.out.println("\nPatient Id: " + patientId);
        ObservableList<MedicalHistoryTableDataModel> medicalHistoryDataList = MedicalHistoryTableDataModel
                .convertMedicalHistoryDataToTableDataModel(patientId);
        for (MedicalHistoryTableDataModel medhis : medicalHistoryDataList) {
            System.out.println(medhis.getObservation());
        }

        // Clear existing columns before adding new ones
        patientMedicalHistoryTable.getColumns().clear();

        TableColumn<MedicalHistoryTableDataModel, String> patientIdColumn = new TableColumn<>("Patient ID");
        TableColumn<MedicalHistoryTableDataModel, String> staffIdColumn = new TableColumn<>("Staff ID");
        TableColumn<MedicalHistoryTableDataModel, LocalDate> dateColumn = new TableColumn<>("Date");
        TableColumn<MedicalHistoryTableDataModel, LocalTime> timeColumn = new TableColumn<>("Time");
        TableColumn<MedicalHistoryTableDataModel, String> resultColumn = new TableColumn<>("Result");
        TableColumn<MedicalHistoryTableDataModel, String> observationColumn = new TableColumn<>("Observation");
        TableColumn<MedicalHistoryTableDataModel, String> complicationColumn = new TableColumn<>("Complication");

        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        observationColumn.setCellValueFactory(new PropertyValueFactory<>("observation"));
        complicationColumn.setCellValueFactory(new PropertyValueFactory<>("complication"));

        patientMedicalHistoryTable.getColumns().addAll(patientIdColumn, staffIdColumn, dateColumn, timeColumn,
                resultColumn, observationColumn, complicationColumn);

        patientMedicalHistoryTable.setItems(medicalHistoryDataList);
    }

}
