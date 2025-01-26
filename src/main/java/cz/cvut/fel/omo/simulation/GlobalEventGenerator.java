package cz.cvut.fel.omo.simulation;

import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.EventType;

import static cz.cvut.fel.omo.event.EventFactory.createEvent;

public class GlobalEventGenerator {

    public GlobalEventGenerator() {
    }

    /**
     * Randomly generates an event.
     * @return generated event or null
     */
    public static Event generateEvent () {
        if (Math.random() < 0.3)
            return createEvent(EventType.TEMPERATURE_CHANGE);
        else if (Math.random() > 0.6)
            return createEvent(EventType.RAIN);
        else
            return null;
    }
}
