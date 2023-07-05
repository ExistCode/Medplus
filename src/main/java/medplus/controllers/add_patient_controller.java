package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
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
import medplus.data.PatientData;
import medplus.models.Patient;

public class add_patient_controller {
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
    private TextField addressTextField;

    @FXML
    private ComboBox<String> gender;

    @FXML
    private TextField contactNumberTextField;

    @FXML
    private DatePicker dateOfBirthSelector;

    @FXML
    private ComboBox<String> bloodType;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField nationalIdTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private ImageView backButton;

    @FXML
    private Pane addPatientButton;

    @FXML
    private Text errorMessageDisplay;
    @FXML
    private Pane updatePatientButton;

    @FXML
    void addPatient(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {
            List<Patient> patientList = PatientData.fetchPatientDataFromDatabase();
            int newPatientId = Integer.parseInt(patientList.get(patientList.size() - 1).getPatientId().substring(1))
                    + 1;
            String newPatientIdFormatted = String.format("P%03d", newPatientId);
            LocalDate dateOfBirth = dateOfBirthSelector.getValue();
            LocalDate today = LocalDate.now();
            Period p = Period.between(dateOfBirth, today);

            Patient newPatient = new Patient(newPatientIdFormatted, nameTextField.getText(),
                    nationalIdTextField.getText(),
                    gender.getSelectionModel().getSelectedItem(),
                    dateOfBirth, p.getYears(), Double.parseDouble(heightTextField.getText()),
                    Double.parseDouble(weightTextField.getText()),
                    bloodType.getSelectionModel().getSelectedItem(),
                    addressTextField.getText(),
                    contactNumberTextField.getText());
            PatientData.addNewPatient(newPatient);
            PatientData.initPatientData.setPatientId(newPatientIdFormatted);
            PatientData.initPatientData.setPatientGender(gender.getSelectionModel().getSelectedItem());
            PatientData.initPatientData.setDateOfBirth(dateOfBirth);
            PatientData.initPatientData
                    .setPatientBloodType(bloodType.getSelectionModel().getSelectedItem());
            PatientData.initPatientData.setPatientHeight(Double.parseDouble(heightTextField.getText()));
            PatientData.initPatientData.setPatientWeight(Double.parseDouble(weightTextField.getText()));

            App.setRoot("patients_details_screen_analysis");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";
        // Validate no empty input

        if (nameTextField.getText().isEmpty() || nationalIdTextField.getText().isEmpty()
                || gender.getSelectionModel().isEmpty() || dateOfBirthSelector.getValue() == null
                || heightTextField.getText().isEmpty() || weightTextField.getText().isEmpty()
                || bloodType.getSelectionModel().isEmpty() || addressTextField.getText().isEmpty()
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

    // initialize Combobox
    @FXML
    public void initialize() {
        bloodType.setItems(bloodTypeOptions);
        gender.setItems(genderOptions);

    }

    @FXML
    void updatePatient(MouseEvent event) {

    }

}
