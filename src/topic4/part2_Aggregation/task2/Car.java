package topic4.part2_Aggregation.task2;

public class Car {

    private Weel[] weels;
    private Engine engine;
    private String model;
    private String numberVIN;
    private double tankVolume;

    public Car(Weel[] weels, Engine engine, String model, String numberVIN, double tankVolume) {
        this.weels = weels;
        this.engine = engine;
        this.model = model;
        this.numberVIN = numberVIN;
        this.tankVolume = tankVolume;
    }

    public void ride() {
        if (engine.start()) {
            System.out.println("Let's ride!");
        } else {
            System.out.println("Car can't ride, make sure it's ready.");
        }
    }

    public void refuel(Engine.EngineType engineType, Engine.FuelType fuelType, double fuelVolume) {
        if (engine.getEngineType().equals(engineType) && engine.getFuelType().equals(fuelType)) {
            if (tankVolume < fuelVolume) {
                fuelVolume = tankVolume;
            }
            System.out.printf("Refuel is done with %8.2f liters of %s %s.\n", fuelVolume, engineType, fuelType);
        } else {
            if (!engine.getEngineType().equals(engineType)) {
                System.out.printf("Fuel type %s is not corresponding to the engine's fuel type %s. Refuel isn't done.\n",
                        engineType, engine.getEngineType());
            } else {
                System.out.printf("Fuel type %s is not corresponding to the engine's fuel type %s. Refuel isn't done.\n",
                        fuelType, engine.getFuelType());
            }
        }
    }

    public void changeWeel(Weel newWeel, int i) {
        if (weels[i].getDiameter() == newWeel.getDiameter()) {
            System.out.print("Weel is changed.\n");
        } else {
            System.out.printf("The new weels's diameter %8.2f is not equal to the car's weels diameter %8.2f. Can't change the weels.\n",
                    newWeel.getDiameter(), weels[i].getDiameter());
        }
    }

    public void printModel() {
        System.out.println("Model = " + model);
    }

    @Override
    public String toString() {
        return "Car{engine=" + engine +
                ", model='" + model + '\'' +
                ", tankVolume=" + tankVolume +
                '}';
    }

    public double getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(double tankVolume) {
        this.tankVolume = tankVolume;
    }

    public Weel[] getWeels() {
        return weels;
    }

    public void setWeels(Weel[] weels) {
        this.weels = weels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberVIN() {
        return numberVIN;
    }

    public void setNumberVIN(String numberVIN) {
        this.numberVIN = numberVIN;
    }
}
