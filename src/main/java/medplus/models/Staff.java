package medplus.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public void seStafftEmail(String e) {
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

    public static void main(String[] args) {
        // Create a list to store the dummy staff data
        List<Staff> staffDataList = new ArrayList<>();

        // Create and add dummy staff data to the list
        staffDataList.add(new Staff("S001", "John Smith", "1234567890", "john@example.com",
                LocalDate.of(1985, 10, 25), 36, "9876543210", "Doctor", "Cardiology"));
        staffDataList.add(new Staff("S002", "Jane Doe", "0987654321", "jane@example.com",
                LocalDate.of(1990, 7, 15), 31, "0123456789", "Nurse", "Pediatrics"));
        staffDataList.add(new Staff("S003", "David Johnson", "5432109876", "david@example.com",
                LocalDate.of(1978, 3, 8), 43, "3456789012", "Technician", "Laboratory"));
        staffDataList.add(new Staff("S004", "Emily Wilson", "0123456789", "emily@example.com",
                LocalDate.of(1982, 12, 12), 39, "7890123456", "Administrator", "Administration"));
        staffDataList.add(new Staff("S005", "Michael Brown", "9876543210", "michael@example.com",
                LocalDate.of(1995, 5, 3), 26, "2345678901", "Receptionist", "Front Office"));

        // Use the staffDataList as needed
    }
}
