package medplus.models;

import java.time.LocalDate;

public class Rehabilitation extends Treatment {
    private String patientGoal;
    private String initialAssessment;
    private String rehabPlan;
    private String rehabSchedule;
    private String rehabProgress;
    private String dischargePlan;

    public Rehabilitation(String treatmentId, String patientName, String staffId, LocalDate startDate,
            LocalDate endDate, String treatmentInfo, String pGoal, String initAssess, String rPlan, String rSchedule,
            String rProgress, String dPlan) {
        super(treatmentId, patientName, staffId, startDate, endDate, treatmentInfo);
        patientGoal = pGoal;
        initialAssessment = initAssess;
        rehabPlan = rPlan;
        rehabSchedule = rSchedule;
        rehabProgress = rProgress;
        dischargePlan = dPlan;

    }

    public void setPatientGoal(String pGoal) {
        patientGoal = pGoal;
    }

    public void setInitialAssessment(String initAssess) {
        initialAssessment = initAssess;
    }

    public void setRehabPlan(String rPlan) {
        rehabPlan = rPlan;
    }

    public void setRehabSchedule(String rSchedule) {
        rehabSchedule = rSchedule;
    }

    public void setRehabProgress(String rProgress) {
        rehabProgress = rProgress;
    }

    public void setDischargePlan(String dPlan) {
        dischargePlan = dPlan;
    }

    public String getPatientGoal() {
        return patientGoal;
    }

    public String getInitialAssessment() {
        return initialAssessment;
    }

    public String getRehabPlan() {
        return rehabPlan;
    }

    public String getRehabSchedule() {
        return rehabSchedule;
    }

    public String getRehabProgress() {
        return rehabProgress;
    }

    public String getDischargePlan() {
        return dischargePlan;
    }

}
