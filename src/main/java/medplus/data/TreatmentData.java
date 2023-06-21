package medplus.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import medplus.models.Treatment;

public class TreatmentData {
    public static Treatment initTreatmentData = new Treatment("", "", "", null, null, "");

        public static String fileName = "src/main/resources/medplus/database/treatment.txt";

        public static List<Treatment> fetchTreatmentDataFromDatabase() {
                List<Treatment> treatmentList = new ArrayList<>();

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        String line;
                        reader.readLine(); // Skip the header line

                        while ((line = reader.readLine()) != null) {
                                String[] TreatmentData = line.split(",");
                                String treatmentId = TreatmentData[0].trim();
                                String patientName = TreatmentData[1].trim();
                                String doctorId = TreatmentData[2].trim();
                                LocalDate startDate = LocalDate.parse(TreatmentData[3].trim());
                                LocalDate endDate = LocalDate.parse(TreatmentData[4].trim());
                                String treatmentInfo = TreatmentData[5].trim();

                                Treatment treatment = new Treatment(treatmentId, patientName,doctorId, startDate, endDate, treatmentInfo);
                                treatmentList.add(treatment);
                        }

                        reader.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }

                return treatmentList;
        }

        public static void createNewFileWithHeaders() {
                File database = new File(fileName);

                try {
                        if (database.createNewFile()) {
                                FileWriter writer = new FileWriter(fileName, true);
                                writer.append("Treatment ID, Patient Name, Doctor ID, Start Date, End Date, Treatment Info");
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

        public static void addNewTreatment(Treatment newTreatment) {

                try {
                        FileWriter writer = new FileWriter(fileName, true);
                        String treatmentData = String.format("%s,%s,%s,%s,%s,%s",
                                        newTreatment.getTreatmentId(),
                                        newTreatment.getPatientName(),
                                        newTreatment.getDoctorId(),
                                        newTreatment.getStartDate(),
                                        newTreatment.getEndDate(),
                                        newTreatment.getTreatmentInfo());

                        writer.append(treatmentData);
                        writer.append("\n");
                        writer.close();
                        System.out.println("Treatment added successfully!");
                } catch (IOException e) {
                        System.out.println(e);
                }
        }

        public static void deleteTreatmentById(String id) {
                ArrayList<String> fetchedTreatmentListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        while ((line = reader.readLine()) != null) {
                                if (line.contains(id)) {
                                        System.out.println("FOUND ID");
                                } else {
                                        fetchedTreatmentListAfterDeletion.add(line);
                                }

                        }
                        reader.close();
                } catch (IOException e) {
                        System.out.println(e);
                }

                try {
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < fetchedTreatmentListAfterDeletion.size(); i++) {
                                writer.append(fetchedTreatmentListAfterDeletion.get(i));
                                writer.append("\n");
                        }
                        writer.close();
                } catch (IOException e) {
                        System.out.println(e);
                } finally {
                        System.out.println("Deletion done!");
                }
        }

        public static void updateTreatmentData(Treatment newTreatmentData) {
                ArrayList<String> fetchedTreatmentListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        while ((line = reader.readLine()) != null) {
                                if (line.contains(newTreatmentData.getTreatmentId())) {
                                        fetchedTreatmentListAfterDeletion.add(newTreatmentData.getTreatmentId() + ","
                                                        + newTreatmentData.getPatientName() + ","
                                                        + newTreatmentData.getDoctorId() + ","
                                                        + newTreatmentData.getStartDate() + ","
                                                        + newTreatmentData.getEndDate() + ","
                                                        + newTreatmentData.getTreatmentInfo() + ",");
                                } else {
                                        fetchedTreatmentListAfterDeletion.add(line);
                                }

                        }
                        reader.close();
                } catch (IOException e) {
                        System.out.println(e);
                }

                try {
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < fetchedTreatmentListAfterDeletion.size(); i++) {
                                writer.append(fetchedTreatmentListAfterDeletion.get(i));
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