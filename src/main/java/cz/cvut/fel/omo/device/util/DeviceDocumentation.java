package cz.cvut.fel.omo.device.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeviceDocumentation {

    private String model;
    private String manufacturer;
    private String manualContent;
    private boolean isFixable;
    private String warrantyCertificate;
}
