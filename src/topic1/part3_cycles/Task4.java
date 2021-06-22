package topic1.part3_cycles;

/* 4. Составить программу нахождения произведения квадратов первых двухсот чисел. */

import java.math.BigInteger;

public class Task4 {
    public static void main(String[] args) {
        composition();
    }

    public static void composition() {
        BigInteger result = new BigInteger(String.valueOf(1));
        for(int i = 1; i < 201; i++) {
            result = result.multiply(BigInteger.valueOf(i * i));
        }
        System.out.println(result);
    }
}
