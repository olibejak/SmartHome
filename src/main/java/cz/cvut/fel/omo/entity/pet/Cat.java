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
        return "Cat purrs contentedly at Mom's touch";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Cat brushes past Dad's legs";
    }

    @Override
    public String visitSon(Son son) {
        return "Cat gives Son a curious look before running off";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Cat lets Daughter pick it up briefly";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Cat naps peacefully near Grandma";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Cat climbs onto Grandpa's lap and settles down";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Cat bats at the Dog's nose playfully";
    }

    @Override
    public String visitCat(Cat cat) {
        if (this.equals(cat)) {
            return "Cat cannot interact with itself";
        }
        return "Cat meows at other Cat";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Cat watches the Hamster with keen eyes";
    }

    @Override
    public String visitSkis(Skis skis) {
        skis.setAvailable(false);
        return "The cat sits on the skis, claiming them as its new throne";
    }

    @Override
    public String visitWeights(Weights weights) {
        weights.setAvailable(false);
        return "The cat tries to nap on the weights, ignoring the activity around it";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        bicycle.setAvailable(false);
        return "The cat perches in the bicycle basket";
    }

    @Override
    public String visitCar(Car car) {
        car.setAvailable(false);
        return "The cat hides below the car";
    }
}
