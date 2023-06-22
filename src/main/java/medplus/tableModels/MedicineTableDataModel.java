package medplus.tableModels;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import medplus.data.MedicineData;
import medplus.models.Medicine;

public class MedicineTableDataModel {
    private SimpleStringProperty medicineId;
    private SimpleStringProperty patientName;
    private SimpleStringProperty doctorId;
    private SimpleStringProperty medicineName;
    private SimpleStringProperty amount;
    private SimpleStringProperty doseDetail;

    public MedicineTableDataModel(String medicineId, String medicineName, String patientName, String doctorId,
            String amount, String doseDetail) {
        this.medicineId = new SimpleStringProperty(medicineId);
        this.patientName = new SimpleStringProperty(patientName);
        this.doctorId = new SimpleStringProperty(doctorId);
        this.medicineName = new SimpleStringProperty(medicineName);
        this.amount = new SimpleStringProperty(amount);
        this.doseDetail = new SimpleStringProperty(doseDetail);
    }

    public static ObservableList<MedicineTableDataModel> convertMedicineDataToMedicineTableDataModel() {
        List<Medicine> initialMedicineList = MedicineData.fetchMedicineDataFromDatabase();
        ObservableList<MedicineTableDataModel> convertedList = FXCollections.observableArrayList();

        for (int i = 0; i < initialMedicineList.size(); i++) {
            String medicineId = initialMedicineList.get(i).getMedicineId();
            String patientName = initialMedicineList.get(i).getPatientName();
            String doctorId = initialMedicineList.get(i).getStaffId();
            String medicineName = initialMedicineList.get(i).getMedicineName();
            String amount = initialMedicineList.get(i).getAmount();
            String doseDetail = initialMedicineList.get(i).getDoseDetail();

            convertedList.add(
                    new MedicineTableDataModel(medicineId, medicineName, patientName, doctorId, amount, doseDetail));
        }

        return convertedList;
    }

    public String getMedicineId() {
        return medicineId.get();
    }

    public SimpleStringProperty medicineIdProperty() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId.set(medicineId);
    }

    public String getPatientName() {
        return patientName.get();
    }

    public SimpleStringProperty patientNameProperty() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName.set(patientName);
    }

    public String getStaffId() {
        return doctorId.get();
    }

    public SimpleStringProperty doctorIdProperty() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId.set(doctorId);
    }

    public String getMedicineName() {
        return medicineName.get();
    }

    public SimpleStringProperty medicineNameProperty() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName.set(medicineName);
    }

    public String getAmount() {
        return amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }

    public String getDoseDetail() {
        return doseDetail.get();
    }

    public SimpleStringProperty doseDetailProperty() {
        return doseDetail;
    }

    public void setDoseDetail(String doseDetail) {
        this.doseDetail.set(doseDetail);
    }
}
