package cz.cvut.fel.omo.simulation.input;

import cz.cvut.fel.omo.house.House;

import java.util.Optional;
import java.util.function.Function;

public interface InputHandler {

    Optional<Function<House, String>> handle(String[] input);
    void setNext(InputHandler handler);
}
