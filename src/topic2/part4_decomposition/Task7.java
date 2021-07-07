package topic2.part4_decomposition;

/**
 * 7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
 */

public class Task7 {
    public static void main(String[] args) {
        System.out.println("Sum = " + findSum());
    }

    private static int findSum() {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            int factorial = 1;
            for (int j = 1; j <= i; j++) {
                factorial *= j;
            }
            sum += factorial;
        }
        return sum;
    }
}
