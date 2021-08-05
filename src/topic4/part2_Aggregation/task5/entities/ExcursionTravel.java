package topic4.part2_Aggregation.task5.entities;

import topic4.part2_Aggregation.task5.enums.*;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Excurtions and cruises
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public class ExcursionTravel extends Travel{
    private int quantityOfCities;

    public ExcursionTravel(TravelType travel, TransportType transport, CateringType catering, int duration,
                           City departure, City destination, int quantityOfCities) {

        super(travel, transport, catering, duration, departure, destination);

        this.quantityOfCities = quantityOfCities;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", quantityOfCities='" + quantityOfCities + "\'.";
    }
}
