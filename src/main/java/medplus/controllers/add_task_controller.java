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
import medplus.data.StaffData;
import medplus.data.TaskData;
import medplus.models.Tasks;
import medplus.tableModels.StaffTableDataModel;

public class add_task_controller {
    @FXML
    private TextField TaskDetails;

    @FXML
    private Pane addTaskButton;
    @FXML
    private TextField taskName;

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
    void addTask(MouseEvent event) throws IOException {
        String errorMessage = validateInput();

        if (errorMessage == "") {
            List<Tasks> taskData = TaskData.fetchTasksDataFromDatabase();
            int newTaskId = Integer
                    .parseInt(taskData.get(taskData.size() - 1).getTaskId().substring(1))
                    + 1;
            String newTaskIdFormatted = String.format("RS%03d", newTaskId);

            Tasks newTasks = new Tasks(newTaskIdFormatted,
                    taskName.getText(),

                    TaskDetails.getText(), staffIdComboBox.getSelectionModel().getSelectedItem());

            TaskData.addNewTask(newTasks);
            App.setRoot("staff_details_admin_screen");
        } else {
            // Show error message
            System.out.println(errorMessage);
        }

    }

    private String validateInput() {
        String errorMessage = "";

        if (taskName.getText().isEmpty() || staffIdComboBox.getSelectionModel().isEmpty()
                || TaskDetails.getText().isEmpty()) {
            errorMessage = "Please make sure all fields are filled with the appropriate type.";
            System.out.println(errorMessage);
            errorMessageDisplay.setText(errorMessage);
        }
        return errorMessage;
    }

    @FXML
    public void initialize() {
        staffIdComboBox.setValue(StaffData.initStaffData.getStaffId());
        staffIdComboBox.setItems(fetchStaffId());
    }
}
