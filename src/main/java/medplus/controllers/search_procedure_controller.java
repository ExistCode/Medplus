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
import medplus.data.ProcedureData;
import medplus.tableModels.ProcedureTableDataModel;

public class search_procedure_controller {

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
    private TableView<ProcedureTableDataModel> procedureTable;

    @FXML
    private TextField searchProcedureTextField;

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
        App.setRoot("add_procedure_screen");

    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) {
        ProcedureTableDataModel selectedProcedure = procedureTable.getSelectionModel().getSelectedItem();
        if (selectedProcedure != null) {
            try {
                ProcedureData.initProcedureData.setProcedureId(selectedProcedure.getProcedureId());
                ProcedureData.initProcedureData.setPatientName(selectedProcedure.getPatientName());
                ProcedureData.initProcedureData.setStaffId(selectedProcedure.getStaffId());
                ProcedureData.initProcedureData.setType(selectedProcedure.getType());
                ProcedureData.initProcedureData.setTime(selectedProcedure.getTime());
                ProcedureData.initProcedureData.setDate(selectedProcedure.getDate());
                ProcedureData.initProcedureData.setDescription(selectedProcedure.getDescription());

                App.setRoot("update_procedure_screen");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @FXML
    public void initialize() {

        ObservableList<ProcedureTableDataModel> procedureDataList = ProcedureTableDataModel
                .convertProcedureDataToProcedureTableDataModel();

        TableColumn procedureIdColumn = new TableColumn("Procedure ID");
        TableColumn nameColumn = new TableColumn("Patient Name");
        TableColumn staffIdColumn = new TableColumn("Staff ID");
        TableColumn dateColumn = new TableColumn("Procedure Date");
        TableColumn timeColumn = new TableColumn("Procedure Time");
        TableColumn typeColumn = new TableColumn("Procedure Type");
        TableColumn descriptionColumn = new TableColumn("Procedure Description");

        procedureTable.getColumns().addAll(procedureIdColumn, nameColumn, staffIdColumn, dateColumn, timeColumn,
                typeColumn, descriptionColumn);

        // Set cell value factories for each TableColumn
        procedureIdColumn.setCellValueFactory(new PropertyValueFactory<>("procedureId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        procedureTable.setItems(procedureDataList);

        FilteredList<ProcedureTableDataModel> filteredData = new FilteredList<>(procedureDataList, b -> true);
        searchProcedureTextField.textProperty().addListener((observable, oldvalue, newvalue) -> {
            filteredData.setPredicate(ProcedureTableDataModel -> {
                if (newvalue.isEmpty() || newvalue.isBlank() || newvalue == null) {
                    return true;
                }

                String searchKeyword = newvalue.toLowerCase();
                if (ProcedureTableDataModel.getPatientName().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (ProcedureTableDataModel.getProcedureId().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (ProcedureTableDataModel.getStaffId().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (ProcedureTableDataModel.getTime().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (ProcedureTableDataModel.getDescription().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<ProcedureTableDataModel> sortedProcedureList = new SortedList<>(filteredData);
        sortedProcedureList.comparatorProperty().bind(procedureTable.comparatorProperty());
        procedureTable.setItems(sortedProcedureList);

    }

}
