package cz.cvut.fel.omo.house;

import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.eventManager.EventListener;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a room in the house that can contain devices, sport equipment, and vehicles.
 * Implements {@link EventListener} to handle room-specific events.
 */
@Getter
@Setter
public class Room implements ConfigurationReport, EventListener {
    private final int id;
    private RoomType type;
    private final ArrayList<Device> devices = new ArrayList<>();
    private final ArrayList<SportEquipment> sportEquipment = new ArrayList<>();
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private final Queue<Event> events = new LinkedList<>();

    public Room(int id) {
        this.id = id;
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    /**
     * Generates a configuration report for the room, including devices, equipment, and vehicles.
     * @return A formatted string containing the room's configuration.
     */
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

    /**
     * Generates a configuration report for all devices in the room.
     * @return A formatted string listing all devices.
     */
    private String reportDeviceConfiguration() {
        StringBuilder configurationReport = new StringBuilder();
        configurationReport.append("\n\t\t\tDevices:");
        for (Device device : devices) {
            configurationReport.append("\n\t\t\t\t").append(device.reportConfiguration());
        }
        return configurationReport.toString();
    }

    /**
     * Generates a configuration report for all sport equipment in the room.
     * @return A formatted string listing all sport equipment.
     */
    private String reportSportEquipmentConfiguration() {
        StringBuilder configurationReport = new StringBuilder();
        configurationReport.append("\n\t\t\tSport Equipment:");
        for (SportEquipment equipment : sportEquipment) {
            configurationReport.append("\n\t\t\t\t").append(equipment.reportConfiguration());
        }
        return configurationReport.toString();
    }

    /**
     * Generates a configuration report for all vehicles in the room.
     * @return A formatted string listing all vehicles.
     */
    private String reportVehicleConfiguration() {
        StringBuilder configurationReport = new StringBuilder();
        configurationReport.append("\n\t\t\tVehicles:");
        for (Vehicle vehicle : vehicles) {
            configurationReport.append("\n\t\t\t\t").append(vehicle.reportConfiguration());
        }
        return configurationReport.toString();
    }

    /**
     * Handles an event and adds it to the room's event queue if it matches the room ID.
     * @param event The event to be handled.
     * Part of Observer design pattern.
     */
    @Override
    public void handleEvent(Event event) {
        if (event.getPayload().getRoomID() != id) {
            return;
        }
        events.add(event);
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", type=" + type + '}';
    }
}
