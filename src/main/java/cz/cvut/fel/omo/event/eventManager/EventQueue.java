package cz.cvut.fel.omo.event.eventManager;

import cz.cvut.fel.omo.event.Event;
import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a queue of events that are waiting to be dispatched by the EventManager.
 */
@Getter
public class EventQueue {

    private Queue<Event> events = new LinkedList<>();
    private EventManager eventManager;

    public EventQueue(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public synchronized void dispatchEvents() {
        while (!events.isEmpty()) {
            eventManager.dispatch(events.poll());
        }
    }
}
