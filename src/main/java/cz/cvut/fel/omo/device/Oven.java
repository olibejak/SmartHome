package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.BobTheBuilder.DTO.type.DeviceType;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.util.DeviceDocumentationLoader;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Oven extends Device{

    private RangeSettingType setting;
    private double maxTemperature;
    private double currentTemperature;

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitOven(this);
    }

    public void setTemperature(int temperature) {
        if (temperature < 0 || temperature > maxTemperature) {
            logger.info(this + " :Temperature " + temperature + " out of range 0 - " + maxTemperature);
            return;
        }
        this.currentTemperature = temperature;
        logger.info(this + " :Setting temperature to " + temperature + "°C");
    }

    public void setSetting(RangeSettingType setting) {
        this.setting = setting;
        logger.info(this + " :Setting to " + setting);
    }

    @Override
    protected DeviceDocumentation loadDocumentation() {
        return DeviceDocumentationLoader.getDocumentation(DeviceType.OVEN);
    }

    @Override
    public String toString() {
        return "Range " + id;
    }

    public enum RangeSettingType {
        BAKE, BROIL, CONVECTION, DEFROST, WARM,
    }
}
