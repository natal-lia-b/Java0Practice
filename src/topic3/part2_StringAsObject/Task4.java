package topic3.part2_StringAsObject;

/**
 * 4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
 */

public class Task4 {
    public static void main(String[] args) {
        String string = "информатика";
        System.out.println("Old string = " + string);
        System.out.println("New string = " + makeTort(string));
    }

    private static String makeTort(String string) {
        return string.substring(7, 8) + string.substring(3, 5) + string.substring(7, 8);
    }
}
