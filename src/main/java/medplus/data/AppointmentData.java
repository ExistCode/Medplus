package medplus.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import medplus.models.Appointment;

public class AppointmentData {

    public static Appointment initAppointmentData = new Appointment("", "", "", "", LocalDate.now(),
            LocalTime.now(),
            "");
    // Database file location

    public static String fileName = "src/main/resources/medplus/database/appointment.txt";

    public static List<Appointment> fetchAllAppointmentDataFromDatabase() {
        List<Appointment> appointmentList = new ArrayList<>();
        // Read the txt file and splitting into their respective fields

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] appointmentData = line.split(",");
                String appointmentId = appointmentData[0].trim();
                String patientId = appointmentData[1].trim();
                String staffId = appointmentData[2].trim();
                String roomNum = appointmentData[3].trim();
                LocalDate date = LocalDate.parse(appointmentData[4].trim());
                LocalTime time = LocalTime.parse(appointmentData[5].trim());
                String description = appointmentData[6].trim();
                // Add the data to the empty list

                Appointment appointment = new Appointment(appointmentId, patientId, staffId, roomNum, date, time,
                        description);
                appointmentList.add(appointment);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appointmentList;
    }

    public static List<Appointment> fetchAppointmentDataFromDatabaseById(String id) {
        List<Appointment> singlePatientAppointmentList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                if (line.contains(id)) {
                    String[] appointmentData = line.split(",");
                    String appointmentId = appointmentData[0].trim();
                    String patientId = appointmentData[1].trim();
                    String staffId = appointmentData[2].trim();
                    String roomNum = appointmentData[3].trim();
                    LocalDate date = LocalDate.parse(appointmentData[4].trim());
                    LocalTime time = LocalTime.parse(appointmentData[5].trim());
                    String description = appointmentData[6].trim();

                    Appointment appointment = new Appointment(appointmentId, patientId, staffId, roomNum, date, time,
                            description);
                    singlePatientAppointmentList.add(appointment);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return singlePatientAppointmentList;
    }

    public static void addNewAppointment(Appointment newAppointment) {
        try {
            // Create a new file

            FileWriter writer = new FileWriter(fileName, true);
            String appointmentData = String.format("%s,%s,%s,%s,%s,%s,%s", newAppointment.getAppointmentId(),
                    newAppointment.getPatientId(), newAppointment.getStaffId(), newAppointment.getRoomNum(),
                    newAppointment.getDate(), newAppointment.getTime(), newAppointment.getDescription());

            writer.append(appointmentData);
            writer.append("\n");
            writer.close();
            System.out.println("Appointment added successfully!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void deleteAppointmentById(String appointmentId) {
        System.out.println("\nDeleted Appointment Id: " + appointmentId);
        ArrayList<String> fetchedAppointmentListAfterDeletion = new ArrayList<>();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            // Iterate over the list and insert the one isn't deleted

            while ((line = reader.readLine()) != null) {
                if (line.contains(appointmentId)) {
                    System.out.println("FOUND ID");
                } else {
                    fetchedAppointmentListAfterDeletion.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < fetchedAppointmentListAfterDeletion.size(); i++) {
                writer.append(fetchedAppointmentListAfterDeletion.get(i));
                writer.append("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("Deletion done!");
        }
    }

    public static void updateAppointment(Appointment newAppointmentData) {
        ArrayList<String> fetchedAppointmentListAfterUpdate = new ArrayList<>();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            // Iterate over the list and insert the updated version of the object

            while ((line = reader.readLine()) != null) {
                if (line.contains(newAppointmentData.getAppointmentId())) {
                    fetchedAppointmentListAfterUpdate.add(newAppointmentData.getAppointmentId() + ","
                            + newAppointmentData.getPatientId() + ","
                            + newAppointmentData.getStaffId() + ","
                            + newAppointmentData.getRoomNum() + ","
                            + newAppointmentData.getDate() + ","
                            + newAppointmentData.getTime() + ","
                            + newAppointmentData.getDescription());
                } else {
                    fetchedAppointmentListAfterUpdate.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < fetchedAppointmentListAfterUpdate.size(); i++) {
                writer.append(fetchedAppointmentListAfterUpdate.get(i));
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
