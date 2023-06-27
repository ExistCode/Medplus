package medplus.models;

import java.time.LocalDate;

public class SurgicalTreatment extends Treatment {
    private String surgeonCreds;
    private String anesthesiaType;
    private String surgicalApproach;
    private String surgicalSite;
    private String complications;

    public SurgicalTreatment(String treatmentId, String patientName, String staffId, LocalDate startDate,
            LocalDate endDate, String treatmentInfo, String sCreds, String aType, String sApproach, String sSite, String comp) {
        super(treatmentId, patientName, staffId, startDate, endDate, treatmentInfo);
        surgeonCreds = sCreds;
        anesthesiaType = aType;
        surgicalApproach = sApproach;
        surgicalSite = sSite;
        complications = comp;
    }

    public void setSurgeonCreds(String sCreds){
        surgeonCreds = sCreds;
    }

    public void setAnesthesiaType(String aType){
        anesthesiaType = aType;
    }

    public void setSurgicalApproach(String sApproach){
        surgicalApproach = sApproach;
    }

    public void setSurgicalSite(String sSite){
        surgicalSite = sSite;
    }

    public void setComplications(String comp){
        complications = comp;
    }

    public String getSurgeonCreds(){
        return surgeonCreds;
    }

    public String getAnesthesiaType(){
        return anesthesiaType;
    }

    public String getSurgicalApproach(){
        return surgicalApproach;
    }

    public String getSurgicalSite(){
        return surgicalSite;
    }

    public String getComplications(){
        return complications;
    }
}
