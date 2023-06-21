package medplus.controllers;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.MedicineData;
import medplus.models.Medicine;
import medplus.tableModels.PatientTableDataModel;
import medplus.tableModels.StaffTableDataModel;

public class add_medicine_controller {

    @FXML
    private Pane addMedicineButton;

    @FXML
    private ImageView backButton;

    @FXML
    private TextField doseInfoTextField;

    @FXML
    private TextField medAmountTextField;

    @FXML
    private TextField medNameTextField;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField doctorIDTextField;

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
        App.setRoot("search_medicine_screen");
    }

    @FXML
    void addMedicine(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {
            List<Medicine> medicineList = MedicineData.fetchMedicineDataFromDatabase();
            int newMedicineId = Integer.parseInt(medicineList.get(medicineList.size() - 1).getMedicineId().substring(1))+ 1;
            String newMedicineIdFormatted = String.format("M%03d", newMedicineId);

            Medicine newMedicine = new Medicine(newMedicineIdFormatted, patientIdComboBox.getSelectionModel().getSelectedItem(),
                    staffIdComboBox.getSelectionModel().getSelectedItem(),
                    medNameTextField.getText(),
                    medAmountTextField.getText(),
                    doseInfoTextField.getText());
            MedicineData.addNewMedicine(newMedicine);
            App.setRoot("search_medicine_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (patientIdComboBox.getSelectionModel().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || medNameTextField.getText().isEmpty() || medAmountTextField.getText().isEmpty()
                || doseInfoTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }

        return errorMessage;
    }

}
