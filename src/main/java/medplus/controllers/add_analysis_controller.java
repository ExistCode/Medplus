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
import medplus.models.Analysis;
import medplus.tableModels.PatientTableDataModel;
import medplus.tableModels.StaffTableDataModel;

public class add_analysis_controller {

    @FXML
    private ComboBox<String> staffIdComboBox;

    ArrayList<String> analysisTypeOption = new ArrayList<String>();

    ObservableList<String> analysisTypeOptions = FXCollections.observableArrayList(
            "Bioblood Analysis",
            "Rw Analysis",
            "Urine Analysis");

    @FXML
    private ComboBox<String> patientNameComboBox;

    @FXML
    private Pane addAnalysisButton;

    @FXML
    private ComboBox<String> analysisType;

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateAnalysisSelector;

    @FXML
    private TextField summaryTextField;

    @FXML
    private TextField testInfoTextField;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_home_screen");
    }

    @FXML
    void addAnalysis(MouseEvent event) throws IOException {
        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();
        String errorMessage = validateInput();

        if (errorMessage == "") {
            List<Analysis> analysisList = AnalysisData.fetchAnalysisDataFromDatabase();
            int newAnalysisId = Integer.parseInt(analysisList.get(analysisList.size() - 1).getAnalysisId().substring(1))
                    + 1;
            String newAnalysisIdFormatted = String.format("A%03d", newAnalysisId);

            Analysis newAnalysis = new Analysis(newAnalysisIdFormatted,
                    patientNameComboBox.getSelectionModel().getSelectedItem(),
                    staffIdComboBox.getSelectionModel().getSelectedItem(),
                    analysisType.getSelectionModel().getSelectedItem(),
                    summaryTextField.getText(),
                    dateAnalysisSelector.getValue(),
                    testInfoTextField.getText());

            AnalysisData.addNewAnalysis(newAnalysis);
            App.setRoot("search_home_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (patientNameComboBox.getSelectionModel().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || analysisType.getSelectionModel().isEmpty() || summaryTextField.getText().isEmpty()
                || dateAnalysisSelector.getValue() == null || testInfoTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }
        return errorMessage;
    }

    @FXML
    public void initialize() {
        patientNameComboBox.setValue(AnalysisData.initanalysisData.getPatientName());
        analysisType.setItems(analysisTypeOptions);
        System.out.println(fetchPatientName());
        staffIdComboBox.setItems(fetchStaffId());
        patientNameComboBox.setItems(fetchPatientName());

    }

    ObservableList<String> fetchPatientName() {
        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();
        ObservableList<String> patientName = FXCollections.observableArrayList();
        for (PatientTableDataModel patient : patientDataList) {
            patientName.add(patient.getName());
        }
        return patientName;
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
