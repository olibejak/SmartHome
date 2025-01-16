package cz.cvut.fel.omo.BobTheBuilder.eventFactory;

import cz.cvut.fel.omo.event.Event;

import java.util.UUID;

public interface EventFactory {

    Event createEvent(UUID deviceID, Integer roomID);
}
