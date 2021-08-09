package topic4.part2_Aggregation.task5.main;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import topic4.part2_Aggregation.task5.actions.FillTravelCollection;
import topic4.part2_Aggregation.task5.actions.FilterVouchers;
import topic4.part2_Aggregation.task5.actions.Service;
import topic4.part2_Aggregation.task5.actions.SortVouchers;
import topic4.part2_Aggregation.task5.entities.TravelCollection;

import java.io.File;
import java.util.Scanner;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 *
 * 5. Туристические путевки.
 * Сформировать набор предложений клиенту по выбору туристической путевки различного типа
 * (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
 * Учитывать возможность выбора транспорта, питания и числа дней.
 * Реализовать выбор и сортировку путевок.
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public class TravelVouchers {

    static Logger logger = LogManager.getLogger(TravelVouchers.class);
    private static final String FILE_PATH = "src\\topic4\\part2_Aggregation\\task5\\Data.txt";

    private static void start() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("WELCOME!  We'll do our best to find your travel.\n");
        String message = "\nMain menu:\n" +
                "1 - show travel collection including all available tours,\n" +
                "2 - set filters,\n" +
                "3 - sort collection,\n" +
                "0 - exit.\n" +
                "Choose the action: ";
        TravelCollection travelCollection = new TravelCollection();
        fillCollection(travelCollection);

        OUT0:
        while (true) {
            Integer inputNumber = Service.getInputNumber(scanner, message);
            if (inputNumber == null) continue;

            switch (inputNumber) {
                case 1:
                    System.out.println(travelCollection.toString());
                    break;
                case 2:
                    filterCollection(scanner, travelCollection);
                    continue OUT0;
                case 3:
                    sortCollection(scanner, travelCollection);
                    continue OUT0;
                case 0:
                    System.out.println("We were glad to see you, come again. Bye!");
                    return;
                default: {
                    System.out.println("Bad input, try again.");
                }
            }
        }

    }

    private static void sortCollection(Scanner scanner, TravelCollection travelCollection) {
        SortVouchers sortedVouchers = new SortVouchers(travelCollection);
        sortedVouchers.sort(scanner);
    }

    private static void filterCollection(Scanner scanner, TravelCollection travelCollection) {
        FilterVouchers filterVouchers = new FilterVouchers(travelCollection);
        filterVouchers.setFilters(scanner);
    }

    private static void fillCollection(TravelCollection oneTravel) {
        File file = new File(FILE_PATH);
        FillTravelCollection fillTravelCollection = new FillTravelCollection(file, oneTravel);
        fillTravelCollection.fill();
    }

    public static void main(String[] args) {
        logger.log(Level.INFO, "app started.");
        start();
        logger.log(Level.INFO, "app finished.");
    }
}

