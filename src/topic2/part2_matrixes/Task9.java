package topic2.part2_matrixes;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
 * столбец содержит максимальную сумму.
 */

public class Task9 {
    static int[][] matrix;

    public static void main(String[] args) {
        createMatrix();
        printMatrix();
        findResult();
    }

    private static void findResult() {
        int[] array = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                array[j] += matrix[i][j];
            }
        }
        System.out.println(Arrays.toString(array));
        findMin(array);
    }

    private static void findMin(int[] array) {
        Arrays.sort(array);
        System.out.println(array[0]);
    }

    // create matrix by my own way
    private static void createMatrix() {
        int k = inputDimension("k");
        int p = inputDimension("p");
        matrix = new int[k][p];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    private static int inputDimension(String s) {
        Scanner scanner = new Scanner(System.in);
        int k;
        do {
            System.out.printf("Input matrix dimension %s: ", s);
            k = scanner.nextInt();
            if (k < 0) {
                System.out.printf("%d is negative, try again. ", k);
            }
        } while (k < 0);
        return k;
    }

    static void printMatrix() {
        System.out.println("matrix= ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%5d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
