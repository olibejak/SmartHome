package cz.cvut.fel.omo.logger;

import lombok.Setter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class GlobalLogger {

    @Setter
    private static GlobalLogger instance;

    private final Logger logger;

    private GlobalLogger() {
        this.logger = LogManager.getLogger();
    }

    public static GlobalLogger getInstance() {
        if (instance == null) {
            setInstance(new GlobalLogger());
        }
        return GlobalLogger.instance;
    }

    public void setLevel(String level) {
        Configurator.setLevel(logger.getName(), Level.getLevel(level));
    }

    public void info(String message) {
        logger.info(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

}
