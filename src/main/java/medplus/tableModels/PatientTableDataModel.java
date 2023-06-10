package medplus.tableModels;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import medplus.data.PatientData;
import medplus.models.Patient;

public class PatientTableDataModel {
    private SimpleStringProperty patientId;
    private SimpleStringProperty name;
    private SimpleStringProperty gender;
    private SimpleObjectProperty<LocalDate> dateOfBirth;
    private SimpleStringProperty bloodType;

    public PatientTableDataModel(String patientId, String name, String gender, LocalDate dateOfBirth,
            String bloodType) {
        this.patientId = new SimpleStringProperty(patientId);
        this.name = new SimpleStringProperty(name);
        this.gender = new SimpleStringProperty(gender);
        this.dateOfBirth = new SimpleObjectProperty<>(dateOfBirth);
        this.bloodType = new SimpleStringProperty(bloodType);
    }

    public static ObservableList<PatientTableDataModel> convertPatientDataToPatientTableDataModel() {
        List<Patient> initialPatientList = PatientData.fetchPatientDataFromDatabase();
        ObservableList<PatientTableDataModel> convertedList = FXCollections.observableArrayList();

        for (int i = 0; i < initialPatientList.size(); i++) {
            String patientId = initialPatientList.get(i).getPatientId();
            String name = initialPatientList.get(i).getPatientName();
            String gender = initialPatientList.get(i).getPatientGender();
            LocalDate dateOfBirth = initialPatientList.get(i).getPatientDateOfBirth();
            String bloodType = initialPatientList.get(i).getPatientBloodType();

            convertedList.add(new PatientTableDataModel(patientId, name, gender, dateOfBirth, bloodType));
        }

        return convertedList;
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

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public SimpleObjectProperty<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public String getBloodType() {
        return bloodType.get();
    }

    public SimpleStringProperty bloodTypeProperty() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType.set(bloodType);
    }
}
