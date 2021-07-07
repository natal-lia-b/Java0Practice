package topic2.part4_decomposition;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5. Составить программу, которая в массиве A[N] находит второе по величине число
 * (вывести на печать число, которое меньше максимального элемента массива, но больше всех других элементов).
 */

public class Task5 {
    private static int[] array;

    public static void main(String[] args) {
        fillArray();
        findTheSecondLargestItem();
    }

    private static void fillArray() {
        int n = inputAmount();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * 101);
        }
        printArray();
    }

    private static void printArray() {
        System.out.println("Initial sequence = ");
        for (int number : array) {
            System.out.printf("%5d ", number);
        }
        System.out.println();
    }

    private static void findTheSecondLargestItem() {
        Arrays.sort(array);
        System.out.printf("The second largest item = %5d", array[array.length - 2]);
    }

    private static int inputAmount() {
        int amount;
        do {
            amount = inputNumber("amount");
            if (amount < 2) {
                System.out.printf("%d must be greater than 1, try again. ", amount);
            }
        } while (amount < 2);
        return amount;
    }

    private static int inputNumber(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s : ", s);
        return scanner.nextInt();
    }
}
