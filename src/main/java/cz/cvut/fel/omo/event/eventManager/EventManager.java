package cz.cvut.fel.omo.event.eventManager;

import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Distributes events to listeners.
 * Part of an observer pattern.
 */
public class EventManager {

    private HashMap<EventType, ArrayList<EventListener>> listeners;

    public void addListener(EventType eventType, EventListener listener) {
    }

    public void removeListener(EventType eventType, EventListener listener) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notify(Event event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
