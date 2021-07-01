package topic2.part2_matrixes;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */
public class Task12 {
    static int[][] matrix;

    public static void main(String[] args) {
        createMatrix();
        printMatrix();
        sortRowItems();
        printMatrix();
    }

    private static void sortRowItems() {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
    }

    // create matrix by my own way
    private static void createMatrix() {
        int k = inputDimension("k");
        int p = inputDimension("p");
        matrix = new int[k][p];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int sign = (int) (Math.random() * 100);
                int number = (int) (Math.random() * 21);
                matrix[i][j] = sign % 2 == 0 ? number : -number;
            }
        }
    }

    private static int inputDimension(String s) {
        Scanner scanner = new Scanner(System.in);
        int k;
        do {
            System.out.printf("Input matrix dimension %s: ", s);
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
