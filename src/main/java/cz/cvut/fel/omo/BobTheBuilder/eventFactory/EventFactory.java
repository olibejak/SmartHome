package cz.cvut.fel.omo.BobTheBuilder.eventFactory;

import cz.cvut.fel.omo.event.Event;

import java.util.UUID;

/**
 * Factory for creating events
 */
public interface EventFactory {

    /**
     * Creates an event object
     * @param deviceID ID of the device
     * @param roomID ID of the room
     * @return event object
     */
    Event createEvent(UUID deviceID, Integer roomID);
}
