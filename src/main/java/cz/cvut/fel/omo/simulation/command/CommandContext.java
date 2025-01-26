package cz.cvut.fel.omo.simulation.command;

import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.simulation.Simulation;
import lombok.Getter;
import lombok.Setter;

/**
 * Context for command execution.
 */
public class CommandContext {

    @Setter
    protected boolean isRunning;
    @Getter
    private final House house;
    private final Simulation simulation;

    public CommandContext(final House house, final Simulation simulation) {
        this.house = house;
        this.simulation = simulation;
        this.isRunning = true;
    }

    /**
     * Proceed to the next cycle.
     */
    public void nextCycle() {
        simulation.nextCycle();
    }

    /**
     * Proceed to the next n cycles.
     * @param num number of cycles to proceed
     */
    public void nextCycle(int num) {
        simulation.nextCycles(num);
    }

    public boolean isRunning() {
        return isRunning;
    }
}
