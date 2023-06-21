package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

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
import medplus.tableModels.AppointmentTableDataModel;
import medplus.tableModels.MedicalHistoryTableDataModel;

public class staff_details_controller {
    // Changes this to AppointmentTableDataModel
    @FXML
    private TableView<AppointmentTableDataModel> appointmentTable;
    @FXML
    private Pane deleteStaffButton;
    @FXML
    private Pane updateButton;
    @FXML
    private Pane editStaffButton;
    @FXML
    private Pane analysisButton;
    @FXML
    private Pane addNewMedicalHistory;

    @FXML
    private Pane deleteAppointmentButton;

    @FXML
    private Pane deleteMedHis;
    @FXML
    private TableView<?> medicalHistoryTable;

    @FXML
    private Pane updateAppointmentButton;

    @FXML
    private Pane updateMedicalHistoryButton;

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
    void changedToAnalysis(MouseEvent event) throws IOException {
        App.setRoot("staff_details_analysis_screen");
    }

    @FXML
    void changedToDiagnosis(MouseEvent event) throws IOException {
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
        System.out.println(StaffData.initStaffData.getStaffId());
        StaffData.deleteStaffById(StaffData.initStaffData.getStaffId());
        App.setRoot("staff_all_home_screen");
    }

    @FXML
    void editStaffDetails(MouseEvent event) throws IOException {
        App.setRoot("update_staff_screen");

    }

    @FXML
    public void initializeAppointmentTable() {
        System.out.println("\nEnter Initialize Appointment Table");
        String staffId = StaffData.initStaffData.getStaffId();
        System.out.println("\nStaff Id: " + staffId);
        ObservableList<AppointmentTableDataModel> appointmentDataList = AppointmentTableDataModel
                .convertAppointmentDataToTableDataModel(staffId);

        // Clear existing columns before adding new ones
        appointmentTable.getColumns().clear();
        TableColumn<AppointmentTableDataModel, String> appointmentIdColumn = new TableColumn<>("Appointment ID");
        TableColumn<AppointmentTableDataModel, String> staffIdColumn = new TableColumn<>("Staff ID");
        TableColumn<AppointmentTableDataModel, String> patientIdColumn = new TableColumn<>("Patient ID");
        TableColumn<AppointmentTableDataModel, String> roomNumColumn = new TableColumn<>("Room");
        TableColumn<AppointmentTableDataModel, LocalDate> dateColumn = new TableColumn<>("Date");
        TableColumn<AppointmentTableDataModel, LocalTime> timeColumn = new TableColumn<>("Time");
        TableColumn<AppointmentTableDataModel, String> descriptionColumn = new TableColumn<>("Description");

        appointmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        roomNumColumn.setCellValueFactory(new PropertyValueFactory<>("roomNum"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        appointmentTable.getColumns().addAll(appointmentIdColumn, staffIdColumn, patientIdColumn, roomNumColumn,
                dateColumn, timeColumn, descriptionColumn);

        appointmentTable.setItems(appointmentDataList);
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

        initializeAppointmentTable();

    }

    @FXML
    void deleteAppointment(MouseEvent event) {

    }

    @FXML
    void deleteMedicalHistory(MouseEvent event) {

    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) {

    }

    @FXML
    void updateAppointment(MouseEvent event) {

    }

}
