package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.TreatmentData;
import medplus.models.Treatment;

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

            Treatment newTreatment = new Treatment(newTreatmentIdFormatted, patientNameTextField.getText(),
                    doctorIDTextField.getText(),
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

        if (patientNameTextField.getText().isEmpty() || doctorIDTextField.getText().isEmpty()
                || dateStartDatePicker.getValue() == null || dateEndDatePicker.getValue() == null
                || treatmentInfoTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }
        return errorMessage;
    }

}

