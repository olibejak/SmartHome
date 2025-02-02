package cz.cvut.fel.omo.simulation.command;

import cz.cvut.fel.omo.exception.MyException;

/**
 * {@link Command} for quiting smart home.
 */
public class QuitCommand implements Command {

    @Override
    public void execute(String[] input, CommandContext context) {
        if (input.length == 1) {
            System.out.println("Exiting Smart Home...");
            context.setRunning(false);
        }
        else {
            throw new MyException("Invalid quit command.");
        }

    }
}
