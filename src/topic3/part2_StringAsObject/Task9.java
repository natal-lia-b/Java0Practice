package topic3.part2_StringAsObject;

/**
 * 9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
 * Учитывать только английские буквы.
 */

public class Task9 {
    public static void main(String[] args) {
        String string = "Размышления о жизни: \"Failure does not mean I’m a failure. It does mean I have not yet succeeded.\"";
        analiseString(string);
    }

    private static void analiseString(String string) {
        int lowerCase = 0;
        int upperCase = 0;
        String letters = "[a-z|A-Z]";
        for (int i = 0; i < string.length(); i++) {
            String oneLetter = String.valueOf(string.charAt(i));
            if (oneLetter.matches(letters)) {
                if (oneLetter.toLowerCase().equals(oneLetter)) {
                    lowerCase++;
                } else if (oneLetter.toUpperCase().equals(oneLetter)){
                    upperCase++;
                }
            }
        }
        System.out.printf("Amount of letters in lower case = %d, in upperCase = %d", lowerCase, upperCase);
    }
}
