package medplus.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.models.Staff;

public class staff_controller {

    @FXML
    private Pane analysisButton;

    @FXML
    private Pane diagnosisButton;
    @FXML
    private Pane treatmentButton;

    @FXML
    private Pane DoctorButton;

    @FXML
    private Pane adminButton;

    @FXML
    private Pane allButton;

    @FXML
    private Pane nursesButton;

    @FXML
    private Pane addNewButton;

    @FXML
    private TableView<Staff> staffTable;

    @FXML
    private TextField searchButton;

    @FXML
    void addNewPatientScreen(MouseEvent event) throws IOException {
        App.setRoot("add_patients_screen");
    }

    @FXML
    private Pane dashboardbutton;

    @FXML
    private Pane patientsbutton;

    @FXML
    private Pane searchbutton;

    @FXML
    private Pane staffButton;

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    void changedToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen");

    }

    @FXML
    void changedToSearch(MouseEvent event) throws IOException {
        App.setRoot("search_home_screen");
    }

    @FXML
    void changedToStaff(MouseEvent event) throws IOException {
        App.setRoot("staff_all_home_screen");
    }

    @FXML
    void changedToAdmin(MouseEvent event) throws IOException {
        App.setRoot("staff_admin_home_screen");

    }

    @FXML
    void changedToAll(MouseEvent event) throws IOException {
        App.setRoot("staff_all_home_screen");

    }

    @FXML
    void changedToDoctor(MouseEvent event) throws IOException {
        App.setRoot("staff_doctor_home_screen");

    }

    @FXML
    void changedToNurses(MouseEvent event) throws IOException {
        App.setRoot("staff_nurses_home_screen");

    }

    @FXML
    void changedToAnalysis(MouseEvent event) {

    }

    @FXML
    void changedToDiagnosis(MouseEvent event) {

    }

    @FXML
    void changedToTreatment(MouseEvent event) {

    }
}
