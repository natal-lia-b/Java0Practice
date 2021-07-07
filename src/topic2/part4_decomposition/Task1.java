package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
 * натуральных чисел: (см. Task1.jpg).
 */

public class Task1 {
    public static void main(String[] args) {
        int a = inputNumber();
        int b = inputNumber();
        int greatestCommonFactor = findGCF(a, b);
        System.out.println("The greatest common factor (НОД) = " + greatestCommonFactor);
        System.out.println("The lowest common multiple (НОК) = " + findLCM(a, b, greatestCommonFactor));

    }
    // НОК
    private static int findLCM(int a, int b, int greatestCommonFactor) {
        return a * b / greatestCommonFactor;
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

    private static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Input number: ");
            number = scanner.nextInt();
            if (number <= 1) {
                System.out.printf("%d must be greater than 1, try again. ", number);
            }
        } while (number <= 1);
        return number;
    }
}
