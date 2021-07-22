package topic4.part2_Aggregation.task2;

public class Weel {
    public enum SeasonType {
        WINTER, SUMMER, ALLSEASON
    }

    private double diameter;
    private SeasonType seasonType;
    private String model;

    public Weel(double diameter, SeasonType seasonType, String model) {
        this.diameter = diameter;
        this.seasonType = seasonType;
        this.model = model;
    }

    public Weel(double diameter) {
        this.diameter = diameter;
        this.seasonType = SeasonType.ALLSEASON;
        this.model = "Belshina";
    }

    @Override
    public String toString() {
        return "Weel{" +
                "diameter=" + diameter +
                ", seasonType=" + seasonType +
                ", model='" + model + '\'' +
                '}';
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public SeasonType getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(SeasonType seasonType) {
        this.seasonType = seasonType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
