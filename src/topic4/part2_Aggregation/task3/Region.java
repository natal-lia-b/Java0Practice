package topic4.part2_Aggregation.task3;

import java.util.Arrays;

public class Region {

    private String name;
    private City capital;
    private District[] districts;

    public Region(String name, City capital, District[] districts) {
        this.name = name;
        this.capital = capital;
        this.districts = districts;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", capital=" + capital +
                ", districts=" + Arrays.toString(districts) +
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

    public District[] getDistricts() {
        return districts;
    }

    public void setDistricts(District[] districts) {
        this.districts = districts;
    }
}
