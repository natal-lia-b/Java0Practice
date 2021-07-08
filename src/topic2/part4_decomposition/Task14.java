package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 14. Натуральное число, в записи которого n цифр, называется числом Армстронга,
 * если сумма его цифр, возведеннЫХ в степень n, равна самому числу.
 * Найти все числа Армстронга от 1 до k.
 * Для решения задачи использовать декомпозицию.
 */

public class Task14 {
    private static int k;

    public static void main(String[] args) {
        k = inputNumber("K") + 1;
        findArmstrongNumbers();
    }

    private static void findArmstrongNumbers() {
        int count = 0;
        for (int i = 1; i < k; i++) {
            int n = findLength(i);
            if (findDigitsSum(i, n) == i) {
                System.out.printf("%5d  ", i);
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }

    private static int findLength(int number) {
        return Integer.toString(Math.abs(number)).length();
    }

    private static int findDigitsSum(int number, int n) {
        int digit;
        int sum = 0;
        while (number > 0) {
            digit = number % 10;
            sum += Math.pow(digit, n);
            if (sum > k) {
                break;
            }
            number = number / 10;
        }
        return sum;
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
