package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 8. Задан массив D. Определить следующие суммы:
 * D[l] + D[2] + D[3];
 * D[3] + D[4] + D[5];
 * D[4] + D[5] + D[6].
 * Пояснение. Составить метод(методы) для вычисления
 * суммы трех последовательно расположенных элементов массива с номерами от k до m.
 */

public class Task8 {
    private static int[] array;

    public static void main(String[] args) {
        fillArray();
        System.out.println("Sum = " + computeSum(inputNumber("k", 0, array.length - 3)));
    }

    private static int computeSum(int k) {
        int m = k + 3;
        int sum = 0;
        for (int i = k; i < m; i++) {
            sum += array[i];
        }
        return sum;
    }

    private static void fillArray() {
        int n = inputNumber("amount", 3, Integer.MAX_VALUE);
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * 101);
        }
        printArray();
    }

    private static void printArray() {
        System.out.print("Array = ");
        for (int number : array) {
            System.out.printf("%5d ", number);
        }
        System.out.println();
    }

    private static int inputNumber(String s, int minNumber, int maxNumber) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.printf("Input %s: ", s);
            number = scanner.nextInt();
            if (number < minNumber) {
                System.out.printf("%s must be greater than %d, try again. ", s, minNumber);
            } else if (number > maxNumber) {
                System.out.printf("Number must be lower than %d to fit the task, try again.\n", array.length - 2);
            }
        } while (number < minNumber || number > maxNumber);
        return number;
    }
}
