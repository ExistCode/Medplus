package medplus.controllers;

import java.io.IOException;
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
import medplus.data.ProcedureData;
import medplus.models.Procedure;
import medplus.tableModels.PatientTableDataModel;
import medplus.tableModels.StaffTableDataModel;

public class add_procedure_controller {

    @FXML
    private ComboBox<String> staffIdComboBox;

    @FXML
    private ComboBox<String> patientNameComboBox;

    @FXML
    private Pane addProcedureButton;

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateDatePicker;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField procedureDescriptionTextField;

    @FXML
    private TextField procedureTypeTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    private TextField timeTextField;

    @FXML
    void backToProcedure(MouseEvent event) throws IOException {
        App.setRoot("search_procedure_screen");

    }

    @FXML
    void addProcedure(MouseEvent event) throws IOException {
        ObservableList<PatientTableDataModel> patientDataList = PatientTableDataModel
                .convertPatientDataToPatientTableDataModel();
        String errorMessage = validateInput();

        if (errorMessage == "") {
            List<Procedure> procedureList = ProcedureData.fetchProcedureDataFromDatabase();
            int newProcedureId = Integer
                    .parseInt(procedureList.get(procedureList.size() - 1).getProcedureId().substring(2))
                    + 1;
            String newProcedureIdFormatted = String.format("PD%03d", newProcedureId);

            Procedure newProcedure = new Procedure(newProcedureIdFormatted,
                    patientNameComboBox.getSelectionModel().getSelectedItem(),
                    staffIdComboBox.getSelectionModel().getSelectedItem(), dateDatePicker.getValue(),
                    timeTextField.getText(),
                    procedureTypeTextField.getText(), procedureDescriptionTextField.getText());

            ProcedureData.addNewProcedure(newProcedure);
            App.setRoot("search_procedure_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";
        // Validate no empty input

        if (patientNameComboBox.getSelectionModel().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || dateDatePicker.getValue() == null || timeTextField.getText().isEmpty()
                || procedureTypeTextField.getText().isEmpty() || procedureDescriptionTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }
        return errorMessage;
    }

    @FXML
    public void initialize() {
        patientNameComboBox.setValue(ProcedureData.initProcedureData.getPatientName());
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
