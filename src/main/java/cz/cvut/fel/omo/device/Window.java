package cz.cvut.fel.omo.device;

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
}
