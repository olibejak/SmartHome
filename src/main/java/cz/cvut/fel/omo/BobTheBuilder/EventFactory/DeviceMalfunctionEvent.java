package cz.cvut.fel.omo.BobTheBuilder.EventFactory;

import cz.cvut.fel.omo.event.EventCreator;
import cz.cvut.fel.omo.event.EventType;
import cz.cvut.fel.omo.event.LocalEvent;

public class DeviceMalfunctionEvent implements LocalEventFactory {
    
    @Override
    public LocalEvent createEvent(EventCreator creator, int location) {
        return new LocalEvent(
                creator,
                EventType.DEVICE_MALFUNCTION,
                location
        );
    }


}
