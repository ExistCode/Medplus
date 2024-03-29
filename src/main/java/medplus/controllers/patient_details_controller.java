package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.AnalysisData;
import medplus.data.MedicalHistoryData;
import medplus.data.PatientData;
import medplus.models.Patient;
import medplus.tableModels.AnalysisTableDataModel;
import medplus.tableModels.DiagnosisTableDataModel;
import medplus.tableModels.MedicalHistoryTableDataModel;

public class patient_details_controller extends patient_controller {
    @FXML
    private Pane deleteAnalysisButton;
    @FXML
    private Pane updateAnalysisButton;

    @FXML
    private Text GenderText;

    @FXML
    private Pane addMedHis;

    @FXML
    private Pane analysisButton;

    @FXML
    private TableView<AnalysisTableDataModel> analysisTable;
    @FXML
    private Pane addAnalysisButton;
    @FXML
    private Text bloodTypeText;

    @FXML
    private Pane dashboardButton;

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
    private Text patientsNameText;

    @FXML
    private Pane patientsButton;

    @FXML
    private Pane searchButton;

    @FXML
    private Pane staffButton;

    @FXML
    private Pane treatmentButton;

    @FXML
    private Pane updateButton;

    @FXML
    private Text weightText;

    @FXML
    private TableView<MedicalHistoryTableDataModel> patientMedicalHistoryTable;
    @FXML
    private TableView<DiagnosisTableDataModel> diagnosisTable;

    @FXML
    void addAnalysis(MouseEvent event) throws IOException {
        AnalysisData.initanalysisData.setPatientName(PatientData.initPatientData.getName());
        App.setRoot("add_analysis_screen");

    }

    @FXML
    void updateAnalysis(MouseEvent event) throws IOException {
        AnalysisTableDataModel selectedAnalysis = analysisTable.getSelectionModel().getSelectedItem();
        if (selectedAnalysis != null) {
            try {
                AnalysisData.initanalysisData.setAnalysisId(selectedAnalysis.getAnalysisId());
                AnalysisData.initanalysisData.setPatientName(selectedAnalysis.getPatientName());
                AnalysisData.initanalysisData.setStaffId(selectedAnalysis.getStaffId());
                AnalysisData.initanalysisData.setTypeOfTest(selectedAnalysis.getTypeOfTest());
                AnalysisData.initanalysisData.setResultSummary(selectedAnalysis.getResultSummary());
                AnalysisData.initanalysisData.setDate(selectedAnalysis.getDate());
                AnalysisData.initanalysisData.setTestInformation(selectedAnalysis.getTestInformation());

                App.setRoot("update_analysis_screen");

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    @FXML
    void deleteAnalysis(MouseEvent event) {
        AnalysisTableDataModel selectedAnalysis = analysisTable.getSelectionModel().getSelectedItem();

        if (selectedAnalysis != null) {
            analysisTable.getItems().remove(selectedAnalysis);

            String selectedRowId = selectedAnalysis.getAnalysisId().toString();
            int selectedRowIdPlusOne = Integer.parseInt(selectedRowId.substring(1));
            String newAnalysisIdFormatted = String.format("A%03d", selectedRowIdPlusOne);
            AnalysisData.deleteAnalysisById(newAnalysisIdFormatted);
        }

    }

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
    void changedToTreatment(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen_treatment");

    }

    @FXML
    void deleteMedicalHistory(MouseEvent event) {
        MedicalHistoryTableDataModel selectedMedHis = patientMedicalHistoryTable.getSelectionModel().getSelectedItem();

        if (selectedMedHis != null) {

            patientMedicalHistoryTable.getItems().remove(selectedMedHis);
            String selectedRowId = selectedMedHis.getMedHisId().toString();
            System.out.println("\n selectedRowid: " + selectedRowId);
            MedicalHistoryData.deleteMedicalHistoryById(selectedRowId);
        }
    }

    @FXML
    void updateMedHis(MouseEvent event) throws IOException {
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
        PatientData.initPatientData.setPatientNationalId(PatientData.initPatientData.getPatientNationalId());
        PatientData.initPatientData.setPatientGender(PatientData.initPatientData.getPatientGender());
        PatientData.initPatientData.setDateOfBirth(PatientData.initPatientData.getDateOfBirth());
        PatientData.initPatientData.setPatientAge(PatientData.initPatientData.getPatientAge());
        PatientData.initPatientData.setPatientHeight(PatientData.initPatientData.getPatientHeight());
        PatientData.initPatientData.setPatientWeight(PatientData.initPatientData.getPatientWeight());
        PatientData.initPatientData.setPatientBloodType(PatientData.initPatientData.getPatientBloodType());
        PatientData.initPatientData.setPatientAddress(PatientData.initPatientData.getPatientAddress());
        PatientData.initPatientData.setPatientContactNumber(PatientData.initPatientData.getPatientContactNumber());
        App.setRoot("update_patients_screen");

    }

    @FXML
    void deletePatient(MouseEvent event) throws IOException {
        PatientData.deletePatientById(PatientData.initPatientData.getPatientId());
        App.setRoot("patients_home_screen");
    }

    @FXML
    public void initialize() {
        System.out.println(PatientData.initPatientData.getName());
        patientsNameText.setText(PatientData.initPatientData.getName());
        GenderText.setText(PatientData.initPatientData.getPatientGender());
        bloodTypeText.setText(PatientData.initPatientData.getPatientBloodType());
        dateOfBirthText.setText(PatientData.initPatientData.getDateOfBirth().toString());
        heightText.setText(Double.toString(PatientData.initPatientData.getPatientHeight()));
        weightText.setText(Double.toString(PatientData.initPatientData.getPatientWeight()));
        initializeMedicalHistoryTable();
        initializeAnalysisTable();

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
        // Customize the cell value factory for timeColumn to display only hour and
        // minute
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        timeColumn.setCellFactory(column -> new TableCell<MedicalHistoryTableDataModel, LocalTime>() {
            @Override
            protected void updateItem(LocalTime time, boolean empty) {
                super.updateItem(time, empty);
                if (empty || time == null) {
                    setText(null);
                } else {
                    setText(time.format(DateTimeFormatter.ofPattern("HH:mm")));
                }
            }
        });

        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        observationColumn.setCellValueFactory(new PropertyValueFactory<>("observation"));
        complicationColumn.setCellValueFactory(new PropertyValueFactory<>("complication"));
        patientMedicalHistoryTable.getColumns().addAll(medHisIdColumn, patientIdColumn, staffIdColumn, dateColumn,
                timeColumn, resultColumn, observationColumn, complicationColumn);

        patientMedicalHistoryTable.setItems(medicalHistoryDataList);
    }

    @FXML
    public void initializeAnalysisTable() {
        ObservableList<AnalysisTableDataModel> analysisDataList = AnalysisTableDataModel
                .convertAnalysisDataToAnalysisTableDataModel();

        ObservableList<AnalysisTableDataModel> patientAnalysisTableData = FXCollections.observableArrayList();
        // Iterating through the list and get the patient's analysis data
        for (AnalysisTableDataModel analysis : analysisDataList) {
            System.out.println(analysis.getPatientName());
            if (analysis.getPatientName().equalsIgnoreCase(PatientData.initPatientData.getName())) {
                patientAnalysisTableData.add(analysis);
            }
        }
        TableColumn analysisIdColumn = new TableColumn("Analysis ID");
        TableColumn staffIdColumn = new TableColumn("Staff ID");
        TableColumn dateColumn = new TableColumn("Analysis Date");
        TableColumn TypeColumn = new TableColumn("Type Of Analysis");
        TableColumn InfoColumn = new TableColumn("Test Information");
        TableColumn summaryColumn = new TableColumn("Result Summary");

        analysisTable.getColumns().addAll(analysisIdColumn, staffIdColumn,
                dateColumn, TypeColumn,
                InfoColumn, summaryColumn);

        // Set cell value factories for each TableColumn
        analysisIdColumn.setCellValueFactory(new PropertyValueFactory<>("analysisId"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("typeOfTest"));
        InfoColumn.setCellValueFactory(new PropertyValueFactory<>("testInformation"));
        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("resultSummary"));

        analysisTable.setItems(patientAnalysisTableData);

    }

}
