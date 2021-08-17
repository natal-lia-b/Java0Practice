package topic5.task4.entities;

import java.util.ArrayList;
import java.util.List;

public class TreasureCollection {
    List<Treasure> treasures = new ArrayList<>();

    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
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
