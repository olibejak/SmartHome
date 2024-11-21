package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.state.DeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.UserManual;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.Getter;

@Getter
public class Window extends Device {

    private boolean hasOpenedCurtain;
    private boolean isOpen;

    public Window(GlobalLogger logger, DeviceState state, UserManual manual, boolean isEssential, boolean isBroken,
                  String warrantyCertificate, Consumption consumption, int durability) {
        super(logger, state, manual, isEssential, isBroken, warrantyCertificate, consumption, durability);
        this.hasOpenedCurtain = false;
        this.isOpen = false;
    }

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
}
