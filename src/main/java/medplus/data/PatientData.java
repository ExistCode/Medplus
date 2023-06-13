package medplus.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.scene.paint.Stop;

import java.time.LocalDate;
import java.io.*;

import medplus.models.Patient;

public class PatientData {
        public static Patient initpatientData = new Patient("", "", "", "", null, 0, 0.0, 0.0, "", "", "");

        public static String fileName = "src/main/resources/medplus/database/patient.txt";

        public static List<Patient> fetchPatientDataFromDatabase() {
                List<Patient> patientList = new ArrayList<>();

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        String line;
                        reader.readLine(); // Skip the header line

                        while ((line = reader.readLine()) != null) {
                                String[] patientData = line.split(",");
                                String patientId = patientData[0].trim();
                                String name = patientData[1].trim();
                                String nationalId = patientData[2].trim();
                                String gender = patientData[3].trim();
                                LocalDate dateOfBirth = LocalDate.parse(patientData[4].trim());
                                int age = Integer.parseInt(patientData[5].trim());
                                double height = Double.parseDouble(patientData[6].trim());
                                double weight = Double.parseDouble(patientData[7].trim());
                                String bloodType = patientData[8].trim();
                                String address = patientData[9].trim();
                                String contactNumber = patientData[10].trim();

                                Patient patient = new Patient(patientId, name, nationalId, gender, dateOfBirth, age,
                                                height, weight, bloodType, address, contactNumber);
                                patientList.add(patient);
                        }

                        reader.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }

                return patientList;
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

        public static void addNewPatient(Patient newPatient) {

                try {
                        FileWriter writer = new FileWriter(fileName, true);
                        String patientData = String.format("%s,%s,%s,%s,%s,%d,%.1f,%.1f,%s,%s,%s",
                                        newPatient.getPatientId(),
                                        newPatient.getPatientName(),
                                        newPatient.getPatientNationalId(),
                                        newPatient.getPatientGender(),
                                        newPatient.getPatientDateOfBirth(),
                                        newPatient.getPatientAge(),
                                        newPatient.getPatientHeight(),
                                        newPatient.getPatientWeight(),
                                        newPatient.getPatientBloodType(),
                                        newPatient.getPatientAddress(),
                                        newPatient.getPatientContactNumber());

                        writer.append(patientData);
                        writer.append("\n");
                        writer.close();
                        System.out.println("Patient added successfully!");
                } catch (IOException e) {
                        System.out.println(e);
                }
        }

        public static void deletePatientById(String id) {
                System.out.println("\nDELETED ID: " + id);
                ArrayList<String> fetchedPatientListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        while ((line = reader.readLine()) != null) {
                                if (line.contains(id)) {
                                        System.out.println("FOUND ID");
                                } else {
                                        fetchedPatientListAfterDeletion.add(line);
                                }

                        }
                        reader.close();
                } catch (IOException e) {
                        System.out.println(e);
                }

                // for (int i = 0; i < fetchedPatientListAfterDeletion.size(); i++) {
                // System.out.println("ENTER FOR");
                // System.out.println(fetchedPatientListAfterDeletion.get(i));
                // }

                try {
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < fetchedPatientListAfterDeletion.size(); i++) {
                                writer.append(fetchedPatientListAfterDeletion.get(i));
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
