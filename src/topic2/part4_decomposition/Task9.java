package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 9. Даны числа X, Y, Z, Т — длины сторон четырехугольника.
 * Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y— прямой
 */

public class Task9 {
    private static double x;
    private static double y;
    private static double z;
    private static double t;

    public static void main(String[] args) {
        inputNumbers();
        System.out.printf("Area = %10.4f", findQuadrangleArea());
    }

    private static void inputNumbers() {
        x = inputNumber("x");
        y = inputNumber("y");
        z = inputNumber("z");
        t = inputNumber("t");
    }

    private static double inputNumber(String s) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.printf("Input %s: ", s);
            number = scanner.nextInt();
            if (number <= 0) {
                System.out.printf("%d must be greater than 0, try again. ", number);
            }
        } while (number <= 0);
        return number;
    }


    private static double findQuadrangleArea() {
        return findRightTriangleArea() + findTriangleArea();
    }

    private static double findTriangleArea() {
        double q = findHypotenuse();
        double p = (z + t + q) / 2;
        return Math.pow(p * (p - z) * (p - t) * (p - q), 0.5);
    }

    private static double findRightTriangleArea() {
        return x * y / 2;
    }

    private static double findHypotenuse() {
        return Math.pow((x * x + y * y), 0.5);
    }
}