package cz.cvut.fel.omo.BobTheBuilder.EventFactory;

import cz.cvut.fel.omo.event.EventCreator;
import cz.cvut.fel.omo.event.LocalEvent;

public interface LocalEventFactory {

    LocalEvent createEvent(EventCreator creator, int location);
}
