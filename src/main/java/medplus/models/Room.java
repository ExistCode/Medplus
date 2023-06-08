package medplus.models;

public class Room {
    private String roomNum;
    private int capacity;
    private String status;

    // Constructor
    public Room(String num, int cap, String stat) {
        roomNum = num;
        capacity = cap;
        status = stat;
    }

    // Setter functions
    public void setRoomNum(String num) {
        roomNum = num;
    }

    public void setCapacity(int cap) {
        capacity = cap;
    }

    public void setStatus(String stat) {
        status = stat;
    }

    // Getter functions
    public String getRoomNum() {
        return roomNum;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStatus() {
        return status;
    }
}
