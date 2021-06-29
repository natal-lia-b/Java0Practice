package topic2.part1_oneDimensionalArrays;
/**
 * 10. Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
 * элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task10 {
    static Scanner scanner;
    static int[] array;

    public static void main(String[] args) {
        initiateArray();
        fillArray();
        squeeze();
        printArray();
    }
    static void printArray() {
        System.out.print("New array:" + Arrays.toString(array));
    }

    private static void squeeze() {
        for (int i = 1, j = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i / 2] = array[i];
            }
            array[i] = 0;
        }
    }

    private static void initiateArray() {
        scanner = new Scanner(System.in);
        System.out.println("Enter array dimension and press <Enter>:");
        int n = scanner.nextInt();
        array = new int[n];
    }

    static void fillArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number a" + i + " :");
            array[i] = scanner.nextInt();
        }
    }
}
