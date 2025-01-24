package cz.cvut.fel.omo.event.util;

import cz.cvut.fel.omo.device.Device;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

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
    UUID device;

    public Payload(Integer roomID) {
        this.roomID = roomID;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer roomID;
        private UUID deviceID;

        public Builder roomID(Integer roomID) {
            this.roomID = roomID;
            return this;
        }

        public Builder deviceID(UUID deviceID) {
            this.deviceID = deviceID;
            return this;
        }

        public Payload build() {
            return new Payload(roomID, deviceID);
        }
    }
}
