package topic4.part2_Aggregation.task3;

/**
 * 3. Создать объект класса Государство, используя классы Область, Район, Город.
 * Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */

public class Main {

    public static void main(String[] args) {
        City borisov = new City("Borisov");
        City[] cities1 = new City[]{new City("Zhodino"), borisov};
        District district1 = new District("Borisovcki", borisov, cities1, 15085);
        City minsk = new City("Minsk");
        City[] cities2 = new City[]{new City("Smolevichy"), minsk};
        District district2 = new District("Minski", minsk, cities2, 52360);
        District[] districts1 = new District[]{district1, district2};

        City grodno = new City("Grodno");
        City[] cities3 = new City[]{new City("Skidel"), grodno};
        District district3 = new District("Grodnenski", borisov, cities3, 25630);
        City shchuchin = new City("Shchuchin");
        City[] cities4 = new City[]{new City("Kazuki"), shchuchin};
        District district4 = new District("Shchuchinski", shchuchin, cities4, 36985);
        District[] districts2 = new District[]{district3, district4};

        Region[] regions = new Region[]{new Region("Minskaya", minsk, districts1),
                new Region("Grodnenskaya", grodno, districts2)};

        State state = new State("Veishnoria", grodno, regions);
        state.printCapital();
        state.printRegionsAmount();
        state.printSquare();
        state.printRegionCapitals();
    }
}
