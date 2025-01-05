package cz.cvut.fel.omo.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalEvent extends Event {

    private int location;

    public LocalEvent(EventCreator creator, EventType type, int location) {
        super(creator, type);
        this.location = location;
    }
}
