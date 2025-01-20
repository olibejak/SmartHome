package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;
import cz.cvut.fel.omo.utils.RandomUtils;

public class Dad extends Person {
    public Dad(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID, hasDriversLicense);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitDad(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Dad laughs with Mom " + mom.getName() + " about a funny memory they share.";
    }

    @Override
    public String visitDad(Dad dad) {
        if (this.equals(dad)) {
            return "Dad " + this.name + " cannot interact with himself.";
        }
        return "Dad " + this.name + " greets Dad " + dad.getName() + " with a firm handshake.";
    }

    @Override
    public String visitSon(Son son) {
        return "Dad " + this.name + " teaches Son " + son.getName() + " how to throw a perfect curveball.";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Dad " + this.name + " praises Daughter " + daughter.getName() + " for her amazing school project.";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Dad " + this.name + " helps Grandma " + grandma.getName() + " set up her new favorite TV show.";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Dad " + this.name + " and Grandpa " + grandpa.getName() + " chat about their favorite old-time stories.";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Dad " + this.name + " throws a ball for Dog " + dog.getName() + " to fetch.";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Dad " + this.name + " gently scratches behind Cat " + cat.getName() + "'s ears while it purrs.";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Dad " + this.name + " watches Hamster " + hamster.getName() + " sprint on its wheel with amusement.";
    }

    @Override
    public String visitSkis(Skis skis) {
        if (skis.isAvailable()) {
            skis.setAvailable(false);
            return "Dad " + this.name + " carves sharp turns down the slope on the " + skis.getColor() + " skis.";
        } else {
            return "Dad " + this.name + " cannot currently interact with " + skis.getColor() + " skis.";
        }
    }

    @Override
    public String visitWeights(Weights weights) {
        if (weights.isAvailable()) {
            weights.setAvailable(false);
            return "Dad " + this.name + " challenges himself to lift the heavy weights, pushing his limits.";
        } else {
            return "Dad " + this.name + " cannot currently interact with weights.";
        }
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        if (bicycle.isAvailable()) {
            bicycle.setAvailable(false);
            return "Dad " + this.name + " rides the " + bicycle.getColor() + " bicycle at full speed, feeling the wind rush past.";
        } else {
            return "Dad " + this.name + " cannot currently interact with " + bicycle.getColor() + " bicycle.";
        }
    }

    @Override
    public String visitCar(Car car) {
        if (car.isAvailable()) {
            if (this.hasDriversLicense) {
                car.setAvailable(false);
                return "Dad " + this.name + " takes the " + car.getColor() + " car for a scenic drive through the countryside.";
            }
            return "Dad " + this.name + " cannot drive the car because he doesn't have a driver's license.";
        } else {
            return "Dad " + this.name + " cannot currently interact with " + car.getColor() + " car.";
        }
    }


    @Override
    public String visitDishwasher(Dishwasher dishwasher) {
        if (dishwasher.getCurrentLoad() < dishwasher.getMaxLoad()) {
            int availableSpace = (int) (dishwasher.getMaxLoad() - dishwasher.getCurrentLoad());
            int maxDishes = Math.min(3, availableSpace);
            dishwasher.addItem("Plate", RandomUtils.getRandomNumber(1, maxDishes));
            return "Dad " + this.name + " added plates to " + dishwasher;
        }
        else {
            return "Dad " + this.name + " ignores full " + dishwasher;
        }
    }

    @Override
    public String visitFridge(Fridge fridge) {
        if (!fridge.isEmpty()) {
            String snack = fridge.removeFirstItem();
            return "Dad " + this.name + " got a " + snack + " from " + fridge;
        }
        return "Dad " + this.name + " could not get anything from empty " + fridge;
    }

    @Override
    public String visitOven(Oven oven) {
        oven.setSetting(Oven.RangeSettingType.BROIL);
        oven.setTemperature(220);
        oven.turnOn();
        return "Dad " + this.name + " started broiling Beef in " + oven;
    }

    @Override
    public String visitRecordPlayer(RecordPlayer recordPlayer) {
        recordPlayer.insertRecord("Africa", "Toto");
        recordPlayer.turnOn();
        return "Dad " + this.name + " turned on the " + recordPlayer;
    }

    @Override
    public String visitTelevision(Television television) {
        if (RandomUtils.isWithinPercentage(90)) {
            television.turnOn();
            television.setChannel(2);
            return "Dad " + this.name + " turned on the " + television + " and switched to channel 2";
        } else {
            television.turnOff();
            return "Dad " + this.name + " turned off the " + television;
        }
    }

    @Override
    public String visitThermostat(Thermostat thermostat) {
        thermostat.turnOn();
        thermostat.setTemperature(thermostat.getCurrentTemperature() - 2);
        return "Dad " + this.name + " tries to turn down the temperature on " + thermostat;
    }

    @Override
    public String visitWashingMachine(WashingMachine washingMachine) {
        if (washingMachine.getCurrentLoad() < washingMachine.getMaxLoad()) {
            int availableSpace = (int) (washingMachine.getMaxLoad() - washingMachine.getCurrentLoad());
            int maxClothes = Math.min(3, availableSpace);
            washingMachine.addItem("Pants", RandomUtils.getRandomNumber(1, maxClothes));
            return "Dad " + this.name + " added pants to " + washingMachine;
        }
        else {
            return "Dad " + this.name + " ignores full " + washingMachine;
        }
    }

    @Override
    public String visitWindow(Window window) {
        if (RandomUtils.isWithinPercentage(40)) {
            window.openCurtain();
            window.open();
            return "Dad " + this.name + " opened Window " + window.getId();
        }
        window.close();
        window.closeCurtain();
        return "Dad " + this.name + " closed the curtains of closed Window " + window.getId();
    }

    @Override
    public String toString() {
        return "Dad " + name + " (" + age + ")";
    }
}
