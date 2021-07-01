package topic2.part2_matrixes;

/**
 * 11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
 * которых число 5 встречается три и более раз.
 */

public class Task11 {
    static int[][] matrix;

    public static void main(String[] args) {
        createMatrix();
        printMatrix();
        checkRows();
    }

    private static void checkRows() {
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 5) {
                    count++;
                }
            }
            if (count > 2) {
                System.out.print(i + " ");
            }
        }
    }

    private static void createMatrix() {
        matrix = new int[10][10];
        int n = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (int) (Math.random() * 16);
            }
        }
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
