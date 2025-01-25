package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.event.util.Payload;

import java.util.UUID;

/**
 * Simple Factory for creating events
 */
public class EventFactory {

    public static Event createEvent(EventType type, int roomId, UUID deviceId) {
        return new Event(
                type,
                Payload.builder()
                        .roomID(roomId)
                        .deviceID(deviceId)
                        .build());
    }

    public static Event createEvent(EventType type, int roomId) {
        return new Event(
                type,
                Payload.builder()
                        .roomID(roomId)
                        .build());
    }

    public static Event createEvent(EventType type) {
        return new Event(type, null);
    }
}
