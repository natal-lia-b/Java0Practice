package topic2.part3_sortings;

import java.util.Scanner;

/**
 * 7. Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= .. <= an и b1 <= b2 <= .. <= bm.
 * Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <= .. <= bm в первую
 * последовательность так, чтобы новая последовательность оставалась возрастающей.
 */

public class Task7 {
    private static double[] sequenceA;
    private static double[] sequenceB;

    public static void main(String[] args) {
        createSequences();
        sortSequences();
    }

    private static void sortSequences() {
    }

    private static void printSequence(String s, double[] sequence) {
        System.out.printf("Initial sequence %s = ", s);
        for (double number : sequence) {
            System.out.printf("%10.4f ", number);
        }
        System.out.println();
    }

    private static void createSequences() {
        sequenceA = new double[inputSequenceLength("A")];
        fillSequence(sequenceA);
        sequenceB = new double[inputSequenceLength("B")];
        fillSequence(sequenceB);
        printSequence("A", sequenceA);
        printSequence("B", sequenceB);
    }

    private static void fillSequence(double[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = (Math.random() * 101);
        }
    }

    private static int inputSequenceLength(String s) {
        Scanner scanner = new Scanner(System.in);
        int sequenceLength;
        do {
            System.out.printf("Input sequence %s length: ", s);
            sequenceLength = scanner.nextInt();
            if (sequenceLength <= 0) {
                System.out.printf("%d must be positive, try again. ", sequenceLength);
            }
        } while (sequenceLength <= 0);
        return sequenceLength;
    }
}
