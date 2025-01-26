package cz.cvut.fel.omo.simulation.command;

import cz.cvut.fel.omo.exception.MyException;

/**
 * Interface for commands called by the user.
 */
public interface Command {

    /**
     * Executes the command
     * @param input input from the user
     * @param context context of the command
     * @throws MyException if the command fails
     */
    void execute(String[] input, CommandContext context) throws MyException;
}
