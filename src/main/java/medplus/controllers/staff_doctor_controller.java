package medplus.controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.tableModels.StaffTableDataModel;

public class staff_doctor_controller {

    @FXML
    private Pane analysisButton;

    @FXML
    private Pane diagnosisButton;
    @FXML
    private Pane treatmentButton;

    @FXML
    private Pane DoctorButton;

    @FXML
    private Pane adminButton;

    @FXML
    private Pane allButton;

    @FXML
    private Pane nursesButton;

    @FXML
    private Pane addNewButton;

    @FXML
    private TableView<StaffTableDataModel> doctorTable;

    @FXML
    private TextField searchButton;

    @FXML
    void addNewPatientScreen(MouseEvent event) throws IOException {
        App.setRoot("add_patients_screen");
    }

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
    void changedToAdmin(MouseEvent event) throws IOException {
        App.setRoot("staff_admin_home_screen");

    }

    @FXML
    void changedToAll(MouseEvent event) throws IOException {
        App.setRoot("staff_all_home_screen");

    }

    @FXML
    void changedToDoctor(MouseEvent event) throws IOException {

    }

    @FXML
    void changedToNurses(MouseEvent event) throws IOException {
        App.setRoot("staff_nurses_home_screen");

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

    public void initialize() {

        ObservableList<StaffTableDataModel> staffDataList = StaffTableDataModel.convertStaffDataToStaffTableDataModel();
        ObservableList<StaffTableDataModel> doctorList = FXCollections.observableArrayList();

        for (StaffTableDataModel staff : staffDataList) {

            if (staff.getDepartment().equals("Doctor")) {
                doctorList.add(staff);
            }
        }

        TableColumn staffIdColumn = new TableColumn("Staff ID");
        TableColumn nameColumn = new TableColumn("Name");
        TableColumn jobTitleColumn = new TableColumn("Job Title");
        TableColumn departmentColumn = new TableColumn("Department");
        TableColumn emailColumn = new TableColumn("Email");
        TableColumn contactNumberColumn = new TableColumn("Contact Number");

        doctorTable.getColumns().addAll(staffIdColumn, nameColumn, jobTitleColumn, departmentColumn,
                emailColumn,
                contactNumberColumn);

        // Set cell value factories for each TableColumn
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactNumberColumn.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));

        doctorTable.setItems(doctorList);
    }
}
