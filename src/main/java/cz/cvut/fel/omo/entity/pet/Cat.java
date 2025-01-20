package cz.cvut.fel.omo.entity.pet;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.entity.person.*;

public class Cat extends Pet {
    public Cat(String name, int age, int roomID) {
        super(name, age, roomID);
    }

    @Override
    public String accept(PetVisitor visitor) {return visitor.visitCat(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Cat " + this.name + " purrs contentedly as Mom " + mom.getName() + " gently strokes its fur.";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Cat " + this.name + " brushes past Dad " + dad.getName() + "'s legs, looking for attention.";
    }

    @Override
    public String visitSon(Son son) {
        return "Cat " + this.name + " gives Son " + son.getName() + " a curious look before darting off to a quiet corner.";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Cat " + this.name + " lets Daughter " + daughter.getName() + " pick it up briefly before wriggling free.";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Cat " + this.name + " naps peacefully near Grandma " + grandma.getName() + "'s rocking chair.";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Cat " + this.name + " climbs onto Grandpa " + grandpa.getName() + "'s lap and curls up, purring softly.";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Cat " + this.name + " playfully bats at Dog " + dog.getName() + "'s nose, then leaps to a high perch.";
    }

    @Override
    public String visitCat(Cat cat) {
        if (this.equals(cat)) {
            return "Cat " + this.name + " cannot interact with itself.";
        }
        return "Cat " + this.name + " meows at Cat " + cat.getName() + ", staring with mild curiosity.";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Cat " + this.name + " crouches low, watching Hamster " + hamster.getName() + " with keen, focused eyes.";
    }

    @Override
    public String visitSkis(Skis skis) {
        if (skis.isAvailable()) {
            skis.setAvailable(false);
            return "Cat " + this.name + " sits regally on the " + skis.getColor() + " skis, claiming them as its throne.";
        } else {
            return "Dog " + this.name + " cannot currently interact with " + skis.getColor() + " skis.";
        }
    }

    @Override
    public String visitWeights(Weights weights) {
        if (weights.isAvailable()) {
            weights.setAvailable(false);
            return "Cat " + this.name + " curls up on the weights, making them its cozy resting spot.";
        } else {
            return "Cat " + this.name + " cannot currently interact with weights.";
        }
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        if (bicycle.isAvailable()) {
            bicycle.setAvailable(false);
            return "Cat " + this.name + " perches elegantly in the basket of the " + bicycle.getColor() + " bicycle, surveying the room.";
        } else {
            return "Cat " + this.name + " cannot currently interact with " + bicycle.getColor() + " bicycle.";
        }
    }

    @Override
    public String visitCar(Car car) {
        if (car.isAvailable()) {
            car.setAvailable(false);
            return "Cat " + this.name + " hides beneath the " + car.getColor() + " car, watching the world quietly from the shadows.";
        } else {
            return "Cat " + this.name + " cannot currently interact with " + car.getColor() + " car.";
        }
    }

    @Override
    public String toString() {
        return "Cat " + name + " (" + age + ")";
    }
}
