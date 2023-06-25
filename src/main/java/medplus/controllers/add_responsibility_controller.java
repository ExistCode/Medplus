package medplus.controllers;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import medplus.App;
import medplus.data.ResponsibilitiesData;
import medplus.data.StaffData;
import medplus.models.Responsibilities;
import medplus.tableModels.StaffTableDataModel;

public class add_responsibility_controller {
    @FXML
    private TextField responsibilityDetails;

    @FXML
    private TextField responsibilityName;

    @FXML
    private Pane addResponsibilityButton;

    @FXML
    private ImageView backButton;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    private ComboBox<String> staffIdComboBox;

    @FXML
    void backToStaff(MouseEvent event) throws IOException {
        App.setRoot("staff_details_admin_screen");

    }

    ObservableList<String> fetchStaffId() {
        ObservableList<StaffTableDataModel> staffDataList = StaffTableDataModel
                .convertStaffDataToStaffTableDataModel();
        ObservableList<String> staffId = FXCollections.observableArrayList();
        for (StaffTableDataModel staff : staffDataList) {
            staffId.add(staff.getStaffId());
        }
        return staffId;
    }

    @FXML
    public void initialize() {
        staffIdComboBox.setValue(StaffData.initStaffData.getStaffId());
        staffIdComboBox.setItems(fetchStaffId());
    }

    @FXML
    void addResponsibility(MouseEvent event) throws IOException {

        String errorMessage = validateInput();

        if (errorMessage == "") {
            List<Responsibilities> responsibilities = ResponsibilitiesData.fetchResponsibilitiesDataFromDatabase();
            int newResponsibilitiesId = Integer
                    .parseInt(responsibilities.get(responsibilities.size() - 1).getResponsibilityId().substring(2))
                    + 1;
            String newResponsibilitiesIdFormatted = String.format("RS%03d", newResponsibilitiesId);

            Responsibilities newResponsibilities = new Responsibilities(newResponsibilitiesIdFormatted,
                    responsibilityName.getText(),

                    responsibilityDetails.getText(), staffIdComboBox.getSelectionModel().getSelectedItem());

            ResponsibilitiesData.addNewResponsibility(newResponsibilities);
            App.setRoot("staff_details_admin_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }

    }

    private String validateInput() {
        String errorMessage = "";

        if (responsibilityName.getText().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || responsibilityDetails.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }
        return errorMessage;
    }
}
