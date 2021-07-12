package topic3.part1_StringAsArray;

/**
 * 5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
 */

public class Task5 {
    public static void main(String[] args) {
        String string = "Ле́тние   Олимпи́йские  и́гры     1980 го́да  проходили в      Москве.";
        System.out.println(deleteExtraBlanks(string));
    }

    private static String deleteExtraBlanks(String string) {
        char[] chars = string.toCharArray();
        char[] newChars = new char[chars.length];
        int j = 0;
        newChars[0] = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (!(Character.isSpaceChar(chars[i]) && Character.isSpaceChar(chars[i - 1]))) {
                j++;
                newChars[j] = chars[i];
            }
        }
        return String.valueOf(newChars);
    }
}
