package cz.cvut.fel.omo.simulation.input;

public class BaseInputHandler implements Handler {
    private final String input;

    public BaseInputHandler(String input) {
        this.input = input;
    }

    @Override
    public String interpret() {
        return input;
    }
}
