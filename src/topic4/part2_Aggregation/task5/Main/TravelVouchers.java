package topic4.part2_Aggregation.task5.Main;

import topic4.part2_Aggregation.task5.actions.FillTravelCollection;
import topic4.part2_Aggregation.task5.actions.FilterVouchers;
import topic4.part2_Aggregation.task5.actions.Service;
import topic4.part2_Aggregation.task5.entities.TravelCollection;

import java.io.File;
import java.util.Scanner;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * <p>
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

    //    private static final Logger log = Logger.getLogger(MainTask04.class);
    private static final String FILE_PATH = "v:\\Projects\\Java0Practice\\src\\topic4\\part2_Aggregation\\task5\\Data.txt";

    private static void start() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("WELCOME!  We'll do our best to find your travel.\n");
        String message = "\nMain menu:\n" +
                "1 - show travel collection including all available tours,\n" +
                "2 - set filters,\n" +
                "0 - exit.\n" +
                "Choose the action: ";
        TravelCollection filteredTravel = new TravelCollection();
        TravelCollection travelCollection = new TravelCollection();
        fillCollection(travelCollection);

        OUT0: while (true) {
            Integer inputNumber = Service.getInputNumber(scanner, message);
            if (inputNumber == null) continue;

            switch (inputNumber) {
                case 1:
                    System.out.println(travelCollection.toString());
                    break;
                case 2:
                    FilterVouchers filterVouchers = new FilterVouchers(travelCollection);
                    filterVouchers.setFilters(scanner);
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

    private static void fillCollection(TravelCollection oneTravel) {
        File file = new File(FILE_PATH);
        FillTravelCollection fillTravelCollection = new FillTravelCollection(file, oneTravel);
        fillTravelCollection.fill();
    }

    public static void main(String[] args) {
        start();
    }
}

