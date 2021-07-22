package topic4.part2_Aggregation.task3;

import java.util.Arrays;

public class District {

    private String name;
    private City capital;
    private City[] cities;
    private double square;

    public District(String name, City capital, City[] cities, double square) {
        this.name = name;
        this.capital = capital;
        this.cities = cities;
        this.square = square;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", capital=" + capital +
                ", cities=" + Arrays.toString(cities) +
                ", square=" + square +
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

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }
}
