package cz.cvut.fel.omo.activity.equipment;

public interface SportEquipmentVisitor {
    String visitSkis(Skis skis);

    String visitWeights(Weights weights);
}
