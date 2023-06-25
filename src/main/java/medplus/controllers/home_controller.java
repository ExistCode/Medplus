package medplus.controllers;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.AppointmentData;
import medplus.data.PatientData;
import medplus.data.RoomData;
import medplus.data.StaffData;
import medplus.data.TreatmentData;
import medplus.models.Appointment;
import medplus.models.Patient;
import medplus.models.Room;
import medplus.models.Staff;
import medplus.models.Treatment;

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
    private Text firstAppointmentDetails;

    @FXML
    private Text firstAppointmentStaffName;
    @FXML
    private Text firstPatientNameAppointment;
    @FXML
    private Text secondAppointmentDetails;

    @FXML
    private Text secondAppointmentStaffName;

    @FXML
    private Text secondPatientNameAppointment;
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

        List<Appointment> initialAppointmentList = AppointmentData.fetchAllAppointmentDataFromDatabase();
        List<Room> initialRoomList = RoomData.fetchRoomDataFromDatabase();
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

        numOfAppointments.setText(Integer.toString(initialAppointmentList.size()));
        numOfDoctors.setText(Integer.toString(numOfDoctor));
        numOfNurses.setText(Integer.toString(numOfNurse));
        numOfAdmin.setText(Integer.toString(numOfAdmins));
        numOfRooms.setText(Integer.toString(initialRoomList.size()));

        List<Patient> patientList = getLatestThreePatients();
        firstPatientsNames.setText(patientList.get(0).getName());
        firstPatientGender.setText(patientList.get(0).getPatientGender());
        firstPatientsdateOfBirth.setText(patientList.get(0).getDateOfBirth().toString());
        firstPatientsAddress.setText(patientList.get(0).getPatientAddress());
        SecondPatientsNames.setText(patientList.get(1).getName());
        SecondPatientGender.setText(patientList.get(1).getPatientGender());
        SecondPatientdateOfBirth.setText(patientList.get(1).getDateOfBirth().toString());
        SecondPatientAddress.setText(patientList.get(1).getPatientAddress());
        thirdPatientsNames.setText(patientList.get(2).getName());
        thirdPatientGender.setText(patientList.get(2).getPatientGender());
        thirdPatientDateOfBirth.setText(patientList.get(2).getDateOfBirth().toString());
        ThirdPatientAddress.setText(patientList.get(2).getPatientAddress());
        firstPatientNameAppointment.setText(getLatest2Treatments().get(1).getPatientName());
        secondPatientNameAppointment.setText(getLatest2Treatments().get(0).getPatientName());
        firstAppointmentDetails.setText(
                getLatest2Treatments().get(1).getTreatmentInfo());
        firstAppointmentStaffName.setText(getLatest2Treatments().get(1).getStaffId());
        secondAppointmentDetails.setText(
                getLatest2Treatments().get(0).getTreatmentInfo());
        secondAppointmentStaffName.setText(getLatest2Treatments().get(0).getStaffId());

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

        return lastThreePatientList;

    }

    public static List<Treatment> getLatest2Treatments() {
        List<Treatment> lastTwoTreatmentList = new ArrayList<>();
        List<Treatment> originalTreatmentList = TreatmentData.fetchTreatmentDataFromDatabase();

        for (Treatment tre : originalTreatmentList) {
            if (tre.getStartDate().isAfter(LocalDate.now())) {
                lastTwoTreatmentList.add(tre);

            }
        }

        return lastTwoTreatmentList;

    }

    @FXML
    void seePatientsDetails1(MouseEvent event) throws IOException {
        List<Patient> patientList = getLatestThreePatients();
        PatientData.initPatientData.setPatientId(patientList.get(0).getPatientId());

        PatientData.initPatientData.setPatientId(patientList.get(0).getPatientId());
        PatientData.initPatientData.setName(patientList.get(0).getName());
        PatientData.initPatientData.setPatientGender(patientList.get(0).getPatientGender());

        PatientData.initPatientData.setDateOfBirth(patientList.get(0).getDateOfBirth());
        PatientData.initPatientData.setPatientBloodType(patientList.get(0).getPatientBloodType());
        PatientData.initPatientData.setPatientHeight(patientList.get(0).getPatientHeight());
        PatientData.initPatientData.setPatientWeight(patientList.get(0).getPatientWeight());
        App.setRoot("patients_details_screen_analysis");

    }

    @FXML
    void seePatientsDetails2(MouseEvent event) throws IOException {
        List<Patient> patientList = getLatestThreePatients();

        PatientData.initPatientData.setPatientId(patientList.get(1).getPatientId());

        PatientData.initPatientData.setName(patientList.get(1).getName());
        PatientData.initPatientData.setPatientGender(patientList.get(1).getPatientGender());

        PatientData.initPatientData.setDateOfBirth(patientList.get(1).getDateOfBirth());
        PatientData.initPatientData.setPatientBloodType(patientList.get(1).getPatientBloodType());
        PatientData.initPatientData.setPatientHeight(patientList.get(1).getPatientHeight());
        PatientData.initPatientData.setPatientWeight(patientList.get(1).getPatientWeight());
        App.setRoot("patients_details_screen_analysis");

    }

    @FXML
    void seePatientsDetails3(MouseEvent event) throws IOException {
        List<Patient> patientList = getLatestThreePatients();

        PatientData.initPatientData.setPatientId(patientList.get(2).getPatientId());

        PatientData.initPatientData.setName(patientList.get(2).getName());
        PatientData.initPatientData.setPatientGender(patientList.get(2).getPatientGender());

        PatientData.initPatientData.setDateOfBirth(patientList.get(2).getDateOfBirth());
        PatientData.initPatientData.setPatientBloodType(patientList.get(2).getPatientBloodType());
        PatientData.initPatientData.setPatientHeight(patientList.get(2).getPatientHeight());
        PatientData.initPatientData.setPatientWeight(patientList.get(2).getPatientWeight());
        App.setRoot("patients_details_screen_analysis");

    }

}
