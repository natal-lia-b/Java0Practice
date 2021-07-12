package topic3.part2_StringAsObject;

/**
 * 3. Проверить, является ли заданное слово палиндромом.
 */

public class Task3 {
    public static void main(String[] args) {
        String string1 = "Masha and Sasha are reading the magazin.";
        System.out.println("Initial string = " + string1);
        System.out.println("String is palindrom = " + isPalindrom(string1));
        String string2 = "Masha is reading.gnidaer si ahsaM";
        System.out.println("Initial string = " + string2);
        System.out.println("String is palindrom = " + isPalindrom(string2));
    }

    private static boolean isPalindrom(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.toString().contentEquals(stringBuilder.reverse());
    }
}
