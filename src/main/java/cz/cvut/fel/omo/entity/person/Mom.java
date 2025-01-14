package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;

public class Mom extends Person {
    public Mom(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID, hasDriversLicense);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitMom(this);}


    @Override
    public String visitMom(Mom mom) {
        if (this.equals(mom)) {
            return "Mom cannot interact with herself";
        }
        return "Mom tells hi to other Mom";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Mom shares a smile with Dad";
    }

    @Override
    public String visitSon(Son son) {
        return "Mom gives Son a gentle hug";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Mom compliments Daughter's creative idea";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Mom asks Grandma about her favorite memories";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Mom listens to Grandpa's wise advice";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Mom pets the Dog lovingly";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Mom admires the Cat's graceful movements";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Mom watches the Hamster run on its wheel";
    }

    @Override
    public String visitSkis(Skis skis) {
        skis.setAvailable(false);
        return "Mom gracefully glides down the slope on the skis";
    }

    @Override
    public String visitWeights(Weights weights) {
        weights.setAvailable(false);
        return "Mom lifts the weights with perfect form, focusing on her fitness";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        bicycle.setAvailable(false);
        return "Mom takes the bicycle for a relaxing ride through the park";
    }

    @Override
    public String visitCar(Car car) {
        if (this.hasDriversLicense) {
            car.setAvailable(false);
            return "Mom drives the car to run errands";
        }
        return "Mom does not have drivers license";
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
