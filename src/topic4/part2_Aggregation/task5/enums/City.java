package topic4.part2_Aggregation.task5.enums;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Enum to store cities
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public enum City {
    GARODNYA("Garodnya"),
    MAHILEU("Mahileu"),
    STAKHOLM("Stakholm"),
    MENSK("Mensk"),
    PORTO("Porto"),
    MILAN("Milan"),
    BARSELONA("Barselona"),
    KIEU("Kieu"),
    MASKWA("Maskwa"),
    VILNYA("Vilnya"),
    WARSHAWA("Warshawa"),
    RYGA("Ryga"),
    BARYSAU("Barysau"),
    ZHODZINA("Zhodzina"),
    VITSEBSK("Vitsebsk"),
    PARIS("Paris"),
    BERLIN("Berlin"),
    PRAHA("Praha"),
    MADRYD("Madryd"),
    LONDAN("Londan"),
    TALIN("Talin"),
    HELSINKI("Helsinki"),
    GOMEL("Gomel"),
    KAZAN("Kazan"),
    BRATSISLAVA("Bratsislava"),
    ZASLAUE("Zaslaue");

    @Override
    public String toString() {
        return cityName;
    }

    private String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }
}
