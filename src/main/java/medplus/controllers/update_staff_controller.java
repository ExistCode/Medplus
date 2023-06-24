package medplus.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

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
import medplus.data.StaffData;
import medplus.models.Staff;

public class update_staff_controller {
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
    void backToStaff(MouseEvent event) throws IOException {
        App.setRoot("staff_all_home_screen");

    }

    @FXML
    void editStaff(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {
            LocalDate dateOfBirth = dateOfBirthSelector.getValue();
            LocalDate today = LocalDate.now();
            Period p = Period.between(dateOfBirth, today);

            Staff newStaff = new Staff(StaffData.initStaffData.getStaffId(), nameTextField.getText(),
                    nationalIdTextField.getText(),
                    emailTextField.getText(),
                    dateOfBirth, p.getYears(), contactNumberTextField.getText(),
                    jobTitleTextField.getText(),
                    departmentBox.getSelectionModel().getSelectedItem());
            StaffData.updateStaffData(newStaff);
            StaffData.initStaffData.setStaffId(StaffData.initStaffData.getStaffId());
            StaffData.initStaffData.setStaffName(nameTextField.getText());
            StaffData.initStaffData.seStafftEmail(emailTextField.getText());
            StaffData.initStaffData.setStaffContactNumber(contactNumberTextField.getText());
            StaffData.initStaffData.setStaffDepartment(departmentBox.getSelectionModel().getSelectedItem());
            StaffData.initStaffData.setStaffJobTitle(jobTitleTextField.getText());
            App.setRoot("staff_details_screen");

        } else {
            // Printing error message
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
    public void initialize() {
        nameTextField.setText(StaffData.initStaffData.getStaffName());
        nationalIdTextField.setText(StaffData.initStaffData.getStaffNationalId());
        emailTextField.setText(StaffData.initStaffData.getStaffEmail());
        contactNumberTextField.setText(StaffData.initStaffData.getStaffContactNumber());
        dateOfBirthSelector.setValue(StaffData.initStaffData.getStaffDateOfBirth());
        jobTitleTextField.setText(StaffData.initStaffData.getStaffJobTitle());
        departmentBox.getSelectionModel().select(StaffData.initStaffData.getStaffDepartment());
        ageTextField.setText(String.valueOf(StaffData.initStaffData.getStaffAge()));

        departmentBox.setItems(departmentOptions);
    }

}
