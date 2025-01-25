package cz.cvut.fel.omo.simulation.command;

public interface Command {

    void execute(String[] input, CommandContext context);
}
