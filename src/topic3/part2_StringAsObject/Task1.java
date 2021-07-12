package topic3.part2_StringAsObject;

/**1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.*/

public class Task1 {
    public static void main(String[] args) {
        String string = "Ле́тние   Олимпи́йские  и́гры        1980 го́да  проходили в      Москве.";
        System.out.printf("Max amount of blanks = %d", findMaxAmount(string));
    }

    private static int findMaxAmount(String string) {
        int maxAmount = 0;
        String[] blanks = string.split("\\S+");
        for (String blank : blanks)  {
            if (blank.length() > maxAmount) {
                maxAmount = blank.length();
            }
        }
        return maxAmount;
    }
}
