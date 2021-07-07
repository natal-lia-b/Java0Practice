package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 */
public class Task2 {
    public static void main(String[] args) {
        findGCF();
    }

    private static void findGCF() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        int greatestCommonFactor = scanner.nextInt();

        for (int i = 1; i < 4; i++) {
            System.out.print("Input number: ");
            int number = scanner.nextInt();
            greatestCommonFactor = findGCF(greatestCommonFactor, number);
        }
        System.out.println(greatestCommonFactor);
    }

    // НОД
    private static int findGCF(int b, int a) {
        while (a != 0 && b != 0) {
            if (a >= b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a == 0 ? b : a;
    }
}
