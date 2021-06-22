package topic1.branching;

/* 2. Найти max{min(a, b), min(c, d)}.*/

public class Task2 {
    public static void main(String[] args) {
        max(10, 15, -2, 0); // 10
    }

    public static void max(int a, int b, int c, int d) {
        int minAB = a < b ? a : b;
        int minCD = c < d ? c : d;
        System.out.println("max = " + (minAB > minCD ? minAB : minCD));
    }
}
