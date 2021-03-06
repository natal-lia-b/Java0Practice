package topic4.part2_Aggregation.task5.action;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import topic4.part2_Aggregation.task5.entity.ExcursionTravel;
import topic4.part2_Aggregation.task5.entity.GeneralTravel;
import topic4.part2_Aggregation.task5.entity.MedicalTravel;
import topic4.part2_Aggregation.task5.entity.TravelCollection;
import topic4.part2_Aggregation.task5.enumeration.CateringType;
import topic4.part2_Aggregation.task5.enumeration.City;
import topic4.part2_Aggregation.task5.enumeration.TransportType;
import topic4.part2_Aggregation.task5.enumeration.TravelType;

import java.io.File;
import java.util.Scanner;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * ACTION: scan file and fill up the travel collection
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public class FillTravelCollection {

    static Logger logger = LogManager.getLogger();
    private static final int CITIES_FROM = 0;
    private static final int CITIES_TO = 30;

    private Scanner scanner;
    private TravelCollection travelCollection;
    private File file;
    private int counter;

    public FillTravelCollection(File file, TravelCollection travelCollection) {
        this.travelCollection = travelCollection;
        this.file = file;
    }

    public void fill() {
        logger.log(Level.INFO, "fill() started.");
        try {
            scanner = new Scanner(file);
            TravelValidator travelValidator = new TravelValidator();
            counter = 0;

            while (scanner.hasNext()) {
                String travel = scanner.next();
                String transport = scanner.next();
                String catering = scanner.next();
                int duration = scanner.nextInt();
                String departure = scanner.next();
                String destination = scanner.next();

                if (travelValidator.isTravel(travel, transport, catering, duration, departure, destination)) {
                    TravelType travelType = TravelType.valueOf(travel);
                    TransportType transportType = TransportType.valueOf(transport);
                    CateringType cateringType = CateringType.valueOf(catering);
                    City departurePoint = City.valueOf(departure);
                    City destinationPoint = City.valueOf(destination);

                    switch (TravelType.valueOf(travel)) {
                        case EXCURSION:
                            addExcursion(travelValidator, duration, travelType, transportType, cateringType, departurePoint, destinationPoint);
                            break;
                        case MEDICAL_TOURIZM:
                            addMedicalTourizm(travelValidator, duration, travelType, transportType, cateringType, departurePoint, destinationPoint);
                            break;
                        default:
                            travelCollection.addTravel(new GeneralTravel(travelType, transportType, cateringType, duration,
                                    departurePoint, destinationPoint));
                            break;

                    }
                    counter++;
                    logger.info("One item '" + travelType + "' was added");
                }
            }
        } catch (NullPointerException e) {
            logger.error("Ho-ho-ho! Null pointer exception is thrown!");
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("Exception during filling. Something have been gone in a wrong way!");
            e.printStackTrace();
        } finally {
            if (counter > 0) {
                System.out.println("Collection is filled up and contains " + counter + " elements. " +
                        "Now you can select your tour.");
                logger.info("Collection is filled up and contains " + counter + " elements. ");
            } else {
                System.out.println("Collection is NOT filled up! Check your file and try again.");
            }
            scanner.close();
        }
        logger.info("fill() finished.");
    }

    private void addMedicalTourizm(TravelValidator travelValidator, int duration, TravelType travelType,
                                   TransportType transportType, CateringType cateringType, City departurePoint, City destinationPoint) {
        String desease = scanner.next();
        if (travelValidator.isExceptionString(desease))
            desease = "";
        travelCollection.addTravel(new MedicalTravel(travelType, transportType, cateringType, duration,
                departurePoint, destinationPoint, desease));
    }

    private void addExcursion(TravelValidator travelValidator, int duration, TravelType travelType,
                              TransportType transportType, CateringType cateringType, City departurePoint, City destinationPoint) {
        int quantityOfCities = 0;
        if (scanner.hasNext()) {
            quantityOfCities = scanner.nextInt();
            if (travelValidator.isExceptionInt(quantityOfCities, "quantityOfCities",
                    CITIES_FROM, CITIES_TO))
                quantityOfCities = 0;
        }

        travelCollection.addTravel(new ExcursionTravel(travelType, transportType, cateringType, duration,
                departurePoint, destinationPoint, quantityOfCities));
    }
}
