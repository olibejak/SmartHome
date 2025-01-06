package cz.cvut.fel.omo.BobTheBuilder.eventFactory;

import cz.cvut.fel.omo.event.Event;
import cz.cvut.fel.omo.event.EventType;
import cz.cvut.fel.omo.event.util.Payload;

public class DeviceMalfunctionEvent implements EventFactory {

    @Override
    public Event createEvent(Payload payload) {
        return new Event(
                EventType.DEVICE_MALFUNCTION,
                Payload.builder()
                        .deviceID(payload.getDeviceID())
                        .roomID(payload.getRoomID())
                        .build()
        );
    }
}
