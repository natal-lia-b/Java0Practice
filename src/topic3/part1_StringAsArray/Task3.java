package topic3.part1_StringAsArray;

/**
 * 3. В строке найти количество цифр.
 */

public class Task3 {
    public static void main(String[] args) {
        String string = "Ле́тние Олимпи́йские и́гры 1980 го́да проходили в Москве, с 19.07 по 3.08 1980 года.";
        System.out.printf("Number of digits = %d", findDigits(string));
    }

    private static int findDigits(String string) {
        char[] chars = string.toCharArray();
        int count = 0;
        for (char oneChar : chars) {
            if (Character.isDigit(oneChar)) {
                count++;
            }
        }
        return count;
    }
}
