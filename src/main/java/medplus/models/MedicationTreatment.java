package medplus.models;

import java.time.LocalDate;

public class MedicationTreatment extends Treatment {
    private String medName;
    private String administrationRoute;
    private String frequency;

    public MedicationTreatment(String treatmentId, String patientName, String staffId, LocalDate startDate,
            LocalDate endDate, String treatmentInfo, String mName, String route, String freq) {
        super(treatmentId, patientName, staffId, startDate, endDate, treatmentInfo);
        medName = mName;
        administrationRoute = route;
        frequency = freq;

    }

    public void setMedName(String mName) {
        medName = mName;
    }

    public void setRoute(String route) {
        administrationRoute = route;
    }

    public void setFrequency(String freq) {
        frequency = freq;
    }

    public String getMedName(){
        return medName;
    }
    public String getRoute(){
        return administrationRoute;
    }

    public String getFrequency(){
        return frequency;
    }
}
