package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
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
import medplus.data.TreatmentData;
import medplus.models.Treatment;
import medplus.tableModels.PatientTableDataModel;
import medplus.tableModels.StaffTableDataModel;

public class add_treatment_controller {

    @FXML
    private Pane addTreatmentButton;

    @FXML
    private ImageView backButton;

    @FXML
    private DatePicker dateEndDatePicker;

    @FXML
    private DatePicker dateStartDatePicker;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField doctorIDTextField;

    @FXML
    private TextField treatmentInfoTextField;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    private ComboBox<String> patientIdComboBox;

    @FXML
    private ComboBox<String> staffIdComboBox;

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

    @FXML
    public void initialize() {
        patientIdComboBox.setItems(fetchPatientName());
        staffIdComboBox.setItems(fetchStaffId());

        // Scanner sc = new Scanner(System.in);
        // String input = sc.nextLine();

    }

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_treatment_screen");

    }

    @FXML
    void addTreatment(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {
            List<Treatment> treatmentList = TreatmentData.fetchTreatmentDataFromDatabase();
            int newTreatmentId = Integer.parseInt(treatmentList.get(treatmentList.size() - 1).getTreatmentId().substring(1))
                    + 1;
            String newTreatmentIdFormatted = String.format("T%03d", newTreatmentId);
            LocalDate dateStart = dateStartDatePicker.getValue();
            LocalDate dateEnd = dateEndDatePicker.getValue();

            Treatment newTreatment = new Treatment(newTreatmentIdFormatted, patientIdComboBox.getSelectionModel().getSelectedItem(),
                    staffIdComboBox.getSelectionModel().getSelectedItem(),
                    dateStart,
                    dateEnd,
                    treatmentInfoTextField.getText());
            TreatmentData.addNewTreatment(newTreatment);
            App.setRoot("search_treatment_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (patientIdComboBox.getSelectionModel().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || dateStartDatePicker.getValue() == null || dateEndDatePicker.getValue() == null
                || treatmentInfoTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }
        return errorMessage;
    }

}

