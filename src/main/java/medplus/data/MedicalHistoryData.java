package medplus.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import medplus.models.MedicalHistory;

public class MedicalHistoryData {

    public static MedicalHistory initMedicalHistoryData = new MedicalHistory("", "", "", LocalDate.now(),
            LocalTime.now(),
            "", "", "");

    public static String fileName = "src/main/resources/medplus/database/medical_history.txt";

    public static List<MedicalHistory> fetchAllMedicalHistoryDataFromDatabase() {
        List<MedicalHistory> medicalHistoryList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] medicalHistoryData = line.split(",");
                String medHisId = medicalHistoryData[0].trim();
                String patientId = medicalHistoryData[1].trim();
                String staffId = medicalHistoryData[2].trim();
                LocalDate date = LocalDate.parse(medicalHistoryData[3].trim());
                LocalTime time = LocalTime.parse(medicalHistoryData[4].trim());
                String result = medicalHistoryData[5].trim();
                String observation = medicalHistoryData[6].trim();
                String complication = medicalHistoryData[7].trim();

                MedicalHistory medicalHistory = new MedicalHistory(medHisId, patientId, staffId, date, time, result,
                        observation, complication);
                medicalHistoryList.add(medicalHistory);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return medicalHistoryList;
    }

    public static List<MedicalHistory> fetchMedicalHistoryDataFromDatabaseById(String id) {
        List<MedicalHistory> singlePatientMedicalHistoryList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                if (line.contains(id)) {
                    String[] medicalHistoryData = line.split(",");
                    String medHisId = medicalHistoryData[0].trim();
                    String patientId = medicalHistoryData[1].trim();
                    String staffId = medicalHistoryData[2].trim();
                    LocalDate date = LocalDate.parse(medicalHistoryData[3].trim());
                    LocalTime time = LocalTime.parse(medicalHistoryData[4].trim());
                    String result = medicalHistoryData[5].trim();
                    String observation = medicalHistoryData[6].trim();
                    String complication = medicalHistoryData[7].trim();

                    MedicalHistory medicalHistory = new MedicalHistory(medHisId, patientId, staffId, date, time, result,
                            observation, complication);
                    singlePatientMedicalHistoryList.add(medicalHistory);
                } else {

                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return singlePatientMedicalHistoryList;
    }

    public static void addNewMedicalHistory(MedicalHistory newMedicalHistory) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            String medicalHistoryData = String.format("%s,%s,%s,%s,%s,%s,%s,%s", newMedicalHistory.getMedHisId(),
                    newMedicalHistory.getPatientId(), newMedicalHistory.getStaffId(), newMedicalHistory.getDate(),
                    newMedicalHistory.getTime(), newMedicalHistory.getResult(), newMedicalHistory.getObservation(),
                    newMedicalHistory.getComplication());

            writer.append(medicalHistoryData);
            writer.append("\n");
            writer.close();
            System.out.println("Medical history added successfully!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void deleteMedicalHistoryByPatientId(String patientId) {
        ArrayList<String> fetchedMedicalHistoryListAfterDeletion = new ArrayList<>();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                if (line.contains(patientId)) {
                    System.out.println("FOUND ID");
                } else {
                    fetchedMedicalHistoryListAfterDeletion.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < fetchedMedicalHistoryListAfterDeletion.size(); i++) {
                writer.append(fetchedMedicalHistoryListAfterDeletion.get(i));
                writer.append("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("Deletion done!");
        }
    }

    public static void updateMedicalHistory(MedicalHistory newMedicalHistoryData) {
        ArrayList<String> fetchedMedicalHistoryListAfterUpdate = new ArrayList<>();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                if (line.contains(newMedicalHistoryData.getMedHisId())) {
                    fetchedMedicalHistoryListAfterUpdate.add(newMedicalHistoryData.getMedHisId() + ","
                            + newMedicalHistoryData.getPatientId() + ","
                            + newMedicalHistoryData.getStaffId() + ","
                            + newMedicalHistoryData.getDate() + ","
                            + newMedicalHistoryData.getTime() + ","
                            + newMedicalHistoryData.getResult() + ","
                            + newMedicalHistoryData.getObservation() + ","
                            + newMedicalHistoryData.getComplication());
                } else {
                    fetchedMedicalHistoryListAfterUpdate.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < fetchedMedicalHistoryListAfterUpdate.size(); i++) {
                writer.append(fetchedMedicalHistoryListAfterUpdate.get(i));
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
