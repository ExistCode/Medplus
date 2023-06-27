package medplus.data;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.io.*;

import medplus.models.Procedure;

public class ProcedureData {
        public static Procedure initProcedureData = new Procedure("", "", "", null, "", "", "");

        public static void main(String[] args) {
                createNewFileWithHeaders();
                fetchProcedureDataFromDatabase();
        }

        public static String fileName = "src/main/resources/medplus/database/procedure.txt";

        public static List<Procedure> fetchProcedureDataFromDatabase() {
                List<Procedure> procedureList = new ArrayList<>();

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        String line;
                        reader.readLine(); // Skip the header line

                        while ((line = reader.readLine()) != null) {
                                String[] procedureData = line.split(",");
                                String procedureId = procedureData[0].trim();
                                String patientName = procedureData[1].trim();
                                String staffId = procedureData[2].trim();
                                LocalDate date = LocalDate.parse(procedureData[3].trim());
                                String time = procedureData[4].trim();
                                String procedureType = procedureData[5].trim();
                                String procedureDescription = procedureData[6].trim();

                                Procedure procedure = new Procedure(procedureId, patientName, staffId, date, time,
                                                procedureType, procedureDescription);
                                procedureList.add(procedure);
                        }

                        reader.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }

                return procedureList;
        }

        public static void createNewFileWithHeaders() {
                File database = new File(fileName);

                try {
                        if (database.createNewFile()) {
                                FileWriter writer = new FileWriter(fileName, true);
                                writer.append("Procedure ID, Patient Name, Staff ID, Date, Time, Procedure Type, Procedure Description");
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

        public static void addNewProcedure(Procedure newProcedure) {

                try {
                        FileWriter writer = new FileWriter(fileName, true);
                        String procedureData = String.format("%s,%s,%s,%s,%s,%s,%s",
                                        newProcedure.getProcedureId(),
                                        newProcedure.getPatientName(),
                                        newProcedure.getStaffId(),
                                        newProcedure.getDate(),
                                        newProcedure.getTime(),
                                        newProcedure.getType(),
                                        newProcedure.getDescription());

                        writer.append(procedureData);
                        writer.append("\n");
                        writer.close();
                        System.out.println("Procedure added successfully!");
                } catch (IOException e) {
                        System.out.println(e);
                }
        }

        public static void deleteProcedureById(String id) {
                System.out.println("\nDELETED ID: " + id);
                ArrayList<String> fetchedProcedureListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        while ((line = reader.readLine()) != null) {
                                if (line.contains(id)) {
                                        System.out.println("FOUND ID");
                                } else {
                                        fetchedProcedureListAfterDeletion.add(line);
                                }

                        }
                        reader.close();
                } catch (IOException e) {
                        System.out.println(e);
                }

                try {
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < fetchedProcedureListAfterDeletion.size(); i++) {
                                writer.append(fetchedProcedureListAfterDeletion.get(i));
                                writer.append("\n");
                        }
                        writer.close();
                } catch (IOException e) {
                        System.out.println(e);
                } finally {
                        System.out.println("Deletion done!");
                }
        }

        public static void updateProcedureData(Procedure newProcedureData) {
                ArrayList<String> fetchedProcedureListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        while ((line = reader.readLine()) != null) {

                                if (line.contains(newProcedureData.getProcedureId())) {
                                        fetchedProcedureListAfterDeletion.add(newProcedureData.getProcedureId() + ","
                                                        + newProcedureData.getPatientName() + ","
                                                        + newProcedureData.getStaffId() + ","
                                                        + newProcedureData.getDate() + ","
                                                        + newProcedureData.getTime() + ","
                                                        + newProcedureData.getType() + ","
                                                        + newProcedureData.getDescription());
                                } else {
                                        fetchedProcedureListAfterDeletion.add(line);
                                }

                        }
                        reader.close();
                } catch (IOException e) {
                        System.out.println(e);
                }

                try {
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < fetchedProcedureListAfterDeletion.size(); i++) {
                                writer.append(fetchedProcedureListAfterDeletion.get(i));
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
