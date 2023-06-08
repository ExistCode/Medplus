package medplus.models;

import java.time.LocalDate;

public class RwAnalysis extends Analysis {
    private double volume;
    private String appearance;
    private double pH;
    private boolean glucosePresence;
    private boolean proteinPresence;
    private boolean bloodCellsPresence;
    private boolean bacteriaPresence;

    // Constructor
    public RwAnalysis(String analysisId, String patientId, String staffId, LocalDate date, String typeOfTest,
            String testInformation, String resultSummary, double vol, String appr, double ph,
            boolean glucosePres, boolean proteinPres, boolean bloodCellsPres, boolean bacteriaPres) {
        super(analysisId, patientId, staffId, date, typeOfTest, testInformation, resultSummary);
        volume = vol;
        appearance = appr;
        pH = ph;
        glucosePresence = glucosePres;
        proteinPresence = proteinPres;
        bloodCellsPresence = bloodCellsPres;
        bacteriaPresence = bacteriaPres;
    }

    // Setter functions
    public void setVolume(double vol) {
        volume = vol;
    }

    public void setAppearance(String appr) {
        appearance = appr;
    }

    public void setpH(double ph) {
        pH = ph;
    }

    public void setGlucosePresence(boolean glucosePres) {
        glucosePresence = glucosePres;
    }

    public void setProteinPresence(boolean proteinPres) {
        proteinPresence = proteinPres;
    }

    public void setBloodCellsPresence(boolean bloodCellsPres) {
        bloodCellsPresence = bloodCellsPres;
    }

    public void setBacteriaPresence(boolean bacteriaPres) {
        bacteriaPresence = bacteriaPres;
    }

    // Getter functions
    public double getVolume() {
        return volume;
    }

    public String getAppearance() {
        return appearance;
    }

    public double getpH() {
        return pH;
    }

    public boolean isGlucosePresence() {
        return glucosePresence;
    }

    public boolean isProteinPresence() {
        return proteinPresence;
    }

    public boolean isBloodCellsPresence() {
        return bloodCellsPresence;
    }

    public boolean isBacteriaPresence() {
        return bacteriaPresence;
    }
}
