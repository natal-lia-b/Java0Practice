package topic2.part1_oneDimensionalArrays;
/**
 * 9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
 * чисел несколько, то определить наименьшее из них.
 */

import java.util.Scanner;

public class Task9 {
    static Scanner scanner;
    static int[] array;

    public static void main(String[] args) {
        initiateArray();
        fillArray();
        findMinPopularNumber();
    }

    private static void findMinPopularNumber() {
        int[] numbers = new int[array.length];
        int[] indexes = new int[array.length];
        for (int i = 0, j = 0; i < array.length; i++) {
            int index = findElement(numbers, array[i]);
            if (index > 0) {
                indexes[index] += 1;
            } else {
                numbers[j] = array[i];
                indexes[j] += 1;
                j++;
            }
        }
        findMinNumber(findPopularIndex(indexes), indexes, numbers);

    }

    private static void findMinNumber(int popularIndex, int[] indexes, int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (indexes[i] == popularIndex && numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("Min popular number = " + min);
    }

    private static int findPopularIndex(int[] indexes) {
        int popularIndex = indexes[0];
        for (int i = 1; i < indexes.length; i++) {
            popularIndex = Integer.max(indexes[i], popularIndex);
        }
        return popularIndex;
    }

    private static int findElement(int[] arr, int element) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == element) {
                return i;
            }
            i++;
        }
        return -1;
    }


    private static void initiateArray() {
        scanner = new Scanner(System.in);
        System.out.println("Enter count of array elements and press <Enter>:");
        int n = scanner.nextInt();
        array = new int[n];
    }

    static void fillArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter a[" + i + "] :");
            array[i] = scanner.nextInt();
        }
    }
}
