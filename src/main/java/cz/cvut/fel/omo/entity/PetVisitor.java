package cz.cvut.fel.omo.entity;

public interface PetVisitor {
    String visitDog(Dog dog);

    // TODO visitCat,...
}
