package medplus.models;

public class Tasks {
    private String taskId;
    private String taskName;
    private String taskDescription;
    private String staffId;

    public Tasks(String id, String name, String description, String sId) {
        taskId = id;
        taskName = name;
        taskDescription = description;
        staffId = sId;
    }

    // Setter functions
    public void setTaskId(String id) {
        taskId = id;
    }

    public void setTaskName(String name) {
        taskName = name;
    }

    public void setTaskDescription(String description) {
        taskDescription = description;
    }

    public void setStaffId(String sId) {
        staffId = sId;
    }

    // Getter functions
    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getStaffId() {
        return staffId;
    }
}
