package medplus.models;

import java.time.LocalDate;

public class Procedure {
    private String procedureId;
    private String patientName;
    private String staffId;
    private LocalDate date;
    private String time;
    private String procedureType;
    private String description;

    // Constructor
    public Procedure(String pId, String pName, String stfId, LocalDate dt, String tm, String pt, String desc) {
        procedureId = pId;
        patientName = pName;
        staffId = stfId;
        date = dt;
        time = tm;
        procedureType = pt;
        description = desc;
    }

    // Setter functions
    public void setProcedureId(String pId) {
        procedureId = pId;
    }

    public void setPatientName(String pName) {
        patientName = pName;
    }

    public void setStaffId(String stfId) {
        staffId = stfId;
    }

    public void setDate(LocalDate dt) {
        date = dt;
    }

    public void setTime(String tm) {
        time = tm;
    }

    public void setType(String typ) {
        procedureType = typ;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    // Getter functions
    public String getProcedureId() {
        return procedureId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getStaffId() {
        return staffId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return procedureType;
    }

    public String getDescription() {
        return description;
    }
}
