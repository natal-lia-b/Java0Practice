package topic1.linear_programs;

// 3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
//      𝑠𝑖𝑛𝑥+𝑐𝑜𝑠𝑦
//      ________ ∗𝑡𝑔 𝑥𝑦
//      𝑐𝑜𝑠𝑥−𝑠𝑖𝑛𝑦

public class Task3 {
    public static void main(String[] args) {
        double result = calculate3(0.5, 1);
        System.out.println(result);
    }

    public static double calculate3(double x, double y) {
        return (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
    }
}
