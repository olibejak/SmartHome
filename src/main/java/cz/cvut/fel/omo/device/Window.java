package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.DeviceDocumentation;
import cz.cvut.fel.omo.device.visitor.DeviceVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Window extends Device {

    private boolean hasOpenedCurtain;
    private boolean isOpen;

    public void open() {
        if (!isOpen) {
            isOpen = true;
            logger.info(this.toString() + " window is opened");
        }
        logger.info(this.toString() + " window is already opened");
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            logger.info(this.toString() + " window is closed");
        }
        logger.info(this.toString() + " window is already closed");
    }

    public void openCurtain() {
        if (!hasOpenedCurtain) {
            hasOpenedCurtain = true;
            logger.info(this.toString() + " curtain is opened");
        }
        logger.info(this.toString() + " curtain is already opened");
    }

    public void closeCurtain() {
        if (hasOpenedCurtain) {
            hasOpenedCurtain = false;
            logger.info(this.toString() + " curtain is closed");
        }
        logger.info(this.toString() + " curtain is already closed");
    }

    @Override
    public String toString() {
        return "Window " + id;
    }

    @Override
    public String accept(DeviceVisitor visitor) {
        return visitor.visitWindow(this);
    }
}
