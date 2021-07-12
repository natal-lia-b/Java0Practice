package topic3.part2_StringAsObject;

/**
 * 2. В строке вставить после каждого символа 'a' символ 'b'.
 */

public class Task2 {
    public static void main(String[] args) {
        String string = "Masha and Sasha are reading the magazin.";
        System.out.println("Initial string = " + string);
        System.out.println("Result string  = " + inputB(string));
    }

    private static String inputB(String string) {
        return string.replaceAll("a", "ab");
    }
}
