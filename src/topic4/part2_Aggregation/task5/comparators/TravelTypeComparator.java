package topic4.part2_Aggregation.task5.comparators;

import topic4.part2_Aggregation.task5.entities.Travel;

import java.util.Comparator;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Class to sort travel collection by travel type
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 07.08.2021
 */

public class TravelTypeComparator implements Comparator<Travel> {
    @Override
    public int compare(Travel o1, Travel o2) {
        return o1.getTravelType().toString().compareTo(o2.getTravelType().toString());
    }
}
