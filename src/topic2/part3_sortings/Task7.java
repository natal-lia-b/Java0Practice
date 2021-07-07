package topic2.part3_sortings;

import java.util.Arrays;
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
        findIndexes();
    }

    private static void findIndexes() {
        for (int i = 0; i < sequenceB.length; i++) {
            int j = 0;
            while (j < sequenceA.length && sequenceB[i] > sequenceA[j]) {
                j++;
            }
            if (j == sequenceA.length) {
                System.out.printf("B[%d]=%10.4f at the end of A", i, sequenceB[i]);
            } else {
                System.out.printf("B[%d]=%10.4f to the left of A[%d]", i, sequenceB[i], j);
            }
            System.out.println();
        }
    }

    private static int binarySearch(int index) {
        int firstIndex = 0;
        int lastIndex = sequenceA.length - 1;
        int midIndex = 0;
        if (sequenceB[index] >= sequenceA[lastIndex]) {
            return lastIndex;
        }
        while (firstIndex < lastIndex) {
            midIndex = firstIndex + (lastIndex - firstIndex) / 2;
            if (sequenceB[index] == sequenceA[lastIndex]) {
                break;
            } else {
                if (sequenceB[index] < sequenceA[lastIndex]) {
                    lastIndex = midIndex;
                    midIndex = lastIndex;
                } else {
                    firstIndex = midIndex + 1;
                    midIndex = firstIndex;
                }
            }
        }
        return midIndex;
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
        createOneSequence("A", sequenceA);
        sequenceB = new double[inputSequenceLength("B")];
        createOneSequence("B", sequenceB);
    }

    private static void createOneSequence(String s, double[] sequence) {
        fillSequence(sequence);
        Arrays.sort(sequence);
        printSequence(s, sequence);
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
