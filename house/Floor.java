package house;

import java.util.ArrayList;

public class Floor implements ConfigurationReport {
    private final int floorNumber;
    private final ArrayList<Room> rooms;

    public Floor(int floorNumber, ArrayList<Room> rooms) {
        this.floorNumber = floorNumber;
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorNumber=" + floorNumber +
                ", rooms=" + rooms +
                '}';
    }

    public String reportConfiguration() {
        StringBuilder configurationReport = new StringBuilder("Floor #" + floorNumber + "\n");
        for (Room room : rooms) {
            configurationReport.append(room.reportConfiguration()).append("\n");
        }
        return configurationReport.toString();
    }
}
