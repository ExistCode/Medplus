package medplus.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import medplus.models.Responsibilities;

public class ResponsibilitiesData {
    public static Responsibilities initResponsibilities = new Responsibilities("", "", "", "");

    public static void main(String[] args) {
        createNewFileWithHeaders();
        fetchResponsibilitiesDataFromDatabase();
    }

    public static String fileName = "src/main/resources/medplus/database/responsibilities.txt";

    public static List<Responsibilities> fetchResponsibilitiesDataFromDatabase() {
        List<Responsibilities> responsibilitiesList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] responsibilitiesData = line.split(",");
                String responsibilityId = responsibilitiesData[0].trim();
                String responsibilityName = responsibilitiesData[1].trim();
                String responsibilityDescription = responsibilitiesData[2].trim();
                String staffId = responsibilitiesData[3].trim();

                Responsibilities responsibility = new Responsibilities(responsibilityId, responsibilityName,
                        responsibilityDescription, staffId);
                responsibilitiesList.add(responsibility);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responsibilitiesList;
    }

    public static List<Responsibilities> fetchResponsibilitiesDataFromDatabasebyId(String id) {
        List<Responsibilities> SingleAdminresponsibilitiesList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                if (line.contains(id)) {
                    String[] responsibilitiesData = line.split(",");
                    String responsibilityId = responsibilitiesData[0].trim();
                    String responsibilityName = responsibilitiesData[1].trim();
                    String responsibilityDescription = responsibilitiesData[2].trim();
                    String staffId = responsibilitiesData[3].trim();

                    Responsibilities responsibility = new Responsibilities(responsibilityId, responsibilityName,
                            responsibilityDescription, staffId);
                    SingleAdminresponsibilitiesList.add(responsibility);

                }

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SingleAdminresponsibilitiesList;
    }

    public static void createNewFileWithHeaders() {
        File database = new File(fileName);

        try {
            if (database.createNewFile()) {
                FileWriter writer = new FileWriter(fileName, true);
                writer.append("Responsibility ID, Responsibility Name, Responsibility Description, Staff ID");
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

    public static void addNewResponsibility(Responsibilities newResponsibility) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            String responsibilityData = String.format("%s,%s,%s,%s", newResponsibility.getResponsibilityId(),
                    newResponsibility.getResponsibilityName(), newResponsibility.getResponsibilityDescription(),
                    newResponsibility.getStaffId());

            writer.append(responsibilityData);
            writer.append("\n");
            writer.close();
            System.out.println("Responsibility added successfully!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void deleteResponsibilityById(String id) {
        System.out.println("\nDELETED ID: " + id);
        ArrayList<String> fetchedResponsibilitiesListAfterDeletion = new ArrayList<>();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                if (line.contains(id)) {
                    System.out.println("FOUND ID");
                } else {
                    fetchedResponsibilitiesListAfterDeletion.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < fetchedResponsibilitiesListAfterDeletion.size(); i++) {
                writer.append(fetchedResponsibilitiesListAfterDeletion.get(i));
                writer.append("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("Deletion done!");
        }
    }

    public static void updateResponsibility(Responsibilities newResponsibilityData) {
        ArrayList<String> fetchedResponsibilitiesListAfterDeletion = new ArrayList<>();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                if (line.contains(newResponsibilityData.getResponsibilityId())) {
                    System.out.println(newResponsibilityData.getResponsibilityId());

                    fetchedResponsibilitiesListAfterDeletion.add(newResponsibilityData.getResponsibilityId() + ","
                            + newResponsibilityData.getResponsibilityName() + ","
                            + newResponsibilityData.getResponsibilityDescription() + ","
                            + newResponsibilityData.getStaffId());
                } else {
                    fetchedResponsibilitiesListAfterDeletion.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < fetchedResponsibilitiesListAfterDeletion.size(); i++) {
                writer.append(fetchedResponsibilitiesListAfterDeletion.get(i));
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
