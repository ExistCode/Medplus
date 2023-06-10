package medplus.tableModels;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import medplus.models.Diagnosis;
import medplus.models.MedicalHistory;
import medplus.models.Patient;

public class patient_table_model {
    private SimpleStringProperty patientId;
    private SimpleStringProperty name;
    private SimpleObjectProperty checkInDate;
    private SimpleStringProperty doctorId;
    private SimpleStringProperty diseaseName;
    private SimpleStringProperty status;

    public patient_table_model(SimpleStringProperty patientId, SimpleStringProperty name,
            SimpleObjectProperty checkInDate, SimpleStringProperty doctorId, SimpleStringProperty diseaseName,
            SimpleStringProperty status) {
        this.patientId = patientId;
        this.name = name;
        this.checkInDate = checkInDate;
        this.doctorId = doctorId;
        this.diseaseName = diseaseName;
        this.status = status;
    }

    public String getPatientId() {
        return patientId.get();
    }

    public SimpleStringProperty patientIdProperty() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId.set(patientId);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Object getCheckInDate() {
        return checkInDate.get();
    }

    public SimpleObjectProperty<Object> checkInDateProperty() {
        return checkInDate;
    }

    public void setCheckInDate(Object checkInDate) {
        this.checkInDate.set(checkInDate);
    }

    public String getDoctorId() {
        return doctorId.get();
    }

    public SimpleStringProperty doctorIdProperty() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId.set(doctorId);
    }

    public String getDiseaseName() {
        return diseaseName.get();
    }

    public SimpleStringProperty diseaseNameProperty() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName.set(diseaseName);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

}
