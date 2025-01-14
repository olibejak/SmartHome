package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;

public class Grandpa extends Person {
    public Grandpa(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID, hasDriversLicense);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitGrandpa(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Grandpa praises Mom for her dedication";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Grandpa shares wisdom with Dad over a casual chat";
    }

    @Override
    public String visitSon(Son son) {
        return "Grandpa teaches Son how to whistle";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Grandpa tells Daughter an exciting tale";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Grandpa compliments Grandma's kindness";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        if (this.equals(grandpa)) {
            return "Grandpa cannot interact with himself";
        }
        return "Grandpa tells hi to other Grandpa";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Grandpa calls the Dog for a playful pat";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Grandpa observes the Cat's curious behavior";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Grandpa peers into the Hamster's cage with interest";
    }

    @Override
    public String visitSkis(Skis skis) {
        if (this.age > 80) {
            return "Grandpa is too old to use the skis";
        }
        skis.setAvailable(false);
        return "Grandpa checks the ski bindings for safety before using them";
    }

    @Override
    public String visitWeights(Weights weights) {
        if (this.age > 80) {
            return "Grandpa is too old to use the weights";
        }
        weights.setAvailable(false);
        return "Grandpa demonstrates his old-school lifting techniques with the weights";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        if (this.age > 80) {
            return "Grandpa is too old to use the bicycle";
        }
        bicycle.setAvailable(false);
        return "Grandpa repairs and tunes the bicycle before taking it for a spin";
    }

    @Override
    public String visitCar(Car car) {
        if (this.hasDriversLicense) {
            car.setAvailable(false);
            return "Grandpa checks the car’s oil and tire pressure before driving";
        }
        return "Grandpa does not have drivers license";
    }

    @Override
    public String visitDishwasher(Dishwasher dishwasher) {
        return "";
    }

    @Override
    public String visitFridge(Fridge fridge) {
        return "";
    }

    @Override
    public String visitOven(Oven oven) {
        return "";
    }

    @Override
    public String visitRecordPlayer(RecordPlayer recordPlayer) {
        return "";
    }

    @Override
    public String visitTelevision(Television television) {
        return "";
    }

    @Override
    public String visitThermostat(Thermostat thermostat) {
        return "";
    }

    @Override
    public String visitWashingMachine(WashingMachine washingMachine) {
        return "";
    }

    @Override
    public String visitWindow(Window window) {
        return "";
    }
}
