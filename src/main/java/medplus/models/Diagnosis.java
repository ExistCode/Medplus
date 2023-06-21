package medplus.models;

import java.time.LocalDate;


public class Diagnosis {
    private String diagnosisId;
    private String patientName;
    private String staffId;
    private LocalDate date;
    private String diagnosis;

    // Constructor
    public Diagnosis(String dId, String pName, String sId, LocalDate d, String ds) {
        diagnosisId = dId;
        patientName = pName;
        staffId = sId;
        date = d;
        diagnosis = ds;
    }

    public Diagnosis(String diagnosisId2, String patientName2, String staffId2, LocalDate date2, Diagnosis diagnosis2) {
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

    public void setDiagnosis(String ds) {
        diagnosis = ds;
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

    public String getDiagnosis() {
        return diagnosis;
    }
}
