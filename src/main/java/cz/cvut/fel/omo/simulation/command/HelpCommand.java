package cz.cvut.fel.omo.simulation.command;

public class HelpCommand implements Command {

    private static final String controls =
            """
                A - House Configuration
                S - Consumption Report
                D - Next Cycle
                H - Help
                Q - Quit
                Usage:
                A [F, R] [ID] - F for floor, R for room, ID for floor or room ID
                S [F, R] [ID] - F for floor, R for room, ID for floor or room ID
                D [number] - Number of cycles
                """;

    @Override
    public void execute(String[] input, CommandContext context) {
        System.out.println(controls);
    }
}