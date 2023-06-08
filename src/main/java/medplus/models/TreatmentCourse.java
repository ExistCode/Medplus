package medplus.models;

import java.time.LocalDate;

public class TreatmentCourse {
    private String treatmentId;
    private String patientId;
    private String staffId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String treatmentDetail;

    // Constructor
    public TreatmentCourse(String tId, String pId, String sId, LocalDate start, LocalDate end, String detail) {
        treatmentId = tId;
        patientId = pId;
        staffId = sId;
        startDate = start;
        endDate = end;
        treatmentDetail = detail;
    }

    // Setter functions
    public void setTreatmentId(String tId) {
        treatmentId = tId;
    }

    public void setPatientId(String pId) {
        patientId = pId;
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

    public void setTreatmentDetail(String detail) {
        treatmentDetail = detail;
    }

    // Getter functions
    public String getTreatmentId() {
        return treatmentId;
    }

    public String getPatientId() {
        return patientId;
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

    public String getTreatmentDetail() {
        return treatmentDetail;
    }
}
