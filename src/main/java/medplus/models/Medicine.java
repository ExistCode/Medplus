package medplus.models;

public class Medicine {
    private String medicineId;
    private String patientId;
    private String doctorId;
    private String name;
    private String doseDetail;
    private String amount;

    // Constructor
    public Medicine(String mId, String pId, String dId, String n, String dose, String amt) {
        medicineId = mId;
        patientId = pId;
        doctorId = dId;
        name = n;
        doseDetail = dose;
        amount = amt;
    }

    // Setter functions
    public void setMedicineId(String mId) {
        medicineId = mId;
    }

    public void setPatientId(String pId) {
        patientId = pId;
    }

    public void setDoctorId(String dId) {
        doctorId = dId;
    }

    public void setName(String n) {
        name = n;
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

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getDoseDetail() {
        return doseDetail;
    }

    public String getAmount() {
        return amount;
    }
}
