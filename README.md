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
mvn exec:java -Dexec.mainClass="cz.cvut.fel.omo.main.Main"
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
- Entities (people, pets) are initialized in [EntityInitialization](https://gitlab.fel.cvut.cz/olibejak/smarthome/-/tree/main/src/main/java/cz/cvut/fel/omo/main/EntityInitialization.java).
  - Use the `h` command to see the list of available commands.


## **Simulation Cycle Flow**

Each cycle represents a time step in the simulation where various events, interactions, and updates take place.

### **1. House Events**

- **1.1 Generate Global Event**:

  - A random **global event** (e.g., power outage, weather event) is generated.
  - If an event is generated, it is added to the event queue.
- **1.2 Log Current Local Events**:

  - The system retrieves and logs all **local events** happening in different rooms.
- **1.3 Dispatch Events**:

  - The `EventManager` processes and dispatches **all events** in the queue.

---

### **2. Family Actions**

Each person performs actions based on their surroundings.

- **2.1 Determine Room Context**:

  - The system retrieves information about the **current room** of the person, including:
    - Other people
    - Pets
    - Devices
    - Vehicles
    - Equipment
    - Active events
- **2.2 React to Local Events**:

  - If an event affects a **device**, the person attempts to interact with it:
    - If the event is **DEVICE_EMPTY**, the person reacts to it.
    - If the event is **DEVICE_FULL**, the person turns it on.
    - If the event is **DEVICE_FINISHED**, the person acknowledges it.
    - If the event is **DEVICE_BROKEN**, the person attempts to fix it.
- **2.3 Interact with Other Entities**:

  - The person may **randomly interact** with:
    - **Another person**
    - **A pet in the same room**
- **2.4 Interact with Smart Home Objects**:

  - The person may interact with:
    - **Sport Equipment** (e.g., weights, skis)
    - **Vehicles** (e.g., bicycle, car)
    - **Devices** (e.g., fridge, television)

---

### **3. Pet Actions**

Each pet performs actions in the house.

- **3.1 Determine Room Context**:

  - The system retrieves information about the **current room** of the pet.
- **3.2 Interact with Other Entities**:

  - The pet may **randomly interact** with:
    - **A person**
    - **Another pet**
- **3.3 Interact with Smart Home Objects**:

  - Some pets may interact with:
    - **Sport Equipment**
    - **Vehicles**

---

### **4. Device Actions**

- Devices update their **consumption** based on their current state.
- The house calculates updated **electricity, water, and gas consumption**.

---

### **5. Movement of Family and Pets**

- Each person and pet **randomly moves** to another room.

---

### **6. Equipment and Vehicles Reset**

- All **vehicles and sport equipment** become available again for the next cycle.

---

### **7. Shuffle Interaction Order**

- The **order of family and pets is shuffled** to create variation in interactions.