package cz.cvut.fel.omo.BobTheBuilder.EventFactory;

import cz.cvut.fel.omo.event.EventCreator;
import cz.cvut.fel.omo.event.GlobalEvent;

public interface GlobalEventFactory {

    GlobalEvent createEvent(EventCreator creator);
}
