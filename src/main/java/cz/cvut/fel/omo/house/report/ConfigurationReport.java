package cz.cvut.fel.omo.house.report;

/**
 * Interface for classes that can report their configuration.
 * Composite design pattern.
 */
public interface ConfigurationReport {

    /**
     * Returns a string representation of the configuration of the object.
     * @return a string representation of the configuration of the object
     */
    String reportConfiguration();
}
