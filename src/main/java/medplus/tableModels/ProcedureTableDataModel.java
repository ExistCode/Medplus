package medplus.tableModels;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import medplus.data.ProcedureData;
import medplus.models.Procedure;

public class ProcedureTableDataModel {
    private SimpleStringProperty procedureId;
    private SimpleStringProperty patientName;
    private SimpleStringProperty staffId;
    private SimpleObjectProperty<LocalDate> date;
    private SimpleStringProperty time;
    private SimpleStringProperty procedureType;
    private SimpleStringProperty procedureDesc;

    public ProcedureTableDataModel(String procedureId, String patientName, String staffId, String time, String procedureType, LocalDate date, String procedureDesc) {
        this.procedureId = new SimpleStringProperty(procedureId);
        this.patientName = new SimpleStringProperty(patientName);
        this.staffId = new SimpleStringProperty(staffId);
        this.time = new SimpleStringProperty(time);
        this.procedureType = new SimpleStringProperty(procedureType);
        this.date = new SimpleObjectProperty<>(date);
        this.procedureDesc = new SimpleStringProperty(procedureDesc);
    }

    public static ObservableList<ProcedureTableDataModel> convertProcedureDataToProcedureTableDataModel() {
        List<Procedure> initialProcedureList = ProcedureData.fetchProcedureDataFromDatabase();
        ObservableList<ProcedureTableDataModel> convertedList = FXCollections.observableArrayList();

        for (int i = 0; i < initialProcedureList.size(); i++) {
            String procedureId = initialProcedureList.get(i).getProcedureId();
            String patientName = initialProcedureList.get(i).getPatientName();
            String staffId = initialProcedureList.get(i).getStaffId();
            LocalDate date = initialProcedureList.get(i).getDate();
            String time = initialProcedureList.get(i).getTime();
            String procedureType = initialProcedureList.get(i).getType();
            String procedureDesc = initialProcedureList.get(i).getDescription();


            convertedList.add(
                    new ProcedureTableDataModel(procedureId, patientName, staffId, time, procedureType, date, procedureDesc));
        }

        return convertedList;
    }

    public String getProcedureId() {
        return procedureId.get();
    }

    public SimpleStringProperty procedureIdProperty() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
        this.procedureId.set(procedureId);
    }

    public String getPatientName() {
        return patientName.get();
    }

    public SimpleStringProperty nameProperty() {
        return patientName;
    }

    public void setName(String patientName) {
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

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getType() {
        return procedureType.get();
    }

    public SimpleStringProperty typeProperty() {
        return procedureType;
    }

    public void setType(String procedureType) {
        this.procedureType.set(procedureType);
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

    public String getDescription() {
        return procedureDesc.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return procedureDesc;
    }

    public void setDescription(String procedureDesc) {
        this.procedureDesc.set(procedureDesc);
    }
}

