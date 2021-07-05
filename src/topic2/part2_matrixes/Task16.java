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
        x = 0;
        y = 0;
        int n = 0;
        int number = 1;
        int halfLength = square.length / 2;
        int twoLengths = square.length * 2;
        for (int i = 0; i < twoLengths; i++, n++) {
            for (int j = 0; j < halfLength; j++, number++) {
                if (number == 1) {
                    square[y][x] = number;
                    continue;
                }
                fillCellEvenEven(n, number);
            }
            correctY(n);
            correctX(n);
            if (n == 7) {
                n = -1;
            }
        }
    }

    private static void correctX(int n) {
        switch (n) {
            case 1:
                x++;
                break;
            case 3:
                x = square.length;
                break;
            case 5:
                x--;
                break;
            case 7:
                x = -1;
                break;
        }
    }

    private static void correctY(int n) {
        switch (n) {
            case 3:
            case 7:
                y = y + 2;
                break;
            case 0:
            case 4:
                y--;
                break;
            case 2:
            case 6:
                y++;
                break;
        }
    }

    private static void fillCellEvenEven(int n, int number) {
        switch (n) {
            case 0:
            case 7:
                x++;
                y--;
                break;
            case 1:
            case 6:
                x++;
                y++;
                break;
            case 3:
            case 4:
                x--;
                y--;
                break;
            case 2:
            case 5:
                x--;
                y++;
                break;
        }
        int y_ = checkYEvenEven();
        square[y_][x] = number;
    }

    private static int checkYEvenEven() {
        return y < 0 ? y + square.length : y >= square.length ? y - square.length : y;
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
