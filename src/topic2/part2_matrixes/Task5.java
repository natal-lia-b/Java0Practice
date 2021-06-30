package topic2.part2_matrixes;

import java.util.Scanner;

/**
 * 5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

public class Task5 {
    static Scanner scanner;
    static int[][] matrix;

    public static void main(String[] args) {
        createMatrix();
        fillMatrix();
        printMatrix();
    }

    private static void fillMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = j < matrix.length - i? i + 1 : 0;
            }

        }
    }

    private static void createMatrix() {
        scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Input n: ");
            n = scanner.nextInt();
        } while (n < 0);
        matrix = new int[n][n];
    }

    static void printMatrix() {
        System.out.println("matrix = ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
