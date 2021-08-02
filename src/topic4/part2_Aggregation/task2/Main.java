package topic4.part2_Aggregation.task2;

/**
 * 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
 * Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
 */

public class Main {

    public static void main(String[] args) {
        Weel[] weels = {new Weel(15), new Weel(15), new Weel(16), new Weel(16)};
        Engine engine = new Engine(Engine.EngineType.PETROL, Engine.FuelType.AI95);
        Car car = new Car(weels, engine, "BMV", "1234568V", 50.4);
        System.out.println(car.toString());

        car.ride();
        engine.setReady(true);
        car.ride();

        car.refuel(Engine.EngineType.DIESEL, Engine.FuelType.DIESEL, 52);
        car.refuel(Engine.EngineType.PETROL, Engine.FuelType.DIESEL, 52);
        car.refuel(Engine.EngineType.PETROL, Engine.FuelType.AI95, 52);

        car.printModel();

        car.changeWeel(new Weel(16), 0);
        car.changeWeel(new Weel(15), 0);
    }
}
