package topic4.part2_Aggregation.task5.enumeration;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Enum to store types of transport
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public enum TransportType {
    ON_FOOT("on foot"),
    BUS("by bus"),
    CAR("by car"),
    TRAIN("by train"),
    PLANE("by plane"),
    MARINE_LINER("by marine liner");

    @Override
    public String toString() {
        return transportName;
    }

    private String transportName;

    TransportType(String transportName) {
        this.transportName = transportName;
    }

    public static TransportType getTransportByOrdinal(int ordinal) {
        TransportType result = null;
        TransportType[] types = TransportType.values();
        int i = 0;
        while (i < types.length) {
            if (types[i].ordinal() == ordinal) {
                result = types[i];
                break;
            }
            i++;
        }
        return result;
    }
}
