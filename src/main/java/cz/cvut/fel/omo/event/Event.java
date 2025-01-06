package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.event.util.Payload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Event class represents an event that can be dispatched by the EventManager.
 */
@AllArgsConstructor
@Getter
@Setter
public class Event {

    private EventType type;

    /**
     * @see Payload
     */
    private Payload payload;
}