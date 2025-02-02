package cz.cvut.fel.omo.simulation.command;

import cz.cvut.fel.omo.exception.MyException;

/**
 * {@link Command} that executes simulation next cycle.
 */
public class NextCycleCommand implements Command {

    @Override
    public void execute(String[] input, CommandContext context) {
        try {
            switch (input.length) {
                case 1:
                    context.nextCycle();
                    break;
                case 2:
                    int cycles = Integer.parseInt(input[1]);
                    context.nextCycle(cycles);
                    break;
                default:
                    throw new MyException("Wrong next cycle command input.");
            }
        } catch (NumberFormatException e) {
            throw new MyException("Invalid number format for next cycle command.");
        }
    }
}
