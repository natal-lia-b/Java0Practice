package topic2.part2_matrixes;

import java.util.Scanner;

/**
 * 8. В числовой матрице поменять местами два любых столбца, т. е. все элементы одного столбца поставить
 * на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
 * пользователь с клавиатуры.
 */

public class Task8 {
    static int[][] matrix;

    public static void main(String[] args) {
        createMatrix();
        revertColumns(inputIndex("1st column"), inputIndex("2nd column"));
        printMatrix();
    }

    private static void revertColumns(int k, int p) {
        int min = Integer.min(k, p);
        int max = Integer.max(k, p);
        int number = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == min) {
                    number = matrix[i][j];
                    matrix[i][j] = matrix[i][max];
                } else if (j == max) {
                    matrix[i][j] = number;
                }
            }
        }
    }

    // create matrix by my own way
    private static void createMatrix() {
        int k = inputDimention();
        matrix = new int[k][k];
        int n = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = n++;
            }
        }
    }

    private static int inputDimention() {
        Scanner scanner = new Scanner(System.in);
        int k;
        do {
            System.out.print("Input matrix dimention: ");
            k = scanner.nextInt();
            if (k < 0) {
                System.out.printf("%d is negative, try again. ", k);
            }
        } while (k < 0);
        return k;
    }

    private static int inputIndex(String s) {
        Scanner scanner = new Scanner(System.in);
        int k;
        do {
            System.out.printf("Input %s: ", s);
            k = scanner.nextInt();
            if (k < 0) {
                System.out.printf("%d is negative number. ", k);
            } else if (k > matrix.length) {
                System.out.println("Index out of matrix bounds, try again.");
            }
        } while (k < 0 || k >= matrix.length);
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
