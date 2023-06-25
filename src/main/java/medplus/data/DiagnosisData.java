package medplus.data;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.io.*;

import medplus.models.Diagnosis;

public class DiagnosisData {
        public static Diagnosis initdiagnosisData = new Diagnosis("", "", "", null, "");

        public static void main(String[] args) {
                createNewFileWithHeaders();
                fetchDiagnosisDataFromDatabase();
        }

        public static String fileName = "src/main/resources/medplus/database/diagnosis.txt";

        public static List<Diagnosis> fetchDiagnosisDataFromDatabase() {
                List<Diagnosis> diagnosisList = new ArrayList<>();

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        String line;
                        reader.readLine(); // Skip the header line

                        while ((line = reader.readLine()) != null) {
                                String[] diagnosisData = line.split(",");
                                String diagnosisId = diagnosisData[0].trim();
                                String patientName = diagnosisData[1].trim();
                                String staffId = diagnosisData[2].trim();
                                LocalDate date = LocalDate.parse(diagnosisData[3].trim());
                                String diagnosis = diagnosisData[4].trim();

                                Diagnosis ds = new Diagnosis(diagnosisId, patientName, staffId, date, diagnosis);
                                diagnosisList.add(ds);
                        }

                        reader.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }

                return diagnosisList;
        }

        public static void createNewFileWithHeaders() {
                File database = new File(fileName);

                try {
                        if (database.createNewFile()) {
                                FileWriter writer = new FileWriter(fileName, true);
                                writer.append("Diagnosis ID, Patient Name, Staff ID, Date, Diagnosis");
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

        public static void addNewDiagnosis(Diagnosis newDiagnosis) {

                try {
                        FileWriter writer = new FileWriter(fileName, true);
                        String diagnosisData = String.format("%s,%s,%s,%s,%s",
                                        newDiagnosis.getDiagnosisId(),
                                        newDiagnosis.getPatientName(),
                                        newDiagnosis.getStaffId(),
                                        newDiagnosis.getDate(),
                                        newDiagnosis.getDiagnosis());

                        writer.append(diagnosisData);
                        writer.append("\n");
                        writer.close();
                        System.out.println("Diagnosis added successfully!");
                } catch (IOException e) {
                        System.out.println(e);
                }
        }

        public static void deleteDiagnosisById(String id) {
                System.out.println("\nDELETED ID: " + id);
                ArrayList<String> fetchedDiagnosisListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        while ((line = reader.readLine()) != null) {
                                if (line.contains(id)) {
                                        System.out.println("FOUND ID");
                                } else {
                                        fetchedDiagnosisListAfterDeletion.add(line);
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
                        for (int i = 0; i < fetchedDiagnosisListAfterDeletion.size(); i++) {
                                writer.append(fetchedDiagnosisListAfterDeletion.get(i));
                                writer.append("\n");
                        }
                        writer.close();
                } catch (IOException e) {
                        System.out.println(e);
                } finally {
                        System.out.println("Deletion done!");
                }
        }

        public static void updateDiagnosis(Diagnosis newDiagnosisData) {
                ArrayList<String> fetchedDiagnosisListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        while ((line = reader.readLine()) != null) {

                                if (line.contains(newDiagnosisData.getDiagnosisId())) {
                                        System.out.println(newDiagnosisData.getDiagnosisId());

                                        fetchedDiagnosisListAfterDeletion.add(newDiagnosisData.getDiagnosisId() + ","

                                                        + newDiagnosisData.getPatientName() + ","
                                                        + newDiagnosisData.getStaffId() + ","
                                                        + newDiagnosisData.getDate() + ","
                                                        + newDiagnosisData.getDiagnosis());

                                } else {
                                        fetchedDiagnosisListAfterDeletion.add(line);
                                }

                        }
                        reader.close();
                } catch (IOException e) {
                        System.out.println(e);
                }

                try {
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < fetchedDiagnosisListAfterDeletion.size(); i++) {
                                writer.append(fetchedDiagnosisListAfterDeletion.get(i));
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
