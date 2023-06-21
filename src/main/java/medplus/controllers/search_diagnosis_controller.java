package medplus.controllers;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private Button analysisButton;

    @FXML
    private Pane dashboardbutton;

    @FXML
    private Button diagnosisButton;

    @FXML
    private Button medicineButton;

    @FXML
    private Pane patientsbutton;

    @FXML
    private Button procedureButton;

    @FXML
    private Pane searchbutton;

    @FXML
    private Pane staffButton;

    @FXML
    private Button treatmentButton;

    @FXML
    private Pane updateButton;

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
    // cannot function

    @FXML
    void switchToUpdateScreen(MouseEvent event) throws IOException {
        App.setRoot("update_diagnosis_screen");
    }

    @FXML
    private TableView<DiagnosisTableDataModel> diagnosisTable;

    @FXML
    void deleteRow(MouseEvent event) {
        diagnosisTable.getItems().removeAll(diagnosisTable.getSelectionModel().getSelectedItems());
        String selectedRowId = diagnosisTable.getSelectionModel().getSelectedItem().getDiagnosisId().toString();
        int selectedRowIdPlusOne = Integer.parseInt(selectedRowId.substring(1)) + 1;
        String newDiagnosisIdFormatted = String.format("D%03d", selectedRowIdPlusOne);
        DiagnosisData.deleteDiagnosisById(newDiagnosisIdFormatted);

    }

    @FXML
    public void initialize() {
        ObservableList<DiagnosisTableDataModel> diagnosisDataList = DiagnosisTableDataModel
                .convertDiagnosisDataToDiagnosisTableDataModel();

        TableColumn diagnosisIdColumn = new TableColumn("Diagnosis ID");
        TableColumn patientNameColumn = new TableColumn("Patient Name");
        TableColumn staffIdColumn = new TableColumn("Staff ID");
        TableColumn dateColumn = new TableColumn("Diagnosis Date");
        TableColumn sicknessColumn = new TableColumn("Sickness");

        diagnosisTable.getColumns().addAll(diagnosisIdColumn, patientNameColumn, staffIdColumn, dateColumn,
                sicknessColumn);

        // Set cell value factories for each TableColumn
        diagnosisIdColumn.setCellValueFactory(new PropertyValueFactory<>("diagnosisId"));
        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        sicknessColumn.setCellValueFactory(new PropertyValueFactory<>("sickness"));

        diagnosisTable.setItems(diagnosisDataList);

        diagnosisTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                DiagnosisTableDataModel selectedDiagnosis = diagnosisTable.getSelectionModel().getSelectedItem();
                if (selectedDiagnosis != null) {

                    DiagnosisData.initdiagnosisData.setDiagnosisId(selectedDiagnosis.getDiagnosisId());
                    DiagnosisData.initdiagnosisData.setPatientName(selectedDiagnosis.getPatientName());
                    DiagnosisData.initdiagnosisData.setStaffId(selectedDiagnosis.getStaffId());
                    DiagnosisData.initdiagnosisData.setDate(selectedDiagnosis.getDate());
                    DiagnosisData.initdiagnosisData.setSickness(selectedDiagnosis.getSickness());

                    System.out.println(DiagnosisData.initdiagnosisData.getDiagnosisId());
                    System.out.println(DiagnosisData.initdiagnosisData.getPatientName());
                    System.out.println(DiagnosisData.initdiagnosisData.getStaffId());
                    System.out.println(DiagnosisData.initdiagnosisData.getDate());
                    System.out.println(DiagnosisData.initdiagnosisData.getSickness());
                }
            }
        });
    }
}
