package topic4.part2_Aggregation.task5.entities;

import topic4.part2_Aggregation.task5.enums.*;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * General travels - all the rest travels
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public class GeneralTravel extends Travel {

    public GeneralTravel(TravelType travel, TransportType transport, CateringType catering, int duration,
                         City departure, City destination) {

        super(travel, transport, catering, duration, departure, destination);
    }
}
