package cz.cvut.fel.omo.activity.equipment;

/**
 * Visitor pattern interface for sport equipment.
 */
public interface SportEquipmentVisitor {
    String visitSkis(Skis skis);

    String visitWeights(Weights weights);
}
