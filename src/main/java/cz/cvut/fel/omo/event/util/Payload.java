package cz.cvut.fel.omo.event.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Used to store data that are sent with the event.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Payload {

    /**
     * Null if the event is not related to a specific room - global event.
     */
    Integer roomID;

    /**
     * Null if the event is not related to a specific device.
     */
    Integer deviceID;

    public Payload(Integer roomID) {
        this.roomID = roomID;
    }
}
