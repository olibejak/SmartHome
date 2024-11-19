package cz.cvut.fel.omo.device;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserManual {

    private String deviceID;
    private String model;
    private String manufacturer;
    private int standardDurability;
    private String manualContent;
    private boolean isFixable;
}
