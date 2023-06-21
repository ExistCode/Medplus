package medplus.models;

import java.time.LocalDate;

public class Treatment {
    private String treatmentId;
    private String patientName;
    private String staffId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String treatmentInfo;

    // Constructor
    public Treatment(String tId, String pName, String sId, LocalDate start, LocalDate end, String info) {
        treatmentId = tId;
        patientName = pName;
        staffId = sId;
        startDate = start;
        endDate = end;
        treatmentInfo = info;
    }

    // Setter functions
    public void setTreatmentId(String tId) {
        treatmentId = tId;
    }

    public void setPatientName(String pName) {
        patientName = pName;
    }

    public void setStaffId(String sId) {
        staffId = sId;
    }

    public void setStartDate(LocalDate start) {
        startDate = start;
    }

    public void setEndDate(LocalDate end) {
        endDate = end;
    }

    public void setTreatmentInfo(String info) {
        treatmentInfo = info;
    }

    // Getter functions
    public String getTreatmentId() {
        return treatmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getStaffId() {
        return staffId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getTreatmentInfo() {
        return treatmentInfo;
    }
}
