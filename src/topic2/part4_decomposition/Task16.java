package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 16. Написать программу, определяющую сумму n-значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме.
 * Для решения задачи использовать декомпозицию.
 */

public class Task16 {
    public static void main(String[] args) {
        findSum(inputN());
    }

    private static void findSum(int n) {
        int firstI = (int) Math.pow(10, n - 1);
        int lastI = (int) Math.pow(10, n);
        int sum = 0;
        for (int i = firstI; i < lastI; i++) {
            int oddDigitsSum = findOddDigitsSum(i);
            if (oddDigitsSum > 0) {
                sum += i;
            }
        }
        System.out.printf("Sum of n-digits numbers including only odd digits = %d\n", sum);
        System.out.printf("Sum of even digits = %d", findEvenDigitsSum(sum));
    }

    private static int findEvenDigitsSum(int number) {
        int digit;
        int sum = 0;
        while (number > 0) {
            digit = number % 10;
            if (digit % 2 == 0) {
                sum += digit;
            }
            number = number / 10;
        }
        return sum;
    }

    private static int findOddDigitsSum(int number) {
        int digit;
        int sum = 0;
        while (number > 0) {
            digit = number % 10;
            if (digit % 2 == 0) {
                sum = 0;
                break;
            }
            sum += digit;
            number = number / 10;
        }
        return sum;
    }

    private static int inputN() {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Input N: ");
            number = scanner.nextInt();
            if (number < 1) {
                System.out.printf("%d must be > 0, try again. ", number);
            }
        } while (number < 1);
        return number;
    }
}
