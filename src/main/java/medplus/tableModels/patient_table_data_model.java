package medplus.tableModels;

import java.util.Date;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import medplus.models.Diagnosis;
import medplus.models.MedicalHistory;
import medplus.models.Patient;

public class patient_table_data_model {
    private ObservableList<patient_table_model> patientTableData;
    private Patient patients;
    private MedicalHistory history;
    private Diagnosis diagnostic;

    public patient_table_data_model() {
        this.patientTableData = FXCollections.observableArrayList();
    }

    public void addPatientData(Patient patients, MedicalHistory history, Diagnosis diagnostic, String stats) {
        SimpleStringProperty patientId = new SimpleStringProperty(patients.getPatientId());
        SimpleStringProperty name = new SimpleStringProperty(patients.getPatientName());
        SimpleObjectProperty<Date> checkInDate = new SimpleObjectProperty(history.getDate());
        SimpleStringProperty doctorId = new SimpleStringProperty(history.getStaffId());
        SimpleStringProperty diseaseName = new SimpleStringProperty(diagnostic.getSickness());
        SimpleStringProperty status = new SimpleStringProperty(stats);
        this.patientTableData.add(new patient_table_model(patientId, name, checkInDate, doctorId, diseaseName, status));
    }

    public ObservableList<patient_table_model> getPatientData() {
        return patientTableData;
    }
}
