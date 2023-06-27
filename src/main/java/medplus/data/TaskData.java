package medplus.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import medplus.models.Tasks;

public class TaskData {
    public static Tasks initTask = new Tasks("", "", "", "");

    public static void main(String[] args) {
        createNewFileWithHeaders();
        fetchTasksDataFromDatabase();
    }
    // Database file location

    public static String fileName = "src/main/resources/medplus/database/tasks.txt";

    public static List<Tasks> fetchTasksDataFromDatabase() {
        List<Tasks> taskList = new ArrayList<>();
        // Read the txt file and splitting into their respective fields

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] taskData = line.split(",");
                String taskId = taskData[0].trim();
                String taskName = taskData[1].trim();
                String taskDescription = taskData[2].trim();
                String staffId = taskData[3].trim();
                // Add the data to the empty list

                Tasks task = new Tasks(taskId, taskName, taskDescription, staffId);
                taskList.add(task);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return taskList;
    }

    public static List<Tasks> fetchTasksDataFromDatabasebyId(String id) {
        List<Tasks> singleAdminList = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                if (line.contains(id)) {
                    String[] taskData = line.split(",");
                    String taskId = taskData[0].trim();
                    String taskName = taskData[1].trim();
                    String taskDescription = taskData[2].trim();
                    String staffId = taskData[3].trim();

                    Tasks task = new Tasks(taskId, taskName, taskDescription, staffId);
                    singleAdminList.add(task);
                }

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return singleAdminList;
    }

    public static void createNewFileWithHeaders() {
        File database = new File(fileName);

        try {
            if (database.createNewFile()) {
                // Create a new file
                FileWriter writer = new FileWriter(fileName, true);
                writer.append("Task ID, Task Name, Task Description, Staff ID");
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

    public static void addNewTask(Tasks newTask) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            String taskData = String.format("%s,%s,%s,%s",
                    newTask.getTaskId(),
                    newTask.getTaskName(),
                    newTask.getTaskDescription(),
                    newTask.getStaffId());

            writer.append(taskData);
            writer.append("\n");
            writer.close();
            System.out.println("Task added successfully!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void deleteTaskById(String id) {
        System.out.println("\nDELETED ID: " + id);
        ArrayList<String> fetchedTaskListAfterDeletion = new ArrayList<>();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            // Iterate over the list and insert the one isn't deleted
            while ((line = reader.readLine()) != null) {
                if (line.contains(id)) {
                    System.out.println("FOUND ID");
                } else {
                    fetchedTaskListAfterDeletion.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < fetchedTaskListAfterDeletion.size(); i++) {
                writer.append(fetchedTaskListAfterDeletion.get(i));
                writer.append("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("Deletion done!");
        }
    }

    public static void updateTask(Tasks newTaskData) {
        ArrayList<String> fetchedTaskListAfterDeletion = new ArrayList<>();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            // Iterate over the list and insert the updated version of the object

            while ((line = reader.readLine()) != null) {
                if (line.contains(newTaskData.getTaskId())) {
                    System.out.println(newTaskData.getTaskId());

                    fetchedTaskListAfterDeletion.add(newTaskData.getTaskId() + ","
                            + newTaskData.getTaskName() + ","
                            + newTaskData.getTaskDescription() + ","
                            + newTaskData.getStaffId());

                } else {
                    fetchedTaskListAfterDeletion.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < fetchedTaskListAfterDeletion.size(); i++) {
                writer.append(fetchedTaskListAfterDeletion.get(i));
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
