package medplus.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.*;

import medplus.models.Patient;

public class PatientData {

        // ------------------------------------------------------------------------------
        // Dummy Data
        public static void fetchDummyPatientDataList() {
                // Create a list to store the dummy patient data
                List<Patient> patientDummyDataList = new ArrayList<>();

                // Create and add dummy patient data to the list
                patientDummyDataList.add(new Patient("P001", "John Doe", "1234567890", "Male",
                                LocalDate.of(1990, 5, 15), 31, 175.0, 75.0, "O+", "New York", "1234567890"));
                patientDummyDataList.add(new Patient("P002", "Jane Smith", "0987654321", "Female",
                                LocalDate.of(1985, 9, 21), 36, 165.0, 60.0, "A+", "Los Angeles", "0987654321"));
                patientDummyDataList.add(new Patient("P003", "David Johnson", "9876543210", "Male",
                                LocalDate.of(1982, 3, 8), 39, 180.0, 80.0, "B-", "Chicago", "9876543210"));
                patientDummyDataList.add(new Patient("P004", "Sarah Williams", "0123456789", "Female",
                                LocalDate.of(1995, 12, 12), 26, 160.0, 55.0, "AB+", "Houston", "0123456789"));
                patientDummyDataList.add(new Patient("P005", "Michael Brown", "5432109876", "Male",
                                LocalDate.of(1978, 7, 3), 43, 185.0, 90.0, "A-", "Miami", "5432109876"));
        }
        // ------------------------------------------------------------------------------

        public static String fileName = "src/main/resources/medplus/database/patient.txt";

        public static void main(String[] args) {
                createNewFileWithHeaders();
                createAddNewPatient();
        }

        public static void createNewFileWithHeaders() {
                File database = new File(fileName);

                try {
                        if (database.createNewFile()) {
                                FileWriter writer = new FileWriter(fileName, true);
                                writer.append("Patient ID, Name, National ID, Gender, Date of Birth, Age, Height, Weight, Blood Type, Address, Contact Number");
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

        public static void createAddNewPatient() {
                Patient newPatient = new Patient("P005", "Michael Brown", "5432109876", "Male",
                                LocalDate.of(1978, 7, 3), 43, 185.0, 90.0, "A-", "Miami", "5432109876");

                try {
                        FileWriter writer = new FileWriter(fileName, true);
                        String patientData = String.format("%-10s%-20s%-15s%-10s%-15s%-5d%-8.1f%-8.1f%-10s%-20s%s",
                                        newPatient.getPatientId(), newPatient.getPatientName(),
                                        newPatient.getPatientNationalId(),
                                        newPatient.getPatientGender(),
                                        newPatient.getPatientDateOfBirth(), newPatient.getAge(),
                                        newPatient.getPatientHeight(),
                                        newPatient.getPatientHeight(),
                                        newPatient.getPatientBloodType(), newPatient.getClass(),
                                        newPatient.getPatientContactNumber());
                        writer.append(patientData);
                        writer.append("\n");
                        writer.close();
                        System.out.println("Patient added successfully!");
                } catch (IOException e) {
                        System.out.println(e);
                }
        }

        public static void deleteRecordById(ArrayList<String> arrayList, Scanner input) {
                System.out.println("Enter the patient ID or keyword to delete a record:");
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
                        System.out.println("Please enter the patient ID or keyword to update the record:");
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
