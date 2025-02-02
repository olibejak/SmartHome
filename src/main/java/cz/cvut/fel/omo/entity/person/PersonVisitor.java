package cz.cvut.fel.omo.entity.person;


/**
 * Defines the Visitor pattern for different types of {@link Person} entities.
 * This interface allows implementing classes to define interactions with specific family members.
 * It is part of the Visitor pattern, which enables dynamic dispatch based on the actual type of the person.
 */
public interface PersonVisitor {
    /**
     * Defines behavior for interacting with a {@link Mom}.
     *
     * @param mom The mom instance being visited.
     * @return A string describing the interaction.
     */
    String visitMom(Mom mom);

    /**
     * Defines behavior for interacting with a {@link Dad}.
     *
     * @param dad The dad instance being visited.
     * @return A string describing the interaction.
     */
    String visitDad(Dad dad);

    /**
     * Defines behavior for interacting with a {@link Son}.
     *
     * @param son The son instance being visited.
     * @return A string describing the interaction.
     */
    String visitSon(Son son);

    /**
     * Defines behavior for interacting with a {@link Daughter}.
     *
     * @param daughter The daughter instance being visited.
     * @return A string describing the interaction.
     */
    String visitDaughter(Daughter daughter);

    /**
     * Defines behavior for interacting with a {@link Grandma}.
     *
     * @param grandma The grandma instance being visited.
     * @return A string describing the interaction.
     */
    String visitGrandma(Grandma grandma);

    /**
     * Defines behavior for interacting with a {@link Grandpa}.
     *
     * @param grandpa The grandpa instance being visited.
     * @return A string describing the interaction.
     */
    String visitGrandpa(Grandpa grandpa);
}
