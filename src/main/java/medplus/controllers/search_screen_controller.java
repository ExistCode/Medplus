package medplus.controllers;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.data.AnalysisData;
import medplus.tableModels.AnalysisTableDataModel;

public class search_screen_controller {

    @FXML
    private ImageView Analysis_btn;

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
    private TableView<AnalysisTableDataModel> analysisTable;

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
        App.setRoot("add_analysis_screen");
    }

    @FXML
    void switchToUpdateScreen(MouseEvent event) throws IOException {
        App.setRoot("update_analysis_screen");
    }

    @FXML
    void deleteRow(MouseEvent event) {
        analysisTable.getItems().removeAll(analysisTable.getSelectionModel().getSelectedItems());
        String selectedRowId = analysisTable.getSelectionModel().getSelectedItem().getAnalysisId().toString();
        int selectedRowIdPlusOne = Integer.parseInt(selectedRowId.substring(1))
                + 1;
        String newAnalysisIdFormatted = String.format("A%03d", selectedRowIdPlusOne);
        AnalysisData.deleteAnalysisById(newAnalysisIdFormatted);

    }

    @FXML
    public void initialize() {
        ObservableList<AnalysisTableDataModel> analysisDataList = AnalysisTableDataModel
                .convertAnalysisDataToAnalysisTableDataModel();

        TableColumn analysisIdColumn = new TableColumn("Analysis ID");
        TableColumn nameColumn = new TableColumn("Patient Name");
        TableColumn staffIdColumn = new TableColumn("Staff ID");
        TableColumn dateColumn = new TableColumn("Analysis Date");
        TableColumn TypeColumn = new TableColumn("Type Of Analysis");
        TableColumn InfoColumn = new TableColumn("Test Information");
        TableColumn summaryColumn = new TableColumn("Result Summary");

        analysisTable.getColumns().addAll(analysisIdColumn, nameColumn, staffIdColumn, dateColumn, TypeColumn,
                InfoColumn, summaryColumn);

        // Set cell value factories for each TableColumn
        analysisIdColumn.setCellValueFactory(new PropertyValueFactory<>("analysisId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("typeOfTest"));
        InfoColumn.setCellValueFactory(new PropertyValueFactory<>("testInformation"));
        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("resultSummary"));

        analysisTable.setItems(analysisDataList);

        analysisTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                AnalysisTableDataModel selectedAnalysis = analysisTable.getSelectionModel().getSelectedItem();
                if (selectedAnalysis != null) {

                    AnalysisData.initanalysisData.setAnalysisId(selectedAnalysis.getAnalysisId());
                    AnalysisData.initanalysisData.setPatientName(selectedAnalysis.getPatientName());
                    AnalysisData.initanalysisData.setStaffId(selectedAnalysis.getStaffId());
                    AnalysisData.initanalysisData.setTypeOfTest(selectedAnalysis.getTypeOfTest());
                    AnalysisData.initanalysisData.setResultSummary(selectedAnalysis.getResultSummary());
                    AnalysisData.initanalysisData.setDate(selectedAnalysis.getDate());
                    AnalysisData.initanalysisData.setTestInformation(selectedAnalysis.getTestInformation());

                    System.out.println(AnalysisData.initanalysisData.getAnalysisId());
                    System.out.println(AnalysisData.initanalysisData.getPatientName());
                    System.out.println(AnalysisData.initanalysisData.getStaffId());
                    System.out.println(AnalysisData.initanalysisData.getTypeOfTest());
                    System.out.println(AnalysisData.initanalysisData.getResultSummary());
                    System.out.println(AnalysisData.initanalysisData.getDate());
                    System.out.println(AnalysisData.initanalysisData.getTestInformation());
                }
            }
        });
    }

}
