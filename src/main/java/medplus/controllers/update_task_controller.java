package medplus.controllers;

import java.io.IOException;
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
import medplus.data.TaskData;
import medplus.models.Tasks;
import medplus.tableModels.StaffTableDataModel;

public class update_task_controller {

    @FXML
    private TextField taskDescription;

    @FXML
    private TextField taskName;

    @FXML
    private Pane updateTask;

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

    // Initializing the admin's task details
    @FXML
    public void initialize() {
        staffIdComboBox.setValue(TaskData.initTask.getStaffId());
        taskName.setText(TaskData.initTask.getTaskName());
        taskDescription.setText(TaskData.initTask.getTaskDescription());
        staffIdComboBox.setItems(fetchStaffId());
    }

    @FXML
    void updateTasks(MouseEvent event) throws IOException {
        String errorMessage = validateInput();
        if (errorMessage.isEmpty()) {
            Tasks newTasks = new Tasks(
                    TaskData.initTask.getTaskId(), taskName.getText(),
                    taskDescription.getText(), staffIdComboBox.getSelectionModel().getSelectedItem());

            TaskData.updateTask(newTasks);
            App.setRoot("staff_details_admin_screen");
        } else {
            System.out.println(errorMessage);
        }

    }
    // Validating no empty and wrong input from user

    private String validateInput() {
        String errorMessage = "";

        if (taskName.getText().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || taskDescription.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }
        return errorMessage;
    }
}
