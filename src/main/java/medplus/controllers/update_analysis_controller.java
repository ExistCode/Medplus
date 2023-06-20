package medplus.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.AnalysisData;
import medplus.data.PatientData;
import medplus.models.Analysis;
import medplus.tableModels.PatientTableDataModel;
import medplus.tableModels.StaffTableDataModel;

public class update_analysis_controller {
    @FXML
    private ComboBox<String> staffIdComboBox;
    @FXML
    private ComboBox<String> patientIdComboBox;
    ArrayList<String> analysisTypeOption = new ArrayList<String>();
    ObservableList<String> analysisTypeOptions = FXCollections.observableArrayList(
            "Bioblood Analysis",
            "Rw Analysis",
            "Urine Analysis");

    @FXML
    private TextField ResultsTextField;

    @FXML
    private ComboBox<String> analysisTypeComboBox;

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateAnalysisDatePicker;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    private TextField testInformationTextField;

    @FXML
    private Pane updateAnalysisButton;
    @FXML
    private Text errorMessageDisplay;

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_home_screen");
    }

    @FXML
    public void initialize() {
        patientIdComboBox.setValue(AnalysisData.initanalysisData.getPatientName());
        staffIdComboBox.setValue(AnalysisData.initanalysisData.getStaffId());
        analysisTypeComboBox.setValue(AnalysisData.initanalysisData.getTypeOfTest());
        ResultsTextField.setText(AnalysisData.initanalysisData.getResultSummary());
        dateAnalysisDatePicker.setValue(AnalysisData.initanalysisData.getDate());
        testInformationTextField.setText(AnalysisData.initanalysisData.getTestInformation());
        analysisTypeComboBox.setItems(analysisTypeOptions);
        patientIdComboBox.setItems(fetchPatientName());
        staffIdComboBox.setItems(fetchStaffId());

    }

    @FXML
    void updateAnalysis(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {
            // List<Analysis> analysisList = AnalysisData.fetchAnalysisDataFromDatabase();
            // int newAnalysisId = Integer.parseInt(analysisList.get(analysisList.size() -
            // 1).getAnalysisId().substring(1))
            // + 1;
            // String newAnalysisIdFormatted = String.format("A%03d", newAnalysisId);

            Analysis newAnalysis = new Analysis(AnalysisData.initanalysisData.getAnalysisId(),
                    patientIdComboBox.getSelectionModel().getSelectedItem(),
                    staffIdComboBox.getSelectionModel().getSelectedItem(),
                    analysisTypeComboBox.getSelectionModel().getSelectedItem(),
                    ResultsTextField.getText(),
                    dateAnalysisDatePicker.getValue(),
                    testInformationTextField.getText());

            AnalysisData.updateAnalysis(newAnalysis);
            App.setRoot("search_home_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }

    }

    private String validateInput() {
        String errorMessage = "";

        if (patientIdComboBox.getSelectionModel().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || analysisTypeComboBox.getSelectionModel().isEmpty() || ResultsTextField.getText().isEmpty()
                || dateAnalysisDatePicker.getValue() == null || testInformationTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }
        return errorMessage;
    }

    ObservableList<String> fetchPatientName() {
        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();
        ObservableList<String> patientId = FXCollections.observableArrayList();
        for (PatientTableDataModel patient : patientDataList) {
            patientId.add(patient.getName());
        }
        return patientId;
    }

    ObservableList<String> fetchStaffId() {
        ObservableList<StaffTableDataModel> staffDataList = StaffTableDataModel
                .convertStaffDataToStaffTableDataModel();
        ObservableList<String> staffId = FXCollections.observableArrayList();
        for (StaffTableDataModel staff : staffDataList) {
            staffId.add(staff.getStaffId());
        }
        return staffId;
    }
}
