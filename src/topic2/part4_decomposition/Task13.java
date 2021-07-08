package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
 * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2.
 * Для решения задачи использовать декомпозицию.
 */

public class Task13 {
    public static void main(String[] args) {
        findSimpleTwins(inputN());
    }

    private static void findSimpleTwins(int n) {
        int lastN = 2 * n + 1;
        int simpleNumber = 1;
        for (int i = n; i < lastN; i++) {
            if (isSimpleNumber(i)) {
                if (i - simpleNumber == 2 && simpleNumber > 1) {
                    System.out.printf("%5d     - %5d\n", simpleNumber, i);
                }
                simpleNumber = i;
            }
        }
    }

    private static boolean isSimpleNumber(int number) {
        boolean isSimpleNumber = true;
        int i = 2;
        int halfNumber = number / 2 + 1;
        while (i < halfNumber) {
            if (number % i == 0) {
                isSimpleNumber = false;
                break;
            }
            i++;
        }
        return isSimpleNumber;
    }

    private static int inputN() {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Input N: ");
            number = scanner.nextInt();
            if (number < 3) {
                System.out.printf("\n%d must be > 2, try again. ", number);
            }
        } while (number < 3);
        return number;
    }
}
