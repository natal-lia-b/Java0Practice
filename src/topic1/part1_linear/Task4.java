package topic1.part1_linear;

/*4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях).
Поменять местами дробную и целую части числа и вывести полученное значение числа.*/

public class Task4 {
    public static void main(String[] args) {
        swapIntegerAndFractionalParts(111.555);
    }

    public static void swapIntegerAndFractionalParts(double x) {
        int integerPart = (int) x;
        int fractionalPart = (int) ((x - integerPart) * 1000);
        System.out.println(fractionalPart + (double) integerPart / 1000);
    }
}