package topic2.part3_sortings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
 * один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
 * дополнительный массив.
 */

public class Task1 {
    static int[] array1;
    static int[] array2;

    public static void main(String[] args) {
        createArrays();
        int k = inputK();
        printArray("1st array = ", array1);
        printArray("2st array = ", array2);
        unionArrays(k);
        printArray("result array = ", array1);
    }

    private static void printArray(String s, int[] array) {
        System.out.println(s + Arrays.toString(array));
    }

    private static void unionArrays(int k) {
        int length1 = array1.length;
        array1 = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array1, k, array1, k + array2.length, length1 - k);
        System.arraycopy(array2, 0, array1, k, array2.length);
    }

    private static void createArrays() {
        array1 = createArray("1st", 0);
        array2 = createArray("2nd", array1.length);
    }

    private static int[] createArray(String s, int l) {
        int[] array = new int[inputArrayLength(s, l)];
        fillArray(array);
        return array;
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 11);
        }
    }

    private static int inputArrayLength(String s, int l) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength;
        do {
            System.out.printf("Input %s array length: ", s);
            arrayLength = scanner.nextInt();
            if (arrayLength <= 0) {
                System.out.printf("%d must be positive, try again. ", arrayLength);
            } else if (arrayLength == l) {
                System.out.print("The lenghts of arrays the must be different, try again. ");
            }
        } while (arrayLength <= 0 || arrayLength == l);
        return arrayLength;
    }

    private static int inputK() {
        Scanner scanner = new Scanner(System.in);
        int k;
        do {
            System.out.print("Input K: ");
            k = scanner.nextInt();
            if (k < 0) {
                System.out.printf("%d is negative, try again. ", k);
            } else if (k >= array1.length) {
                System.out.printf("%d is greater than 1st array length, try again. ", k);
            }
        } while (k < 0 || k >= array1.length);
        return k;
    }
}
