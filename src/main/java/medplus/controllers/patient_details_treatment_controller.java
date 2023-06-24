package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.MedicalHistoryData;
import medplus.data.PatientData;
import medplus.tableModels.DiagnosisTableDataModel;
import medplus.tableModels.MedicalHistoryTableDataModel;
import medplus.tableModels.TreatmentTableDataModel;

public class patient_details_treatment_controller {
    @FXML
    private Text GenderText;

    @FXML
    private Pane addMedHis;

    @FXML
    private Pane analysisButton;

    @FXML
    private Text bloodTypeText;

    @FXML
    private Pane dashboardbutton;

    @FXML
    private Text dateOfBirthText;

    @FXML
    private Pane deleteButton;

    @FXML
    private Pane deletePatientButton;

    @FXML
    private Pane diagnosisButton;

    @FXML
    private Pane editPatientButton;

    @FXML
    private Text heightText;

    @FXML
    private TableView<MedicalHistoryTableDataModel> patientMedicalHistoryTable;
    @FXML
    private TableView<DiagnosisTableDataModel> diagnosisTable;

    @FXML
    private Text patientsNameText;

    @FXML
    private Pane patientsbutton;

    @FXML
    private Pane searchbutton;

    @FXML
    private Pane staffButton;

    @FXML
    private Pane treatmentButton;

    @FXML
    private Pane updateButton;

    @FXML
    private Text weightText;
    @FXML
    private TableView<TreatmentTableDataModel> treatmentTable;

    @FXML
    void changedToAddMedicalHistory(MouseEvent event) throws IOException {
        MedicalHistoryData.initMedicalHistoryData.setPatientId(PatientData.initPatientData.getPatientId());
        App.setRoot("add_medical_history_screen");

    }

    @FXML
    void changedToAnalysis(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen_analysis");

    }

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    void changedToDiagnosis(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen_diagnosis");

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
    void changedToTreatment(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen_treatment");

    }

    @FXML
    void deleteMedicalHistory(MouseEvent event) {
        MedicalHistoryTableDataModel selectedMedHis = patientMedicalHistoryTable.getSelectionModel().getSelectedItem();

        if (selectedMedHis != null) {

            patientMedicalHistoryTable.getItems().remove(selectedMedHis);
            // staffTable.setItems(filteringList());

            String selectedRowId = selectedMedHis.getMedHisId().toString();
            System.out.println("\n selectedRowid: " + selectedRowId);
            MedicalHistoryData.deleteMedicalHistoryById(selectedRowId);
        }
    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) throws IOException {
        MedicalHistoryTableDataModel selectedMedHis = patientMedicalHistoryTable.getSelectionModel()
                .getSelectedItem();
        System.out.println("\nClicked Observation: " + selectedMedHis.getObservation());
        MedicalHistoryData.initMedicalHistoryData.setMedicalHistoryId(selectedMedHis.getMedHisId());
        MedicalHistoryData.initMedicalHistoryData.setPatientId(selectedMedHis.getPatientId());
        MedicalHistoryData.initMedicalHistoryData.setStaffId(selectedMedHis.getStaffId());
        MedicalHistoryData.initMedicalHistoryData.setDate(selectedMedHis.getDate());
        MedicalHistoryData.initMedicalHistoryData.setTime(selectedMedHis.getTime());
        MedicalHistoryData.initMedicalHistoryData.setResult(selectedMedHis.getResult());
        MedicalHistoryData.initMedicalHistoryData.setObservation(selectedMedHis.getObservation());
        MedicalHistoryData.initMedicalHistoryData.setComplication(selectedMedHis.getComplication());

        App.setRoot("update_medical_history_screen");

    }

    @FXML
    void editPatientDetails(MouseEvent event) throws IOException {
        PatientData.initPatientData.setPatientId(PatientData.initPatientData.getPatientId());
        PatientData.initPatientData.setName(PatientData.initPatientData.getName());
        PatientData.initPatientData.setPatientNationalId("6789012345");
        PatientData.initPatientData.setPatientGender(PatientData.initPatientData.getPatientGender());
        PatientData.initPatientData.setDateOfBirth(PatientData.initPatientData.getDateOfBirth());
        PatientData.initPatientData.setPatientAge(PatientData.initPatientData.getPatientAge());
        PatientData.initPatientData.setPatientHeight(PatientData.initPatientData.getPatientHeight());
        PatientData.initPatientData.setPatientWeight(PatientData.initPatientData.getPatientWeight());
        PatientData.initPatientData.setPatientBloodType(PatientData.initPatientData.getPatientBloodType());
        PatientData.initPatientData.setPatientAddress("Miami");
        PatientData.initPatientData.setPatientContactNumber("60238343422");

        App.setRoot("update_patients_screen");

    }

    @FXML
    void deletePatient(MouseEvent event) throws IOException {
        PatientData.deletePatientById(PatientData.initPatientData.getPatientId());
        App.setRoot("patients_home_screen");
    }

    @FXML
    public void initialize() {
        // Format f = new SimpleDateFormat("dd MMM yy");
        // String strDate = PatientData.initPatientData.getPatientDateOfBirth()
        // .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        System.out.println(PatientData.initPatientData.getName());
        patientsNameText.setText(PatientData.initPatientData.getName());
        GenderText.setText(PatientData.initPatientData.getPatientGender());
        // dateOfBirthText.setText(strDate);
        // dateOfBirthText.setText(PatientData.initpatientData.getPatientDateOfBirth().toString());
        bloodTypeText.setText(PatientData.initPatientData.getPatientBloodType());
        heightText.setText(Double.toString(PatientData.initPatientData.getPatientHeight()));
        weightText.setText(Double.toString(PatientData.initPatientData.getPatientWeight()));
        initializeMedicalHistoryTable();
        initializeTreatmentTable();

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
        // for (MedicalHistoryTableDataModel medhis : medicalHistoryDataList) {
        // System.out.println(medhis.getObservation());
        // }

        // Clear existing columns before adding new ones
        patientMedicalHistoryTable.getColumns().clear();
        TableColumn<MedicalHistoryTableDataModel, String> medHisIdColumn = new TableColumn<>("History ID");
        TableColumn<MedicalHistoryTableDataModel, String> patientIdColumn = new TableColumn<>("Patient ID");
        TableColumn<MedicalHistoryTableDataModel, String> staffIdColumn = new TableColumn<>("Staff ID");
        TableColumn<MedicalHistoryTableDataModel, LocalDate> dateColumn = new TableColumn<>("Date");
        TableColumn<MedicalHistoryTableDataModel, LocalTime> timeColumn = new TableColumn<>("Time");
        TableColumn<MedicalHistoryTableDataModel, String> resultColumn = new TableColumn<>("Result");
        TableColumn<MedicalHistoryTableDataModel, String> observationColumn = new TableColumn<>("Observation");
        TableColumn<MedicalHistoryTableDataModel, String> complicationColumn = new TableColumn<>("Complication");

        medHisIdColumn.setCellValueFactory(new PropertyValueFactory<>("medHisId"));

        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        observationColumn.setCellValueFactory(new PropertyValueFactory<>("observation"));
        complicationColumn.setCellValueFactory(new PropertyValueFactory<>("complication"));

        patientMedicalHistoryTable.getColumns().addAll(medHisIdColumn, patientIdColumn, staffIdColumn, dateColumn,
                timeColumn,
                resultColumn, observationColumn, complicationColumn);

        patientMedicalHistoryTable.setItems(medicalHistoryDataList);
    }

    @FXML
    public void initializeTreatmentTable() {
        ObservableList<TreatmentTableDataModel> treatmentDataList = TreatmentTableDataModel
                .convertTreatmentDataToTreatmentTableDataModel();

        ObservableList<TreatmentTableDataModel> patientTreatmentTable = FXCollections.observableArrayList();

        for (TreatmentTableDataModel treatment : treatmentDataList) {
            System.out.println(treatment.getPatientName());
            if (treatment.getPatientName().equalsIgnoreCase(PatientData.initPatientData.getName())) {
                patientTreatmentTable.add(treatment);
            }
        }
        TableColumn treatmentIdColumn = new TableColumn("Treatment ID");
        TableColumn patientNameColumn = new TableColumn("Patient Name");
        TableColumn doctorIdColumn = new TableColumn("Doctor Id");
        TableColumn startDateColumn = new TableColumn("Start Date");
        TableColumn endDateColumn = new TableColumn("End Date");
        TableColumn treatmentInfoColumn = new TableColumn("Treatment Info");

        treatmentTable.getColumns().addAll(treatmentIdColumn, patientNameColumn, doctorIdColumn, startDateColumn,
                endDateColumn, treatmentInfoColumn);

        // Set cell value factories for each TableColumn
        treatmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentId"));
        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        doctorIdColumn.setCellValueFactory(new PropertyValueFactory<>("doctorId"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        treatmentInfoColumn.setCellValueFactory(new PropertyValueFactory<>("treatmentInfo"));

        treatmentTable.setItems(patientTreatmentTable);

    }

}
