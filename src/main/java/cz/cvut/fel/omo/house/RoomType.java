package cz.cvut.fel.omo.house;

import lombok.Getter;

@Getter
public enum RoomType {
    KITCHEN("Kitchen"),
    BEDROOM("Bedroom"),
    GARAGE("Garage"),
    LIVING_ROOM("Living Room"),
    TOILET("Toilet"),
    BATHROOM("Bathroom"),
    OUTSIDE("Outside");

    private final String displayName;

    RoomType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
