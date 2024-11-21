package cz.cvut.fel.omo.device.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserManual {

    private String deviceID;
    private String model;
    private String manufacturer;
    private int standardDurability;
    private String manualContent;
    private boolean isFixable;
}
