package topic3.part1_StringAsArray;

/**
 * 1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */

public class Task1 {
    public static void main(String[] args) {
        String[] names = {"firstVarName", "secondVarName", "thirdVarNameKuKu"};
        printNames(transformNames(names));
    }

    private static String[] transformNames(String[] names) {
        char[] newChars;
        String[] newNames = new String[3];
        for (int s = 0; s < names.length; s++) {
            char[] chars = names[s].toCharArray();
            newChars = new char[chars.length * 2];
            int i = 0;
            for (char oneChar : chars) {
                if (!Character.valueOf(oneChar).equals(Character.toLowerCase(oneChar))) {
                    newChars[i++] = '_';
                    newChars[i] = Character.toLowerCase(oneChar);
                } else {
                    newChars[i] = oneChar;
                }
                i++;
            }
            newNames[s] = String.valueOf(newChars);
        }
        return newNames;
    }

    private static void printNames(String[] newNames) {
        System.out.print("[");
        for (String oneName : newNames) {
            System.out.printf("%s ", oneName);
        }
        System.out.println("]");
    }
}
