package cz.cvut.fel.omo.entity.person;

import cz.cvut.fel.omo.activity.equipment.Skis;
import cz.cvut.fel.omo.activity.equipment.Weights;
import cz.cvut.fel.omo.activity.vehicle.Bicycle;
import cz.cvut.fel.omo.activity.vehicle.Car;
import cz.cvut.fel.omo.device.*;
import cz.cvut.fel.omo.entity.pet.*;
import cz.cvut.fel.omo.utils.RandomUtils;

public class Grandma extends Person {
    public Grandma(String name, int age, int roomID, boolean hasDriversLicense) {
        super(name, age, roomID, hasDriversLicense);
    }

    @Override
    public String accept(PersonVisitor visitor) {return visitor.visitGrandma(this);}


    @Override
    public String visitMom(Mom mom) {
        return "Grandma " + this.name + " warmly thanks Mom " + mom.getName() + " for keeping the house lively and cheerful.";
    }

    @Override
    public String visitDad(Dad dad) {
        return "Grandma " + this.name + " shares a heartwarming story with Dad " + dad.getName() + " from her younger days.";
    }

    @Override
    public String visitSon(Son son) {
        return "Grandma " + this.name + " lovingly knits a special sweater for Son " + son.getName() + ".";
    }

    @Override
    public String visitDaughter(Daughter daughter) {
        return "Grandma " + this.name + " admires Daughter " + daughter.getName() + "'s boundless enthusiasm and energy.";
    }

    @Override
    public String visitGrandma(Grandma grandma) {
        if (this.equals(grandma)) {
            return "Grandma " + this.name + " cannot interact with herself.";
        }
        return "Grandma " + this.name + " exchanges warm greetings with Grandma " + grandma.getName() + ".";
    }

    @Override
    public String visitGrandpa(Grandpa grandpa) {
        return "Grandma " + this.name + " reminisces with Grandpa " + grandpa.getName() + " about their cherished memories together.";
    }

    @Override
    public String visitDog(Dog dog) {
        return "Grandma " + this.name + " gently scratches Dog " + dog.getName() + " behind its ears while it wags its tail.";
    }

    @Override
    public String visitCat(Cat cat) {
        return "Grandma " + this.name + " smiles as Cat " + cat.getName() + " curls up on her lap, purring contentedly.";
    }

    @Override
    public String visitHamster(Hamster hamster) {
        return "Grandma " + this.name + " chuckles at Hamster " + hamster.getName() + "'s amusing antics in its cage.";
    }

    @Override
    public String visitSkis(Skis skis) {
        if (skis.isAvailable()) {
            if (this.age > 80) {
                return "Grandma " + this.name + " reminisces about her adventurous youth while holding the " + skis.getColor() + " skis.";
            }
            skis.setAvailable(false);
            return "Grandma " + this.name + " carefully glides down the slope on the " + skis.getColor() + " skis, enjoying the fresh air.";
        } else {
            return "Grandma " + this.name + " cannot currently interact with " + skis.getColor() + " skis.";
        }
    }

    @Override
    public String visitWeights(Weights weights) {
        if (weights.isAvailable()) {
            weights.setAvailable(false);
            return "Grandma " + this.name + " selects the lightest weights for a gentle and mindful exercise session.";
        } else {
            return "Grandma " + this.name + " cannot currently interact with weights.";
        }
    }

    @Override
    public String visitBicycle(Bicycle bicycle) {
        if (bicycle.isAvailable()) {
            bicycle.setAvailable(false);
            return "Grandma " + this.name + " enjoys a slow, peaceful ride on the " + bicycle.getColor() + " bicycle through the garden path.";
        } else {
            return "Grandma " + this.name + " cannot currently interact with " + bicycle.getColor() + " bicycle.";
        }
    }

    @Override
    public String visitCar(Car car) {
        if (car.isAvailable()) {
            if (this.hasDriversLicense) {
                car.setAvailable(false);
                return "Grandma " + this.name + " adjusts the seat and mirrors before taking the " + car.getColor() + " car for a short, comfortable drive.";
            }
            return "Grandma " + this.name + " does not have a driver's license and cannot drive the car.";
        } else {
            return "Grandma " + this.name + " cannot currently interact with " + car.getColor() + " car.";
        }
    }

    @Override
    public boolean reactToBrokenDevice(Device device) {
        logger.info("Grandma " + this.name + " is not able to fix " + device);
        return false;
    }

    @Override
    public String visitDishwasher(Dishwasher dishwasher) {
        if (dishwasher.getCurrentLoad() < dishwasher.getMaxLoad()) {
            int availableSpace = (int) (dishwasher.getMaxLoad() - dishwasher.getCurrentLoad());
            int maxDishes = Math.min(2, availableSpace);
            dishwasher.addItem("Plate", RandomUtils.getRandomNumber(1, maxDishes));
            return "Grandma " + this.name + " added plates to " + dishwasher;
        }
        else {
            return "Grandma " + this.name + " notices full " + dishwasher;
        }
    }

    @Override
    public String visitFridge(Fridge fridge) {
        if (!fridge.isEmpty()) {
            String snack = fridge.removeFirstItem();
            return "Grandma " + this.name + " got a " + snack + " from " + fridge;
        }
        return "Grandma " + this.name + " could not get anything from empty " + fridge;
    }

    @Override
    public String visitOven(Oven oven) {
        oven.setSetting(Oven.RangeSettingType.DEFROST);
        oven.setTemperature(180);
        oven.turnOn();
        return "Grandma " + this.name + " started defrosting a Chicken in " + oven;
    }

    @Override
    public String visitRecordPlayer(RecordPlayer recordPlayer) {
        recordPlayer.turnOff();
        return "Grandma " + this.name + " turned off the " + recordPlayer;
    }

    @Override
    public String visitTelevision(Television television) {
        if (RandomUtils.isWithinPercentage(50)) {
            television.turnOn();
            television.setChannel(5);
            return "Grandma " + this.name + " turned on the " + television + " and switched to channel 5";
        } else {
            television.turnOff();
            return "Grandma " + this.name + " turned off the " + television;
        }
    }

    @Override
    public String visitThermostat(Thermostat thermostat) {
        thermostat.turnOn();
        thermostat.setTemperature(thermostat.getCurrentTemperature() + 3);
        return "Grandma " + this.name + " tries to turn up the temperature on " + thermostat;
    }

    @Override
    public String visitWashingMachine(WashingMachine washingMachine) {
        if (washingMachine.getCurrentLoad() < washingMachine.getMaxLoad()) {
            int availableSpace = (int) (washingMachine.getMaxLoad() - washingMachine.getCurrentLoad());
            int maxClothes = Math.min(4, availableSpace);
            washingMachine.addItem("Sweater", RandomUtils.getRandomNumber(1, maxClothes));
            return "Grandma " + this.name + " added sweaters to " + washingMachine;
        }
        else {
            return "Grandma " + this.name + " notices full " + washingMachine;
        }
    }

    @Override
    public String visitWindow(Window window) {
        if (RandomUtils.isWithinPercentage(60)) {
            window.openCurtain();
            window.open();
            return "Grandma " + this.name + " opened " + window;
        }
        window.close();
        window.openCurtain();
        return "Grandma " + this.name + " opened the curtains of closed " + window;
    }

    @Override
    public boolean visitEmptyFridge(Fridge fridge) {
        fridge.addItem("Milk", 1);
        fridge.addItem("Ham", 1);
        fridge.addItem("Cucumber", 1);
        fridge.addItem("Yogurt", 2);
        fridge.addItem("Orange Juice", 2);
        logger.info("Grandma " + this.name + " filled up " + fridge);
        return true;
    }

    @Override
    public boolean visitFinishedDishwasher(Dishwasher dishwasher) {
        dishwasher.removeAllItems();
        logger.info("Grandma " + this.name + " took out all dishes from " + dishwasher);
        return true;
    }

    @Override
    public boolean visitFinishedWashingMachine(WashingMachine washingMachine) {
        washingMachine.removeAllItems();
        logger.info("Grandma " + this.name + " took out all clothes from " + washingMachine);
        return true;
    }

    @Override
    public String toString() {
        return "Grandma " + name + " (" + age + ")";
    }
}
