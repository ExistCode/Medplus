package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
import medplus.data.AppointmentData;
import medplus.data.MedicalHistoryData;
import medplus.data.PatientData;
import medplus.data.StaffData;
import medplus.tableModels.AppointmentTableDataModel;
import medplus.tableModels.MedicalHistoryTableDataModel;

public class staff_details_controller {
    @FXML
    private Pane addNewAppointmentButton;

    @FXML
    private Pane addNewMedicalHistory;

    @FXML
    private TableView<AppointmentTableDataModel> appointmentTable;

    @FXML
    private Pane dashboardButton;

    @FXML
    private Pane deleteAppointmentButton;

    @FXML
    private Pane deleteMedHis;

    @FXML
    private Pane deleteStaffButton;

    @FXML
    private Pane editStaffButton;

    @FXML
    private TableView<MedicalHistoryTableDataModel> medicalHistoryTable;

    @FXML
    private Pane patientsButton;

    @FXML
    private Pane searchButton;

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
    private Pane updateAppointmentButton;

    @FXML
    private Pane updateMedicalHistoryButton;

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
    void addNewAppointment(MouseEvent event) throws IOException {
        AppointmentData.initAppointmentData.setPatientId(StaffData.initStaffData.getStaffId());
        App.setRoot("add_appointment_screen");
    }

    @FXML
    void deleteAppointment(MouseEvent event) {
        AppointmentTableDataModel selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();

        if (selectedAppointment != null) {

            appointmentTable.getItems().remove(selectedAppointment);

            String selectedRowId = selectedAppointment.getAppointmentId().toString();
            AppointmentData.deleteAppointmentById(selectedRowId);
        }
    }

    @FXML
    void updateAppointment(MouseEvent event) throws IOException {
        AppointmentTableDataModel selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            AppointmentData.initAppointmentData.setAppointmentId(selectedAppointment.getAppointmentId());
            AppointmentData.initAppointmentData.setStaffId(selectedAppointment.getStaffId());
            AppointmentData.initAppointmentData.setPatientId(selectedAppointment.getPatientId());
            AppointmentData.initAppointmentData.setRoomNum(selectedAppointment.getRoomNum());
            AppointmentData.initAppointmentData.setDate(selectedAppointment.getDate());
            AppointmentData.initAppointmentData.setTime(selectedAppointment.getTime());
            AppointmentData.initAppointmentData.setDescription(selectedAppointment.getDescription());

            App.setRoot("update_appointment_screen");
        }
    }

    @FXML
    void deleteMedicalHistory(MouseEvent event) {
        MedicalHistoryTableDataModel selectedMedHis = medicalHistoryTable.getSelectionModel().getSelectedItem();

        if (selectedMedHis != null) {

            medicalHistoryTable.getItems().remove(selectedMedHis);
            // staffTable.setItems(filteringList());

            String selectedRowId = selectedMedHis.getMedHisId().toString();
            System.out.println("\n selectedRowid: " + selectedRowId);
            MedicalHistoryData.deleteMedicalHistoryById(selectedRowId);
        }

    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) throws IOException {
        MedicalHistoryTableDataModel selectedMedHis = medicalHistoryTable.getSelectionModel()
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

        App.setRoot("update_medical_history_staff_screen");
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

        // Customize the cell value factory for timeColumn to display only hour and
        // minute
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        timeColumn.setCellFactory(column -> new TableCell<AppointmentTableDataModel, LocalTime>() {
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

        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        appointmentTable.getColumns().addAll(appointmentIdColumn, staffIdColumn, patientIdColumn, roomNumColumn,
                dateColumn, timeColumn, descriptionColumn);

        appointmentTable.setItems(appointmentDataList);
    }

    @FXML
    public void initialize() {
        System.out.println(PatientData.initPatientData.getName());
        staffName.setText(StaffData.initStaffData.getName());
        staffGender.setText(StaffData.initStaffData.getStaffEmail());
        staffBirthday.setText(StaffData.initStaffData.getStaffContactNumber());
        staffDepartment.setText(StaffData.initStaffData.getStaffDepartment());
        staffSpecialty.setText(StaffData.initStaffData.getStaffJobTitle());

        initializeAppointmentTable();
        initializeMedicalHistoryTable();

    }

    @FXML
    public void initializeMedicalHistoryTable() {
        System.out.println("\nEnter Initialize Medical History Table");
        String staffId = StaffData.initStaffData.getStaffId();
        System.out.println("\nPatient Id: " + staffId);
        ObservableList<MedicalHistoryTableDataModel> medicalHistoryDataList = MedicalHistoryTableDataModel
                .convertMedicalHistoryDataToTableDataModel(staffId);

        // Clear existing columns before adding new ones
        medicalHistoryTable.getColumns().clear();
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

        medicalHistoryTable.getColumns().addAll(medHisIdColumn, patientIdColumn, staffIdColumn, dateColumn,
                timeColumn, resultColumn, observationColumn, complicationColumn);

        medicalHistoryTable.setItems(medicalHistoryDataList);
    }
}
