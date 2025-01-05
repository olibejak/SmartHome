package cz.cvut.fel.omo.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalEvent extends Event {

    public GlobalEvent(EventCreator creator, EventType type) {
        super(creator, type);
    }
}
