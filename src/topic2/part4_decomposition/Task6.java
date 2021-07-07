package topic2.part4_decomposition;

/**
 * 6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
 */

public class Task6 {
    public static void main(String[] args) {
        int a = addNumber();
        int b = addNumber();
        int c = addNumber();
        System.out.printf("a = %d, b = %d, c = %d\n", a, b, c);
        System.out.println("Mutual simplicity = " + checkMutualSimplicity(a, b, c));
    }

    private static boolean checkMutualSimplicity(int a, int b, int c) {
        return findGCF(a, b) == 1 && findGCF(b, c) == 1 && findGCF(a, c) == 1;
    }

    // НОД
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

    private static int addNumber() {
        return (int) (Math.random() * 101);
    }
}
