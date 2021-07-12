package topic3.part1_StringAsArray;

/**
 * 2. Замените в строке все вхождения 'word' на 'letter'.
 */

public class Task2 {
    public static void main(String[] args) {
        String string = "100 indifferent words are worse than one kind word.";
        System.out.println(changeWord(string));
    }

    private static String changeWord(String string) {
        char[] word = "word".toCharArray();
        char[] chars = string.toCharArray();
        char[] newChars = new char[newLength(chars)];
        int w = 0;
        int j = 0;
        for (char oneChar : chars) {
            if (w < word.length && oneChar == word[w]) {
                w++;
            } else {
                w = 0;
            }
            if (w == word.length) {
                j = addLetter(j, newChars);
                w = 0;
            } else {
                newChars[j] = oneChar;
                j++;
            }
        }
        return new String(newChars);
    }

    private static int addLetter(int j, char[] newChars) {
        int wordLength = "word".length() - 1;
        char[] letter = "letter".toCharArray();
        int i = 0;
        int l = j - wordLength;
        int letterLength = l + letter.length;
        for (; l < letterLength; l++) {
            newChars[l] = letter[i];
            i++;
        }
        return l;
    }

    private static int newLength(char[] chars) {
        int count = 0;
        for (char oneChar : chars) {
            if (oneChar == 'w') {
                count++;
            }
        }
        return chars.length + count * 2;
    }
}
