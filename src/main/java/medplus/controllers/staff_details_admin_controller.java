package medplus.controllers;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.ResponsibilitiesData;
import medplus.data.StaffData;
import medplus.data.TaskData;
import medplus.tableModels.ResponsibilitiesTableDataModel;
import medplus.tableModels.TaskTableDataModel;

public class staff_details_admin_controller {

    @FXML
    private Pane addNewResponsibilities;

    @FXML
    private Pane addNewTasks;

    @FXML
    private Pane dashboardbutton;

    @FXML
    private Pane deleteResponsibilities;

    @FXML
    private Pane deleteStaffButton;

    @FXML
    private Pane deleteTasks;

    @FXML
    private Pane editStaffButton;

    @FXML
    private Pane patientsbutton;

    @FXML
    private TableView<ResponsibilitiesTableDataModel> responsibilitiesTable;

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
    private TableView<TaskTableDataModel> tasksTable;

    @FXML
    private Pane updateResponsibilities;

    @FXML
    private Pane updateTasks;

    @FXML
    void addNewResponsibilities(MouseEvent event) throws IOException {
        App.setRoot("add_responsibility_screen");
    }

    @FXML
    void addNewTasks(MouseEvent event) throws IOException {
        App.setRoot("add_task_screen");
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
    void deleteResponsibilities(MouseEvent event) {
        ResponsibilitiesTableDataModel selectedResponsibilities = responsibilitiesTable.getSelectionModel()
                .getSelectedItem();
        if (selectedResponsibilities != null) {
            responsibilitiesTable.getItems().remove(selectedResponsibilities);
            String selectedRowId = selectedResponsibilities.getResponsibilityId().toString();
            ResponsibilitiesData.deleteResponsibilityById(selectedRowId);
        }

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
    void deleteTasks(MouseEvent event) {
        TaskTableDataModel selectedTask = tasksTable.getSelectionModel()
                .getSelectedItem();
        if (selectedTask != null) {
            tasksTable.getItems().remove(selectedTask);
            String selectedRowId = selectedTask.getTaskId().toString();
            TaskData.deleteTaskById(selectedRowId);
        }

    }

    @FXML
    void updateResponsibilities(MouseEvent event) throws IOException {
        ResponsibilitiesTableDataModel selectedResponsibilities = responsibilitiesTable.getSelectionModel()
                .getSelectedItem();
        System.out.println("ResponsibilitiesId: " + selectedResponsibilities.getResponsibilityId());
        ResponsibilitiesData.initResponsibilities.setResponsibilityId(selectedResponsibilities.getResponsibilityId());
        ResponsibilitiesData.initResponsibilities
                .setResponsibilityName(selectedResponsibilities.getResponsibilityName());
        ResponsibilitiesData.initResponsibilities
                .setResponsibilityDescription(selectedResponsibilities.getResponsibilityDescription());
        ResponsibilitiesData.initResponsibilities.setStaffId(selectedResponsibilities.getStaffId());
        App.setRoot("update_responsibility_screen");

    }

    @FXML
    void updateTasks(MouseEvent event) throws IOException {
        TaskTableDataModel selectedTask = tasksTable.getSelectionModel()
                .getSelectedItem();
        if (selectedTask != null) {
            TaskData.initTask.setTaskId(selectedTask.getTaskId());
            TaskData.initTask.setTaskName(selectedTask.getTaskName());
            TaskData.initTask.setTaskDescription(selectedTask.getTaskDescription());
            TaskData.initTask.setStaffId(selectedTask.getStaffId());
        }
        App.setRoot("update_task_screen");
    }

    @FXML
    public void initialize() {
        staffName.setText(StaffData.initStaffData.getName());
        staffGender.setText(StaffData.initStaffData.getStaffEmail());
        staffBirthday.setText(StaffData.initStaffData.getStaffContactNumber());
        staffDepartment.setText(StaffData.initStaffData.getStaffDepartment());
        staffSpecialty.setText(StaffData.initStaffData.getStaffJobTitle());
        initializeResponsibilitiesTable();
        initializeTasksTable();

    }

    @FXML
    public void initializeResponsibilitiesTable() {
        System.out.println("\nEnter Initialize Responsibilities Table");
        String staffId = StaffData.initStaffData.getStaffId();
        System.out.println("\nStaff Id: " + staffId);
        ObservableList<ResponsibilitiesTableDataModel> responsibilitiesDataList = ResponsibilitiesTableDataModel
                .convertResponsibilitiesDataToTableDataModel(staffId);

        // Clear existing columns before adding new ones
        responsibilitiesTable.getColumns().clear();
        TableColumn<ResponsibilitiesTableDataModel, String> responsibilityIdColumn = new TableColumn<>(
                "ID");
        TableColumn<ResponsibilitiesTableDataModel, String> responsibilityNameColumn = new TableColumn<>(
                "Name");
        TableColumn<ResponsibilitiesTableDataModel, String> responsibilityDescriptionColumn = new TableColumn<>(
                "Responsibility Description");
        TableColumn<ResponsibilitiesTableDataModel, String> staffIdColumn = new TableColumn<>("Staff ID");

        responsibilityIdColumn.setCellValueFactory(new PropertyValueFactory<>("responsibilityId"));
        responsibilityNameColumn.setCellValueFactory(new PropertyValueFactory<>("responsibilityName"));
        responsibilityDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("responsibilityDescription"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));

        responsibilitiesTable.getColumns().addAll(responsibilityIdColumn, responsibilityNameColumn,
                responsibilityDescriptionColumn, staffIdColumn);

        responsibilitiesTable.setItems(responsibilitiesDataList);
    }

    @FXML
    public void initializeTasksTable() {
        System.out.println("\nEnter Initialize Tasks Table");
        String staffId = StaffData.initStaffData.getStaffId();
        System.out.println("\nStaff Id: " + staffId);
        ObservableList<TaskTableDataModel> tasksDataList = TaskTableDataModel
                .convertTaskDataToTaskTableDataModel(staffId);

        // Clear existing columns before adding new ones
        tasksTable.getColumns().clear();
        TableColumn<TaskTableDataModel, String> taskIdColumn = new TableColumn<>("Task ID");
        TableColumn<TaskTableDataModel, String> taskNameColumn = new TableColumn<>("Task Name");
        TableColumn<TaskTableDataModel, String> taskDescriptionColumn = new TableColumn<>("Task Description");
        TableColumn<TaskTableDataModel, String> staffIdColumn = new TableColumn<>("Staff ID");

        taskIdColumn.setCellValueFactory(new PropertyValueFactory<>("taskId"));
        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        taskDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("taskDescription"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));

        tasksTable.getColumns().addAll(taskIdColumn, taskNameColumn, taskDescriptionColumn, staffIdColumn);

        tasksTable.setItems(tasksDataList);
    }

}
