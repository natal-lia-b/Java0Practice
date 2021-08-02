package topic4.part2_Aggregation.task3;

import java.util.Arrays;

public class State {

    private String name;
    private City capital;
    private Region[] regions;

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
