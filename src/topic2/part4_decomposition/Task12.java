package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 12. Даны натуральные числа К и N.
 * Написать метод(методы) формирования массива А, элементами которого являются числа,
 * сумма цифр которых равна К и которые не больше N.
 */

public class Task12 {
    private static int k;
    private static int n;

    public static void main(String[] args) {
        inputNumbers();
        int[] array = fillArray();
        printArray(array);
    }

    private static void printArray(int[] array) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] > 0) {
                System.out.printf("%10d", array[i]);
                n++;
                if (n % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }

    private static int[] fillArray() {
        int[] array = new int[n];
        int cycleN = n + 1;
        int n = 0;
        for (int i = 0; i < cycleN; i++) {
            if (findDigitsSum(i) == k) {
                array[n] = i;
                n++;
            }
        }
        return array;
    }

    private static int findDigitsSum(int number) {
        int digit;
        int sum = 0;
        while (number > 0) {
            digit = number % 10;
            sum += digit;
            if (sum > k) {
                break;
            }
            number = number / 10;
        }
        return sum;
    }

    private static void inputNumbers() {
        k = inputNumber("K");
        n = inputNumber("N");
    }

    private static int inputNumber(String s) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.printf("Input %s: ", s);
            number = scanner.nextInt();
            if (number < 0) {
                System.out.printf("%d must be >= 0, try again. ", number);
            }
        } while (number < 0);
        return number;
    }

}
