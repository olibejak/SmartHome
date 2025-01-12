package cz.cvut.fel.omo.entity.pet;

import cz.cvut.fel.omo.entity.pet.Dog;

public interface PetVisitor {
    String visitDog(Dog dog);

    String visitCat(Cat cat);

    String visitHamster(Hamster hamster);
}
