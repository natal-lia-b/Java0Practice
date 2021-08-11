package topic4.part2_Aggregation.task5.actions;

import topic4.part2_Aggregation.task5.entities.Travel;
import topic4.part2_Aggregation.task5.entities.TravelCollection;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static topic4.part2_Aggregation.task5.actions.Service.cloneTravelCollection;
import static topic4.part2_Aggregation.task5.actions.Service.showList;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Collection sorting by available categories.
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 07.08.2021
 */

public class SortVouchers {

    private String message = "\n   Available categories to sort collection:\n" +
            "   1 - travel type,\n" +
            "   2 - transport type,\n" +
            "   3 - catering type,\n" +
            "   4 - city of departure,\n" +
            "   5 - city of destination,\n" +
            "   6 - duration,\n" +
            "   0 - exit to the previous level.\n" +
            "   Choose the category: ";

    private TravelCollection travelCollection;
    private TravelCollection sortedList;

    public SortVouchers(TravelCollection travelCollection) {
        this.travelCollection = travelCollection;
    }

    public void sort(Scanner scanner) {
        sortedList = cloneTravelCollection(travelCollection);
        OUT1:
        while (true) {
            Integer filterNumber = Service.getInputNumber(scanner, message);
            if (filterNumber == null) continue;

            switch (filterNumber) {
                case 1:
                    sortByTravelType();
                    break;
                case 2:
                    sortByTransportType();
                    break;
                case 3:
                    sortByCateringType();
                    break;
                case 4:
                    sortByDeparture();
                    break;
                case 5:
                    sortByDestination();
                    break;
                case 6:
                    sortByDuration();
                    break;
                case 0:
                    break OUT1;
                default: {
                    System.out.println("Bad input, try again.");
                    break;
                }
            }
        }
    }

    private void sortByDuration() {
        Comparator<Travel> comparator = new Travel.DurationComparator();
        sortAndShow(comparator);
    }

    private void sortByDeparture() {
        Comparator<Travel> comparator = new Travel.DepartureComparator();
        sortAndShow(comparator);
    }

    private void sortByDestination() {
        Comparator<Travel> comparator = new Travel.DestinationComparator();
        sortAndShow(comparator);
    }

    private void sortByCateringType() {
        Comparator<Travel> comparator = new Travel.CateringTypeComparator();
        sortAndShow(comparator);
    }

    private void sortByTransportType() {
        Comparator<Travel> comparator = new Travel.TransportTypeComparator();
        sortAndShow(comparator);
    }

    private void sortByTravelType() {
        Comparator<Travel> comparator = new Travel.TravelTypeComparator();
        sortAndShow(comparator);
    }

    private void sortAndShow(Comparator<Travel> comparator) {
        TravelCollection sortedListCopy = cloneTravelCollection(sortedList);
        Collections.sort(sortedListCopy.getTravelList(), comparator);
        showList(sortedListCopy);
    }
}
