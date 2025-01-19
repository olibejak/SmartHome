package cz.cvut.fel.omo.activity.vehicle;

import lombok.Getter;

@Getter
public enum EngineType {
    PETROL("Petrol"),
    DIESEL("Diesel"),
    ELECTRIC("Electric");

    private final String displayName;

    EngineType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
