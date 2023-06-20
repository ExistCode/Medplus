package medplus.controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.MedicineData;
import medplus.models.Medicine;

public class update_medicine_controller {

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
    private Pane updateMedicineButton;

    @FXML
    void backToSearch(MouseEvent event) throws IOException{
        App.setRoot("search_medicine_screen");
    }

    @FXML
    private Text errorMessageDisplay;

    @FXML
    void updateMedicine(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {

            Medicine newMedicine = new Medicine(MedicineData.initMedicineData.getMedicineId(), patientNameTextField.getText(),
                    doctorIDTextField.getText(),
                    medNameTextField.getText(),
                    medAmountTextField.getText(),
                    doseInfoTextField.getText());
            MedicineData.updateMedicineData(newMedicine);
            App.setRoot("search_medicine_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (patientNameTextField.getText().isEmpty() || doctorIDTextField.getText().isEmpty()
                || medNameTextField.getText().isEmpty() || medAmountTextField.getText().isEmpty()
                || doseInfoTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }

        return errorMessage;
    }

    @FXML
    public void initialize() {
        patientNameTextField.setText(MedicineData.initMedicineData.getPatientName());
        doctorIDTextField.setText(MedicineData.initMedicineData.getDoctorId());
        medNameTextField.setText(MedicineData.initMedicineData.getMedicineName());
        medAmountTextField.setText(MedicineData.initMedicineData.getAmount());
        doseInfoTextField.setText(MedicineData.initMedicineData.getDoseDetail());
    }
}
