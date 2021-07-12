package topic3.part2_StringAsObject;

/**
 * 7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
 * Например, если было введено "abc cde def", то должно быть выведено "abcdef".
 */

public class Task7 {
    public static void main(String[] args) {
        String string = "abc cde def";
        System.out.println("Old string = " + string);
        System.out.println("New string = " + deleteRepeatingLetters(string));
    }

    private static String deleteRepeatingLetters(String string) {
        string = string.replaceAll("\\s", "");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char charI = string.charAt(i);
            int n = string.lastIndexOf(charI);
            if (n <= i) {
                stringBuilder.append(string.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
