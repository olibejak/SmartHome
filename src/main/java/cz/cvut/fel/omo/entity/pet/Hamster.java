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
        return "Hamster squeaks softly as Mom approaches";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Hamster scurries around its cage as Dad watches";
    }

    @Override
    public String visitSon(Son son) {
        return "Hamster takes a treat from Son's hand";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Hamster climbs onto Daughter's palm";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Hamster peers out of its tiny house at Grandma";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Hamster spins on its wheel while Grandpa chuckles";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Hamster stays still as the Dog sniffs the cage";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Hamster hides as the Cat watches intently";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        if (this.equals(hamster)) {
            return "Hamster cannot interact with itself";
        }
        return "Hamster looks at other Hamster";
    }
}
