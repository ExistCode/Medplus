package medplus.models;

public class Medicine {
    private String medicineId;
    private String patientName;
    private String doctorId;
    private String medicineName;
    private String amount;
    private String doseDetail;

    // Constructor
    public Medicine(String mId, String pName, String dId, String mName, String amt, String dose) {
        medicineId = mId;
        patientName = pName;
        doctorId = dId;
        medicineName = mName;
        amount = amt;
        doseDetail = dose;
    }

    // Setter functions
    public void setMedicineId(String mId) {
        medicineId = mId;
    }

    public void setPatientName(String pName) {
        patientName = pName;
    }

    public void setDoctorId(String dId) {
        doctorId = dId;
    }

    public void setMedicineName(String mName){
        medicineName = mName;
    }

    public void setDoseDetail(String dose) {
        doseDetail = dose;
    }

    public void setAmount(String amt) {
        amount = amt;
    }

    // Getter functions
    public String getMedicineId() {
        return medicineId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getMedicineName(){
        return medicineName;
    }
    
    public String getDoseDetail() {
        return doseDetail;
    }

    public String getAmount() {
        return amount;
    }
}
