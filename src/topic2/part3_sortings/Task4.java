package topic2.part3_sortings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 4. Сортировка обменами.
 * Дана последовательность чисел (см. Task2.jpg, последовательность а).
 * Требуется переставить числа в порядке возрастания.
 * Для этого сравниваются два соседних числа ai и ai+1. Если ai > ai+1 , то делается
 * перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
 * Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
 */

public class Task4 {
    private static int[] array1;

    public static void main(String[] args) {
        createArray();
        sortWithExchanges();
    }

    private static void sortWithExchanges() {
        int lastIndex = array1.length - 1;
        int count = 0;
        for (int i = 0; i < lastIndex; i++) {
            for (int j = 0; j < lastIndex; j++) {
                if (array1[j] > array1[j + 1]) {
                    int copyNumber = array1[j];
                    array1[j] = array1[j + 1];
                    array1[j + 1] = copyNumber;
                    count++;
                }
            }
        }
        printArray("Sorted array  = ");
        System.out.printf("Count of exchanges = %d", count);
    }

    private static void printArray(String s) {
        System.out.println(s + Arrays.toString(array1));
    }

    private static void createArray() {
        array1 = new int[inputArrayLength()];
        fillArray();
        printArray("Initial array = ");
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
