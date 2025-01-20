package cz.cvut.fel.omo.event.eventManager;

import cz.cvut.fel.omo.event.Event;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

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

    /**
     * Retrieves a list of events that are associated with a specific room ID.
     *
     * @param roomId the ID of the room to filter events for
     * @return a list of events related to the specified room ID
     */
    public ArrayList<Event> getEventsByRoomId(int roomId) {
        return events.stream()
                .filter(event -> event.getPayload() != null && event.getPayload().getRoomID() != null)
                .filter(event -> event.getPayload().getRoomID().equals(roomId))
                .collect(Collectors.toCollection(ArrayList::new));  // Collect to an ArrayList
    }
}
