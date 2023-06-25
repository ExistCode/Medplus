package medplus.models;

import java.time.LocalDate;

public class Staff implements Person {
    private String staffId;
    private String name;
    private String nationalId;
    private String email;
    private LocalDate dateOfBirth;
    private int age;
    private String contactNumber;
    private String jobTitle;
    private String department;

    // Constructor
    public Staff(String sId, String n, String nId, String e, LocalDate dOB, int a, String cN, String jT, String dept) {
        staffId = sId;
        name = n;
        nationalId = nId;
        email = e;
        dateOfBirth = dOB;
        age = a;
        contactNumber = cN;
        jobTitle = jT;
        department = dept;
    }

    // Setter Functions
    public void setStaffId(String sId) {
        staffId = sId;
    }

    public void setName(String n) {
        name = n;
    }

    public void setStaffNationalId(String nId) {
        nationalId = nId;
    }

    public void setStaffEmail(String e) {
        email = e;
    }

    public void setDateOfBirth(LocalDate dOB) {
        dateOfBirth = dOB;
    }

    public void setStaffAge(int a) {
        age = a;
    }

    public void setStaffContactNumber(String cN) {
        contactNumber = cN;
    }

    public void setStaffJobTitle(String jT) {
        jobTitle = jT;
    }

    public void setStaffDepartment(String dept) {
        department = dept;
    }

    // Getter Functions
    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public String getStaffNationalId() {
        return nationalId;
    }

    public String getStaffEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getStaffAge() {
        return age;
    }

    public String getStaffContactNumber() {
        return contactNumber;
    }

    public String getStaffJobTitle() {
        return jobTitle;
    }

    public String getStaffDepartment() {
        return department;
    }

    public String getAllData() {
        return getStaffId() + "," + getName() + "," + getStaffNationalId() + "," + getStaffEmail() + ","
                + getStaffContactNumber() + "," + getStaffJobTitle() + "," + getStaffDepartment();
    }

}
