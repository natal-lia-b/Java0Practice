package topic2.part2_matrixes;

import java.util.Scanner;

/**
 * 16. Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,
 * ..., n*n так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
 * собой. Построить такой квадрат. Пример магического квадрата порядка 3:
 * 6 1 8
 * 7 5 3
 * 2 9 4
 */

public class Task16 {
    static int[][] square;
    static int x;
    static int y;

    public static void main(String[] args) {
        createSquare();
        fillSquare();
        printSquare();
    }

    private static void fillSquare() {
        if (square.length % 2 != 0) {
            fillOdd();
        } else if (square.length % 4 == 0) {
            fillEvenEven();
        } else {
            fillEvenOdd();
        }
    }

    private static void fillEvenOdd() {
    }

    private static void fillEvenEven() {
    }

    private static void fillOdd() {
        int lastIndex = square.length * square.length + 1;
        x = 1;
        y = 0;
        square[y][x] = 1;
        for (int i = 2; i < lastIndex; i++) {
            fillCellOdd(i);
        }
    }

    private static void fillCellOdd(int i) {
        int x_ = checkCoordinateOdd(x + 2);
        int y_ = checkCoordinateOdd(y + 2);
        while (square[y_][x_] > 0) {
            x_ = checkCoordinateOdd(x + 3);
            y_ = checkCoordinateOdd(y + 1);
        }
        x = x_;
        y = y_;
        square[y_][x_] = i;
    }

    private static int checkCoordinateOdd(int coordinate) {
        return coordinate >= square.length ? coordinate - square.length : coordinate;
    }

    private static void createSquare() {
        int n = inputDimension("n");
        square = new int[n][n];
    }

    private static int inputDimension(String s) {
        Scanner scanner = new Scanner(System.in);
        int dimension;
        do {
            System.out.printf("Input magic square side %s: ", s);
            dimension = scanner.nextInt();
            if (dimension < 3) {
                System.out.printf("%d must be greater than 2, try again. ", dimension);
            }
        } while (dimension < 3);
        return dimension;
    }

    static void printSquare() {
        System.out.println("magic square = ");
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[0].length; j++) {
                System.out.printf("%5d ", square[i][j]);
            }
            System.out.println();
        }
    }
}
