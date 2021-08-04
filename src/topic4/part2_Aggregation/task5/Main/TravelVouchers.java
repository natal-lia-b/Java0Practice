package topic4.part2_Aggregation.task5.Main;

import topic4.part2_Aggregation.task5.actions.FillTravelCollection;
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

class TravelVouchers {

    //    private static final Logger log = Logger.getLogger(MainTask04.class);
    public static final String FILE_PATH = "v:\\Projects\\Java0Practice\\src\\topic4\\part2_Aggregation\\task5\\Data.txt";

    private static void start() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        while (true) {
            System.out.println("WELCOME!  We'll do our best to find your travel.\n" +
                    "1 - fill the collection,\n" +
                    "0 - exit.");
            int inputNumber;
            try {
                inputNumber = Integer.valueOf(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Something is wrong, try again.");
                continue;
//            } catch (Exception e) {
//                System.out.println("Something is wrong, try again.");
            }
            TravelCollection oneTravel = new TravelCollection();

            switch (inputNumber) {
                case 1:
                    File file = new File(FILE_PATH);
                    FillTravelCollection fillTravelCollection = new FillTravelCollection(file, oneTravel);
                    fillTravelCollection.fill();
                    System.out.println(oneTravel.toString());
                    break;
                case 0:
                    System.out.println("We were glad to see you, come again! Bye!");
                    return;
                default:
                    System.out.println("Bad number, try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        start();
    }
}

