package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
 * Сколько таких действий надо произвести, чтобы получился нуль?
 * Для решения задачи использовать декомпозицию.
 */

public class Task17 {
    public static void main(String[] args) {
        System.out.printf("Count = %d", findCount(inputN()));
    }

    private static int findCount(int n) {
        int count = 0;
        do {
            n -= findDigitsSum(n);
            count++;
        } while (n > 0);
        return count;
    }

    private static int findDigitsSum(int number) {
        int digit;
        int sum = 0;
        while (number > 0) {
            digit = number % 10;
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
