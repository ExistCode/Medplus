package medplus.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import medplus.models.Analysis;

public class AnalysisData {
    public static Analysis initAnalysisData = new Analysis("", "", "", null, "", "","");

    public static void main(String[] args){
        createNewFileWithHeaders();
        fetchAnalysisDataFromDatabase();
    }

    public static String fileName = "src/main/resources/medplus/database/analysis.txt";

    public static List<Analysis> fetchAnalysisDataFromDatabase(){
        List<Analysis> analysisList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] analysisData = line.split(",");
                String analysisId = analysisData[0].trim();
                String patientName = analysisData[1].trim();
                String staffId = analysisData[2].trim();
                LocalDate date = LocalDate.parse(analysisData[3].trim());
                String typeOfTest = analysisData[4].trim();
                String testInformation = analysisData[5].trim();
                String resultSummary = analysisData[6].trim();

                Analysis analysis = new Analysis(analysisId, patientName, staffId, date, typeOfTest, testInformation, resultSummary);
                analysisList.add(analysis);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return analysisList;       
    }

    public static void createNewFileWithHeaders(){
        File database = new File(fileName);

        try {
            if (database.createNewFile()) {
                FileWriter writer = new FileWriter(fileName, true);
                writer.append("Analysis ID, Patient Name, Staff ID, Date, Type Of Test, Test Information, Result Summary");
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

    public static void addNewAnalysis(Analysis newAnalysis){

        try {
            FileWriter writer = new FileWriter(fileName, true);
            String analysisData = String.format("%s,%s,%s,%s,%s,%s,%s",
                    newAnalysis.getAnalysisId(),
                    newAnalysis.getPatientName(),
                    newAnalysis.getStaffId(),
                    newAnalysis.getDate(),
                    newAnalysis.getTypeOfTest(),
                    newAnalysis.getTestInformation(),
                    newAnalysis.getResultSummary());

            writer.append(analysisData);
            writer.append("\n");
            writer.close();
            System.out.println("Analysis added successfully");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
