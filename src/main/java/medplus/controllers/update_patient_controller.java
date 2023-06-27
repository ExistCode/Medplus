package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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
import medplus.data.PatientData;
import medplus.models.Patient;

public class update_patient_controller {
    ArrayList<String> bloodTypeOption = new ArrayList<String>();
    ObservableList<String> bloodTypeOptions = FXCollections.observableArrayList(
            "A-",
            "A+",
            "B-",
            "B+",
            "O-",
            "O+",
            "AB-",
            "AB+");

    ObservableList<String> genderOptions = FXCollections.observableArrayList(
            "Male",
            "Female");

    // TEXT FIELDS
    @FXML
    private ComboBox<String> genderComboBox;

    @FXML
    private TextField addressTextField;

    @FXML
    private ImageView backButton;

    @FXML
    private ComboBox<String> bloodTypeComboBox;

    @FXML
    private TextField contactNumberTextField;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField nationalIdTextField;

    @FXML
    private DatePicker dateOfBirthPicker;

    @FXML
    private Pane updatePatientButton;

    @FXML
    private TextField weightTextField;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    void updatePatient(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {

            LocalDate dateOfBirth = dateOfBirthPicker.getValue();
            LocalDate today = LocalDate.now();
            Period p = Period.between(dateOfBirth, today);

            Patient newPatient = new Patient(PatientData.initPatientData.getPatientId(), fullNameTextField.getText(),
                    nationalIdTextField.getText(),
                    genderComboBox.getSelectionModel().getSelectedItem(),
                    dateOfBirth, p.getYears(), Double.parseDouble(heightTextField.getText()),
                    Double.parseDouble(weightTextField.getText()),
                    bloodTypeComboBox.getSelectionModel().getSelectedItem(),
                    addressTextField.getText(),
                    contactNumberTextField.getText());
            PatientData.updatePatientData(newPatient);
            App.setRoot("patients_home_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (fullNameTextField.getText().isEmpty() || nationalIdTextField.getText().isEmpty()
                || genderComboBox.getSelectionModel().isEmpty() || dateOfBirthPicker.getValue() == null
                || heightTextField.getText().isEmpty() || weightTextField.getText().isEmpty()
                || bloodTypeComboBox.getSelectionModel().isEmpty() || addressTextField.getText().isEmpty()
                || contactNumberTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        } else {
            try {
                Double.parseDouble(heightTextField.getText());
                Double.parseDouble(weightTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage = "Please enter valid numeric values for height and weight.";
                errorMessageDisplay.setText(errorMessage);
            }
        }

        return errorMessage;
    }

    @FXML
    void backToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients_home_screen");

    }

    @FXML
    public void initialize() {
        fullNameTextField.setText(PatientData.initPatientData.getName());
        nationalIdTextField.setText(PatientData.initPatientData.getPatientNationalId());
        dateOfBirthPicker.setValue(PatientData.initPatientData.getDateOfBirth());
        contactNumberTextField.setText(PatientData.initPatientData.getPatientContactNumber());
        addressTextField.setText(PatientData.initPatientData.getPatientAddress());
        genderComboBox.setValue(PatientData.initPatientData.getPatientGender());
        genderComboBox.setItems(genderOptions);
        bloodTypeComboBox.setValue(PatientData.initPatientData.getPatientBloodType());
        bloodTypeComboBox.setItems(bloodTypeOptions);
        weightTextField.setText(String.valueOf(PatientData.initPatientData.getPatientWeight()));
        heightTextField.setText(String.valueOf(PatientData.initPatientData.getPatientHeight()));
    }

}
