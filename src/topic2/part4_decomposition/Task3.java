package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.
 *            ___
 * S = a^2 * V 3  / 4
 */

public class Task3 {
    public static void main(String[] args) {
        System.out.printf("Regular triangle area = %10.4f", findRegularTriangleArea());
    }

    private static double findRegularTriangleArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a: ");
        int number = scanner.nextInt();
        return number * number * Math.pow(3, 0.5) / 4;
    }
}
