package medplus.models;

import java.time.LocalDate;

public class Doctor extends Staff {
    private String specialization;
    private int yearsOfExperience;
    private String doctorAppointment;

    public Doctor(String staffId, String name, String nationalId, String email, LocalDate dateOfBirth, int age,
            String contactNumber, String jobTitle, String department, String spec, int exp,
            String docAppt) {
        super(staffId, name, nationalId, email, dateOfBirth, age, contactNumber, jobTitle, department);
        specialization = spec;
        yearsOfExperience = exp;
        doctorAppointment = docAppt;
    }

    // Setter functions
    public void setSpecialization(String spec) {
        specialization = spec;
    }

    public void setYearsOfExperience(int exp) {
        yearsOfExperience = exp;
    }

    public void setDoctorAppointment(String docAppt) {
        doctorAppointment = docAppt;
    }

    // Getter functions
    public String getSpecialization() {
        return specialization;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getDoctorAppointment() {
        return doctorAppointment;
    }

    // Polymorphism
    @Override
    public String getAllData() {
        super.getAllData();
        return getSpecialization() + getYearsOfExperience() + getDoctorAppointment();

    }
}
