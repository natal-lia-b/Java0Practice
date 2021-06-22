package topic1.part3_cycles;

/*2. Вычислить значения функции на отрезке [а,b] c шагом h:*/

public class Task2 {
    public static void main(String[] args) {
        calculateTask2(-2, 10, 2);
    }

    public static void calculateTask2(int a, int b, int h) {
        for (int x = a; x <= b; x += h) {
            System.out.println("x = " + x + ", y = " + (x > 2 ? x : - x));
        }
    }
}
