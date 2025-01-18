package cz.cvut.fel.omo.BobTheBuilder;

public interface FactoryRegistry<T, D> {

    T createObject(D dto, int roomId);
}
