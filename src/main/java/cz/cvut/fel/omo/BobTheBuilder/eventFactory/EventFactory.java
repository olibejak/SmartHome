package cz.cvut.fel.omo.BobTheBuilder.eventFactory;

import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.util.Payload;

public interface EventFactory {

    Event createEvent(Payload payload);
}
