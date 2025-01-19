package cz.cvut.fel.omo.entity.pet;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.entity.person.*;

public class Hamster extends Pet {
    public Hamster(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PetVisitor visitor) {return visitor.visitHamster(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Hamster " + this.name + " squeaks softly, peeking out of its tiny house as Mom " + mom.getName() + " approaches.";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Hamster " + this.name + " scurries excitedly around its cage, catching Dad " + dad.getName() + "'s attention.";
    }

    @Override
    public String visitSon(Son son) {
        return "Hamster " + this.name + " eagerly takes a treat from Son " + son.getName() + "'s hand and nibbles on it.";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Hamster " + this.name + " climbs carefully onto Daughter " + daughter.getName() + "'s palm, twitching its whiskers.";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Hamster " + this.name + " peers curiously out of its tiny house at Grandma " + grandma.getName() + ".";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Hamster " + this.name + " spins energetically on its wheel while Grandpa " + grandpa.getName() + " chuckles at its antics.";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Hamster " + this.name + " freezes in place as Dog " + dog.getName() + " sniffs around its cage curiously.";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Hamster " + this.name + " hides nervously in its tiny house as Cat " + cat.getName() + " watches intently.";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        if (this.equals(hamster)) {
            return "Hamster " + this.name + " cannot interact with itself.";
        }
        return "Hamster " + this.name + " sniffs curiously at the other Hamster " + hamster.getName() + " through the cage.";
    }

    @Override
    public String visitSkis(Skis skis) {
        return "Hamster " + this.name + " cannot interact with the skis.";
    }

    @Override
    public String visitWeights(Weights weights) {
        return "Hamster " + this.name + " cannot interact with the weights.";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        return "Hamster " + this.name + " cannot interact with the bicycle.";
    }

    @Override
    public String visitCar(Car car) {
        return "Hamster " + this.name + " cannot interact with the car.";
    }

    @Override
    public String toString() {
        return "Hamster " + name + ", " + age + " in Room #" + roomID;
    }
}
