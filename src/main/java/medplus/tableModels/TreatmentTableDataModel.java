package medplus.tableModels;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import medplus.data.TreatmentData;
import medplus.models.Treatment;

public class TreatmentTableDataModel {
    private SimpleStringProperty treatmentId;
    private SimpleStringProperty patientName;
    private SimpleStringProperty staffId;
    private SimpleObjectProperty<LocalDate> startDate;
    private SimpleObjectProperty<LocalDate> endDate;
    private SimpleStringProperty treatmentInfo;

    public TreatmentTableDataModel(String treatmentId, String patientName, String staffId, LocalDate startDate, LocalDate endDate, String treatmentInfo) {
        this.treatmentId = new SimpleStringProperty(treatmentId);
        this.patientName = new SimpleStringProperty(patientName);
        this.staffId = new SimpleStringProperty(staffId);
        this.startDate = new SimpleObjectProperty<>(startDate);
        this.endDate = new SimpleObjectProperty<>(endDate);
        this.treatmentInfo = new SimpleStringProperty(treatmentInfo);
    }

    public static ObservableList<TreatmentTableDataModel> convertTreatmentDataToTreatmentTableDataModel() {
        List<Treatment> initialTreatmentList = TreatmentData.fetchTreatmentDataFromDatabase();
        ObservableList<TreatmentTableDataModel> convertedList = FXCollections.observableArrayList();

        for (int i = 0; i < initialTreatmentList.size(); i++) {
            String treatmentId = initialTreatmentList.get(i).getTreatmentId();
            String patientName = initialTreatmentList.get(i).getPatientName();
            String staffId = initialTreatmentList.get(i).getStaffId();
            LocalDate startDate = initialTreatmentList.get(i).getStartDate();
            LocalDate endDate = initialTreatmentList.get(i).getEndDate();
            String treatmentInfo = initialTreatmentList.get(i).getTreatmentInfo();
            convertedList.add(new TreatmentTableDataModel(treatmentId, patientName, staffId, startDate, endDate, treatmentInfo));
        }

        return convertedList;
    }

    public String getTreatmentId(){
        return treatmentId.get();
    }

    public SimpleStringProperty treatmentIdProperty(){
        return treatmentId;
    }
    
    public void setTreatmentId(String treatmentId){
        this.treatmentId.set(treatmentId);
    }
    
    public String getPatientName(){
        return patientName.get();
    }

    public SimpleStringProperty patientNameProperty(){
        return patientName;
    }

    public void setPatientName(String patientName){
        this.patientName.set(patientName);
    }

    public String getStaffId(){
        return staffId.get();
    }

    public SimpleStringProperty staffIdProperty(){
        return staffId;
    }

    public void setDcotorId(String staffId){
        this.staffId.set(staffId);
    }

    public LocalDate getStartDate(){
        return startDate.get();
    }

    public SimpleObjectProperty<LocalDate> startDateProperty(){
        return startDate;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate.set(startDate);
    }

    public LocalDate getEndDate(){
        return endDate.get();
    }

    public SimpleObjectProperty<LocalDate> endDateProperty(){
        return endDate;
    }

    public void setEndDate(LocalDate endDate){
        this.endDate.set(endDate);
    }

    public String getTreatementInfo(){
        return treatmentInfo.get();
    }

    public SimpleStringProperty treatmentInfoProperty(){
        return treatmentInfo;
    }
    
    public void setTreatmentInfo(String treatmentInfo){
        this.treatmentInfo.set(treatmentInfo);
    }

    public String getTreatmentInfo() {
        return null;
    }
}
