package topic3.part2_StringAsObject;

/**
 * 6. Из заданной строки получить новую, повторив каждый символ дважды.
 */

public class Task6 {
    public static void main(String[] args) {
        String string = "информатика";
        System.out.println("Old string = " + string);
        System.out.println("New string = " + doubleLetters(string));
    }

    private static String doubleLetters(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < 2; j++) {
                stringBuilder.append(string.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
