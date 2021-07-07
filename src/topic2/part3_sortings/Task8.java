package topic2.part3_sortings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 8.Даны дроби
 * p1      p2          pn  (pi, qi - натуральные).
 * -- ,    -- , ... ,  --
 * q1      q2          qn
 * Составить программу, которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.
 */

public class Task8 {
    private static int[] p;
    private static int[] q;

    public static void main(String[] args) {
        createArray();
        findLowestCommonDenominator();
    }

    private static void findLowestCommonDenominator() {
        int greatestCommonFactor = q[0];  // НОД
        int lowestCommonMultiple = q[0];  // НОК
        for (int i = 1; i < q.length; i++) {
            lowestCommonMultiple = lowestCommonMultiple * q[i] / findGCF(lowestCommonMultiple, q[i]);
        }

        for (int i = 0; i < p.length; i++) {
            p[i] *= lowestCommonMultiple / q[i];
            q[i] = lowestCommonMultiple;
        }

        Arrays.sort(p);
        System.out.println("Sorted sequence =");
        printSequence();
    }

    private static int findGCF(int b, int a) {
        while (a != 0 && b != 0) {
            if (a >= b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a == 0 ? b : a;
    }

    private static void printSequence() {
        for (int i = 0; i < p.length; i++) {
            System.out.printf("%5d  ", p[i]);
        }
        System.out.println();
        for (int i = 0; i < p.length; i++) {
            System.out.print("-----  ");
        }
        System.out.println();
        for (int i = 0; i < p.length; i++) {
            System.out.printf("%5d  ", q[i]);
        }
        System.out.println();
    }

    private static void createArray() {
        p = new int[inputSequenceLength()];
        fillSequence(p);
//        q = new int[]{24, 5,7,36};
        q = new int[p.length];
        fillSequence(q);
        System.out.println("Initial sequence = ");
        printSequence();
    }

    private static void fillSequence(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            int n = (int) (Math.random() * 21);
            sequence[i] = n < 3 ? 3 : n;
        }
    }

    private static int inputSequenceLength() {
        Scanner scanner = new Scanner(System.in);
        int sequenceLength;
        do {
            System.out.print("Input sequence length: ");
            sequenceLength = scanner.nextInt();
            if (sequenceLength <= 0) {
                System.out.printf("%d must be positive, try again. ", sequenceLength);
            }
        } while (sequenceLength <= 0);
        return sequenceLength;
    }

}
