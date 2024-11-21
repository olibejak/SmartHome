package cz.cvut.fel.omo.device;

import cz.cvut.fel.omo.device.state.DeviceState;
import cz.cvut.fel.omo.device.util.Consumption;
import cz.cvut.fel.omo.device.util.UserManual;
import cz.cvut.fel.omo.logger.GlobalLogger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Device {

    protected GlobalLogger logger;

    private DeviceState state;
    private UserManual manual;
    private boolean isEssential;
    private boolean isBroken;
    private String warrantyCertificate;
    private Consumption consumption;
    @Setter
    private int durability;

//    public Event generateEvent() {
//
//    }

    /**
     * Change state of the device
     * @param state new state
     */
    public void changeState(DeviceState state) {
        this.state = state;
    }

    public void plugIn() {
        state.plugIn();
    }
    public void plugOut() {
        state.plugOut();
    }
    public void turnOn() {
        state.turnOn();
    }
    public void turnOff() {
        state.turnOff();
    }

    public String reportConsumption() {
        return new StringBuilder()
                .append("Device: ")
                .append(this.toString())
                .append("\n\tConsumption:\n\t\tElectricity: ")
                .append(consumption.getElectricityConsumed())
                .append(" kWh\n\t\tWater: ")
                .append(consumption.getWaterConsumed())
                .append(" l\n\t\tGas: ")
                .append(consumption.getGasConsumed())
                .append(" m3")
                .toString();
    }

    public void update() {
        state.calculateConsumption();
        state.calculateDurability();
    }
}
