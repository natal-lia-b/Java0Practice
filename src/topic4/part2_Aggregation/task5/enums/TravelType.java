package topic4.part2_Aggregation.task5.enums;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Enum to store types of travel
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public enum TravelType {
    EXCURSION("Excursion"),
    MEDICAL_TOURIZM("Medical tourizm"),
    SHOPPING("Shopping"),
    VACATION("Vacation"),
    CRUISE("Cruise"),
    ADVENTURE("Adventure"),
    BUSINESS_TOURIZM("Business tourizm"),
    HONEYMOON("Honeymoon");

    private String travelName;

    @Override
    public String toString() {
        return travelName;
    }

    TravelType(String travelName) {
        this.travelName = travelName;
    }

    public static TravelType getTravelByOrdinal(int ordinal) {
        TravelType result = null;
        TravelType[] types = TravelType.values();
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
