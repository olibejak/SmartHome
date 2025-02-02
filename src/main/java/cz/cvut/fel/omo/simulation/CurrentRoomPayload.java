package cz.cvut.fel.omo.simulation;

import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.entity.person.Person;
import cz.cvut.fel.omo.entity.pet.Pet;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.house.RoomType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Represents the current state of a specific room in the house.
 * Stores details about people, pets, equipment, vehicles, devices, and events within the room.
 */
@NoArgsConstructor
@Getter
@Setter
public class CurrentRoomPayload {
    private int currentRoomId;
    private RoomType currentRoomType;
    private ArrayList<Person> currentPeople;
    private ArrayList<Pet> currentPets;
    private ArrayList<SportEquipment> currentEquipment;
    private ArrayList<Vehicle> currentVehicles;
    private ArrayList<Device> currentDevices;
    private ArrayList<Event> currentEvents;

    public void removePerson(Person person) {
        if (currentPeople != null) {
            currentPeople.remove(person);
        }
    }

    public void removePet(Pet pet) {
        if (currentPets != null) {
            currentPets.remove(pet);
        }
    }

    /**
     * Retrieves a list of all available sport equipment in the room.
     * @return A list of available sport equipment.
     */
    public ArrayList<SportEquipment> getCurrentAvailableEquipment() {
        if (currentEquipment == null) {
            return new ArrayList<>();
        }
        return currentEquipment.stream()
                .filter(SportEquipment::isAvailable)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Retrieves a list of all available vehicles in the room.
     * @return A list of available vehicles.
     */
    public ArrayList<Vehicle> getCurrentAvailableVehicles() {
        if (currentVehicles == null) {
            return new ArrayList<>();
        }
        return currentVehicles.stream()
                .filter(Vehicle::isAvailable)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Generates a formatted log with details about the current room.
     * Includes information about people, pets, equipment, vehicles, devices, and events in the room.
     * @return A formatted string containing room details.
     */
    public String getRoomDetailsLog() {
        StringBuilder log = new StringBuilder();

        log.append("Room ID: ").append(currentRoomId).append(", ");
        log.append("Room Type: ").append(currentRoomType != null ? currentRoomType.toString() : "N/A").append("\n");

        if (currentPeople != null && !currentPeople.isEmpty()) {
            log.append("  People: ");
            currentPeople.forEach(person ->
                    log.append(person.toString()).append(", ")
            );
            log.delete(log.length() - 2, log.length()).append("\n");
        }

        if (currentPets != null && !currentPets.isEmpty()) {
            log.append("  Pets: ");
            currentPets.forEach(pet ->
                    log.append(pet.toString()).append(", ")
            );
            log.delete(log.length() - 2, log.length()).append("\n");
        }

        if (currentEquipment != null && !currentEquipment.isEmpty()) {
            log.append("  Sport Equipment: ");
            currentEquipment.forEach(equipment ->
                    log.append(equipment.getClass().getSimpleName()).append(", ")
            );
            log.delete(log.length() - 2, log.length()).append("\n");
        }

        if (currentVehicles != null && !currentVehicles.isEmpty()) {
            log.append("  Vehicles: ");
            currentVehicles.forEach(vehicle ->
                    log.append(vehicle.getClass().getSimpleName())
                            .append(" - ").append(vehicle.getModel()).append(" (").append(vehicle.getYearOfManufacturing()).append("), ")
            );
            log.delete(log.length() - 2, log.length()).append("\n");
        }

        if (currentDevices != null && !currentDevices.isEmpty()) {
            log.append("  Devices: ");
            currentDevices.forEach(device ->
                    log.append(device.getClass().getSimpleName())
                            .append(" (ID: ").append(device.getId()).append("), ")
            );
            log.delete(log.length() - 2, log.length()).append("\n");
        }

        if (currentEvents != null && !currentEvents.isEmpty()) {
            log.append("  Events: ");
            currentEvents.forEach(event ->
                    log.append(event.getClass().getSimpleName()).append(" - ").append(event.getType()).append(", ")
            );
            log.delete(log.length() - 2, log.length()).append("\n");
        }

        return log.toString().trim();
    }



    @Override
    public String toString() {
        return "CurrentRoomPayload:" +
                "\n  Room ID: " + currentRoomId +
                "\n  Room Type: " + (currentRoomType != null ? currentRoomType.toString() : "N/A") +
                "\n  People: " + (currentPeople != null ? currentPeople.size() : 0) +
                "\n  Pets: " + (currentPets != null ? currentPets.size() : 0) +
                "\n  Equipment: " + (currentEquipment != null ? currentEquipment.size() : 0) +
                "\n  Vehicles: " + (currentVehicles != null ? currentVehicles.size() : 0) +
                "\n  Devices: " + (currentDevices != null ? currentDevices.size() : 0) +
                "\n  Events: " + (currentEvents != null ? currentEvents.size() : 0) +
                "\n";
    }

}
