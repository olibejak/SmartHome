package cz.cvut.fel.omo.simulation;

import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.entity.person.Person;
import cz.cvut.fel.omo.entity.pet.Pet;
import cz.cvut.fel.omo.event.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class CurrentRoomPayload {
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
}
