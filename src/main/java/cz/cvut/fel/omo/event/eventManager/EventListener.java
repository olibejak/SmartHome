package cz.cvut.fel.omo.event.eventManager;

import cz.cvut.fel.omo.event.Event;

/**
 * Interface for classes that want to listen to events.
 */
public interface EventListener {

    void handleEvent(Event event);
}
