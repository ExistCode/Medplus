package medplus.data;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.io.*;

import medplus.models.Analysis;

public class AnalysisData {
        public static Analysis initanalysisData = new Analysis("", "", "", "", "", null, "");

        public static void main(String[] args) {
                createNewFileWithHeaders();
                fetchAnalysisDataFromDatabase();
        }
        // Database file location

        public static String fileName = "src/main/resources/medplus/database/analysis.txt";

        public static List<Analysis> fetchAnalysisDataFromDatabase() {
                List<Analysis> analysisList = new ArrayList<>();
                // Read the txt file and splitting into their respective fields

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        String line;
                        reader.readLine(); // Skip the header line

                        while ((line = reader.readLine()) != null) {
                                String[] analysisData = line.split(",");
                                String analysisId = analysisData[0].trim();
                                String patientId = analysisData[1].trim();
                                String staffId = analysisData[2].trim();
                                String typeOfTest = analysisData[3].trim();
                                String resultSummary = analysisData[4].trim();
                                LocalDate date = LocalDate.parse(analysisData[5].trim());
                                String testInformation = analysisData[6].trim();
                                // Add the data to the empty list
                                Analysis analysis = new Analysis(analysisId, patientId, staffId, typeOfTest,
                                                resultSummary, date, testInformation);
                                analysisList.add(analysis);
                        }

                        reader.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }

                return analysisList;
        }

        public static void createNewFileWithHeaders() {
                File database = new File(fileName);

                try {
                        // Create a new file

                        if (database.createNewFile()) {
                                FileWriter writer = new FileWriter(fileName, true);
                                writer.append("Patient Name, Staff ID, Analysis Type, Result Summary, Date of Analysis, Test Information");
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

        public static void addNewAnalysis(Analysis newAnalysis) {

                try {
                        FileWriter writer = new FileWriter(fileName, true);
                        String analysisData = String.format("%s,%s,%s,%s,%s,%s,%s",
                                        newAnalysis.getAnalysisId(),
                                        newAnalysis.getPatientName(),
                                        newAnalysis.getStaffId(),
                                        newAnalysis.getTypeOfTest(),
                                        newAnalysis.getResultSummary(),
                                        newAnalysis.getDate(),
                                        newAnalysis.getTestInformation());

                        writer.append(analysisData);
                        writer.append("\n");
                        writer.close();
                        System.out.println("Analysis added successfully!");
                } catch (IOException e) {
                        System.out.println(e);
                }
        }

        public static void deleteAnalysisById(String id) {
                System.out.println("\nDELETED ID: " + id);
                ArrayList<String> fetchedAnalysisListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        // Iterate over the list and insert the one isn't deleted
                        while ((line = reader.readLine()) != null) {
                                if (line.contains(id)) {
                                        System.out.println("FOUND ID");
                                } else {
                                        fetchedAnalysisListAfterDeletion.add(line);
                                }

                        }
                        reader.close();
                } catch (IOException e) {
                        System.out.println(e);
                }

                try {
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < fetchedAnalysisListAfterDeletion.size(); i++) {
                                writer.append(fetchedAnalysisListAfterDeletion.get(i));
                                writer.append("\n");
                        }
                        writer.close();
                } catch (IOException e) {
                        System.out.println(e);
                } finally {
                        System.out.println("Deletion done!");
                }
        }

        public static void updateAnalysis(Analysis newAnalysisData) {
                ArrayList<String> fetchedAnalysisListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        // Iterate over the list and insert the updated version of the object

                        while ((line = reader.readLine()) != null) {

                                if (line.contains(newAnalysisData.getAnalysisId())) {
                                        System.out.println(newAnalysisData.getAnalysisId());

                                        fetchedAnalysisListAfterDeletion.add(newAnalysisData.getAnalysisId() + ","

                                                        + newAnalysisData.getPatientName() + ","
                                                        + newAnalysisData.getStaffId() + ","
                                                        + newAnalysisData.getTypeOfTest() + ","
                                                        + newAnalysisData.getResultSummary() + ","
                                                        + newAnalysisData.getDate() + ","
                                                        + newAnalysisData.getTestInformation());

                                } else {
                                        fetchedAnalysisListAfterDeletion.add(line);
                                }

                        }
                        reader.close();
                } catch (IOException e) {
                        System.out.println(e);
                }

                try {
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < fetchedAnalysisListAfterDeletion.size(); i++) {
                                writer.append(fetchedAnalysisListAfterDeletion.get(i));
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
