package cz.cvut.fel.omo.device;

public record StorageItem(String name, double load) {

    @Override
    public String toString() {
        return "name: " + name + ", load: " + load;
    }
}
