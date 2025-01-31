package cz.cvut.fel.omo.house;

import cz.cvut.fel.omo.activity.equipment.SportEquipment;
import cz.cvut.fel.omo.activity.vehicle.Vehicle;
import cz.cvut.fel.omo.device.Device;
import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.util.Payload;
import cz.cvut.fel.omo.house.report.ConsumptionReport;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class House implements ConfigurationReport {
    private final ArrayList<Floor> floors = new ArrayList<>();

    public ArrayList<Integer> getFloorNumbers() {
        return floors.stream()
                .map(Floor::getFloorNumber)
                .sorted(Comparator.comparingInt(id -> id))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Integer> getRoomIds() {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .map(Room::getId)
                .sorted(Comparator.comparingInt(id -> id))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public RoomType getRoomTypeByRoomId(int roomId) {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == roomId)
                .findFirst()
                .map(Room::getType)
                .orElse(null);
    }


    public ArrayList<Device> getDevicesByRoomId(int roomId) {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == roomId)
                .findFirst()
                .map(Room::getDevices)
                .orElse(new ArrayList<>());
    }

    public ArrayList<SportEquipment> getSportEquipmentByRoomId(int roomId) {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == roomId)
                .findFirst()
                .map(Room::getSportEquipment)
                .orElse(new ArrayList<>());
    }

    public ArrayList<Vehicle> getVehiclesByRoomId(int roomId) {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == roomId)
                .findFirst()
                .map(Room::getVehicles)
                .orElse(new ArrayList<>());
    }

    public void makeAllVehiclesAndEquipmentAvailable() {
        floors.forEach(floor ->
                floor.getRooms().forEach(room -> {
                    room.getVehicles().forEach(vehicle -> vehicle.setAvailable(true));
                    room.getSportEquipment().forEach(equipment -> equipment.setAvailable(true));
                })
        );
    }

    public void updateAllDevices() {
        floors.forEach(floor ->
                floor.getRooms().forEach(room ->
                        room.getDevices().forEach(Device::update)
                )
        );
    }

    public String reportConsumption() {
        return ConsumptionReport.getConsumptionReport(this);
    }

    public String reportConsumptionByFloor(int floorId) {
        return ConsumptionReport.getFloorConsumptionReport(this, floorId);
    }

    public String reportConsumptionByRoom(int roomId) {
        return ConsumptionReport.getRoomConsumptionReport(this, roomId);
    }

    public Optional<Room> getRoomByID(int id) {
        return getFloors().stream()
                .filter(floor -> floor.getFloorNumber() == id / 100)
                .findFirst().stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == id)
                .findFirst();
    }

    public Optional<Floor> getFloorByID(int id) {
        return getFloors().stream()
                .filter(floor -> floor.getFloorNumber() == id)
                .findFirst();
    }

    public ArrayList<Event> getAllLocalEvents() {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .flatMap(room -> room.getEvents().stream())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Event> getEventsByRoomId(int roomId) {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == roomId)
                .findFirst()
                .map(Room::getEvents)
                .map(ArrayList::new) // Convert to a mutable list
                .orElse(new ArrayList<>());
    }

    public ArrayList<Event> getAllDeviceEvents() {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .flatMap(room -> room.getDevices().stream())
                .flatMap(device -> device.getEventQueue().getEvents().stream())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Event> getDeviceEventsByRoomId(int roomId) {
        return floors.stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == roomId)
                .flatMap(room -> room.getDevices().stream())
                .flatMap(device -> device.getEventQueue().getEvents().stream())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Device getDeviceByID(Payload payload) {
        AtomicReference<Device> result = new AtomicReference<>();
        getRoomByID(payload.getRoomID()).ifPresent(room -> {
            for (Device device : room.getDevices()) {
                if (device.getId().equals(payload.getDeviceID())) {
                    result.set(device);
                    break;
                }
            }
        });
        return result.get();
    }

    public String reportConfiguration() {
        StringBuilder configurationReport = new StringBuilder("House Configuration Report:\n");
        configurationReport.append("\nFloor Configuration:");
        for (Floor floor : floors) {
            configurationReport.append("\n").append(floor.reportConfiguration());
        }
        return configurationReport.toString();
    }

    @Override
    public String toString() {
        return "House{" + "floors=" + floors + '}';
    }
}

