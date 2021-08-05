package topic4.part2_Aggregation.task5.actions;

import java.util.Scanner;

public class Service {

    public static Integer getInputNumber(Scanner scanner, String message) {
        System.out.print(message);
        Integer inputNumber;
        try {
            inputNumber = Integer.valueOf(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Something is wrong, try again.");
            return null;
        }
        return inputNumber;
    }

}
