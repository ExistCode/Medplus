package medplus.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.data.PatientData;

public class add_patient_controller {
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

    @FXML
    private ComboBox<String> Gender;
    @FXML
    private Pane addPatientButton;

    @FXML
    private ImageView backButton;
    @FXML
    private ComboBox<String> bloodType;

    @FXML
    void addPatient(MouseEvent event) throws IOException {
        PatientData.addNewPatient();
        App.setRoot("patients_home_screen");

    }

    @FXML
    void backToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients_home_screen");

    }

    /**
     * 
     */
    @FXML
    public void initialize() {
        bloodType.setItems(bloodTypeOptions);
        Gender.setItems(genderOptions);

    }

}
