package medplus.controllers;

import java.io.IOException;
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

public class update_procedure_controller {

    @FXML
    private ComboBox<String> staffIdComboBox;

    @FXML
    private ComboBox<String> patientNameComboBox;

    @FXML
    private ImageView backButton;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private DatePicker dateDatePicker;

    @FXML
    private TextField procedureDescriptionTextField;

    @FXML
    private TextField timeTextField;

    @FXML
    private TextField procedureTypeTextField;

    @FXML
    private TextField staffIDTextField;

    @FXML
    private Pane updateProcedureButton;

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_procedure_screen");

    }

    @FXML
    void updateProcedure(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {
            
            Procedure newProcedure = new Procedure(ProcedureData.initProcedureData.getProcedureId(), 
                    patientNameComboBox.getSelectionModel().getSelectedItem(),
                    staffIDTextField.getText(),
                    dateDatePicker.getValue(),
                    timeTextField.getText(),
                    procedureTypeTextField.getText(),
                    procedureDescriptionTextField.getText());

            ProcedureData.addNewProcedure(newProcedure);
            App.setRoot("search_procedure_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (patientNameComboBox.getSelectionModel().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || dateDatePicker.getValue() == null || timeTextField.getText().isEmpty()
                || procedureTypeTextField.getText().isEmpty() || procedureDescriptionTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }
        return errorMessage;
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

    @FXML
    public void initialize() {
        patientNameComboBox.setValue(ProcedureData.initProcedureData.getPatientName());
        staffIdComboBox.setValue(ProcedureData.initProcedureData.getStaffId());
        dateDatePicker.setValue(ProcedureData.initProcedureData.getDate());
        timeTextField.setText(ProcedureData.initProcedureData.getTime());
        procedureTypeTextField.setText(ProcedureData.initProcedureData.getType());
        procedureDescriptionTextField.setText(ProcedureData.initProcedureData.getDescription());
        patientNameComboBox.setItems(fetchPatientName());
        staffIdComboBox.setItems(fetchStaffId());
    }
}