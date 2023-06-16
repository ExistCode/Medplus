package medplus.controllers;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private Text SecondPatientAddress;

    @FXML
    private Text SecondPatientGender;

    @FXML
    private Text SecondPatientdateOfBirth;

    @FXML
    private Text SecondPatientsNames;

    @FXML
    private Text ThirdPatientAddress;

    @FXML
    private Text firstPatientsAddress;

    @FXML
    private Text thirdPatientDateOfBirth;

    @FXML
    private Text thirdPatientGender;

    @FXML
    private Text thirdPatientsNames;

    @FXML
    private Text firstPatientsdateOfBirth;

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
    private Pane seeDetailsSecond;

    @FXML
    private Pane seeDetailsThird;

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
            if (staff.getStaffDepartment().equals("Doctor")) {
                this.numOfDoctor++;

            } else if (staff.getStaffDepartment().equals("Nurse")) {
                this.numOfNurse++;

            } else {
                this.numOfAdmins++;
            }

        }
        numOfDoctors.setText(Integer.toString(numOfDoctor));
        numOfNurses.setText(Integer.toString(numOfNurse));
        numOfAdmin.setText(Integer.toString(numOfAdmins));
        List<Patient> patientList = getLatestThreePatients();
        firstPatientsNames.setText(patientList.get(0).getPatientName());
        firstPatientGender.setText(patientList.get(0).getPatientGender());
        firstPatientsdateOfBirth.setText(patientList.get(0).getPatientDateOfBirth().toString());
        firstPatientsAddress.setText(patientList.get(0).getPatientAddress());
        SecondPatientsNames.setText(patientList.get(1).getPatientName());
        SecondPatientGender.setText(patientList.get(1).getPatientGender());
        SecondPatientdateOfBirth.setText(patientList.get(1).getPatientDateOfBirth().toString());
        SecondPatientAddress.setText(patientList.get(1).getPatientAddress());
        thirdPatientsNames.setText(patientList.get(2).getPatientName());
        thirdPatientGender.setText(patientList.get(2).getPatientGender());
        thirdPatientDateOfBirth.setText(patientList.get(2).getPatientDateOfBirth().toString());
        ThirdPatientAddress.setText(patientList.get(2).getPatientAddress());

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

    public static List<Patient> getLatestThreePatients() {
        List<Patient> lastThreePatientList = new ArrayList<>();
        List<Patient> originalPatientList = PatientData.fetchPatientDataFromDatabase();

        lastThreePatientList.add(0, originalPatientList.get(originalPatientList.size() - 1));
        lastThreePatientList.add(1, originalPatientList.get(originalPatientList.size() - 2));
        lastThreePatientList.add(2, originalPatientList.get(originalPatientList.size() - 3));
        for (int i = 0; i < lastThreePatientList.size(); i++) {
            System.out.println(lastThreePatientList.get(i).getPatientName());
        }

        return lastThreePatientList;

    }

    @FXML
    void seePatientsDetails1(MouseEvent event) throws IOException {
        List<Patient> patientList = getLatestThreePatients();

        PatientData.initPatientData.setPatientName(patientList.get(0).getPatientName());
        PatientData.initPatientData.setPatientGender(patientList.get(0).getPatientGender());

        PatientData.initPatientData.setPatientDateOfBirth(patientList.get(0).getPatientDateOfBirth());
        PatientData.initPatientData.setPatientBloodType(patientList.get(0).getPatientBloodType());
        PatientData.initPatientData.setPatientHeight(patientList.get(0).getPatientHeight());
        PatientData.initPatientData.setPatientWeight(patientList.get(0).getPatientWeight());
        App.setRoot("patients_details_screen_analysis");

    }

    @FXML
    void seePatientsDetails2(MouseEvent event) throws IOException {
        List<Patient> patientList = getLatestThreePatients();

        PatientData.initPatientData.setPatientName(patientList.get(1).getPatientName());
        PatientData.initPatientData.setPatientGender(patientList.get(1).getPatientGender());

        PatientData.initPatientData.setPatientDateOfBirth(patientList.get(1).getPatientDateOfBirth());
        PatientData.initPatientData.setPatientBloodType(patientList.get(1).getPatientBloodType());
        PatientData.initPatientData.setPatientHeight(patientList.get(1).getPatientHeight());
        PatientData.initPatientData.setPatientWeight(patientList.get(1).getPatientWeight());
        App.setRoot("patients_details_screen_analysis");

    }

    @FXML
    void seePatientsDetails3(MouseEvent event) throws IOException {
        List<Patient> patientList = getLatestThreePatients();

        PatientData.initPatientData.setPatientName(patientList.get(2).getPatientName());
        PatientData.initPatientData.setPatientGender(patientList.get(2).getPatientGender());

        PatientData.initPatientData.setPatientDateOfBirth(patientList.get(2).getPatientDateOfBirth());
        PatientData.initPatientData.setPatientBloodType(patientList.get(2).getPatientBloodType());
        PatientData.initPatientData.setPatientHeight(patientList.get(2).getPatientHeight());
        PatientData.initPatientData.setPatientWeight(patientList.get(2).getPatientWeight());
        App.setRoot("patients_details_screen_analysis");

    }

}
