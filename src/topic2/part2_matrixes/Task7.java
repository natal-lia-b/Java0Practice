package topic2.part2_matrixes;

import java.util.Scanner;

/**
 * 7. Сформировать квадратную матрицу порядка N по правилу: см. Task7.jpg
 * и подсчитать количество положительных элементов в ней.
 */

public class Task7 {
    static Scanner scanner;
    static double[][] matrix;

    public static void main(String[] args) {
        createMatrix();
        fillMatrix();
        printMatrix();
        countPositiveItems();
    }

    private static void countPositiveItems() {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > 0) {
                    count++;
                }
            }
        }
        System.out.printf("Count of positive numbers = %d", count);
    }

    private static void fillMatrix() {
        int n = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = Math.sin((i * i - j * j) / n);
            }
        }
    }

    private static void createMatrix() {
        scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Input positive n: ");
            n = scanner.nextInt();
            if (n < 0) {
                System.out.printf("%d is not positive number. ", n);
            }
        } while (n <= 0);
        matrix = new double[n][n];
    }

    static void printMatrix() {
        System.out.println("matrix = ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%5.5f ", matrix[i][j]);
//                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
