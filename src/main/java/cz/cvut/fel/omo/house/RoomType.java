package cz.cvut.fel.omo.house;

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

    /**
     * Gets the human-readable name of the room type.
     * @return The display name of the room.
     */
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
