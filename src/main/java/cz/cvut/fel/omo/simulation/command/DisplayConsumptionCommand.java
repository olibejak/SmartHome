package cz.cvut.fel.omo.simulation.command;

import cz.cvut.fel.omo.exception.MyException;

/**
 * {@link Command} for displaying consumption of the house or its parts.
 */
public class DisplayConsumptionCommand implements Command {

    @Override
    public void execute(String[] input, CommandContext context) {
        if (input.length == 1) {
            System.out.println(context.getHouse().reportConsumption());
            return;
        }
        try {
            switch (input[1]) {
                case "R":
                    System.out.println(context.getHouse().reportConsumptionByRoom(Integer.parseInt(input[2])));
                    break;
                case "F":
                    System.out.println(context.getHouse().reportConsumptionByFloor(Integer.parseInt(input[2])));
                    break;
                default:
                    System.out.println("Invalid Display Consumption command.");
            }
        } catch (NumberFormatException e) {
            throw new MyException("Invalid number format for Display Consumption command.");
        }
    }
}

