package medplus.controllers;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.data.DiagnosisData;
import medplus.tableModels.DiagnosisTableDataModel;

public class search_diagnosis_controller {

    @FXML
    private Pane addButton;

    @FXML
    private TextField searchDiagnosisText;

    @FXML
    private Button analysisButton;

    @FXML
    private Pane dashboardButton;

    @FXML
    private Button diagnosisButton;

    @FXML
    private Button medicineButton;

    @FXML
    private Pane patientsButton;

    @FXML
    private Button procedureButton;

    @FXML
    private Pane searchButton;

    @FXML
    private Pane staffButton;

    @FXML
    private Button treatmentButton;

    @FXML
    private Pane updateButton;

    @FXML
    private TableView<DiagnosisTableDataModel> diagnosisTable;

    @FXML
    void changedToAnalysis(MouseEvent event) throws IOException {
        App.setRoot("search_home_screen");
    }

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    void changedToDiagnosis(MouseEvent event) throws IOException {
        App.setRoot("search_diagnosis_screen");
    }

    @FXML
    void changedToMedicine(MouseEvent event) throws IOException {
        App.setRoot("search_medicine_screen");
    }

    @FXML
    void changedToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients_home_screen");
    }

    @FXML
    void changedToProcedure(MouseEvent event) throws IOException {
        App.setRoot("search_procedure_screen");
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
        App.setRoot("search_treatment_screen");
    }

    @FXML
    void switchToAddScreen(MouseEvent event) throws IOException {
        App.setRoot("add_diagnosis_screen");
    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) throws IOException {
        // Retrieve the selected data and insert it into the empty object
        DiagnosisTableDataModel selectedDiagnosis = diagnosisTable.getSelectionModel().getSelectedItem();
        if (selectedDiagnosis != null) {
            try {
                DiagnosisData.initdiagnosisData.setDiagnosisId(selectedDiagnosis.getDiagnosisId());
                DiagnosisData.initdiagnosisData.setPatientName(selectedDiagnosis.getPatientName());
                DiagnosisData.initdiagnosisData.setStaffId(selectedDiagnosis.getStaffId());
                DiagnosisData.initdiagnosisData.setDate(selectedDiagnosis.getDate());
                DiagnosisData.initdiagnosisData.setDiagnosis(selectedDiagnosis.getDiagnosis());

                App.setRoot("update_diagnosis_screen");

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    // Initialize the javafx controller and the table view content

    @FXML
    public void initialize() {
        ObservableList<DiagnosisTableDataModel> diagnosisDataList = DiagnosisTableDataModel
                .convertDiagnosisDataToDiagnosisTableDataModel();

        TableColumn diagnosisIdColumn = new TableColumn("Diagnosis ID");
        TableColumn patientNameColumn = new TableColumn("Patient Name");
        TableColumn staffIdColumn = new TableColumn("Staff ID");
        TableColumn dateColumn = new TableColumn("Diagnosis Date");
        TableColumn diagnosisColumn = new TableColumn("Diagnosis");

        diagnosisTable.getColumns().addAll(diagnosisIdColumn, patientNameColumn, staffIdColumn, dateColumn,
                diagnosisColumn);

        // Set cell value factories for each TableColumn
        diagnosisIdColumn.setCellValueFactory(new PropertyValueFactory<>("diagnosisId"));
        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        diagnosisColumn.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        diagnosisTable.setItems(diagnosisDataList);
        // Filtered the list
        FilteredList<DiagnosisTableDataModel> filteredData = new FilteredList<>(diagnosisDataList, b -> true);
        searchDiagnosisText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            filteredData.setPredicate(DiagnosisTableDataModel -> {
                if (newvalue.isEmpty() || newvalue.isBlank() || newvalue == null) {
                    return true;
                }

                String searchKeyword = newvalue.toLowerCase();
                if (DiagnosisTableDataModel.getPatientName().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (DiagnosisTableDataModel.getDiagnosisId().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (DiagnosisTableDataModel.getStaffId().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (DiagnosisTableDataModel.getDate().toString().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (DiagnosisTableDataModel.getDiagnosis().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        // Sorted the list according to the filtered data
        SortedList<DiagnosisTableDataModel> sortedDiagnosisData = new SortedList<>(filteredData);
        sortedDiagnosisData.comparatorProperty().bind(diagnosisTable.comparatorProperty());
        diagnosisTable.setItems(sortedDiagnosisData);

    }
}
