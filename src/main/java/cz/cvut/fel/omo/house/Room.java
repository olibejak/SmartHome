package cz.cvut.fel.omo.house;

import lombok.Getter;

@Getter
public class Room implements ConfigurationReport {
    private final int id;
    private final RoomType type;
//    todo private final ArrayList<Device> devices;

    public Room(int id, RoomType type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }

    @Override
    public String reportConfiguration() {
        StringBuilder configurationReport = new StringBuilder();
        configurationReport.append(id).append(" ").append(type);
//        todo device configuration
        return configurationReport.toString();
    }
}
