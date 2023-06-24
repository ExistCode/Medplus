package medplus.models;

public class Responsibilities {
    private String responsibilityId;
    private String responsibilityName;
    private String responsibilityDescription;
    private String staffId;

    public Responsibilities(String id, String name, String description, String sId) {
        responsibilityId = id;
        responsibilityName = name;
        responsibilityDescription = description;
        staffId = sId;
    }

    // Setter functions
    public void setResponsibilityId(String id) {
        responsibilityId = id;
    }

    public void setResponsibilityName(String name) {
        responsibilityName = name;
    }

    public void setResponsibilityDescription(String description) {
        responsibilityDescription = description;
    }

    public void setStaffId(String sId) {
        staffId = sId;
    }

    // Getter functions
    public String getResponsibilityId() {
        return responsibilityId;
    }

    public String getResponsibilityName() {
        return responsibilityName;
    }

    public String getResponsibilityDescription() {
        return responsibilityDescription;
    }

    public String getStaffId() {
        return staffId;
    }
}
