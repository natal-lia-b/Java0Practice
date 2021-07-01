package topic2.part2_matrixes;

import java.util.Scanner;

/**
 * 10. Найти положительные элементы главной диагонали квадратной матрицы.
 */

public class Task10 {
    static int[][] matrix;

    public static void main(String[] args) {
        createMatrix();
        printMatrix();
        printPositiveElements();
    }

    private static void printPositiveElements() {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] > 0) {
                System.out.print(matrix[i][i] + " ");
            }
        }
    }

    // create matrix by my own way
    private static void createMatrix() {
        int k = inputDimension();
        matrix = new int[k][k];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int sign = (int) (Math.random() * 100);
                int number = (int) (Math.random() * 10);
                matrix[i][j] = sign % 2 == 0 ? number : -number;
            }
        }
    }

    private static int inputDimension() {
        Scanner scanner = new Scanner(System.in);
        int k;
        do {
            System.out.print("Input matrix dimension: ");
            k = scanner.nextInt();
            if (k < 0) {
                System.out.printf("%d is negative, try again. ", k);
            }
        } while (k < 0);
        return k;
    }

    static void printMatrix() {
        System.out.println("matrix = ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%5d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
