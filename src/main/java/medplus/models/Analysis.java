package medplus.models;

import java.time.LocalDate;

public class Analysis {
    private String analysisId;
    private String patientId;
    private String staffId;
    private LocalDate date;
    private String typeOfTest;
    private String testInformation;
    private String resultSummary;

    // Constructor
    public Analysis(String aId, String pId, String sId, LocalDate d, String testType, String info, String summary) {
        analysisId = aId;
        patientId = pId;
        staffId = sId;
        date = d;
        typeOfTest = testType;
        testInformation = info;
        resultSummary = summary;
    }

    // Setter functions
    public void setAnalysisId(String aId) {
        analysisId = aId;
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

    public void setTypeOfTest(String testType) {
        typeOfTest = testType;
    }

    public void setTestInformation(String info) {
        testInformation = info;
    }

    public void setResultSummary(String summary) {
        resultSummary = summary;
    }

    // Getter functions
    public String getAnalysisId() {
        return analysisId;
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

    public String getTypeOfTest() {
        return typeOfTest;
    }

    public String getTestInformation() {
        return testInformation;
    }

    public String getResultSummary() {
        return resultSummary;
    }
}
