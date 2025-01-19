package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;
import cz.cvut.fel.omo.utils.RandomUtils;

public class Son extends Person {
    public Son(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID, hasDriversLicense);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitSon(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Son " + this.name + " excitedly tells Mom " + mom.getName() + " about his latest adventure in the backyard.";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Son " + this.name + " challenges Dad " + dad.getName() + " to a playful game of tag.";
    }

    @Override
    public String visitSon(Son son) {
        if (this.equals(son)) {
            return "Son " + this.name + " cannot interact with himself.";
        }
        return "Son " + this.name + " greets his buddy Son " + son.getName() + " with a friendly high-five.";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Son " + this.name + " teases Daughter " + daughter.getName() + " with a mischievous grin and runs away.";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        return "Son " + this.name + " proudly shows Grandma " + grandma.getName() + " his latest drawing of a rocket ship.";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Son " + this.name + " asks Grandpa " + grandpa.getName() + " to share one of his favorite childhood stories.";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Son " + this.name + " plays a lively game of fetch with Dog " + dog.getName() + ", laughing as they race for the ball.";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Son " + this.name + " chases Cat " + cat.getName() + " around the room until the Cat leaps to a high perch.";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Son " + this.name + " carefully feeds Hamster " + hamster.getName() + " a small snack and watches it nibble away.";
    }

    @Override
    public String visitSkis(Skis skis) {
        skis.setAvailable(false);
        return "Son " + this.name + " attempts a daring jump on the " + skis.getColor() + " skis, cheering as he lands safely.";
    }

    @Override
    public String visitWeights(Weights weights) {
        weights.setAvailable(false);
        return "Son " + this.name + " tests the weights, imagining himself as the strongest person in the family.";
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        bicycle.setAvailable(false);
        return "Son " + this.name + " pops wheelies and shows off cool tricks on the " + bicycle.getColor() + " bicycle.";
    }

    @Override
    public String visitCar(Car car) {
        if (this.hasDriversLicense) {
            car.setAvailable(false);
            return "Son " + this.name + " drives the " + car.getColor() + " car to the store to pick up some snacks.";
        }
        return "Son " + this.name + " does not have a driver's license and cannot drive the car.";
    }


    @Override
    public String visitDishwasher(Dishwasher dishwasher) {
        if (dishwasher.getCurrentLoad() < dishwasher.getMaxLoad()) {
            int availableSpace = (int) (dishwasher.getMaxLoad() - dishwasher.getCurrentLoad());
            int maxDishes = Math.min(2, availableSpace);
            dishwasher.addItem("Glass", RandomUtils.getRandomNumber(1, maxDishes));
            return "Son " + this.name + " added glasses to Dishwasher " + dishwasher.getId();
        }
        else {
            return "Son " + this.name + " ignores full Dishwasher " + dishwasher.getId();
        }
    }

    @Override
    public String visitFridge(Fridge fridge) {
        if (!fridge.isEmpty()) {
            String snack = fridge.getFirstItem();
            return "Son " + this.name + " got a " + snack + " from Fridge " + fridge.getId();
        }
        return "Son " + this.name + " could not get anything from empty Fridge " + fridge.getId();
    }

    @Override
    public String visitOven(Oven oven) {
        return "Son " + this.name + " does not know how to operate Oven " + oven.getId();
    }

    @Override
    public String visitRecordPlayer(RecordPlayer recordPlayer) {
        recordPlayer.insertRecord("The Fox", "Ylvis");
        recordPlayer.turnOn();
        return "Son " + this.name + " turned on the Record Player " + recordPlayer.getId();
    }

    @Override
    public String visitTelevision(Television television) {
        if (RandomUtils.isWithinPercentage(80)) {
            television.setChannel(3);
            television.turnOn();
            return "Son " + this.name + " turned on the TV " + television.getId();
        } else {
            television.turnOff();
            return "Son " + this.name + " turned off the TV " + television.getId();
        }
    }

    @Override
    public String visitThermostat(Thermostat thermostat) {
        thermostat.setTemperature(thermostat.getCurrentTemperature() - 1);
        thermostat.turnOn();
        return "Son " + this.name + " tries to turn down the temperature on Thermostat " + thermostat.getId();
    }

    @Override
    public String visitWashingMachine(WashingMachine washingMachine) {
        if (washingMachine.getCurrentLoad() < washingMachine.getMaxLoad()) {
            int availableSpace = (int) (washingMachine.getMaxLoad() - washingMachine.getCurrentLoad());
            int maxClothes = Math.min(2, availableSpace);
            washingMachine.addItem("Socks", RandomUtils.getRandomNumber(1, maxClothes));
            return "Son " + this.name + " added socks to Washing Machine " + washingMachine.getId();
        }
        else {
            return "Son " + this.name + " ignores full Washing Machine " + washingMachine.getId();
        }
    }

    @Override
    public String visitWindow(Window window) {
        if (RandomUtils.isWithinPercentage(50)) {
            window.openCurtain();
            window.open();
            return "Son " + this.name + " opened Window " + window.getId();
        }
        window.close();
        window.closeCurtain();
        return "Son " + this.name + " closed the curtains of closed Window " + window.getId();
    }
}
