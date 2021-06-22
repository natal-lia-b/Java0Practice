package topic1.part3_cycles;

/*5. Даны числовой ряд и некоторое число е.
Найти сумму тех членов ряда, модуль которых больше или равен заданному е.
Общий член ряда имеет вид: см. topic1.part3_cycles.Task5.jpg */

public class Task5 {
    public static void main(String[] args) {
        sum(-1452, -10, 10);
    }

    public static void sum(double e, int n0, int n1) {
        double result = 0;
        for(int i = n0; i <= n1; i++) {
            double number = 1 / Math.pow(2, i) + 1 / Math.pow(3, i);
            if (Math.abs(number) >= e) {
                result += number;
            }
        }
        System.out.println("Sum = " + result);
    }
}
