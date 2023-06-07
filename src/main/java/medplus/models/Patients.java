package medplus.models;

import java.util.Date;

public class Patients {
    private String patientId;
    private String patientName;
    private String nationality;
    private String patientGender;
    private Date birthDate;
    private int patientAge;
    private int patientHeight;
    private int patientWeight;
    private String patientBloodType;
    private String patientAddress;
    private String patientContactNumber;

    public Patients(String Id, String name, String country, String gender, Date DOB, int age, int height,
            int weight, String bloodtypes, String address, String contactNumber) {
        patientId = Id;
        patientName = name;
        nationality = country;
        patientGender = gender;
        birthDate = DOB;
        patientAge = age;
        patientHeight = height;
        patientWeight = weight;
        patientBloodType = bloodtypes;
        patientAddress = address;
        patientContactNumber = contactNumber;
    }

}
