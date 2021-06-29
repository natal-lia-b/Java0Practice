package topic2.part1_oneDimensionalArrays;
/**
 * 7. Даны действительные числа a1,a2,... ,an. Найти: см. рис. Task7.jpg.
 */

import java.util.Scanner;

public class Task7 {
    static Scanner scanner;
    static double[] array;

    public static void main(String[] args) {
        initiateArray();
        fillArray();
        findMax();
    }

    private static void findMax() {
        double max = Double.MIN_VALUE;
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            max = Double.max(max, array[i] + array[j]);
        }
        System.out.println("max = " + max);
    }

    private static void initiateArray() {
        scanner = new Scanner(System.in);
        System.out.println("Enter count of numbers and press <Enter>:");
        int n = scanner.nextInt();
        array = new double[n];
    }

    static void fillArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number a" + i + " :");
            array[i] = scanner.nextDouble();
        }
    }
}
