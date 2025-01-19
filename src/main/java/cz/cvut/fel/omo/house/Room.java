package cz.cvut.fel.omo.house;

import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.device.Device;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Room implements ConfigurationReport {
    private final int id;
    private RoomType type;
    private final ArrayList<Device> devices = new ArrayList<>();
    private final ArrayList<SportEquipment> SportEquipment = new ArrayList<>();
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public Room(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", type=" + type + '}';
    }

    @Override
    public String reportConfiguration() {
        StringBuilder configurationReport = new StringBuilder();
        configurationReport.append("\t\t").append(type).append(" #").append(id).append("\n");
        configurationReport.append("\t\t\tDevices:\n");
        for (Device device : devices) {
            configurationReport.append("\t\t\t\t").append(device.reportConfiguration()).append("\n");
        }
//        for (Device device : devices) {
//            configurationReport.append("\t\t\t\t").append(device.reportConfiguration()).append("\n");
//        }
        // todo equipment configuration
        // todo vehicle configuration
        return configurationReport.toString();
    }
}
