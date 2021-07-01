package topic2.part2_matrixes;

import java.util.Scanner;

/**
 * 15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 */

public class Task15 {
    static int[][] matrix;

    public static void main(String[] args) {
        createMatrix();
        printMatrix();
        int max = maxItem();
        System.out.println(max);
        changeNegativeItems(max);
        printMatrix();
    }

    private static void changeNegativeItems(int max) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0) {
                    matrix[i][j] = max;
                }
            }
        }
    }

    private static int maxItem() {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int item : row) {
                max = Integer.max(item, max);
            }
        }
        return max;
    }

    // create matrix by my own way
    private static void createMatrix() {
        int m = inputDimension("m");
        int n = inputDimension("n");
        matrix = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int sign = (int) (Math.random() * 100);
                int number = (int) (Math.random() * 21);
                matrix[i][j] = sign % 2 == 0 ? number : -number;
            }
        }
    }

    private static int getIndex() {
        return (int) (Math.random() * matrix.length);
    }

    private static int inputDimension(String s) {
        Scanner scanner = new Scanner(System.in);
        int dimension;
        do {
            System.out.printf("Input matrix dimension %s: ", s);
            dimension = scanner.nextInt();
            if (dimension < 0) {
                System.out.printf("%d is negative, try again. ", dimension);
            }
        } while (dimension < 0);
        return dimension;
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
