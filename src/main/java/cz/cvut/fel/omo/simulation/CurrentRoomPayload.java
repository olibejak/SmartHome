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

    // Person methods
    public void addPerson(Person person) {
        if (currentPeople == null) {
            currentPeople = new ArrayList<>();
        }
        currentPeople.add(person);
    }

    public void removePerson(Person person) {
        if (currentPeople != null) {
            currentPeople.remove(person);
        }
    }

    public int getNumberOfPeople() {
        return currentPeople != null ? currentPeople.size() : 0;
    }

    public boolean containsPerson(Person person) {
        return currentPeople != null && currentPeople.contains(person);
    }

    // Pet methods
    public void addPet(Pet pet) {
        if (currentPets == null) {
            currentPets = new ArrayList<>();
        }
        currentPets.add(pet);
    }

    public void removePet(Pet pet) {
        if (currentPets != null) {
            currentPets.remove(pet);
        }
    }

    public int getNumberOfPets() {
        return currentPets != null ? currentPets.size() : 0;
    }

    public boolean containsPet(Pet pet) {
        return currentPets != null && currentPets.contains(pet);
    }

    // Equipment methods
    public void addEquipment(SportEquipment equipment) {
        if (currentEquipment == null) {
            currentEquipment = new ArrayList<>();
        }
        currentEquipment.add(equipment);
    }

    public void removeEquipment(SportEquipment equipment) {
        if (currentEquipment != null) {
            currentEquipment.remove(equipment);
        }
    }

    public int getNumberOfEquipment() {
        return currentEquipment != null ? currentEquipment.size() : 0;
    }

    public boolean containsEquipment(SportEquipment equipment) {
        return currentEquipment != null && currentEquipment.contains(equipment);
    }

    // Vehicle methods
    public void addVehicle(Vehicle vehicle) {
        if (currentVehicles == null) {
            currentVehicles = new ArrayList<>();
        }
        currentVehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        if (currentVehicles != null) {
            currentVehicles.remove(vehicle);
        }
    }

    public int getNumberOfVehicles() {
        return currentVehicles != null ? currentVehicles.size() : 0;
    }

    public boolean containsVehicle(Vehicle vehicle) {
        return currentVehicles != null && currentVehicles.contains(vehicle);
    }

    // Device methods
    public void addDevice(Device device) {
        if (currentDevices == null) {
            currentDevices = new ArrayList<>();
        }
        currentDevices.add(device);
    }

    public void removeDevice(Device device) {
        if (currentDevices != null) {
            currentDevices.remove(device);
        }
    }

    public int getNumberOfDevices() {
        return currentDevices != null ? currentDevices.size() : 0;
    }

    public boolean containsDevice(Device device) {
        return currentDevices != null && currentDevices.contains(device);
    }

    // Event methods
    public void addEvent(Event event) {
        if (currentEvents == null) {
            currentEvents = new ArrayList<>();
        }
        currentEvents.add(event);
    }

    public void removeEvent(Event event) {
        if (currentEvents != null) {
            currentEvents.remove(event);
        }
    }

    public int getNumberOfEvents() {
        return currentEvents != null ? currentEvents.size() : 0;
    }

    public boolean containsEvent(Event event) {
        return currentEvents != null && currentEvents.contains(event);
    }

    public String getRoomDetailsLog() {
        StringBuilder log = new StringBuilder();

        log.append("Room ID: ").append(currentRoomId).append(", ");
        log.append("Room Type: ").append(currentRoomType != null ? currentRoomType.toString() : "N/A").append("\n");

        if (currentPeople != null && !currentPeople.isEmpty()) {
            log.append("  People: ");
//            currentPeople.forEach(person ->
//                    log.append(person.getClass().getSimpleName())
//                            .append(" - ").append(person.getName()).append(" (").append(person.getAge()).append("), ")
//            );
            currentPeople.forEach(person ->
                    log.append(person.toString()).append(", ")
            );
            log.delete(log.length() - 2, log.length()).append("\n");
        }

        if (currentPets != null && !currentPets.isEmpty()) {
            log.append("  Pets: ");
//            currentPets.forEach(pet ->
//                    log.append(pet.getClass().getSimpleName())
//                            .append(" - ").append(pet.getName()).append(" (").append(pet.getAge()).append("), ")
//            );
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
