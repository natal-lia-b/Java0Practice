package topic4.part2_Aggregation.task5.actions;

import topic4.part2_Aggregation.task5.entities.Travel;
import topic4.part2_Aggregation.task5.entities.TravelCollection;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Service methods
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 04.08.2021
 */

public class Service {

    public static Integer getInputNumber(Scanner scanner, String message) {
        System.out.print(message);
        Integer inputNumber;
        try {
            inputNumber = Integer.valueOf(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Something is wrong, try again.");
            return null;
        }
        return inputNumber;
    }

    public static TravelCollection cloneTravelCollection(TravelCollection collectionFrom) {
        TravelCollection collectionTo = new TravelCollection();
        try {
            collectionTo = (TravelCollection) collectionFrom.clone();
            collectionTo.setTravelList((ArrayList<Travel>) collectionFrom.getTravelList().clone());
        } catch (CloneNotSupportedException e) {
            System.out.println("Something wrong with travel collection creating.");
            e.printStackTrace();
        }
        return collectionTo;
    }

    public static void showList(TravelCollection travelList) {
        if (travelList.getTravelList().size() > 0) {
            System.out.println(travelList.toString());
        } else {
            System.out.println("Nothing to show. Reset filters.");
        }
    }
}
