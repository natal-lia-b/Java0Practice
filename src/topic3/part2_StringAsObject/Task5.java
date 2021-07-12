package topic3.part2_StringAsObject;

/**
 * 5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
 */

public class Task5 {
    public static void main(String[] args) {
        String string = "ианформатикаа";
        System.out.println("String = " + string);
        System.out.println("Amount = " + countAmount(string));
    }

    private static int countAmount(String string) {
        int amount = 0;
        while (string.contains("а")) {
            string = string.substring(string.indexOf("а") + 1);
            amount++;
        }

        return amount;
    }
}
