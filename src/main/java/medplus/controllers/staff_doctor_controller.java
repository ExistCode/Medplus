package medplus.controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.data.StaffData;
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
    private TextField searchField;
    @FXML
    private Pane dashboardButton;

    @FXML
    private Pane patientsButton;

    @FXML
    private Pane searchButton;

    @FXML
    private Pane staffButton;

    @FXML
    void addNewPatientScreen(MouseEvent event) throws IOException {
        App.setRoot("add_staff_screen");
    }

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
    void deleteRow(MouseEvent event) {
        StaffTableDataModel selectedStaff = doctorTable.getSelectionModel().getSelectedItem();

        if (selectedStaff != null) {
            doctorTable.getItems().remove(selectedStaff);

            String selectedRowId = selectedStaff.getStaffId().toString();
            int selectedRowIdPlusOne = Integer.parseInt(selectedRowId.substring(1));
            String newDoctorIdFormatted = String.format("S%03d", selectedRowIdPlusOne);
            StaffData.deleteStaffById(newDoctorIdFormatted);
        }
    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) throws IOException {
        App.setRoot("update_staff_screen");

    }

    @FXML
    private Pane updateButton;
    @FXML
    private Pane deleteButton;
    // Initialize the javafx controller with staff details

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
        // Filtered the doctor data
        FilteredList<StaffTableDataModel> filteredData = new FilteredList<>(doctorList, b -> true);
        searchField.textProperty().addListener((observable, oldvalue, newvalue) -> {
            filteredData.setPredicate(StaffTableDataModel -> {
                if (newvalue.isEmpty() || newvalue.isBlank() || newvalue == null) {
                    return true;
                }

                String searchKeyword = newvalue.toLowerCase();
                if (StaffTableDataModel.getStaffId().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (StaffTableDataModel.getName().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (StaffTableDataModel.getJobTitle().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (StaffTableDataModel.getDepartment().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (StaffTableDataModel.getEmail().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (StaffTableDataModel.getContactNumber().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        // Sorted it using sortedList

        SortedList<StaffTableDataModel> sortedStaffData = new SortedList<>(
                filteredData);
        sortedStaffData.comparatorProperty().bind(doctorTable.comparatorProperty());
        doctorTable.setItems(sortedStaffData);
        doctorTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                StaffTableDataModel selectedStaff = doctorTable.getSelectionModel().getSelectedItem();

                if (selectedStaff != null) {

                    try {

                        StaffData.initStaffData.setName(selectedStaff.getName());
                        StaffData.initStaffData.setStaffEmail(selectedStaff.getEmail());
                        StaffData.initStaffData.setStaffContactNumber(selectedStaff.getContactNumber());
                        StaffData.initStaffData.setStaffDepartment(selectedStaff.getDepartment());
                        StaffData.initStaffData.setStaffJobTitle(selectedStaff.getJobTitle());

                        App.setRoot("staff_details_screen");

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}
