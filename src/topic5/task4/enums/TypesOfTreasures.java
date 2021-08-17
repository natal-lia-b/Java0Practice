package topic5.task4.enums;

public enum TypesOfTreasures {
    GOLD("Gold"),
    SILVER("Silver"),
    GOLD_RING("Gold ring"),
    SILVER_EARRINGS("Silver earring"),
    BRILLIANT("Brilliant"),
    DIAMANT("Diamant"),
    ADAMANT("Adamant");

    private String string;

    TypesOfTreasures(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
