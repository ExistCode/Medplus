package medplus.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Procedure {
    private String procedureId;
    private String patientId;
    private String doctorId;
    private LocalDate date;
    private LocalTime time;
    private String type;
    private String description;

    // Constructor
    public Procedure(String pId, String ptId, String drId, LocalDate dt, LocalTime tm, String typ, String desc) {
        procedureId = pId;
        patientId = ptId;
        doctorId = drId;
        date = dt;
        time = tm;
        type = typ;
        description = desc;
    }

    // Setter functions
    public void setProcedureId(String pId) {
        procedureId = pId;
    }

    public void setPatientId(String ptId) {
        patientId = ptId;
    }

    public void setDoctorId(String drId) {
        doctorId = drId;
    }

    public void setDate(LocalDate dt) {
        date = dt;
    }

    public void setTime(LocalTime tm) {
        time = tm;
    }

    public void setType(String typ) {
        type = typ;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    // Getter functions
    public String getProcedureId() {
        return procedureId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
