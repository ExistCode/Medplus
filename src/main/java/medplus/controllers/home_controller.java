package medplus.controllers;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.PatientData;
import medplus.data.StaffData;
import medplus.models.Patient;
import medplus.models.Staff;

public class home_controller {
    private int numOfDoctor;
    private int numOfNurse;
    private int numOfAdmins;

    @FXML
    private Pane dashboard;
    @FXML
    private Text datetime;
    @FXML
    private Pane dashboardbutton;

    @FXML
    private Pane patientsbutton;
    @FXML
    private Pane seeDetails;

    @FXML
    private Pane searchbutton;

    @FXML
    private Pane staffButton;
    @FXML
    private Text firstPatientGender;

    @FXML
    private Text firstPatientsNames;

    @FXML
    private Text numOfAdmin;

    @FXML
    private Text numOfAppointments;

    @FXML
    private Text numOfDoctors;

    @FXML
    private Text numOfNurses;

    @FXML
    private Text numOfPatients;

    @FXML
    private Text numOfRooms;

    @FXML
    private Text numOfStaffs;

    @FXML
    void changedToDashboard(MouseEvent event) throws IOException {
        App.setRoot("home_screen");
    }

    @FXML
    public void initialize() {
        Format f = new SimpleDateFormat("dd MMM yy");
        String strDate = f.format(new Date());
        datetime.setText(strDate);
        List<Patient> initialPatientList = PatientData.fetchPatientDataFromDatabase();
        List<Staff> initialStaffList = StaffData.fetchStaffDataFromDatabase();
        numOfPatients.setText(Integer.toString(initialPatientList.size()));
        numOfStaffs.setText(Integer.toString(initialStaffList.size()));
        // To get the number of staff
        for (Staff staff : initialStaffList) {
            if (staff.getStaffDepartment().contains("doctor")) {
                this.numOfDoctor++;

            } else if (staff.getStaffDepartment().contains("nurse")) {
                this.numOfNurse++;

            } else {
                this.numOfAdmins++;
            }

        }
        numOfDoctors.setText(Integer.toString(numOfDoctor));
        numOfNurses.setText(Integer.toString(numOfNurse));
        numOfAdmin.setText(Integer.toString(numOfAdmins));

    }

    @FXML
    void changedToPatients(MouseEvent event) throws IOException {
        App.setRoot("patients_home_screen");

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
    void seePatientsDetails(MouseEvent event) throws IOException {
        App.setRoot("patients_details_screen");

    }

}
