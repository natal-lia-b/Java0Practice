package topic2.part4_decomposition;

import java.util.Scanner;

/**
 * 4. На плоскости заданы своими координатами n точек.
 * Написать метод(методы), определяющие, между какими из пар точек самое большое расстояние.
 * Указание. Координаты точек занести в массив.
 */

public class Task4 {
    private static double[] x;
    private static double[] y;

    public static void main(String[] args) {
        int amount = inputAmount();
        inputDots(amount);
        findMaxDistance();
    }

    private static void findMaxDistance() {
        double maxDistance = 0;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                double distance = findDistance(i, j);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.printf("Maximum distance is %10.4f\n", maxDistance);
        System.out.printf("between %d and %d", index1, index2);
    }

    private static double findDistance(int i, int j) {
        return Math.pow(Math.pow((x[i] - x[j]), 2) + Math.pow((y[i] - y[j]), 2), 0.5);
    }

    private static int inputAmount() {
        int amount;
        do {
            amount = inputNumber("dots amount");
            if (amount < 2) {
                System.out.printf("%d must be greater than 1, try again. ", amount);
            }
        } while (amount < 2);
        return amount;
    }

    private static void inputDots(int dotsAmount) {
        x = new double[dotsAmount];
        y = new double[dotsAmount];
        for (int i = 0; i < dotsAmount; i++) {
            x[i] = inputNumber("x[" + i + "]");
            y[i] = inputNumber("y[" + i + "]");
        }
    }

    private static int inputNumber(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s : ", s);
        return scanner.nextInt();
    }

}
