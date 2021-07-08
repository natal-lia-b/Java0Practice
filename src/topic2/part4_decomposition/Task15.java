package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 15. Найти все натуральные n-значные числа, цифры в которых образуют
 * строго возрастающую последовательность (например, 1234, 5789).
 * Для решения задачи использовать декомпозицию.
 */

public class Task15 {
    public static void main(String[] args) {
        int digitsAmount = inputDigitsAmount();
        findNumbers(digitsAmount);
    }

    private static void findNumbers(int digitsAmount) {
        int maxNumber = findMaxNumber(digitsAmount);
        int minNumber = findMinNumber(digitsAmount);
        int n = 0;
        for (int i = minNumber; i < maxNumber; i++) {
            if (isGrowingSequence(i)) {
                System.out.printf("%10d", i);
                n++;
                if (n % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }

    private static boolean isGrowingSequence(int number) {
        boolean isGrowingSequence = true;
        int digit = 9;

        while (number > 0) {
            if (number % 10 >= digit) {
                isGrowingSequence = false;
                break;
            }
            digit = number % 10;
            number = number / 10;
        }
        return isGrowingSequence;
    }

    private static int findMinNumber(int digitsAmount) {
        return (int) Math.pow(10, digitsAmount - 1);
    }

    private static int findMaxNumber(int digitsAmount) {
        return (int) Math.pow(10, digitsAmount);
    }

    private static int inputDigitsAmount() {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Input amount of digits :");
            number = scanner.nextInt();
            if (number <= 0) {
                System.out.printf("%d must be greater than 0, try again. ", number);
            }
        } while (number <= 0);
        return number;
    }

}
