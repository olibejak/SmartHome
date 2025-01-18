package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.utils.RandomUtils;

public class Mom extends Person {
    public Mom(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID, hasDriversLicense);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitMom(this);}


    @Override
    public String visitMom(Mom mom) {
        if (this.equals(mom)) {
            return "Mom " + this.name + " cannot interact with herself.";
        }
        return "Mom " + this.name + " tells hi to other Mom " + mom.getName() + ".";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Mom " + this.name + " shares a smile with Dad " + dad.getName() + ".";
    }

    @Override
    public String visitSon(Son son) {
        return "Mom " + this.name + " gives Son " + son.getName() + " a gentle hug.";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Mom " + this.name + " compliments Daughter " + daughter.getName() + "'s creative idea.";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Mom " + this.name + " asks Grandma " + grandma.getName() + " about her favorite memories.";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Mom " + this.name + " listens to Grandpa " + grandpa.getName() + "'s wise advice.";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Mom " + this.name + " pets the Dog " + dog.getName() + " lovingly.";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Mom " + this.name + " admires the Cat " + cat.getName() + "'s graceful movements.";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Mom " + this.name + " watches the Hamster " + hamster.getName() + " run on its wheel.";
    }

    @Override
    public String visitSkis(Skis skis) {
        skis.setAvailable(false);
        return "Mom " + this.name + " gracefully glides down the slope on the " + skis.getColor() + " skis.";
    }

    @Override
    public String visitWeights(Weights weights) {
        weights.setAvailable(false);
        return "Mom " + this.name + " lifts the weights with perfect form, focusing on her fitness.";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        bicycle.setAvailable(false);
        return "Mom " + this.name + " takes the " + bicycle.getColor() + " bicycle for a relaxing ride through the park.";
    }

    @Override
    public String visitCar(Car car) {
        if (this.hasDriversLicense) {
            car.setAvailable(false);
            return "Mom " + this.name + " drives the " + car.getColor() + " car to run errands.";
        }
        return "Mom " + this.name + " cannot drive the car because she doesn't have a driver's license.";
    }

    @Override
    public String visitDishwasher(Dishwasher dishwasher) {
        if (dishwasher.getCurrentLoad() < dishwasher.getMaxLoad()) {
            int availableSpace = (int) (dishwasher.getMaxLoad() - dishwasher.getCurrentLoad());
            int maxDishes = Math.min(5, availableSpace);
            dishwasher.addItem("Bowl", RandomUtils.getRandomNumber(1, maxDishes));
            return "Mom " + this.name + " added bowls to Dishwasher " + dishwasher.getId();
        }
        else {
            return "Mom " + this.name + " notices full Dishwasher " + dishwasher.getId();
        }
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
        recordPlayer.insertRecord("Mamma Mia", "ABBA");
        recordPlayer.turnOn();
        return "Mom " + this.name + " turned on the Record Player " + recordPlayer.getId();
    }

    @Override
    public String visitTelevision(Television television) {
        if (RandomUtils.isWithinPercentage(70)) {
            television.setChannel(1);
            television.turnOn();
            return "Mom " + this.name + " turned on the TV " + television.getId();
        } else {
            television.turnOff();
            return "Mom " + this.name + " turned off the TV " + television.getId();
        }
    }

    @Override
    public String visitThermostat(Thermostat thermostat) {
        thermostat.setTemperature(thermostat.getCurrentTemperature() + 2);
        thermostat.turnOn();
        return "Mom " + this.name + " tries to turn up the temperature on Thermostat " + thermostat.getId();
    }

    @Override
    public String visitWashingMachine(WashingMachine washingMachine) {
        if (washingMachine.getCurrentLoad() < washingMachine.getMaxLoad()) {
            int availableSpace = (int) (washingMachine.getMaxLoad() - washingMachine.getCurrentLoad());
            int maxClothes = Math.min(5, availableSpace);
            washingMachine.addItem("Shirt", RandomUtils.getRandomNumber(1, maxClothes));
            return "Mom " + this.name + " added shirts to Washing Machine " + washingMachine.getId();
        }
        else {
            return "Mom " + this.name + " notices full Washing Machine " + washingMachine.getId();
        }
    }

    @Override
    public String visitWindow(Window window) {
        return "";
    }
}
