package medplus.models;

import java.time.LocalDate;

public class Analysis {
    private String analysisId;
    private String patientName;
    private String staffId;
    private String typeOfTest;
    private String resultSummary;
    private LocalDate date;
    private String testInformation;

    // Constructor
    public Analysis(String aId, String pName, String sId, String testType, String summary, LocalDate d, String info) {
        analysisId = aId;
        patientName = pName;
        staffId = sId;
        typeOfTest = testType;
        resultSummary = summary;
        date = d;
        testInformation = info;
    }

    // Setter functions
    public void setAnalysisId(String aId) {
        analysisId = aId;
    }

    public void setPatientName(String pName) {
        patientName = pName;
    }

    public void setStaffId(String sId) {
        staffId = sId;
    }

    public void setTypeOfTest(String testType) {
        typeOfTest = testType;
    }

    public void setResultSummary(String summary) {
        resultSummary = summary;
    }

    public void setDate(LocalDate d) {
        date = d;
    }

    public void setTestInformation(String info) {
        testInformation = info;
    }

    // Getter functions
    public String getAnalysisId() {
        return analysisId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getTypeOfTest() {
        return typeOfTest;
    }

    public String getResultSummary() {
        return resultSummary;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTestInformation() {
        return testInformation;
    }

}
