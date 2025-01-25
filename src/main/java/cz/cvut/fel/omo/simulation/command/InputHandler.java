package cz.cvut.fel.omo.simulation.command;

import cz.cvut.fel.omo.logger.GlobalLogger;

import java.util.HashMap;
import java.util.Map;

public class InputHandler {
    private final Map<String, Command> commandMap = new HashMap<>();

    public InputHandler() {
        commandMap.put("A", new DisplayConfigurationCommand());
        commandMap.put("S", new DisplayConsumptionCommand());
        commandMap.put("D", new NextCycleCommand());
        commandMap.put("Q", new QuitCommand());
        commandMap.put("H", new HelpCommand());
    }

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
