package topic2.part1_oneDimensionalArrays;

import java.util.Scanner;

/**
 * 3. Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
 * положительных и нулевых элементов.
 */

public class Task3 {
    static Scanner scanner;
    static double[] array;
    static int negativeCount;
    static int positiveCount;
    static int zeroCount;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Enter number and press <Enter>:");
        int n = scanner.nextInt();
        array = new double[n];
        count();
        System.out.println("Count of positive elements = " + positiveCount);
        System.out.println("Count of negative elements = " + negativeCount);
        System.out.println("Count of zeros = " + zeroCount);
    }

    static void count() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter [" + i + "] element of array:");
            array[i] = scanner.nextDouble();

            if (array[i] > 0) {
                positiveCount++;
            } else if (array[i] < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }
    }
}
