package topic4.part2_Aggregation.task5.entity;

import topic4.part2_Aggregation.task5.enumeration.*;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Travels for medical purposes
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public class MedicalTravel extends Travel{

    private String desease;

    public MedicalTravel(TravelType travel, TransportType transport, CateringType catering, int duration,
                         City departure, City destination, String desease) {

        super(travel, transport, catering, duration, departure, destination);

        this.desease = desease;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", desease='" + desease + "\'.";
    }
}
