package medplus.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private String staffId;
    private String roomNum;
    private LocalDate date;
    private LocalTime time;
    private String description;

    // Constructor
    public Appointment(String aId, String pId, String sId, String room, LocalDate d, LocalTime t, String desc) {
        appointmentId = aId;
        patientId = pId;
        staffId = sId;
        roomNum = room;
        date = d;
        time = t;
        description = desc;
    }

    // Setter functions
    public void setAppointmentId(String aId) {
        appointmentId = aId;
    }

    public void setPatientId(String pId) {
        patientId = pId;
    }

    public void setStaffId(String sId) {
        staffId = sId;
    }

    public void setRoomNum(String room) {
        roomNum = room;
    }

    public void setDate(LocalDate d) {
        date = d;
    }

    public void setTime(LocalTime t) {
        time = t;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    // Getter functions
    public String getAppointmentId() {
        return appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }
}
