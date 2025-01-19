package cz.cvut.fel.omo.entity.pet;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.entity.person.*;

public class Dog extends Pet {
    public Dog(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PetVisitor visitor) {return visitor.visitDog(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Dog " + this.name + " wags its tail happily and follows Mom " + mom.getName() + " around the house.";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Dog " + this.name + " barks excitedly and jumps up to greet Dad " + dad.getName() + ".";
    }

    @Override
    public String visitSon(Son son) {
        return "Dog " + this.name + " leaps playfully onto Son " + son.getName() + " and licks his face.";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Dog " + this.name + " eagerly follows Daughter " + daughter.getName() + " everywhere she goes.";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Dog " + this.name + " rests its head gently on Grandma " + grandma.getName() + "'s lap for a comforting pet.";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Dog " + this.name + " happily brings a ball to Grandpa " + grandpa.getName() + " for a game of fetch.";
    }

    @Override
    public String visitDog(Dog dog) {
        if (this.equals(dog)) {
            return "Dog " + this.name + " cannot interact with itself.";
        }
        return "Dog " + this.name + " sniffs and playfully barks at Dog " + dog.getName() + ".";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Dog " + this.name + " curiously sniffs at Cat " + cat.getName() + " but gets ignored.";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Dog " + this.name + " watches Hamster " + hamster.getName() + " with great interest, tilting its head.";
    }

    @Override
    public String visitSkis(Skis skis) {
        return "Dog " + this.name + " accidentally knocks over the " + skis.getColor() + " skis with its wagging tail.";
    }

    @Override
    public String visitWeights(Weights weights) {
        weights.setAvailable(false);
        return "Dog " + this.name + " nudges one of the weights and then rolls it across the floor.";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        return "Dog " + this.name + " barks at the " + bicycle.getColor() + " bicycle, thinking it's a fun new toy.";
    }

    @Override
    public String visitCar(Car car) {
        return "Dog " + this.name + " curls up and takes a nap beside the " + car.getColor() + " car.";
    }

    @Override
    public String toString() {
        return "Dog " + name + ", " + age + " in Room #" + roomID;
    }
}
