package topic4.part2_Aggregation.task3;

import java.util.Arrays;

/**
 * 3. Создать объект класса Государство, используя классы Область, Район, Город.
 * Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */

public class State {

    private String name;
    private City capital;
    private Region[] regions;

    public static void main(String[] args) {
        City borisov = new City("Borisov");
        City[] cities1 = new City[]{new City("Zhodino"), borisov};
        District district1 = new District("Borisovcki", borisov, cities1, 15085);
        City minsk = new City("Minsk");
        City[] cities2 = new City[]{new City("Smolevichy"), minsk};
        District district2 = new District("Minski", minsk, cities2, 52360);
        City grodno = new City("Grodno");
        City[] cities3 = new City[]{new City("Skidel"), grodno};
        District district3 = new District("Grodnenski", borisov, cities3, 25630);
        City shchuchin = new City("Shchuchin");
        City[] cities4 = new City[]{new City("Kazuki"), shchuchin};
        District district4 = new District("Shchuchinski", shchuchin, cities4, 36985);
        District[] districts1 = new District[]{district1, district2};
        District[] districts2 = new District[]{district3, district4};
        Region[] regions = new Region[]{new Region("Minskaya", minsk, new District[]{district1, district2}),
                new Region("Grodnenskaya", grodno, new District[]{district3, district4})};

        State state = new State("Veishnoria", grodno, regions);
        state.printCapital();
        state.printRegionsAmount();
        state.printSquare();
        state.printRegionCapitals();
    }

    public void printRegionCapitals() {
        StringBuilder result = new StringBuilder();
        for (Region region : regions) {
            result.append(region.getCapital().toString().concat(" "));
        }
        System.out.println("Region capitals = " + result.toString().strip());
    }

    public void printSquare() {
        double square = 0;
        for (Region region : regions) {
            for (District district : region.getDistricts()) {
                square += district.getSquare();
            }
        }
        System.out.println("Square of the state = " + square);
    }

    public void printRegionsAmount() {
        System.out.println("Regions amount = " + regions.length);
    }

    public void printCapital() {
        System.out.println("Capital = " + capital.getName());
    }

    public State(String name, City capital, Region[] regions) {
        this.name = name;
        this.capital = capital;
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", capital=" + capital +
                ", regions=" + Arrays.toString(regions) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public Region[] getRegions() {
        return regions;
    }

    public void setRegions(Region[] regions) {
        this.regions = regions;
    }
}
