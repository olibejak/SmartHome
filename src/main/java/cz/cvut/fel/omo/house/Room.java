package cz.cvut.fel.omo.house;

import cz.cvut.fel.omo.device.Device;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Room implements ConfigurationReport {
    private final int id;
    private final RoomType type;
    private final ArrayList<Device> devices;
//    todo private final ArrayList<Device> devices;

    public Room(int id, RoomType type, ArrayList<Device> devices) {
        this.id = id;
        this.type = type;
        this.devices = devices;
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
