package cz.cvut.fel.omo.event.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Payload {

    Integer roomID;
    Integer deviceID;

    public Payload(Integer roomID) {
        this.roomID = roomID;
    }


}
