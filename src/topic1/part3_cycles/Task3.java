package topic1.part3_cycles;

/*3. Найти сумму квадратов первых ста чисел.*/

public class Task3 {
    public static void main(String[] args) {
        sum();
    }

    public static void sum() {
        long result = 0;
        for(int i = 1; i < 101; i++) {
            result += i * i;
        }
        System.out.println(result);
    }
}
