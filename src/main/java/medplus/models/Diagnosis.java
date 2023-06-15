package medplus.models;

import java.time.LocalDate;


public class Diagnosis {
    private String diagnosisId;
    private String patientName;
    private String staffId;
    private LocalDate date;
    private String sickness;

    // Constructor
    public Diagnosis(String dId, String pName, String sId, LocalDate d, String s) {
        diagnosisId = dId;
        patientName = pName;
        staffId = sId;
        date = d;
        sickness = s;
    }

    // Setter functions
    public void setDiagnosisId(String dId) {
        diagnosisId = dId;
    }

    public void setPatientName(String pName) {
        patientName = pName;
    }

    public void setStaffId(String sId) {
        staffId = sId;
    }

    public void setDate(LocalDate d) {
        date = d;
    }

    public void setSickness(String s) {
        sickness = s;
    }

    // Getter functions
    public String getDiagnosisId() {
        return diagnosisId;
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

    public String getSickness() {
        return sickness;
    }
}
