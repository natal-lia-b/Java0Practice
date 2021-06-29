package topic2.part1_oneDimensionalArrays;

import java.util.Scanner;

/**
 * 4. Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
 */

public class Task4 {
    static Scanner scanner;
    static double[] array;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Enter number and press <Enter>:");
        int n = scanner.nextInt();
        array = new double[n];
        fillArray();
        swap();
        printArray();
    }

    static void fillArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter [" + i + "] element of array:");
            array[i] = scanner.nextDouble();
        }
    }

    static void swap() {
        int indexMin = 0;
        double min = array[0];
        int indexMax = 0;
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexMin = i;
            } else if (array[i] > max) {
                max = array[i];
                indexMax = i;
            }
        }
        array[indexMin] = max;
        array[indexMax] = min;
    }

    static void printArray() {
        System.out.println("Array after swap:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }
}
