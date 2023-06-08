package medplus.models;

import java.time.LocalDate;

public class Patient {
    private String patientId;
    private String name;
    private String nationalId;
    private String gender;
    private LocalDate dateOfBirth;
    private int age;
    private double height;
    private double weight;
    private String bloodType;
    private String address;
    private String contactNumber;

    // Constructor
    public Patient(String pId, String n, String nId, String g, LocalDate dOB, int a, double h, double w, String bT,
            String ad, String cN) {
        patientId = pId;
        name = n;
        nationalId = nId;
        gender = g;
        dateOfBirth = dOB;
        age = a;
        height = h;
        weight = w;
        bloodType = bT;
        address = ad;
        contactNumber = cN;
    }

    // Setter Functions
    public void setPatientId(String pId) {
        patientId = pId;
    }

    public void setPatientName(String n) {
        name = n;
    }

    public void setPatientNationalId(String nId) {
        nationalId = nId;
    }

    public void setPatientGender(String g) {
        gender = g;
    }

    public void setPatientDateOfBirth(LocalDate dob) {
        dateOfBirth = dob;
    }

    public void setPatientAge(int a) {
        age = a;
    }

    public void setPatientHeight(double h) {
        height = h;
    }

    public void setPatientWeight(double w) {
        weight = w;
    }

    public void setPatientBloodType(String bT) {
        bloodType = bT;
    }

    public void setPatientAddress(String a) {
        address = a;
    }

    public void setPatientContactNumber(String cN) {
        contactNumber = cN;
    }

    // Getter Functions
    public String getPatientNationalId() {
        return nationalId;
    }

    public String getPatientName() {
        return name;
    }

    public String getPatientGender() {
        return gender;
    }

    public LocalDate getPatientDateOfBirth() {
        return dateOfBirth;
    }

    public String getPatientId() {
        return patientId;
    }

    public int getPatientAge() {
        return age;
    }

    public double getPatientHeight() {
        return height;
    }

    public double getPatientWeight() {
        return weight;
    }

    public String getPatientBloodType() {
        return bloodType;
    }

    public String getPatientAddress() {
        return address;
    }

    public String getPatientContactNumber() {
        return contactNumber;
    }
}