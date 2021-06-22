package topic1.branching;

/*5. Вычислить значение функции:
* см. topic1.branching.Task5.jpg*/

public class Task5 {
    public static void main(String[] args) {
        calculateTask5(3);  // value = 9
        calculateTask5(1);  // 7
        calculateTask5(5);  // 0.0076335877862595
    }

    public static void calculateTask5(double x) {
        double result;
        if (x <= 3) {
            result = x * x - 3 * x + 9;
        } else {
            result = 1 / (Math.pow(x, 3) + 6);
        }
        System.out.println("F(x) = " + result);
    }
}
