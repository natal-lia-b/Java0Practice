package topic2.part3_sortings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 3. Сортировка выбором. Дана последовательность чисел a.
 * Требуется переставить элементы так, чтобы они были расположены по убыванию.
 * Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится на первое место,
 * а первый - на место наибольшего. Затем, начиная со второго, эта процедура повторяется.
 * Написать алгоритм сортировки выбором.
 */

public class Task3 {
    private static int[] array1;

    public static void main(String[] args) {
        createArray();
        sortArray();
    }

    private static void sortArray() {
        for (int i = 0; i < array1.length; i++) {
            int max = array1[i];
            int index = i;
            for (int j = i + 1; j < array1.length; j++) {
                if (array1[j] > max) {
                    max = array1[j];
                    index = j;
                }
            }
            if (index > i) {
                array1[index] = array1[i];
                array1[i] = max;
            }
        }
        printArray("reverted array = ");
    }

    private static void printArray(String s) {
        System.out.println(s + Arrays.toString(array1));
    }

    private static void createArray() {
        array1 = new int[inputArrayLength()];
        fillArray();
        printArray("initial array  = ");
    }

    private static void fillArray() {
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 101);
        }
    }

    private static int inputArrayLength() {
        Scanner scanner = new Scanner(System.in);
        int arrayLength;
        do {
            System.out.print("Input array length: ");
            arrayLength = scanner.nextInt();
            if (arrayLength <= 0) {
                System.out.printf("%d must be positive, try again. ", arrayLength);
            }
        } while (arrayLength <= 0);
        return arrayLength;
    }
}
