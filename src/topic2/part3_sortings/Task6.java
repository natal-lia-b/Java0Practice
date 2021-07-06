package topic2.part3_sortings;

import java.util.Scanner;

/**
 * 6. Сортировка Шелла. (Гномья оортировка?)
 * Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
 * Делается это следующим образом: сравниваются два соседних элемента ai и ai+1 . Если ai <= ai+1, то продвигаются
 * на один элемент вперед. Если ai > ai+1, то производится перестановка и сдвигаются на один элемент назад.
 * Составить алгоритм этой сортировки.
 */

public class Task6 {
    private static double[] sequence;

    public static void main(String[] args) {
        createSequence();
        sortSequence();
    }

    private static void sortSequence() {
        int i = 1;
        while (i < sequence.length) {
            if ( i == 0 || sequence[i] > sequence[i - 1]) {
                i++;
            } else {
                double dummy = sequence[i];
                sequence[i] = sequence[i - 1];
                sequence[i - 1] = dummy;
                i--;
            }
        }
        printSequence("Sorted sequence  = ");
    }

    private static void printSequence(String s) {
        System.out.printf("%s", s);
        for (double number : sequence) {
            System.out.printf("%10.4f ", number);
        }
        System.out.println();
    }

    private static void createSequence() {
        sequence = new double[inputSequenceLength()];
        fillSequence();
        printSequence("Initial sequence = ");
    }

    private static void fillSequence() {
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = (Math.random() * 101);
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
