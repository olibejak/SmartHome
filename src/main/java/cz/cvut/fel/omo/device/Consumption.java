package cz.cvut.fel.omo.device;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Consumption {

    private final double electricityIdleRate;
    private final double electricityActiveRate;
    private final double gasRate;
    private final double waterRate;
    private double electricityConsumed = 0;
    private double gasConsumed = 0;
    private double waterConsumed = 0;

    public Consumption(double electricityIdleRate, double electricityActiveRate, double gasRate, double waterRate) {
        this.electricityIdleRate = electricityIdleRate;
        this.electricityActiveRate = electricityActiveRate;
        this.gasRate = gasRate;
        this.waterRate = waterRate;
    }

    public void addIdleElectricityConsumed() {
        this.electricityConsumed += electricityIdleRate;
    }

    public void addActiveElectricityConsumed() {
        this.electricityConsumed += electricityActiveRate;
    }

    public void addGasConsumed() {
        this.gasConsumed += gasRate;
    }

    public void addWaterConsumed() {
        this.waterConsumed += waterRate;
    }
}
