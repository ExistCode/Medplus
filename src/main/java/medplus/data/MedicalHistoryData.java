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
    public static String fileName = "src/main/resources/medplus/database/medical_history.txt";

    public static List<MedicalHistory> fetchMedicalHistoryDataFromDatabaseById(String id) {
        List<MedicalHistory> singlePatientMedicalHistoryList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                if (line.contains(id)) {
                    String[] medicalHistoryData = line.split(",");
                    String patientId = medicalHistoryData[0].trim();
                    String staffId = medicalHistoryData[1].trim();
                    LocalDate date = LocalDate.parse(medicalHistoryData[2].trim());
                    LocalTime time = LocalTime.parse(medicalHistoryData[3].trim());
                    String result = medicalHistoryData[4].trim();
                    String observation = medicalHistoryData[5].trim();
                    String complication = medicalHistoryData[6].trim();

                    MedicalHistory medicalHistory = new MedicalHistory(patientId, staffId, date, time, result,
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
            String medicalHistoryData = String.format("%s,%s,%s,%s,%s,%s,%s", newMedicalHistory.getPatientId(),
                    newMedicalHistory.getStaffId(), newMedicalHistory.getDate(), newMedicalHistory.getTime(),
                    newMedicalHistory.getResult(), newMedicalHistory.getObservation(),
                    newMedicalHistory.getComplication());

            writer.append(medicalHistoryData);
            writer.append("\n");
            writer.close();
            System.out.println("Medical history added successfully!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}