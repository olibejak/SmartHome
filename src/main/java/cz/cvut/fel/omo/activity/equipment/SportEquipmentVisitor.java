package cz.cvut.fel.omo.activity.equipment;

/**
 * Defines the Visitor pattern for different types of sport equipment.
 * This interface allows implementing classes to define interactions with specific sport equipment.
 */
public interface SportEquipmentVisitor {
    /**
     * Defines behavior for interacting with {@link Skis}.
     *
     * @param skis The skis instance being visited.
     * @return A string describing the interaction.
     */
    String visitSkis(Skis skis);

    /**
     * Defines behavior for interacting with {@link Weights}.
     *
     * @param weights The weights instance being visited.
     * @return A string describing the interaction.
     */
    String visitWeights(Weights weights);
}
