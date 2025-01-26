# SmartHome
Simulation of Entities interacting with a smart home system.<br>

## Table of Contents
- [Description](#description)
- [Usage](#usage)
- [Inputs](#inputs)

## Description
SmartHome is a simulation of a smart home system. The system is a composite of a house with rooms and devices. 
The devices can be turned on and off, and they consume electricity. 
The system calculates the total electricity consumption of the house and the electricity consumption of each room. 
The user can interact with the system through the console.

## Usage
SmartHome uses Java 21 and Maven. Use the following commands to build and run:
```
git clone https://gitlab.fel.cvut.cz/olibejak/smarthome.git
mvn clean install
mvn exec:java -Dexec.mainClass="cz.cvut.fel.omo.Main"
```

## Inputs
- The application reads inputs from the 
[recourse directory](https://gitlab.fel.cvut.cz/olibejak/smarthome/-/tree/main/src/main/resources).
- The house structure is loaded from 
[house.json](https://gitlab.fel.cvut.cz/olibejak/smarthome/-/tree/main/src/main/resources/house.json) according to 
DTOs found in [DTO directory](https://gitlab.fel.cvut.cz/olibejak/smarthome/-/tree/main/src/main/java/cz/cvut/fel/omo/DTO).
- Device consumption can be edited in [devices.json](https://gitlab.fel.cvut.cz/olibejak/smarthome/-/tree/main/src/main/resources/device_consumption.json)
according to [ConsumptionDTO](https://gitlab.fel.cvut.cz/olibejak/smarthome/-/tree/main/src/main/java/cz/cvut/fel/omo/DTO/ConsumptionDTO).
- Device documentation can be edited in [device_documentation.json](https://gitlab.fel.cvut.cz/olibejak/smarthome/-/tree/main/src/main/resources/device_documentation.json)
according to [DeviceDocumentation](https://gitlab.fel.cvut.cz/olibejak/smarthome/-/tree/main/src/main/java/cz/cvut/fel/omo/device/util/DeviceDocumentation.java).
- While running the application, the user can interact with the application through the console.
  - Use the `h` command to see the list of available commands.
