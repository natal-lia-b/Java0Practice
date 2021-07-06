package topic2.part3_sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 5. Сортировка вставками. Дана последовательность чисел a1,a2,..an.
 * Требуется переставить числа в порядке возрастания.
 * Делается это следующим образом. Пусть a1,a2,..ai - упорядоченная последовательность,
 * т.е. a1<=a2<=..<=ai. Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая
 * последовательность была тоже возрастающей.
 * Процесс производится до тех пор, пока все элементы от i+1 до n не будут перебраны.
 * Примечание. Место помещения очередного элемента в отсортированную часть производить
 * с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 */

public class Task5 {
    private static int[] sequence;
    private static ArrayList<Integer> sortedSequence = new ArrayList<>();

    public static void main(String[] args) {
        createArray();
        sortSequence();
    }

    private static void sortSequence() {
        for (int i = 1; i < sequence.length; i++) {
            binarySearch(i);
        }
        System.out.println("Sorted sequence = "+ sortedSequence.toString());
    }

    private static void binarySearch(int index) {
        int firstIndex = 0;
        int lastIndex = sortedSequence.size();
        int midIndex = 0;
        if (sequence[index] >= sortedSequence.get(lastIndex - 1)) {
            sortedSequence.add(sequence[index]);
            return;
        }
        while (firstIndex < lastIndex) {
            midIndex = firstIndex + (lastIndex - firstIndex) / 2;
            if (sequence[index] == sortedSequence.get(midIndex)) {
                break;
            } else {
                if (sequence[index] < sortedSequence.get(midIndex)) {
                    lastIndex = midIndex;
                    midIndex = lastIndex;
                } else {
                    firstIndex = midIndex + 1;
                    midIndex = firstIndex;
                }
            }
        }
        sortedSequence.add(midIndex, sequence[index]);
    }

    private static void printSequence(String s) {
        System.out.println(s + Arrays.toString(sequence));
    }

    private static void createArray() {
        sequence = new int[inputSequenceLength()];
        fillSequence();
        sortedSequence.add(sequence[0]);
        printSequence("Initial sequence = ");
    }

    private static void fillSequence() {
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = (int) (Math.random() * 101);
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
