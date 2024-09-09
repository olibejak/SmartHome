package house;

import java.util.ArrayList;

public class Floor implements ConfigurationReport {
    private final ArrayList<Room> rooms;

    public Floor(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "rooms=" + rooms +
                '}';
    }

    public String reportConfiguration() {
        StringBuilder configurationReport = new StringBuilder("Floor #...\n");
        for (Room room : rooms) {
            configurationReport.append(room.reportConfiguration()).append("\n");
        }
        return configurationReport.toString();
    }
}
