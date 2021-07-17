package topic3.part3_RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2. Дана строка, содержащая следующий текст (xml-документ):
 * <notes>
 * <note id = "1">
 * <to>Вася</to>
 * <from>Света</from>
 * <heading>Напоминание</heading>
 * <body>Позвони мне завтра!</body>
 * </note>
 * <note id = "2">
 * <to>Петя</to>
 * <from>Маша</from>
 * <heading>Важное напоминание</heading>
 * <body/>
 * </note>
 * </notes>
 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип
 * (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
 * Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
 */

public class Task2 {
    public static void main(String[] args) {
        String xmlText = "<notes>\n" +
                "   <note id = \"1\">\n" +
                "       <to>Вася</to>\n" +
                "       <from>Света</from>\n" +
                "       <heading>Напоминание</heading>\n" +
                "       <body>Позвони мне завтра!</body>\n" +
                "   </note>\n" +
                "   <note id = \"2\">\n" +
                "       <to>Петя</to>\n" +
                "       <from>Маша</from>\n" +
                "       <heading>Важное напоминание</heading>\n" +
                "       <body/>\n" +
                "   </note>\n" +
                "</notes>\n";
        System.out.println(parse(xmlText));
    }

    private static String parse(String xmlText) {
        Pattern patternOpenedTag = Pattern.compile("<\\w+?>");

        StringBuilder result = new StringBuilder();
        String[] lines = xmlText.split("\n");

//        for (String line : lines) {
        for (int i = 0; i < lines.length; i++) {
            Matcher matcherOpenedTag = patternOpenedTag.matcher(lines[i]);
            if (matcherOpenedTag.find()) {
                String name = matcherOpenedTag.group();
                result.append(name).append(" - opened tag.\n");

                Pattern patternClosedTag = Pattern.compile("</"+ name.replaceAll("<", ""));
                int j = i;
                while (j < lines.length) {
                    Matcher matcherClosedTag = patternClosedTag.matcher(lines[j]);
                    if (matcherClosedTag.find()) {
                        result.append(matcherClosedTag.group()).append(" - closed tag.\n");
                        break;
                    }
                    result.append(lines[j]);
                    j++;
                }

            }
        }
        return  result.toString();
    }
}
