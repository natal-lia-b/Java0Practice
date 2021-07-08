package topic3.part1_StringAsArray;

/**
 * 2. Замените в строке все вхождения 'word' на 'letter'.
 */

public class Task2 {
    public static void main(String[] args) {
        String string = "One word is better than none.";
        System.out.println(changeString(string));
    }

    private static String changeString(String string) {
        return string.replace("word", "letter");
    }
}
