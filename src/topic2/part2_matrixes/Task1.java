package topic2.part2_matrixes;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 */
public class Task1 {
    static Scanner scanner;
    static int[][] matrix;

    public static void main(String[] args) {
        initiateMatrix();
        fillMatrix();
        printMatrix();
    }

    static void printMatrix() {
        System.out.println("New array:");
        for (int i = 0; i < matrix.length; i += 2) {
            if (matrix[i][0] > matrix[i][matrix[0].length - 1]) {
                System.out.println(Arrays.toString(matrix[i]));
            }
        }
    }

    private static void initiateMatrix() {
        scanner = new Scanner(System.in);
        System.out.println("Enter matrix dimension N and press <Enter>:");
        int n = scanner.nextInt();
        System.out.println("Enter matrix dimension M and press <Enter>:");
        int m = scanner.nextInt();
        matrix = new int[n][m];
    }

    static void fillMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("Enter matrix[" + i + "][" + j + "] :");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}
