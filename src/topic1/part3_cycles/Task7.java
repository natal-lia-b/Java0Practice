package topic1.part3_cycles;

/*7. Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
m и n вводятся с клавиатуры.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task7 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int m = Integer.parseInt(bufferedReader.readLine());
            int n = Integer.parseInt(bufferedReader.readLine());
            if (m <= 0 || n <= 0) {
                System.out.println("The number isn't natural, the program cannot be executed.");
                return;
            }
            printDividers(m, n);
        } catch (IOException e) {
            System.out.println("Wrong number, the program cannot be executed.");
        }
    }

    public static void printDividers(int m, int n) {
        for (int i = m; i <= n; i++) {
            System.out.print("number = " + i + " dividers = ");
            getDividers(i);
            System.out.println();
        }
    }

    public static void getDividers(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
