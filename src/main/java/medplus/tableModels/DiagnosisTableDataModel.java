package medplus.tableModels;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import medplus.data.DiagnosisData;
import medplus.models.Diagnosis;

public class DiagnosisTableDataModel {
    private SimpleStringProperty diagnosisId;
    private SimpleStringProperty patientName;
    private SimpleStringProperty staffId;
    private SimpleObjectProperty<LocalDate> date;
    private SimpleStringProperty diagnosis;

    public DiagnosisTableDataModel(String diagnosisId, String patientName, String staffId, LocalDate date, String diagnosis){
        this.diagnosisId = new SimpleStringProperty(diagnosisId);
        this.patientName = new SimpleStringProperty(patientName);
        this.staffId = new SimpleStringProperty(staffId);
        this.date = new SimpleObjectProperty<>(date);
        this.diagnosis = new SimpleStringProperty(diagnosis);
    }

    public static ObservableList<DiagnosisTableDataModel> convertDiagnosisDataToDiagnosisTableDataModel() {
        List<Diagnosis> initialDiagnosisList = DiagnosisData.fetchDiagnosisDataFromDatabase();
        ObservableList<DiagnosisTableDataModel> convertedList = FXCollections.observableArrayList();

        for (int i = 0; i < initialDiagnosisList.size(); i++) {
            String diagnosisId = initialDiagnosisList.get(i).getDiagnosisId();
            String patientName = initialDiagnosisList.get(i).getPatientName();
            String staffId = initialDiagnosisList.get(i).getStaffId();
            LocalDate date = initialDiagnosisList.get(i).getDate();
            String diagnosis = initialDiagnosisList.get(i).getDiagnosis();
        
            convertedList.add(
                    new DiagnosisTableDataModel(diagnosisId, patientName, staffId, date, diagnosis));
        }

        return convertedList;
    }

    public String getDiagnosisId() {
        return diagnosisId.get();
    }

    public SimpleStringProperty diagnosisIdProperty() {
        return diagnosisId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId.set(diagnosisId);
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

    public SimpleObjectProperty<LocalDate> date() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public String getDiagnosis() {
        return diagnosis.get();
    }

    public SimpleStringProperty DiagnosisProperty() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis.set(diagnosis);
    }

}
