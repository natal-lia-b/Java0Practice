package topic2.part2_matrixes;
/**
 * 2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */

import java.util.Scanner;

public class Task2 {
    static Scanner scanner;
    static int[][] matrix;

    public static void main(String[] args) {
        initiateMatrix();
        fillMatrix();
        printMatrix();
    }

    static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

    private static void initiateMatrix() {
        scanner = new Scanner(System.in);
        System.out.println("Enter matrix dimension and press <Enter>:");
        int n = scanner.nextInt();
        matrix = new int[n][n];
    }

    static void fillMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("Enter element[" + i + "][" + j + "]:");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}
