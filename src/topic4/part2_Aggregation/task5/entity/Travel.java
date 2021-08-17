package topic4.part2_Aggregation.task5.entity;

import topic4.part2_Aggregation.task5.enumeration.CateringType;
import topic4.part2_Aggregation.task5.enumeration.City;
import topic4.part2_Aggregation.task5.enumeration.TransportType;
import topic4.part2_Aggregation.task5.enumeration.TravelType;

import java.util.Comparator;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Abstract class for travelling
 *
 * @author Natallia Bialiatskaya
 * @version 2.0
 * @since 11.08.2021
 */

abstract public class Travel implements Cloneable {

    private TravelType travelType;
    private TransportType transportType;
    private CateringType cateringType;
    private int duration;
    private City departure;
    private City destination;

    public Travel(TravelType travelType, TransportType transport, CateringType catering, int duration,
                  City departure, City destination) {
        this.travelType = travelType;
        this.transportType = transport;
        this.cateringType = catering;
        this.duration = duration;
        this.departure = departure;
        this.destination = destination;
    }

    public TravelType getTravelType() {
        return travelType;
    }

    public void setTravelType(TravelType travelType) {
        this.travelType = travelType;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public CateringType getCateringType() {
        return cateringType;
    }

    public void setCateringType(CateringType cateringType) {
        this.cateringType = cateringType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public City getDeparture() {
        return departure;
    }

    public void setDeparture(City departure) {
        this.departure = departure;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return departure.ordinal() * 10_000_000 + destination.ordinal() * 100_000 + cateringType.ordinal() * 10_000 +
                transportType.ordinal() * 1_000 + travelType.ordinal() * 100 + duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travel travel1 = (Travel) o;
        return duration == travel1.duration &&
                travelType == travel1.travelType &&
                transportType == travel1.transportType &&
                cateringType == travel1.cateringType &&
                departure == travel1.departure &&
                destination == travel1.destination;
    }

    @Override
    public String toString() {
        return "\n" + travelType.toString() +
                ", transportType='" + transportType.toString() + '\'' +
                ", cateringType='" + cateringType.toString() + '\'' +
                ", duration=" + duration +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'';
    }

    /**
     * Class to sort travel collection by catering type
     * @version 2.0
     * @since 11.08.2021
     */
    public static class CateringTypeComparator implements Comparator<Travel> {
        @Override
        public int compare(Travel o1, Travel o2) {
            return o1.getCateringType().toString().compareTo(o2.getCateringType().toString());
        }
    }

    /**
     * Class to sort travel collection by city of departure
     * @version 2.0
     * @since 11.08.2021
     */
    public static class DepartureComparator implements Comparator<Travel> {
        @Override
        public int compare(Travel o1, Travel o2) {
            return o1.getDeparture().toString().compareTo(o2.getDeparture().toString());
        }
    }

    /**
     * Class to sort travel collection by city of destination
     * @version 2.0
     * @since 11.08.2021
     */
    public static class DestinationComparator implements Comparator<Travel> {
        @Override
        public int compare(Travel o1, Travel o2) {
            return o1.getDestination().toString().compareTo(o2.getDestination().toString());
        }
    }

    /**
     * Class to sort travel collection by duration
     * @version 2.0
     * @since 11.08.2021
     */
    public static class DurationComparator implements Comparator<Travel> {
        @Override
        public int compare(Travel o1, Travel o2) {
            return o1.getDuration() - o2.getDuration();
        }

    }

    /**
     * Class to sort travel collection by transport type
     * @version 2.0
     * @since 11.08.2021
     */
    public static class TransportTypeComparator implements Comparator<Travel> {
        @Override
        public int compare(Travel o1, Travel o2) {
            return o1.getTransportType().toString().compareTo(o2.getTransportType().toString());
        }
    }

    /**
     * Class to sort travel collection by travel type
     * @version 2.0
     * @since 11.08.2021
     */
    public static class TravelTypeComparator implements Comparator<Travel> {
        @Override
        public int compare(Travel o1, Travel o2) {
            return o1.getTravelType().toString().compareTo(o2.getTravelType().toString());
        }
    }
}
