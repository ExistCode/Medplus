package medplus.controllers;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.MedicineData;
import medplus.models.Medicine;

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

            Medicine newMedicine = new Medicine(newMedicineIdFormatted, patientNameTextField.getText(),
                    doctorIDTextField.getText(),
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

        if (patientNameTextField.getText().isEmpty() || doctorIDTextField.getText().isEmpty()
                || medNameTextField.getText().isEmpty() || medAmountTextField.getText().isEmpty()
                || doseInfoTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }

        return errorMessage;
    }

}
