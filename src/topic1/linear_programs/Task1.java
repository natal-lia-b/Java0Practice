package topic1.linear_programs;

// 1. Найдите значение функции: z = ( (a – 3 ) * b / 2) + c

public class Task1 {
    public static void main(String[] args) {
        int z = calculateTask1(13, 10, 5);  // value = 55
        System.out.println("value = " + z);
    }

    public static int calculateTask1(int a, int b, int c) {
        return (a - 3) * b / 2 + c;
    }
}
