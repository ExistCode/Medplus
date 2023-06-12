package medplus.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.*;

import medplus.models.Staff;

public class StaffData {

    public static void main(String[] args) {
        createNewFileWithHeaders();
        fetchStaffDataFromDatabase();
    }

    public static String fileName = "src/main/resources/medplus/database/staff.txt";

    public static List<Staff> fetchStaffDataFromDatabase() {
        List<Staff> staffList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] staffData = line.split(",");
                String staffId = staffData[0].trim();
                String name = staffData[1].trim();
                String nationalId = staffData[2].trim();
                String email = staffData[3].trim();
                LocalDate dateOfBirth = LocalDate.parse(staffData[4].trim());
                int age = Integer.parseInt(staffData[5].trim());
                String contactNumber = staffData[6].trim();
                String jobTitle = staffData[7].trim();
                String department = staffData[8].trim();

                Staff staff = new Staff(staffId, name, nationalId, email, dateOfBirth, age, contactNumber, jobTitle,
                        department);
                staffList.add(staff);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return staffList;
    }

    public static void createNewFileWithHeaders() {
        File database = new File(fileName);

        try {
            if (database.createNewFile()) {
                FileWriter writer = new FileWriter(fileName, true);
                writer.append(
                        "Staff ID, Name, National ID, Email, Date of Birth, Age, Contact Number, Job Title, Department");
                writer.append("\n");
                writer.close();
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewStaff(Staff newStaff) {

        try {
            FileWriter writer = new FileWriter(fileName, true);
            String staffData = String.format("%s,%s,%s,%s,%s,%d,%s,%s,%s",
                    newStaff.getStaffId(),
                    newStaff.getStaffName(),
                    newStaff.getStaffNationalId(),
                    newStaff.getStaffEmail(),
                    newStaff.getStaffDateOfBirth(),
                    newStaff.getStaffAge(),
                    newStaff.getStaffContactNumber(),
                    newStaff.getStaffJobTitle(),
                    newStaff.getStaffDepartment());

            writer.append(staffData);
            writer.append("\n");
            writer.close();
            System.out.println("Staff added successfully!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void deleteRecordById(ArrayList<String> arrayList, Scanner input) {
        System.out.println("Enter the staff ID or keyword to delete a record:");
        String searchKey = input.next();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchKey)) {
                    System.out.println(line);
                    continue;
                } else {
                    arrayList.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < arrayList.size(); i++) {
                writer.append(arrayList.get(i));
                writer.append("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("Deletion done!");
        }
    }

    public static void updateRecord(ArrayList<String> arrayList, Scanner input) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            System.out.println("Please enter the staff ID or keyword to update the record:");
            String searchKey = input.next();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchKey)) {
                    System.out.println("Enter the attribute value you want to change:");
                    String oldValue = input.next();
                    System.out.println("Enter the new attribute value:");
                    String newValue = input.next();
                    arrayList.add(line.replace(oldValue, newValue));
                } else {
                    arrayList.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < arrayList.size(); i++) {
                writer.append(arrayList.get(i));
                writer.append("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("Update done!");
        }
    }
}
