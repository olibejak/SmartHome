package cz.cvut.fel.omo.simulation;

import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.EventType;
import cz.cvut.fel.omo.event.eventManager.EventQueue;

import static cz.cvut.fel.omo.event.EventFactory.createEvent;

public class GlobalEventGenerator {

    EventQueue eventQueue;

    public GlobalEventGenerator(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
    }

    /**
     * Randomly generates an event.
     * @return generated event or null
     */
    public Event generateEvent () {
        if (Math.random() < 0.3)
            return createEvent(EventType.TEMPERATURE_CHANGE);
        else if (Math.random() > 0.6)
            return createEvent(EventType.RAIN);
        else
            return null;
    }
}
