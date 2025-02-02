package cz.cvut.fel.omo.device.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the documentation for a device, including its model, manufacturer, manual, and warranty information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDocumentation {

    private String model;
    private String manufacturer;
    private String manualContent;
    private Boolean isFixable;
    private String warrantyCertificate;

    @Override
    public String toString() {
        return "DeviceDocumentation{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", manualContent='" + manualContent + '\'' +
                ", isFixable=" + isFixable +
                ", warrantyCertificate='" + warrantyCertificate + '\'' +
                '}';
    }
}
