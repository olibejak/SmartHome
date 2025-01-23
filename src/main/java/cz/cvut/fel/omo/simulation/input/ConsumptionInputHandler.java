package cz.cvut.fel.omo.simulation.input;

import cz.cvut.fel.omo.house.House;

import java.util.Optional;
import java.util.function.Function;

public class ConsumptionInputHandler implements InputHandler {

    private final String input;

    public ConsumptionInputHandler(String input) {
        this.input = input;
    }

    @Override
    public Optional<Function<House, String>> handle(String input) {
        // Logic for handling consumption based on targetType and targetValue
        String[] args = cutString(input);
        if (args.length == 1) {
            return Optional.of(House::reportConfiguration);
        }

        if (args[1].equals("R")) {
            return Optional.of(house -> house.reportConsumptionByRoom(Integer.parseInt(args[2])));
        } else if (args[1].equals("F")) {
            return Optional.of(house -> house.reportConsumptionByFloor(Integer.parseInt(args[2])));
        }

        return Optional.empty();
    }
}

