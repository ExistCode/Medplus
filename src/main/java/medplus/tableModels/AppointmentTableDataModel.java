package medplus.tableModels;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import medplus.data.AppointmentData;
import medplus.models.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AppointmentTableDataModel {
    private SimpleStringProperty appointmentId;
    private SimpleStringProperty patientId;
    private SimpleStringProperty staffId;
    private SimpleStringProperty roomNum;
    private SimpleObjectProperty<LocalDate> date;
    private SimpleObjectProperty<LocalTime> time;
    private SimpleStringProperty description;

    public AppointmentTableDataModel(String appointmentId, String patientId, String staffId, String roomNum,
            LocalDate date, LocalTime time, String description) {
        this.appointmentId = new SimpleStringProperty(appointmentId);
        this.patientId = new SimpleStringProperty(patientId);
        this.staffId = new SimpleStringProperty(staffId);
        this.roomNum = new SimpleStringProperty(roomNum);
        this.date = new SimpleObjectProperty<>(date);
        this.time = new SimpleObjectProperty<>(time);
        this.description = new SimpleStringProperty(description);
    }

    public static ObservableList<AppointmentTableDataModel> convertAppointmentDataToTableDataModel(String id) {
        List<Appointment> initialAppointmentList = AppointmentData.fetchAppointmentDataFromDatabaseById(id);
        ObservableList<AppointmentTableDataModel> convertedList = FXCollections.observableArrayList();

        for (int i = 0; i < initialAppointmentList.size(); i++) {
            String appointmentId = initialAppointmentList.get(i).getAppointmentId();
            String patientId = initialAppointmentList.get(i).getPatientId();
            String staffId = initialAppointmentList.get(i).getStaffId();
            String roomNum = initialAppointmentList.get(i).getRoomNum();
            LocalDate date = initialAppointmentList.get(i).getDate();
            LocalTime time = initialAppointmentList.get(i).getTime();
            String description = initialAppointmentList.get(i).getDescription();

            convertedList.add(
                    new AppointmentTableDataModel(appointmentId, patientId, staffId, roomNum, date, time, description));
        }

        return convertedList;
    }

    public String getAppointmentId() {
        return appointmentId.get();
    }

    public SimpleStringProperty appointmentIdProperty() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId.set(appointmentId);
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

    public String getRoomNum() {
        return roomNum.get();
    }

    public SimpleStringProperty roomNumProperty() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum.set(roomNum);
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

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
