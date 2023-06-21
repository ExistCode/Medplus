package medplus.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import medplus.models.Room;

public class RoomData {
    public static Room initRoomData = new Room("", 0, "");

    public static void main(String[] args) {
        createNewFileWithHeaders();
        fetchRoomDataFromDatabase();
    }

    public static String fileName = "src/main/resources/medplus/database/room.txt";

    public static List<Room> fetchRoomDataFromDatabase() {
        List<Room> roomList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] roomData = line.split(",");
                String roomNum = roomData[0].trim();
                int capacity = Integer.parseInt(roomData[1].trim());
                String status = roomData[2].trim();

                Room room = new Room(roomNum, capacity, status);
                roomList.add(room);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return roomList;
    }

    public static void createNewFileWithHeaders() {
        File database = new File(fileName);

        try {
            if (database.createNewFile()) {
                FileWriter writer = new FileWriter(fileName, true);
                writer.append("Room Number, Capacity, Status");
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

    public static void addNewRoom(Room newRoom) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            String roomData = String.format("%s,%d,%s",
                    newRoom.getRoomNum(),
                    newRoom.getCapacity(),
                    newRoom.getStatus());

            writer.append(roomData);
            writer.append("\n");
            writer.close();
            System.out.println("Room added successfully!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void deleteRoomByNumber(String roomNum) {
        System.out.println("\nDELETED Room Number: " + roomNum);
        ArrayList<String> fetchedRoomListAfterDeletion = new ArrayList<>();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                if (line.contains(roomNum)) {
                    System.out.println("FOUND Room Number");
                } else {
                    fetchedRoomListAfterDeletion.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < fetchedRoomListAfterDeletion.size(); i++) {
                writer.append(fetchedRoomListAfterDeletion.get(i));
                writer.append("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("Deletion done!");
        }
    }

    public static void updateRoom(Room newRoomData) {
        ArrayList<String> fetchedRoomListAfterUpdate = new ArrayList<>();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                if (line.contains(newRoomData.getRoomNum())) {
                    fetchedRoomListAfterUpdate.add(newRoomData.getRoomNum() + ","
                            + newRoomData.getCapacity() + ","
                            + newRoomData.getStatus());
                } else {
                    fetchedRoomListAfterUpdate.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < fetchedRoomListAfterUpdate.size(); i++) {
                writer.append(fetchedRoomListAfterUpdate.get(i));
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
