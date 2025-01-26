package cz.cvut.fel.omo.simulation.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles user input and executes the corresponding command.
 */
public class InputHandler {
    private final Map<String, Command> commandMap = new HashMap<>();

    /**
     * Initializes the command map with the available commands.
     */
    public InputHandler() {
        commandMap.put("A", new DisplayConfigurationCommand());
        commandMap.put("S", new DisplayConsumptionCommand());
        commandMap.put("D", new NextCycleCommand());
        commandMap.put("Q", new QuitCommand());
        commandMap.put("H", new HelpCommand());
    }

    /**
     * Executes the help command.
     */
    public void getHelp() {
        commandMap.get("H").execute(null, null);
    }

    /**
     * Handles the user input and executes the corresponding command.
     *
     * @param input   the user input
     * @param context the command context
     */
    public void handleInput(String input, CommandContext context) {
        String[] inputParts = input.split(" ");
        String commandKey = inputParts[0]; // Get the first word
        Command command = commandMap.get(commandKey);

        if (command == null) {
            System.out.println("Invalid command. Type 'H' for a list of commands.");
            return;
        }

        try {
            command.execute(inputParts, context);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Type 'H' for a list of commands.");
        }
    }
}
