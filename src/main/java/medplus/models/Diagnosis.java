package medplus.models;

import java.time.LocalDate;

public class Diagnosis {
    private String diagnosisId;
    private String patientId;
    private String staffId;
    private LocalDate date;
    private String name;
    private String sickness;

    // Constructor
    public Diagnosis(String dId, String pId, String sId, LocalDate d, String n, String s) {
        diagnosisId = dId;
        patientId = pId;
        staffId = sId;
        date = d;
        name = n;
        sickness = s;
    }

    // Setter functions
    public void setDiagnosisId(String dId) {
        diagnosisId = dId;
    }

    public void setPatientId(String pId) {
        patientId = pId;
    }

    public void setStaffId(String sId) {
        staffId = sId;
    }

    public void setDate(LocalDate d) {
        date = d;
    }

    public void setName(String n) {
        name = n;
    }

    public void setSickness(String s) {
        sickness = s;
    }

    // Getter functions
    public String getDiagnosisId() {
        return diagnosisId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getStaffId() {
        return staffId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getSickness() {
        return sickness;
    }
}
