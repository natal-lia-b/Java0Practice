package topic4.part2_Aggregation.task5.enumeration;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Enum to store cities
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public enum City {
    MENSK("Mensk"),
    PORTO("Porto"),
    MILAN("Milan"),
    BARSELONA("Barselona"),
    KIEU("Kieu"),
    VILNYA("Vilnya"),
    WARSHAWA("Warshawa"),
    PARIS("Paris"),
    BERLIN("Berlin"),
    PRAHA("Praha"),
    MADRYD("Madryd"),
    LONDAN("Londan");

    @Override
    public String toString() {
        return cityName;
    }

    private String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }

    public static City getCityByOrdinal(int ordinal) {
        City result = null;
        City[] types = City.values();
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
