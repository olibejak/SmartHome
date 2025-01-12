package cz.cvut.fel.omo.entity.pet;

import cz.cvut.fel.omo.entity.person.*;

public class Dog extends Pet {
    public Dog(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PetVisitor visitor) {return visitor.visitDog(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Dog wags its tail happily at Mom";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Dog barks excitedly at Dad";
    }

    @Override
    public String visitSon(Son son) {
        return "Dog jumps on Son playfully";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Dog follows Daughter around eagerly";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Dog rests its head on Grandma's lap";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Dog brings a ball to Grandpa";
    }

    @Override
    public String visitDog(Dog dog) {
        if (this.equals(dog)) {
            return "Dog cannot interact with itself";
        }
        return "Dog barks at other Dog";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Dog sniffs the Cat curiously";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Dog watches the Hamster with great interest";
    }
}
