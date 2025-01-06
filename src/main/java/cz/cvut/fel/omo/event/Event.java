package cz.cvut.fel.omo.event;

import cz.cvut.fel.omo.event.util.Payload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Event {

    private EventType type;
    private Payload payload;
}