package topic5.task4.entity;

import java.util.ArrayList;

public class TreasureCollection {
    ArrayList<Treasure> treasures = new ArrayList<>();

    public TreasureCollection() {
    }

    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Treasure treasure : treasures) {
            result.append(treasure.toString());
        }
        return result.toString();
    }
}
