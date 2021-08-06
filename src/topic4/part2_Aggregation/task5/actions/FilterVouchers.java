package topic4.part2_Aggregation.task5.actions;

import topic4.part2_Aggregation.task5.entities.Travel;
import topic4.part2_Aggregation.task5.entities.TravelCollection;
import topic4.part2_Aggregation.task5.enums.CateringType;
import topic4.part2_Aggregation.task5.enums.City;
import topic4.part2_Aggregation.task5.enums.TransportType;
import topic4.part2_Aggregation.task5.enums.TravelType;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 04.08.2021
 */

public class FilterVouchers {

    private String message = "\n   Available filters:\n" +
            "   1 - travel type,\n" +
            "   2 - transport type,\n" +
            "   3 - catering type,\n" +
            "   4 - city of departure,\n" +
            "   5 - city of destination,\n" +
            "   6 - duration,\n" +
            "   7 - RESET ALL FILTERS,\n" +
            "   0 - exit to the previous level.\n" +
            "   Choose the filter: ";
    private String message1 = "\n       Available types of travel:\n" +
            "       1 - excursion,\n" +
            "       2 - medical tourizm,\n" +
            "       3 - shopping,\n" +
            "       4 - vacation,\n" +
            "       5 - cruise,\n" +
            "       6 - adventure,\n" +
            "       7 - business tourizm,\n" +
            "       8 - honeymoon,\n" +
            "       0 - exit to the previous level.\n" +
            "       Choose the type of travel: ";
    private String message2 = "\n       Available types of transport:\n" +
            "       1 - on foot,\n" +
            "       2 - by bus,\n" +
            "       3 - by car,\n" +
            "       4 - by train,\n" +
            "       5 - by plane,\n" +
            "       6 - by marine liner,\n" +
            "       0 - exit to the previous level.\n" +
            "       Choose the type of transport: ";
    private String message3 = "\n       Available types of catering:\n" +
            "       1 - non available,\n" +
            "       2 - breakfast only,\n" +
            "       3 - buffet only,\n" +
            "       4 - half board,\n" +
            "       5 - all inclusive,\n" +
            "       6 - breakfast and dinner,\n" +
            "       0 - exit to the previous level.\n" +
            "       Choose the type of catering: ";
    private String message4 = "\n       Available cities:\n" +
            "       1 - Mensk,\n" +
            "       2 - Porto,\n" +
            "       3 - Milan,\n" +
            "       4 - Barselona,\n" +
            "       5 - Kieu,\n" +
            "       6 - Vilnya,\n" +
            "       7 - Warshawa,\n" +
            "       8 - Paris,\n" +
            "       9 - Berlin,\n" +
            "       10 - Praha,\n" +
            "       11 - Madryd,\n" +
            "       12 - Londan.\n" +
            "       0 - exit to the previous level.\n" +
            "       Choose city: ";

    private TravelCollection travelCollection;
    private TravelCollection travelList;

    public FilterVouchers(TravelCollection travelCollection) {
        this.travelCollection = travelCollection;
    }

    public void setFilters(Scanner scanner) {
        travelList = cloneTravelCollection(travelCollection);
        OUT1:
        while (true) {
            Integer filterNumber = Service.getInputNumber(scanner, message);
            if (filterNumber == null) continue;

            switch (filterNumber) {
                case 1:
                    getTravelTypeFilter(scanner);
                    break;
                case 2:
                    getTransportTypeFilter(scanner);
                    break;
                case 3:
                    getCateringTypeFilter(scanner);
                    break;
                case 4:
                    City departureForFilter = getCityFilter(scanner);
                    setDepartureFilter(departureForFilter);
                    showListWithFilters();
                    break;
                case 5:
                    City destinationForFilter = getCityFilter(scanner);
                    setDestinationFilter(destinationForFilter);
                    showListWithFilters();
                    break;
                case 6:
                    setDurationFilter(scanner);
                    break;
                case 7:
                    resetFilters();
                    break;
                case 0:
                    break OUT1;
                default: {
                    System.out.println("Bad input, try again.");
                    break;
                }
            }
        }
    }


    private void setDurationFilter(Scanner scanner) {
        int max = getMaxDurationFromData();
        Integer minDuration = Service.getInputNumber(scanner, "   Enter minimum duration (from 1 to " + max + "): ");
        if (minDuration == null) minDuration = 1;

        Integer maxDuration = Service.getInputNumber(scanner, "   Enter maximum duration (from 1 to " + max + "): ");
        if (maxDuration == null || maxDuration > max) {
            maxDuration = max;
        }

        TravelCollection travelListCopy = cloneTravelCollection(travelList);
        for (Travel travel : travelListCopy.getTravelList()) {
            if (travel.getDuration() < minDuration || travel.getDuration() > maxDuration) {
                travelList.removeTravel(travel);
            }
        }
        showListWithFilters();
    }

    private int getMaxDurationFromData() {
        int max = 1;
        for (Travel travel : travelList.getTravelList()) {
            if (travel.getDuration() > max) {
                max = travel.getDuration();
            }
        }
        return max;
    }

    private void setDestinationFilter(City city) {
        TravelCollection travelListCopy = cloneTravelCollection(travelList);
        for (Travel travel : travelListCopy.getTravelList()) {
            if (isEmptyDestinationFilter(travel, city)) {
                travelList.removeTravel(travel);
            }
        }
    }

    private void setDepartureFilter(City city) {
        TravelCollection travelListCopy = cloneTravelCollection(travelList);
        for (Travel travel : travelListCopy.getTravelList()) {
            if (isEmptyDepartureFilter(travel, city)) {
                travelList.removeTravel(travel);
            }
        }
    }

    private void setCateringFilter(CateringType cateringFilter) {
        TravelCollection travelListCopy = cloneTravelCollection(travelList);
        for (Travel travel : travelListCopy.getTravelList()) {
            if (isEmptyCateringFilter(travel, cateringFilter)) {
                travelList.removeTravel(travel);
            }
        }
    }

    private void setTravelFilter(TravelType travelFilter) {
        TravelCollection travelListCopy = cloneTravelCollection(travelList);
        for (Travel travel : travelListCopy.getTravelList()) {
            if (isEmptyTravelFilter(travel, travelFilter)) {
                travelList.removeTravel(travel);
            }
        }
    }

    private void setTransportFilter(TransportType transportFilter) {
        TravelCollection travelListCopy = cloneTravelCollection(travelList);
        for (Travel travel : travelListCopy.getTravelList()) {
            if (isEmptyTransportFilter(travel, transportFilter)) {
                travelList.removeTravel(travel);
            }
        }
    }

    private boolean isEmptyDestinationFilter(Travel travel, City city) {
        return city != null && city != travel.getDestination();
    }

    private boolean isEmptyDepartureFilter(Travel travel, City city) {
        return city != null && city != travel.getDeparture();
    }

    private boolean isEmptyCateringFilter(Travel travel, CateringType cateringTypeForFilter) {
        return cateringTypeForFilter != null && cateringTypeForFilter != travel.getCateringType();
    }

    private boolean isEmptyTransportFilter(Travel travel, TransportType transportTypeForFilter) {
        return transportTypeForFilter != null && transportTypeForFilter != travel.getTransportType();
    }

    private boolean isEmptyTravelFilter(Travel travel, TravelType travelTypeForFilter) {
        return travelTypeForFilter != null && travelTypeForFilter != travel.getTravelType();
    }

    private void showListWithFilters() {
        if (travelList.getTravelList().size() > 0) {
            System.out.println(travelList.toString());
        } else {
            System.out.println("Nothing to show. Reset filters.");
        }
    }

    private void resetFilters() {
        travelList = cloneTravelCollection(travelCollection);
    }

    private City getCityFilter(Scanner scanner) {
        Integer deepFilter;
        City city = null;
        deepFilter = Service.getInputNumber(scanner, message4);
        if (deepFilter != null) {
            city = City.getCityByOrdinal(--deepFilter);
        }
        return city;
    }

    private void getCateringTypeFilter(Scanner scanner) {
        CateringType cateringTypeForFilter = null;
        Integer deepFilter;
        deepFilter = Service.getInputNumber(scanner, message3);
        if (deepFilter != null) {
            cateringTypeForFilter = CateringType.getCateringByOrdinal(--deepFilter);
        }

        setCateringFilter(cateringTypeForFilter);
        showListWithFilters();
    }

    private void getTransportTypeFilter(Scanner scanner) {
        TransportType transportTypeForFilter = null;
        Integer deepFilter;
        deepFilter = Service.getInputNumber(scanner, message2);
        if (deepFilter != null) {
            transportTypeForFilter = TransportType.getTransportByOrdinal(--deepFilter);
        }

        setTransportFilter(transportTypeForFilter);
        showListWithFilters();
    }

    private void getTravelTypeFilter(Scanner scanner) {
        TravelType travelTypeForFilter = null;
        Integer deepFilter;
        deepFilter = Service.getInputNumber(scanner, message1);
        if (deepFilter != null) {
            travelTypeForFilter = TravelType.getTravelByOrdinal(--deepFilter);
        }

        setTravelFilter(travelTypeForFilter);
        showListWithFilters();
    }

    private TravelCollection cloneTravelCollection(TravelCollection collectionFrom) {
        TravelCollection collectionTo = new TravelCollection();
        try {
            collectionTo = (TravelCollection) collectionFrom.clone();
            collectionTo.setTravelList((ArrayList<Travel>) collectionFrom.getTravelList().clone());
        } catch (CloneNotSupportedException e) {
            System.out.println("Something wrong with travel collection creating.");
            e.printStackTrace();
        }
        return collectionTo;
    }
}
