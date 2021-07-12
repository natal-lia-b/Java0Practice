package topic3.part2_StringAsObject;

/**
 * 10. Строка X состоит из нескольких предложений,
 * каждое из которых кончается точкой, восклицательным или вопросительным знаком.
 * Определить количество предложений в строке X.
 */

public class Task10 {
    public static void main(String[] args) {
        String string = "Першы сказ. Другі сказ? Трэці сказ! Чацверты сказ. Палова пятага сказу, другая палова!";
        System.out.printf("Amount = %d", countSentencesAmount(string));
    }

    private static int countSentencesAmount(String string) {
        String[] strings = string.split("[.?!]+");
        return strings.length;
    }
}
