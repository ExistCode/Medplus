package medplus.tableModels;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import medplus.App;
import medplus.data.PatientData;
import medplus.models.Patient;

public class PatientTableDataModel {
    private SimpleStringProperty patientId;
    private SimpleStringProperty name;
    private SimpleStringProperty gender;
    private SimpleObjectProperty<LocalDate> dateOfBirth;
    private SimpleStringProperty bloodType;
    private SimpleIntegerProperty age;
    private SimpleDoubleProperty weight;
    private SimpleDoubleProperty height;

    public PatientTableDataModel(String patientId, String name, String gender, LocalDate dateOfBirth, String bloodType,
            int age, double weight, double height) {
        this.patientId = new SimpleStringProperty(patientId);
        this.name = new SimpleStringProperty(name);
        this.gender = new SimpleStringProperty(gender);
        this.dateOfBirth = new SimpleObjectProperty<>(dateOfBirth);
        this.bloodType = new SimpleStringProperty(bloodType);
        this.age = new SimpleIntegerProperty(age);
        this.weight = new SimpleDoubleProperty(weight);
        this.height = new SimpleDoubleProperty(height);
    }

    public static ObservableList<PatientTableDataModel> convertPatientDataToPatientTableDataModel() {
        List<Patient> initialPatientList = PatientData.fetchPatientDataFromDatabase();
        ObservableList<PatientTableDataModel> convertedList = FXCollections.observableArrayList();

        for (int i = 0; i < initialPatientList.size(); i++) {
            String patientId = initialPatientList.get(i).getPatientId();
            String name = initialPatientList.get(i).getName();
            String gender = initialPatientList.get(i).getPatientGender();
            LocalDate dateOfBirth = initialPatientList.get(i).getDateOfBirth();
            String bloodType = initialPatientList.get(i).getPatientBloodType();
            int age = initialPatientList.get(i).getPatientAge();
            double weight = initialPatientList.get(i).getPatientWeight();
            double height = initialPatientList.get(i).getPatientHeight();

            convertedList.add(
                    new PatientTableDataModel(patientId, name, gender, dateOfBirth, bloodType, age, weight, height));
        }

        return convertedList;
    }

    public void detailsButtonAction(ActionEvent event) throws IOException {
        App.setRoot("patients_details_screen");
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

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public double getWeight() {
        return weight.get();
    }

    public SimpleDoubleProperty weightProperty() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    public double getHeight() {
        return height.get();
    }

    public SimpleDoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }
}
