package topic2.part1_oneDimensionalArrays;

import java.util.Scanner;

/**
 * 1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */

public class Task1 {
    static int[] array = {1, 10, 18, 25, 36, 12, 5};

    public static void main(String[] args) {
        System.out.println("Enter number and press <Enter>:");
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        System.out.println("Sum = " + sum(k));
    }

    static int sum(int k){
        int sum = 0;
        for (int element: array) {
            if (element % k == 0) {
                sum += element;
            }
        }

        return sum;
    }
}
