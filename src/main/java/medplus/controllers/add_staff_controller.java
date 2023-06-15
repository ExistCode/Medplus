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
import medplus.data.StaffData;
import medplus.models.Patient;
import medplus.models.Staff;

public class add_staff_controller {
    ObservableList<String> departmentOptions = FXCollections.observableArrayList(
            "Doctor",
            "Nurse",
            "Administration");

    @FXML
    private Pane addStaffButton;

    @FXML
    private TextField ageTextField;

    @FXML
    private ImageView backButton;

    @FXML
    private TextField contactNumberTextField;

    @FXML
    private DatePicker dateOfBirthSelector;

    @FXML
    private ComboBox<String> departmentBox;

    @FXML
    private TextField emailTextField;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    private TextField jobTitleTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField nationalIdTextField;

    @FXML
    void addStaff(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage.equals("")) {
            List<Staff> staffList = StaffData.fetchStaffDataFromDatabase();
            int newStaffId = Integer.parseInt(staffList.get(staffList.size() - 1).getStaffId().substring(1)) + 1;
            String newStaffIdFormatted = String.format("S%03d", newStaffId);
            LocalDate dateOfBirth = dateOfBirthSelector.getValue();
            LocalDate today = LocalDate.now();
            Period p = Period.between(dateOfBirth, today);
            System.out.println(newStaffIdFormatted);

            Staff newStaff = new Staff(newStaffIdFormatted, nameTextField.getText(),
                    nationalIdTextField.getText(),
                    emailTextField.getText(),
                    dateOfBirth, p.getYears(), contactNumberTextField.getText(),
                    jobTitleTextField.getText(),
                    departmentBox.getSelectionModel().getSelectedItem());
            StaffData.addNewStaff(newStaff);
            App.setRoot("staff_all_home_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }
    }

    private String validateInput() {
        String errorMessage = "";

        if (nameTextField.getText().isEmpty() || nationalIdTextField.getText().isEmpty()
                || emailTextField.getText().isEmpty() || dateOfBirthSelector.getValue() == null
                || contactNumberTextField.getText().isEmpty() || jobTitleTextField.getText().isEmpty()
                || departmentBox.getSelectionModel().isEmpty()) {
            errorMessage = "Please make sure all fields are filled.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }

        return errorMessage;
    }

    @FXML
    void backToStaff(MouseEvent event) throws IOException {
        App.setRoot("staff_all_home_screen");
    }

    @FXML
    public void initialize() {
        departmentBox.setItems(departmentOptions);
    }

}
