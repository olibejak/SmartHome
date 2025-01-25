package cz.cvut.fel.omo.simulation.command;

import cz.cvut.fel.omo.exception.MyException;
import cz.cvut.fel.omo.house.Floor;
import cz.cvut.fel.omo.house.Room;

import java.util.Optional;

public class DisplayConfigurationCommand implements Command {

    @Override
    public void execute(String[] input, CommandContext context) {
        if (input.length == 1) {
            System.out.println(context.getHouse().reportConfiguration());
            return;
        }

        try {
            switch (input[1]) {
                case "R":
                    System.out.println(getRoomConfiguration(context, Integer.parseInt(input[2])));
                    break;
                case "F":
                    System.out.println(getFloorConfiguration(context, Integer.parseInt(input[2])));
                    break;
                default:
                    System.out.println("Invalid Display Consumption command.");
            }
        } catch (NumberFormatException e) {
            throw new MyException("Invalid number format for Display Consumption command.");
        }
    }

    private String getRoomConfiguration(CommandContext ctx, int id) {
        Optional<Room> room = ctx.getHouse().getRoomByID(id);
        if (room.isPresent()) {
            return room.get().reportConfiguration();
        }
        return "Room with id: " + id + " not fount";
    }

    private String getFloorConfiguration(CommandContext ctx, int id) {
        Optional<Floor> floor = ctx.getHouse().getFloorByID(id);
        if (floor.isPresent()) {
            return floor.get().reportConfiguration();
        }
        return "Floor with id: " + id + " not fount";
    }
}
