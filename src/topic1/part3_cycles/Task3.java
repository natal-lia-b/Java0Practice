package topic1.part3_cycles;

/*3. Найти сумму квадратов первых ста чисел.*/

public class Task3 {
    public static void main(String[] args) {
        sum();
    }

    public static void sum() {
        long sum = 0;
        for(int i = 1; i < 101; i++) {
            sum += i * i;
        }
        System.out.println(sum);
    }
}
