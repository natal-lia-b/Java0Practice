package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 */

public class Task11 {
    public static void main(String[] args) {
        int numberA = inputNumber("A");
        int numberB = inputNumber("B");
        findLongerNumber(numberA, numberB);
    }

    private static void findLongerNumber(int numberA, int numberB) {
        int lengthA = findLength(numberA);
        int lengthB = findLength(numberB);
        System.out.println(lengthA == lengthB ? "The numbers have equal amount of digits." :
                lengthA > lengthB ? numberA : numberB);
    }

    private static int findLength(int number) {
        return Integer.toString(Math.abs(number)).length();
    }

    private static int inputNumber(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input number %s: ", s);
        return scanner.nextInt();
    }
}
