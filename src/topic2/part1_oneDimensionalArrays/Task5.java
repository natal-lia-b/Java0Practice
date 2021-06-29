package topic2.part1_oneDimensionalArrays;

import java.util.Scanner;

/**
 * 5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
 */

public class Task5 {
    static Scanner scanner;
    static int[] array;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Enter count of numbers and press <Enter>:");
        int n = scanner.nextInt();
        array = new int[n];
        fillArray();
        checkArray();
    }

    private static void checkArray() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i) {
                System.out.println("a" + i + " = " + array[i]);
            }
        }
    }

    static void fillArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number a" + i + " :");
            array[i] = scanner.nextInt();
        }
    }
}
