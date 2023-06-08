package medplus.models;

import java.time.LocalDate;

public class BiobloodAnalysis extends Analysis {
    private String bloodCount;
    private String bloodChemistry;
    private String bloodType;
    private String coagulationProfile;

    public BiobloodAnalysis(String analysisId, String patientId, String staffId, LocalDate date, String typeOfTest,
            String testInformation, String resultSummary, String bCount, String bChem, String bType,
            String coagProfile) {
        super(analysisId, patientId, staffId, date, typeOfTest, testInformation, resultSummary);
        bloodCount = bCount;
        bloodChemistry = bChem;
        bloodType = bType;
        coagulationProfile = coagProfile;
    }

    // Setter functions
    public void setBloodCount(String bCount) {
        bloodCount = bCount;
    }

    public void setBloodChemistry(String bChem) {
        bloodChemistry = bChem;
    }

    public void setBloodType(String bType) {
        bloodType = bType;
    }

    public void setCoagulationProfile(String coagProfile) {
        coagulationProfile = coagProfile;
    }

    // Getter functions
    public String getBloodCount() {
        return bloodCount;
    }

    public String getBloodChemistry() {
        return bloodChemistry;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getCoagulationProfile() {
        return coagulationProfile;
    }
}
