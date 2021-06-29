package topic2.part1_oneDimensionalArrays;
/**
 * 8. Дана последовательность целых чисел a1,a2,... ,an. Образовать новую последовательность, выбросив из
 * исходной те члены, которые равны min(a1,a2,... ,an).
 */

import java.util.Scanner;

public class Task8 {
    static Scanner scanner;
    static int[] array;

    public static void main(String[] args) {
        initiateArray();
        fillArray();
        createNewArray();
    }

    private static void createNewArray() {
        int min = findMin();
        int newLength = countNewLength(min);
        if (newLength > 0) {
            deleteMin(newLength, min);
            printArray();
        } else {
            System.out.println("Something's going wrong.");
        }
    }

    private static void deleteMin(int newLength, int min) {
        int[] newArray = new int[newLength];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != min) {
                newArray[j] = array[i];
                j++;
            }
        }
        array = newArray;
    }

    static void printArray() {
        System.out.println("Array without min elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }


    private static int countNewLength(int min) {
        int newLength = array.length;
        for (int element : array) {
            if (element == min) {
                newLength--;
            }
        }
        return newLength;
    }

    private static int findMin() {
        int min = array[0];
        for (int element : array) {
            min = Integer.min(min, element);
        }
        return min;
    }

    private static void initiateArray() {
        scanner = new Scanner(System.in);
        System.out.println("Enter count of numbers and press <Enter>:");
        int n = scanner.nextInt();
        array = new int[n];
    }

    static void fillArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number a" + i + " :");
            array[i] = scanner.nextInt();
        }
    }
}
