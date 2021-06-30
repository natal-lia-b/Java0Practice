package topic2.part2_matrixes;

import java.util.Scanner;

/**
 * 6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное): см. Task6.jpg
 */

public class Task6 {
    static Scanner scanner;
    static int[][] matrix;

    public static void main(String[] args) {
        createMatrix();
        fillMatrix();
        printMatrix();
    }

    private static void fillMatrix() {
        int lastIndex = matrix.length - 1;
        int halfLength = matrix.length / 2;
        final int ONE = 1;
        for (int i1 = 0, in = lastIndex; i1 < halfLength; i1++, in--) {
            for (int j1 = 0, jn = lastIndex; j1 < halfLength; j1++, jn--) {
                if (i1 <= j1) {
                    matrix[i1][j1] = ONE;
                    matrix[i1][jn] = ONE;
                    matrix[in][j1] = ONE;
                    matrix[in][jn] = ONE;
                }
            }
        }
    }

    private static void createMatrix() {
        scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Input positive even n: ");
            n = scanner.nextInt();
            if (n < 0) {
                System.out.printf("%d is not positive number. ", n);
            } else if (n % 2 != 0) {
                System.out.printf("%d is not even number. ", n);
                n = -1;
            }
        } while (n <= 0);
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
