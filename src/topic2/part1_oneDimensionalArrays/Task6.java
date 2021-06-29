package topic2.part1_oneDimensionalArrays;

import java.util.Scanner;

/**
 * 6. Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
 * являются простыми числами.
 */

public class Task6 {
    static Scanner scanner;
    static double[] array;

    public static void main(String[] args) {
        initiateArray();
        fillArray();
        getSum();
    }

    private static void getSum() {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (isSimple(i)) {
                sum += array[i];
            }
        }
        System.out.println("Sum = " + sum);
    }

    private static boolean isSimple(int i) {
        int n = 2;
        while (n <= i / 2) {
            if (i % n == 0) {
                return false;
            }
            n++;
        }
        return true;
    }

    private static void initiateArray() {
        scanner = new Scanner(System.in);
        System.out.println("Enter count of numbers and press <Enter>:");
        int n = scanner.nextInt();
        array = new double[n];
    }

    private static void fillArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number a" + i + " :");
            array[i] = scanner.nextDouble();
        }
    }
}
