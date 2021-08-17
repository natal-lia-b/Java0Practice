package topic5.task4.action;

import topic5.task4.entity.Treasure;

import java.util.ArrayList;

public class TheMostExpensiveTreasure {

    public static Treasure find(ArrayList<Treasure> treasures) {
        Treasure theMostExpensiveTreasure = treasures.get(0);
        for (Treasure treasure : treasures) {
            if (treasure.compareTo(theMostExpensiveTreasure) > 0) {
                theMostExpensiveTreasure = treasure;
            }
        }
        return theMostExpensiveTreasure;
    }
}
