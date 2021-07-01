package topic2.part3_sortings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2. Даны две последовательности (см. Task2.jpg). Образовать из них новую последовательность
 * чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
 */

public class Task2 {
    private static int[] array1;
    private static int[] array2;

    public static void main(String[] args) {
        createArrays();
        unionArrays();
        printArray("result array = ", array1);
    }

    private static void printArray(String s, int[] array) {
        System.out.println(s + Arrays.toString(array));
    }

    private static void unionArrays() {
        int length1 = array1.length;
        array1 = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, array1, length1, array2.length);
        Arrays.sort(array1);
    }

    private static void createArrays() {
        array1 = createArray("1st");
        array2 = createArray("2nd");
        printArray("1st", array1);
        printArray("2nd", array2);
    }

    private static int[] createArray(String s) {
        int[] array = new int[inputArrayLength(s)];
        fillArray(array);
        return array;
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 21);
        }
    }

    private static int inputArrayLength(String s) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength;
        do {
            System.out.printf("Input %s array length: ", s);
            arrayLength = scanner.nextInt();
            if (arrayLength <= 0) {
                System.out.printf("%d must be positive, try again. ", arrayLength);
            }
        } while (arrayLength <= 0);
        return arrayLength;
    }
}
