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

    /**
     * Add a listener to the event manager.
     * @param type the type of event to listen to
     * @param listener the listener to add
     */
    public void subscribe(EventType type, EventListener listener) {
        listeners.computeIfAbsent(type, k -> new ArrayList<>()).add(listener);
    }

    /**
     * Remove a listener from the event manager.
     * @param type the type of event to stop listening to
     * @param listener the listener to remove
     */
    public void unsubscribe(EventType type, EventListener listener) {
        ArrayList<EventListener> eventListeners = listeners.get(type);
        if (eventListeners != null) {
            eventListeners.remove(listener);
        }
    }

    /**
     * Dispatch an event to all listeners based on the event type.
     * @param event the event to dispatch
     */
    public void dispatch(Event event) {
        ArrayList<EventListener> eventListeners = listeners.get(event.getType());
        if (eventListeners != null) {
            for (EventListener listener : eventListeners) {
                listener.handleEvent(event);
            }
        }
    }
}
