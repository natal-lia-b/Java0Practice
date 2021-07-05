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
    private static int[][] square;
    private static int x;
    private static int y;

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
        int squareSide = square.length / 2;
        int firstNumber = 1;
        int lastNumber = square.length * square.length / 4;
        int difference = lastNumber;
        fillSmallSquareEvenOdd(firstNumber, lastNumber, squareSide, 0, 0);

        firstNumber += difference;
        lastNumber += difference;
        fillSmallSquareEvenOdd(firstNumber, lastNumber, squareSide, squareSide, squareSide);

        firstNumber += difference;
        lastNumber += difference;
        fillSmallSquareEvenOdd(firstNumber, lastNumber, squareSide, squareSide, 0);

        firstNumber += difference;
        lastNumber += difference;
        fillSmallSquareEvenOdd(firstNumber, lastNumber, squareSide, 0, squareSide);

        changeItems();
    }

    private static void changeItems() {
        int changes = square.length / 4;
        int smallSquareSide = square.length / 2;
        for (int y = 0; y < smallSquareSide; y++) {
            swapLeftColumns(smallSquareSide, y);
        }
        for (int i = 0; i < changes; i++) {
            swapCenterColumns(smallSquareSide, i);
        }
    }

    private static void swapCenterColumns(int squareSide, int i) {
        int x = squareSide + i;
        for (int y = 0; y < squareSide; y++) {
            swapTwoCenterCells(squareSide, y, x);
            swapTwoCenterCells(squareSide, y, x - 2 * i - 1);
        }
    }

    private static void swapLeftColumns(int squareSide, int y) {
        int x = (y > 0 && y < squareSide - 1) ? 1 : 0;
        swapTwoCenterCells(squareSide, y, x);
    }

    private static void swapTwoCenterCells(int squareSide, int y, int x) {
        int n = square[y][x];
        square[y][x] = square[y + squareSide][x];
        square[y + squareSide][x] = n;
    }

    private static void fillSmallSquareEvenOdd(int firstNumber, int lastNumber, int squareSide, int shiftX, int shiftY) {
        x = 1;
        y = 0;
        square[y + shiftY][x + shiftX] = firstNumber;
        int nextNumber = firstNumber + 1;
        for (int i = nextNumber; i <= lastNumber; i++) {
            fillCellOdd(i, squareSide, shiftX, shiftY);
        }
    }

    private static void fillEvenEven() {
        x = 0;
        y = 0;
        int n = 0;
        int number = 1;
        int halfLength = square.length / 2;
        int twoLengths = square.length * 2;
        for (int i = 0; i < twoLengths; i++, n++) {
            if (n == 8) {
                n = 0;
            }
            for (int j = 0; j < halfLength; j++, number++) {
                if (number == 1) {
                    square[y][x] = number;
                    continue;
                }
                fillCellEvenEven(n, number);
            }
            correctY(n);
            correctX(n);
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
            fillCellOdd(i, square.length, 0, 0);
        }
    }

    private static void fillCellOdd(int i, int squareSide, int shiftX, int shiftY) {
        x = checkCoordinateOdd(x + 2, squareSide);
        y = checkCoordinateOdd(y + 2, squareSide);
        while (square[y + shiftY][x + shiftX] > 0) {
            x = checkCoordinateOdd(x + 3, squareSide);
            y = checkCoordinateOdd(y + 1, squareSide);
        }
        square[y + shiftY][x + shiftX] = i;
    }

    private static int checkCoordinateOdd(int coordinate, int squareSide) {
        return coordinate >= squareSide ? coordinate - squareSide : coordinate;
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

    private static void printSquare() {
        System.out.println("magic square = ");
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[0].length; j++) {
                System.out.printf("%5d ", square[i][j]);
            }
            System.out.println();
        }
    }
}
