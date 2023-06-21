package medplus.controllers;

import java.io.IOException;
import java.time.LocalTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import medplus.App;
import medplus.data.AppointmentData;
import medplus.models.Appointment;

public class update_appointment_controller {

    ObservableList<String> roomNumOption = FXCollections.observableArrayList(
            "R101", "R102", "R103", "R104", "R105", "R106", "R201", "R202", "R203", "R204",
            "R205", "R206", "R207", "R208", "R301", "R302", "R303", "R304", "R305", "R306");

    @FXML
    private DatePicker appointmentDatePicker;

    @FXML
    private ImageView backButton;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TextField patinetIdTextField;

    @FXML
    private ComboBox<String> roomNumberComboBox;

    @FXML
    private TextField staffIdTextField;

    @FXML
    private Pane updateAppointmentButton;

    @FXML
    void backToStaffDetails(MouseEvent event) throws IOException {
        App.setRoot("staff_details_analysis_screen");
    }

    @FXML
    void updateNewAppointment(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage.isEmpty()) {
            Appointment updatedAppointment = new Appointment(
                    AppointmentData.initAppointmentData.getAppointmentId(),
                    patinetIdTextField.getText(),
                    staffIdTextField.getText(),
                    roomNumberComboBox.getValue(),
                    appointmentDatePicker.getValue(),
                    LocalTime.now(),
                    descriptionTextField.getText());

            AppointmentData.updateAppointment(updatedAppointment);
            App.setRoot("staff_details_analysis_screen");
        } else {
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (patinetIdTextField.getText().isEmpty() ||
                staffIdTextField.getText().isEmpty() ||
                roomNumberComboBox.getValue() == null ||
                appointmentDatePicker.getValue() == null ||
                descriptionTextField.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled.";
        }

        return errorMessage;
    }

    @FXML
    public void initialize() {
        patinetIdTextField.setText(AppointmentData.initAppointmentData.getPatientId());
        staffIdTextField.setText(AppointmentData.initAppointmentData.getStaffId());
        roomNumberComboBox.setValue(AppointmentData.initAppointmentData.getRoomNum());
        appointmentDatePicker.setValue(AppointmentData.initAppointmentData.getDate());
        descriptionTextField.setText(AppointmentData.initAppointmentData.getDescription());
        roomNumberComboBox.setItems(roomNumOption);
    }
}
