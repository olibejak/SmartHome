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
    private final ArrayList<SportEquipment> sportEquipment = new ArrayList<>();
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
        configurationReport.append("\n").append("\t\t").append(type).append(" #").append(id);
        if (!devices.isEmpty()) {
            configurationReport.append(reportDeviceConfiguration());
        }
        if (!sportEquipment.isEmpty()) {
            configurationReport.append(reportSportEquipmentConfiguration());
        }
        if (!vehicles.isEmpty()) {
            configurationReport.append(reportVehicleConfiguration());
        }
        return configurationReport.toString();
    }

    private String reportDeviceConfiguration() {
        StringBuilder configurationReport = new StringBuilder();
        configurationReport.append("\n\t\t\tDevices:");
        for (Device device : devices) {
            configurationReport.append("\n\t\t\t\t").append(device.reportConfiguration());
        }
        return configurationReport.toString();
    }

    private String reportSportEquipmentConfiguration() {
        StringBuilder configurationReport = new StringBuilder();
        configurationReport.append("\n\t\t\tSport Equipment:");
        for (SportEquipment equipment : sportEquipment) {
            configurationReport.append("\n\t\t\t\t").append(equipment.reportConfiguration());
        }
        return configurationReport.toString();
    }

    private String reportVehicleConfiguration() {
        StringBuilder configurationReport = new StringBuilder();
        configurationReport.append("\n\t\t\tVehicles:");
        for (Vehicle vehicle : vehicles) {
            configurationReport.append("\n\t\t\t\t").append(vehicle.reportConfiguration());
        }
        return configurationReport.toString();
    }
}
