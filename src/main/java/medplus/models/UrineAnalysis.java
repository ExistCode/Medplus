package medplus.models;

import java.time.LocalDate;

public class UrineAnalysis extends Analysis {
    private double volume;
    private String appearance;
    private double pH;
    private boolean presenceOfGlucose;
    private boolean presenceOfProtein;
    private boolean presenceOfBloodCells;
    private boolean presenceOfBacteria;
    private boolean presenceOfCrystal;

    // Constructor
    public UrineAnalysis(String aId, String pId, String sId, LocalDate d, String testType, String info, String summary,
            double vol, String appr, double ph, boolean glucose, boolean protein, boolean bloodCells,
            boolean bacteria, boolean crystal) {
        super(aId, pId, sId, d, testType, info, summary);
        volume = vol;
        appearance = appr;
        pH = ph;
        presenceOfGlucose = glucose;
        presenceOfProtein = protein;
        presenceOfBloodCells = bloodCells;
        presenceOfBacteria = bacteria;
        presenceOfCrystal = crystal;
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

    public void setPresenceOfGlucose(boolean glucose) {
        presenceOfGlucose = glucose;
    }

    public void setPresenceOfProtein(boolean protein) {
        presenceOfProtein = protein;
    }

    public void setPresenceOfBloodCells(boolean bloodCells) {
        presenceOfBloodCells = bloodCells;
    }

    public void setPresenceOfBacteria(boolean bacteria) {
        presenceOfBacteria = bacteria;
    }

    public void setPresenceOfCrystal(boolean crystal) {
        presenceOfCrystal = crystal;
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

    public boolean isPresenceOfGlucose() {
        return presenceOfGlucose;
    }

    public boolean isPresenceOfProtein() {
        return presenceOfProtein;
    }

    public boolean isPresenceOfBloodCells() {
        return presenceOfBloodCells;
    }

    public boolean isPresenceOfBacteria() {
        return presenceOfBacteria;
    }

    public boolean isPresenceOfCrystal() {
        return presenceOfCrystal;
    }
}
