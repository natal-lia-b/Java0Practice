package topic4.part2_Aggregation.task5.entities;

import topic4.part2_Aggregation.task5.enums.*;
/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Abstract class for travelling
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 04.08.2021
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
}
