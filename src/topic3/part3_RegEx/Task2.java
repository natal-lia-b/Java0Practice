package topic3.part3_RegEx;

import java.util.ArrayList;
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
//                "   </note>\n" +
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
        Pattern patternOpenedTag = Pattern.compile("<\\w+");
        Pattern patternContent = Pattern.compile(">.+?<");
        Pattern patternAttributes = Pattern.compile("<\\w+(\\s+\\w+)+");

        String[] lines = xmlText.split("\n");
        boolean isWrongFormat = false;
        StringBuilder result = new StringBuilder();
        StringBuilder resultWrongFormat = new StringBuilder();
        ArrayList<Integer> closedTagsIndexes = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            Matcher matcherOpenedTag = patternOpenedTag.matcher(lines[i]);
            if (matcherOpenedTag.find()) {
                String name = matcherOpenedTag.group();
                result.append(name).append("> - tag is opened.\n");

//                Pattern patternWrongFormat = Pattern.compile("(" + name + "){1}(^[\\s>])+");
                Pattern patternWrongFormat = Pattern.compile(name + "/");
                Matcher matcherWrongFormat = patternWrongFormat.matcher(lines[i]);
                if (matcherWrongFormat.find()) {
                    isWrongFormat = true;
                    resultWrongFormat.append("Line".concat((i + 1) + ". Wrong tag format.\n"));
                    continue;
                }

                Matcher matcherAttributes = patternAttributes.matcher(lines[i].strip());
                if (matcherAttributes.find()) {
                    String attributes = lines[i].strip().replaceAll(name, "").replaceAll("[<>/]", "").strip();
                    result.append(attributes).append(" - attributes.\n");
                }

                Pattern patternClosedTag = Pattern.compile("</" + name.replaceAll("<", ""));
                int j = i;
                StringBuilder content = new StringBuilder();
                boolean isClosed = false;
                while (j < lines.length) {
                    Matcher matcherClosedTag = patternClosedTag.matcher(lines[j]);
                    if (matcherClosedTag.find()) {
                        if (i == j) {
                            Matcher matcherContent = patternContent.matcher(lines[j]);
                            if (matcherContent.find()) {
                                result.append(matcherContent.group(), 1, matcherContent.group().length() - 1);
                            }
                        } else {
                            result.append(content);
                        }
                        if (closedTagsIndexes.contains(j)) {
                            isClosed = false;
                        } else {
                            closedTagsIndexes.add(j);
                            isClosed = true;
                        }
                        result.append(" - content.\n");
                        result.append(matcherClosedTag.group()).append("> - tag is closed.\n");
                        break;
                    }
                    if (i != j) {
                        content.append(lines[j].concat("\n"));
                    }
                    j++;
                }
                if (!isClosed) {
                    isWrongFormat = true;
                    resultWrongFormat.append("Line".concat((i + 1) + ". Opened tag is not closed.\n"));
                }
            } else {
                if (!closedTagsIndexes.contains(i)) {
                    isWrongFormat = true;
                    resultWrongFormat.append("Line".concat((i + 1) + ". Opened tag is not found.\n"));
                }
            }

        }
        return isWrongFormat ? resultWrongFormat.toString() : result.toString();
    }
}
