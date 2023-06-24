package medplus.tableModels;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import medplus.data.TaskData;
import medplus.models.Tasks;

public class TaskTableDataModel {
    private SimpleStringProperty taskId;
    private SimpleStringProperty taskName;
    private SimpleStringProperty taskDescription;
    private SimpleStringProperty staffId;

    public TaskTableDataModel(String taskId, String taskName, String taskDescription, String staffId) {
        this.taskId = new SimpleStringProperty(taskId);
        this.taskName = new SimpleStringProperty(taskName);
        this.taskDescription = new SimpleStringProperty(taskDescription);
        this.staffId = new SimpleStringProperty(staffId);
    }

    public static ObservableList<TaskTableDataModel> convertTaskDataToTaskTableDataModel(String id) {
        List<Tasks> initialTaskList = TaskData.fetchTasksDataFromDatabasebyId(id);
        ObservableList<TaskTableDataModel> convertedList = FXCollections.observableArrayList();

        for (int i = 0; i < initialTaskList.size(); i++) {
            String taskId = initialTaskList.get(i).getTaskId();
            String taskName = initialTaskList.get(i).getTaskName();
            String taskDescription = initialTaskList.get(i).getTaskDescription();
            String staffId = initialTaskList.get(i).getStaffId();

            convertedList.add(new TaskTableDataModel(taskId, taskName, taskDescription, staffId));
        }

        return convertedList;
    }

    public String getTaskId() {
        return taskId.get();
    }

    public SimpleStringProperty taskIdProperty() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId.set(taskId);
    }

    public String getTaskName() {
        return taskName.get();
    }

    public SimpleStringProperty taskNameProperty() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName.set(taskName);
    }

    public String getTaskDescription() {
        return taskDescription.get();
    }

    public SimpleStringProperty taskDescriptionProperty() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription.set(taskDescription);
    }

    public String getStaffId() {
        return staffId.get();
    }

    public SimpleStringProperty staffIdProperty() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId.set(staffId);
    }
}
