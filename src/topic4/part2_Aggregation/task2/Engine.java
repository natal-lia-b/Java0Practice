package topic4.part2_Aggregation.task2;

public class Engine {
    public enum EngineType {
        PETROL, DIESEL
    }

    public enum FuelType {
        AI92, AI95, DIESEL
    }

    private EngineType engineType;
    private FuelType fuelType;
    private String number;
    private boolean isReady;

    public Engine(EngineType engineType, FuelType fuelType, String number, boolean isReady) {
        this.engineType = engineType;
        this.fuelType = fuelType;
        this.number = number;
        this.isReady = true;
    }

    public Engine(EngineType engineType, FuelType fuelType) {
        this.engineType = engineType;
        this.fuelType = fuelType;
        this.isReady = false;
    }

    public boolean start() {
        boolean result = false;
        if (isReady) {
            System.out.println("Engine is ready to ride!");
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        Engine engine = new Engine(EngineType.PETROL, FuelType.AI95);
        System.out.println(engine.toString());
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineType=" + engineType +
                ", fuelType=" + fuelType +
                '}';
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
