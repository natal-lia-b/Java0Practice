package topic2.part2_matrixes;

import java.util.Scanner;

/**
 * 14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
 * единиц равно номеру столбца.
 */

public class Task14 {
    static int[][] matrix;

    public static void main(String[] args) {
        createMatrix();
        printMatrix();
    }

    private static void createMatrix() {
        int m = inputDimension("m");
        int n = inputDimension("n");
        matrix = new int[m][n];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int c = 0; c < j; c++) {
                while (true) {
                    int index = getIndex();
                    if (matrix[index][j] != 1) {
                        matrix[index][j] = 1;
                        break;
                    }
                }
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
