package cz.cvut.fel.omo.entity.pet;

/**
 * Defines the Visitor pattern for different types of {@link Pet} entities.
 * This interface allows implementing classes to define interactions with specific pets.
 * It follows the Visitor pattern, enabling type-specific behavior without modifying pet classes.
 */
public interface PetVisitor {
    /**
     * Defines behavior for interacting with a {@link Dog}.
     *
     * @param dog The dog instance being visited.
     * @return A string describing the interaction.
     */
    String visitDog(Dog dog);

    /**
     * Defines behavior for interacting with a {@link Cat}.
     *
     * @param cat The cat instance being visited.
     * @return A string describing the interaction.
     */
    String visitCat(Cat cat);

    /**
     * Defines behavior for interacting with a {@link Hamster}.
     *
     * @param hamster The hamster instance being visited.
     * @return A string describing the interaction.
     */
    String visitHamster(Hamster hamster);
}
