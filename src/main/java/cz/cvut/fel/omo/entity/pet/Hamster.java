package cz.cvut.fel.omo.entity.pet;

import cz.cvut.fel.omo.entity.person.*;

public class Hamster extends Pet {
    public Hamster(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PetVisitor visitor) {return visitor.visitHamster(this);}


    @Override
    public String visitMom(Mom mom) {
        return "";
    }

    @Override
    public String visitDad(Dad dad) {
        return "";
    }

    @Override
    public String visitSon(Son son) {
        return "";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "";
    }

    @Override
    public String visitDog(Dog dog) {
        return "";
    }

    @Override
    public String visitCat(Cat cat) {
        return "";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "";
    }
}
