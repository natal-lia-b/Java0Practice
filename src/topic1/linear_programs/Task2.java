package topic1.linear_programs;

// 2. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
//     ______
// 𝑏+√𝑏2+4𝑎𝑐        −2
// _________  −𝑎3𝑐+𝑏
// 2𝑎


public class Task2 {
    public static void main(String[] args) {
        double result = calculate2(0, 2, 10);
        System.out.println(result);
    }

    public static double calculate2(double a, double b, double c) {
        double sqrt = Math.sqrt(b * b + 4 * a * c);
        double fraction = (b + sqrt) / (2 * a);
        double tail = - Math.pow(a, 3) * c + Math.pow(b, -2);
        return fraction + tail;
    }
}
