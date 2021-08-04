package topic4.part2_Aggregation.task5.enums;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Enum to store types of catering
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public enum CateringType {
    NON_AVAILABLE("non available"),      // without catering
    BREAKFAST_ONLY("breakfast only"),
    BUFFET_ONLY("buffet only"),          // шведский стол
    HALF_BOARD("half board"),            // полупансион
    ALL_INCLUSIVE("all inclusive"),
    BREAKFAST_AND_DINNER("breakfast and dinner");

    @Override
    public String toString() {
        return cateringName;
    }

    private String cateringName;

    CateringType(String cateringName) {
        this.cateringName = cateringName;
    }
}
