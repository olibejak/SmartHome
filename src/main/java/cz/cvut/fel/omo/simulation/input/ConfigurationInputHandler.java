package cz.cvut.fel.omo.simulation.input;

import cz.cvut.fel.omo.house.Floor;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.Room;

import java.util.Optional;
import java.util.function.Function;

public class ConfigurationInputHandler implements InputHandler {
    private final String input;

    public ConfigurationInputHandler(String input) {
        this.input = input;
    }

    @Override
    public Optional<Function<House, String>> handle(String input) {
        String[] args = cutString(input);
        if (args.length == 1) {
            return Optional.of(House::reportConfiguration);
        }

        int id;
        try {
            id = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            return ;
        }

        if (args[1].equals("R")) {
            return house -> house.getFloors().stream()
                    .filter(floor -> floor.getFloorNumber() == id) // Filter by floor ID
                    .flatMap(floor -> floor.getRooms().stream()) // Flatten to a stream of rooms
                    .filter(room -> room.getId() == id) // Filter by room number
                    .findFirst()
                    .reportConfigurationByRoom(Integer.parseInt(args[2]));
        } else if (args[1].equals("F")) {
            return house -> house.reportConfigurationByFloor(Integer.parseInt(args[2]));
        }

        return (house) -> "Invalid configuration command";
    }

    private Room getRoom(int id) {
        return house -> house.getFloors().stream()
                .flatMap(floor -> floor.getRooms().stream())
                .filter(room -> room.getId() == id)
                .findFirst()
                .map(Floor::reportConfiguration)
                .orElse("Room not found");
    }

    private Floor getFloor(House house, int id) {
        return house -> house.getFloors().stream()
                .filter(floor -> floor.getFloorNumber() == id)
                .findFirst()
                .map(Floor::reportConfiguration)
                .orElse("Floor not found");
    }
}
