package medplus.controllers;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.tableModels.PatientTableDataModel;

public class patient_controller {

    //
    @FXML
    private Pane analysisButton;

    @FXML
    private Pane diagnosisButton;
    @FXML
    private Pane treatmentButton;

    @FXML
    private Pane addNewButton;

    @FXML
    private TableView<PatientTableDataModel> patientsTable;

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

        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();
        TableColumn patientIdColumn = new TableColumn("Patient ID");
        TableColumn nameColumn = new TableColumn("Name");
        TableColumn genderColumn = new TableColumn("Gender");
        TableColumn dateOfBirthColumn = new TableColumn("Date of Birth");
        TableColumn bloodTypeColumn = new TableColumn("Blood Type");
        TableColumn statusColumn = new TableColumn("");
        TableColumn updateColumn = new TableColumn("");
        TableColumn deleteColumn = new TableColumn("");

        patientsTable.getColumns().addAll(patientIdColumn, nameColumn, genderColumn,
                bloodTypeColumn, dateOfBirthColumn, statusColumn, updateColumn, deleteColumn);

        // Set cell value factories for each TableColumn
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        bloodTypeColumn.setCellValueFactory(new PropertyValueFactory<>("bloodType"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        updateColumn.setCellValueFactory(new PropertyValueFactory<>("update"));
        deleteColumn.setCellValueFactory(new PropertyValueFactory<>("delete"));

        patientsTable.setItems(patientDataList);

    }

    @FXML
    private void deleteRowFromTable(ActionEvent event) {
        patientsTable.getItems().removeAll(patientsTable.getSelectionModel().getSelectedItems());
    }

}
