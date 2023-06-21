package medplus.models;

public class Medicine {
    private String medicineId;
    private String patientName;
    private String staffId;
    private String medicineName;
    private String amount;
    private String doseDetail;

    // Constructor
    public Medicine(String mId, String pName, String sId, String mName, String amt, String dose) {
        medicineId = mId;
        patientName = pName;
        staffId = sId;
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

    public void setStaffId(String sId) {
        staffId = sId;
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

    public String getStaffId() {
        return staffId;
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
