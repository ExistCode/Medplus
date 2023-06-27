package medplus.data;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.io.*;

import medplus.models.Patient;

public class PatientData {
        public static Patient initPatientData = new Patient("", "", "", "", null, 0, 0.0, 0.0, "", "", "");
        // Database file location

        public static String fileName = "src/main/resources/medplus/database/patient.txt";

        public static List<Patient> fetchPatientDataFromDatabase() {
                List<Patient> patientList = new ArrayList<>();
                // Read the txt file and splitting into their respective fields

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
                                // Add the data to the empty list

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
                        // Create a new file

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
                                        newPatient.getName(),
                                        newPatient.getPatientNationalId(),
                                        newPatient.getPatientGender(),
                                        newPatient.getDateOfBirth(),
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
                ArrayList<String> fetchedPatientListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        // Iterate over the list and insert the one isn't deleted

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

        public static void updatePatientData(Patient newPatientData) {
                ArrayList<String> fetchedPatientListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        // Iterate over the list and insert the updated version of the object

                        while ((line = reader.readLine()) != null) {
                                if (line.contains(newPatientData.getPatientId())) {
                                        fetchedPatientListAfterDeletion.add(newPatientData.getPatientId() + ","
                                                        + newPatientData.getName() + ","
                                                        + newPatientData.getPatientNationalId() + ","
                                                        + newPatientData.getPatientGender() + ","
                                                        + newPatientData.getDateOfBirth() + ","
                                                        + newPatientData.getPatientAge() + ","
                                                        + newPatientData.getPatientHeight() + ","
                                                        + newPatientData.getPatientWeight() + ","
                                                        + newPatientData.getPatientBloodType() + ","
                                                        + newPatientData.getPatientAddress() + ","
                                                        + newPatientData.getPatientContactNumber());
                                } else {
                                        fetchedPatientListAfterDeletion.add(line);
                                }

                        }
                        reader.close();
                } catch (IOException e) {
                        System.out.println(e);
                }

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
                        System.out.println("Update done!");
                }
        }
}
