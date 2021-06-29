package topic2.part2_matrixes;
/**
 * 4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное): см. Task4.jpg
 */

import java.util.Scanner;

public class Task4 {
    static Scanner scanner;
    static int[][] matrix;

    public static void main(String[] args) {
        initiateMatrix();
        fillFirstRow();
        fillMatrix();
        printMatrix();
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

    private static void initiateMatrix() {
        scanner = new Scanner(System.in);
        int n;
        do {
            System.out.println("Enter matrix dimension N (even number) and press <Enter>:");
            n = scanner.nextInt();
        } while (n % 2 != 0);
        matrix = new int[n][n];
    }

    static void fillFirstRow() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Enter first row element[" + 0 + "][" + i + "] :");
            matrix[0][i] = scanner.nextInt();
        }
    }

    static void fillMatrix() {
        for (int i = 1; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = matrix[0][j];
                }
            } else {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = matrix[0][matrix.length - j - 1];
                }
            }
        }
    }
}
