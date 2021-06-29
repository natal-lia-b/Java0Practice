package topic2.part2_matrixes;
/**
 * 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */

import java.util.Scanner;

public class Task3 {
    static Scanner scanner;
    static int[][] matrix;

    public static void main(String[] args) {
        initiateMatrix();
        fillMatrix();
        printWholeMatrix();
        printRow();
        printColumn();
    }

    private static void printColumn() {
        System.out.println("Enter p:");
        int p = scanner.nextInt();
        try {
            if (p <= matrix[0].length) {
                System.out.print("Column p: ");
                for (int i = 0; i < matrix.length; i++) {
                    System.out.print(matrix[i][p] + " ");
                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("wrong index.");
        }
    }

    static void printRow() {
        System.out.println("Enter k:");
        int k = scanner.nextInt();
        try {
            if (k <= matrix.length) {
                System.out.print("Row k: ");
                for (int i = 0; i < matrix[0].length; i++) {
                    System.out.print(matrix[k][i] + " ");
                }
                System.out.println("");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("wrong index.");
        }
    }

    static void printWholeMatrix() {
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
        System.out.println("Enter matrix dimension n and press <Enter>:");
        int n = scanner.nextInt();
        System.out.println("Enter matrix dimension m and press <Enter>:");
        int m = scanner.nextInt();
        matrix = new int[n][m];
    }

    static void fillMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("Enter element[" + i + "][" + j + "] :");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}
