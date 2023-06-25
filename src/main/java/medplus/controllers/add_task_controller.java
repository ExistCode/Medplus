package medplus.controllers;

import java.io.IOException;
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
import medplus.data.ProcedureData;
import medplus.models.Procedure;
import medplus.tableModels.StaffTableDataModel;

public class add_task_controller {

    @FXML
    private Pane addResponsibilityButton;

    @FXML
    private ImageView backButton;

    @FXML
    private Text errorMessageDisplay;

    @FXML
    private ComboBox <String> staffIdComboBox;

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
        staffIdComboBox.setItems(fetchStaffId());
    }
}
