package topic3.part1_StringAsArray;

/**
 * 4. В строке найти количество чисел.
 */

public class Task4 {
    public static void main(String[] args) {
        String string = "Ле́тние Олимпи́йские и́гры 1980 го́да проходили в Москве, с 19.07 по 3.08 1980 года.";
        System.out.printf("Amount of numbers = %d", findDigits(string));
    }

    private static int findDigits(String string) {
        char[] chars = string.toCharArray();
        int count = Character.isDigit(chars[0]) ? 1 : 0;
        for (int i = 1; i < chars.length; i++) {
            if (Character.isDigit(chars[i]) && (!Character.isDigit(chars[i - 1]))) {
                count++;
            }
        }
        return count;
    }
}
