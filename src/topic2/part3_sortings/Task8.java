package topic2.part3_sortings;

import java.util.Scanner;

/**
 * 8.Даны дроби     p1      p2          pn  (pi, qi - натуральные).
 * -- ,    -- , ... ,  --
 * q1      q2          qn
 * Составить программу, которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.
 */

public class Task8 {
    private static int[] p;
    private static int[] q;

    public static void main(String[] args) {
        createArray();
    }

    private static void printSequence() {
        for (int i = 0; i < p.length; i++) {
            System.out.printf("%3d  ", p[i]);
        }
        System.out.println();
        for (int i = 0; i < p.length; i++) {
            System.out.print("---  ");
        }
        System.out.println();
        for (int i = 0; i < p.length; i++) {
            System.out.printf("%3d  ", q[i]);
        }
        System.out.println();
    }

    private static void createArray() {
        p = new int[inputSequenceLength()];
        fillSequence(p);
        q = new int[p.length];
        fillSequence(q);
        System.out.println("Initial sequence = ");
        printSequence();
    }

    private static void fillSequence(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            int n = (int) (Math.random() * 11);
            sequence[i] = n == 0 ? 1 : n;
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
