package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 10. Дано натуральное число N. Написать метод(методы) для формирования массива,
 * элементами которого являются цифры числа N.
 */

public class Task10 {
    public static void main(String[] args) {
        int number = inputNumber();
        printArray(createArray(number));
    }

    private static void printArray(int[] array) {
        System.out.print("array = ");
        for (int item : array) {
            System.out.printf("%3s", item);
        }
    }

    private static int[] createArray(int number) {
        int length = Integer.toString(number).length();
        int[] array = new int[Integer.toString(number).length()];
        for (int i = length - 1; i > -1; i--) {
            array[i] = number % 10;
            number /= 10;
        }
        return array;
    }

    private static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        return scanner.nextInt();
    }
}
