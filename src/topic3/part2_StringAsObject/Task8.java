package topic3.part2_StringAsObject;

/**
 * 8. Вводится строка слов, разделенных пробелами.
 * Найти самое длинное слово и вывести его на экран.
 * Случай, когда самых длинных слов может быть несколько, не обрабатывать.
 */

public class Task8 {
    public static void main(String[] args) {
        String string = "Ле́тние Олимпи́йские и́гры 1980 го́да проходили в Москве.";
        System.out.println(findMaxLengthWord(string));
    }

    private static String findMaxLengthWord(String string) {
        String[] strings = string.split("\\s+");
        int max = 0;
        int indexMax = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > max) {
                max = strings[i].length();
                indexMax = i;
            }
        }
        return strings[indexMax];
    }
}
