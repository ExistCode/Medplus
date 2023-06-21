package medplus.data;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import medplus.models.Medicine;

public class MedicineData {
        public static Medicine initMedicineData = new Medicine("", "", "", "", "","");

        public static String fileName = "src/main/resources/medplus/database/medicine.txt";

        public static List<Medicine> fetchMedicineDataFromDatabase() {
                List<Medicine> medicineList = new ArrayList<>();

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        String line;
                        reader.readLine(); // Skip the header line

                        while ((line = reader.readLine()) != null) {
                                String[] medicineData = line.split(",");
                                String medicineId = medicineData[0].trim();
                                String patientName = medicineData[1].trim();
                                String doctorId = medicineData[2].trim();
                                String medicineName = medicineData[3].trim();
                                String amount = medicineData[4].trim();
                                String doseDetail = medicineData[5].trim();

                                Medicine medicine = new Medicine(medicineId, patientName, doctorId, medicineName, amount, doseDetail);
                                medicineList.add(medicine);
                        }

                        reader.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }

                return medicineList;
        }

        public static void createNewFileWithHeaders() {
                File database = new File(fileName);

                try {
                        if (database.createNewFile()) {
                                FileWriter writer = new FileWriter(fileName, true);
                                writer.append("Medicine ID, Patient Name, Doctor ID, Medicine Name, Amount, Dose Detaik");
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

        public static void addNewMedicine(Medicine newMedicine) {

                try {
                        FileWriter writer = new FileWriter(fileName, true);
                        String medicineData = String.format("%s,%s,%s,%s,%s,%s",
                                        newMedicine.getMedicineId(),
                                        newMedicine.getPatientName(),
                                        newMedicine.getStaffId(),
                                        newMedicine.getMedicineName(),
                                        newMedicine.getAmount(),
                                        newMedicine.getDoseDetail());

                        writer.append(medicineData);
                        writer.append("\n");
                        writer.close();
                        System.out.println("Medicine added successfully!");
                } catch (IOException e) {
                        System.out.println(e);
                }
        }

        public static void deleteMedicineById(String id) {
                ArrayList<String> fetchedMedicineListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        while ((line = reader.readLine()) != null) {
                                if (line.contains(id)) {
                                        System.out.println("FOUND ID");
                                } else {
                                        fetchedMedicineListAfterDeletion.add(line);
                                }

                        }
                        reader.close();
                } catch (IOException e) {
                        System.out.println(e);
                }

                try {
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < fetchedMedicineListAfterDeletion.size(); i++) {
                                writer.append(fetchedMedicineListAfterDeletion.get(i));
                                writer.append("\n");
                        }
                        writer.close();
                } catch (IOException e) {
                        System.out.println(e);
                } finally {
                        System.out.println("Deletion done!");
                }
        }

        public static void updateMedicineData(Medicine newMedicineData) {
                ArrayList<String> fetchedMedicineListAfterDeletion = new ArrayList<>();
                String line;

                try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        while ((line = reader.readLine()) != null) {
                                if (line.contains(newMedicineData.getMedicineId())) {
                                        fetchedMedicineListAfterDeletion.add(newMedicineData.getMedicineId() + ","
                                                        + newMedicineData.getPatientName() + ","
                                                        + newMedicineData.getStaffId() + ","
                                                        + newMedicineData.getMedicineName() + ","
                                                        + newMedicineData.getAmount() + ","
                                                        + newMedicineData.getDoseDetail() + ",");
                                } else {
                                        fetchedMedicineListAfterDeletion.add(line);
                                }
                        }
                        reader.close();
                } catch (IOException e) {
                        System.out.println(e);
                }

                try {
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < fetchedMedicineListAfterDeletion.size(); i++) {
                                writer.append(fetchedMedicineListAfterDeletion.get(i));
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
