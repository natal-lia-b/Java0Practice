package topic1.part3_cycles;

/*6. Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.*/

public class Task6 {
    public static void main(String[] args) {
        printSymbols();
    }

    public static void printSymbols() {
        for (int i = 32; i <= Character.MAX_VALUE; i++) {
            System.out.printf("%5s = %s   ", i, (char) i);
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}
