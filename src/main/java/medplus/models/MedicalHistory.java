package medplus.models;

import java.time.*;

public class MedicalHistory {
    private String medHisId;
    private String patientId;
    private String staffId;
    private LocalDate date;
    private LocalTime time;
    private String result;
    private String observation;
    private String complication;

    // Constructor
    public MedicalHistory(String mHId, String pId, String sId, LocalDate d, LocalTime t, String r, String obs,
            String comp) {
        medHisId = mHId;
        patientId = pId;
        staffId = sId;
        date = d;
        time = t;
        result = r;
        observation = obs;
        complication = comp;
    }

    // Setter Functions
    public void setMedicalHistoryId(String mHId) {
        medHisId = mHId;
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

    public void setTime(LocalTime t) {
        time = t;
    }

    public void setResult(String r) {
        result = r;
    }

    public void setObservation(String obs) {
        observation = obs;
    }

    public void setComplication(String comp) {
        complication = comp;
    }

    // Getter Functions
    public String getMedHisId() {
        return medHisId;
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

    public LocalTime getTime() {
        return time;
    }

    public String getResult() {
        return result;
    }

    public String getObservation() {
        return observation;
    }

    public String getComplication() {
        return complication;
    }
}
