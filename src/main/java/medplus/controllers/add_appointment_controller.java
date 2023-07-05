package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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
import medplus.data.AppointmentData;
import medplus.data.StaffData;
import medplus.models.Appointment;

public class add_appointment_controller {

    ObservableList<String> roomNumOption = FXCollections.observableArrayList(
            "R101", "R102", "R103", "R104", "R105", "R106", "R201", "R202", "R203", "R204",
            "R205", "R206", "R207", "R208", "R301", "R302", "R303", "R304", "R305", "R306");

    @FXML
    private Pane addAppointmentButton;

    @FXML
    private DatePicker appointmentDatePicker;

    @FXML
    private ImageView backButton;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TextField patientIdTextField;

    @FXML
    private ComboBox<String> roomNumberComboBox;

    @FXML
    private TextField staffIdTextField;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    void addNewAppointment(MouseEvent event) {
        String errorMessage = validateInput();

        if (errorMessage.isEmpty()) {
            List<Appointment> appointmentList = AppointmentData.fetchAllAppointmentDataFromDatabase();
            int newAppointmentId = Integer
                    .parseInt(appointmentList.get(appointmentList.size() - 1).getAppointmentId().substring(1)) + 1;
            String newAppointmentIdFormatted = String.format("A%03d", newAppointmentId);
            String patientId = patientIdTextField.getText();
            String staffId = staffIdTextField.getText();
            LocalDate date = appointmentDatePicker.getValue();
            String description = descriptionTextField.getText();
            String roomNumber = roomNumberComboBox.getValue();

            Appointment newAppointment = new Appointment(newAppointmentIdFormatted, patientId, staffId, roomNumber,
                    date, LocalTime.now(), description);

            AppointmentData.addNewAppointment(newAppointment);

            try {
                App.setRoot("staff_details_screen");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";
        // Validate no empty input
        if (patientIdTextField.getText().isEmpty() || staffIdTextField.getText().isEmpty()
                || appointmentDatePicker.getValue() == null || descriptionTextField.getText().isEmpty()
                || roomNumberComboBox.getValue() == null) {
            errorMessage = "Please make sure all fields are filled.";
            errorMessageDisplay.setText(errorMessage);
        }

        return errorMessage;
    }

    @FXML
    void backToSearch(MouseEvent event) throws IOException {
        App.setRoot("staff_details_screen");

    }

    // Initialize Combobox and staffId
    @FXML
    public void initialize() {
        staffIdTextField.setText(AppointmentData.initAppointmentData.getStaffId());
        roomNumberComboBox.setItems(roomNumOption);
    }
}