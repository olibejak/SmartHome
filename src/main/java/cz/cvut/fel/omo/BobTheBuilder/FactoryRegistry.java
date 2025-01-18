package cz.cvut.fel.omo.BobTheBuilder;

/**
 * Factory registry for creating objects.
 * @param <T> type of the object
 * @param <D> type of the DTO
 */
public interface FactoryRegistry<T, D> {

    /**
     * Creates an object from a DTO
     * @param dto DTO of the object
     * @param roomId ID of the room
     * @return object
     */
    T createObject(D dto, int roomId);
}
