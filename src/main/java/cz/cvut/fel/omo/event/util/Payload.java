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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer roomID;
        private Integer deviceID;

        public Builder roomID(Integer roomID) {
            this.roomID = roomID;
            return this;
        }

        public Builder deviceID(Integer deviceID) {
            this.deviceID = deviceID;
            return this;
        }

        public Payload build() {
            return new Payload(roomID, deviceID);
        }
    }
}
