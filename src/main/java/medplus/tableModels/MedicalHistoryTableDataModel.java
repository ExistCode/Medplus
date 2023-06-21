package medplus.tableModels;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import medplus.data.MedicalHistoryData;
import medplus.models.MedicalHistory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MedicalHistoryTableDataModel {
    private SimpleStringProperty medHisId;
    private SimpleStringProperty patientId;
    private SimpleStringProperty staffId;
    private SimpleObjectProperty<LocalDate> date;
    private SimpleObjectProperty<LocalTime> time;
    private SimpleStringProperty result;
    private SimpleStringProperty observation;
    private SimpleStringProperty complication;

    public MedicalHistoryTableDataModel(String medHisId, String patientId, String staffId, LocalDate date,
            LocalTime time,
            String result, String observation, String complication) {
        this.medHisId = new SimpleStringProperty(medHisId);
        this.patientId = new SimpleStringProperty(patientId);
        this.staffId = new SimpleStringProperty(staffId);
        this.date = new SimpleObjectProperty<>(date);
        this.time = new SimpleObjectProperty<>(time);
        this.result = new SimpleStringProperty(result);
        this.observation = new SimpleStringProperty(observation);
        this.complication = new SimpleStringProperty(complication);
    }

    public static ObservableList<MedicalHistoryTableDataModel> convertMedicalHistoryDataToTableDataModel(String id) {
        List<MedicalHistory> initialMedicalHistoryList = MedicalHistoryData.fetchMedicalHistoryDataFromDatabaseById(id);
        ObservableList<MedicalHistoryTableDataModel> convertedList = FXCollections.observableArrayList();

        for (int i = 0; i < initialMedicalHistoryList.size(); i++) {
            String medHisId = initialMedicalHistoryList.get(i).getMedHisId();
            String patientId = initialMedicalHistoryList.get(i).getPatientId();
            String staffId = initialMedicalHistoryList.get(i).getStaffId();
            LocalDate date = initialMedicalHistoryList.get(i).getDate();
            LocalTime time = initialMedicalHistoryList.get(i).getTime();
            String result = initialMedicalHistoryList.get(i).getResult();
            String observation = initialMedicalHistoryList.get(i).getObservation();
            String complication = initialMedicalHistoryList.get(i).getComplication();

            convertedList
                    .add(new MedicalHistoryTableDataModel(medHisId, patientId, staffId, date, time, result, observation,
                            complication));
        }

        return convertedList;
    }

    public String getMedHisId() {
        return medHisId.get();
    }

    public SimpleStringProperty medHisIdProperty() {
        return medHisId;
    }

    public void setMedHisId(String medHisId) {
        this.medHisId.set(medHisId);
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

    public String getStaffId() {
        return staffId.get();
    }

    public SimpleStringProperty staffIdProperty() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId.set(staffId);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public LocalTime getTime() {
        return time.get();
    }

    public SimpleObjectProperty<LocalTime> timeProperty() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time.set(time);
    }

    public String getResult() {
        return result.get();
    }

    public SimpleStringProperty resultProperty() {
        return result;
    }

    public void setResult(String result) {
        this.result.set(result);
    }

    public String getObservation() {
        return observation.get();
    }

    public SimpleStringProperty observationProperty() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation.set(observation);
    }

    public String getComplication() {
        return complication.get();
    }

    public SimpleStringProperty complicationProperty() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication.set(complication);
    }
}
