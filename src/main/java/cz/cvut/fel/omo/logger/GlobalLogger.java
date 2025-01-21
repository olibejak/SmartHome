package cz.cvut.fel.omo.logger;

import lombok.Setter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * Singleton logger * config is located in resources/log4j2.xml
 */
public final class GlobalLogger {

    @Setter
    private static GlobalLogger instance;

    private final Logger logger;

    /**
     * Set log4j2 as logger
     */
    private GlobalLogger() {
        this.logger = LogManager.getLogger();
    }

    /**
     * Singleton get instance
     * Not thread safe
     * @return GlobalLogger instance
     */
    public static GlobalLogger getInstance() {
        if (instance == null) {
            setInstance(new GlobalLogger());
        }
        return GlobalLogger.instance;
    }

    /**
     * Set logger level
     * @param level string value
     */
    public void setLevel(String level) {
        Configurator.setLevel(logger.getName(), Level.getLevel(level));
    }

    /**
     * Info log
     * @param message message to log
     */
    public void info(String message) {
        logger.info(message);
    }

    /**
     * Error log
     * @param message message to log
     */
    public void error(String message) {
        logger.error(message);
    }

    /**
     * Debug log
     * @param message message to log
     */
    public void debug(String message) {
        logger.debug(message);
    }

    /**
     * Warn log
     * @param message message to log
     */
    public void warn(String message) {
        logger.warn(message);
    }
}
