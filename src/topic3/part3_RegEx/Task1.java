package topic3.part3_RegEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом
 * три различных операции:
 * отсортировать абзацы по количеству предложений;
 * в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
 * <p>
 * 1 paragraph - 3 sentences
 * 2 paragraph - 2 sentences
 * 2 paragraph - 1 sentence
 */

public class Task1 {
    public static void main(String[] args) {
        String string =
                "А1S1 І Я. Купала, і Я. Колас пісалі вершы, прысвечаныя праблемам грамадства, бо ў часы нашаніўства сацыяльнае і нацыянальнае становішча беларусаў было адной з найважнейшых тэм у літаратуры! А1S2 Але і ў творах, прысвечаных «долі беларуса», можна выразна ўбачыць розніцу паміж паэтамі. А1S3 Яна – у настроі вершаў і ў шляхах вырашэння праблемы.\n" +
                        "А2S1 Колас, ствараючы вельмі падрабязны, наглядны вобраз чалавека і яго жыцця, імкнецца выклікаць шкадаванне да лёсу беларуса. А2S2 Выхад лірычны герой прапануе праз адукацыю, навучанне, якое мусіць узвысіць пакрыўджанага чалавека?\n" +
                        "А3S1 У вершах Купалы пераважае настрой актыўнага супрацьстаяння, які аўтар распальвае ў сваім чытачу рознымі паэтычнымі сродкамі (звароты, заклікі, паўторы); cпосаб пераадолення сітуацыі – гэта змаганне як заканамерны вынік нанесенай крыўды.\n";
        startApp(string);
    }

    private static void startApp(String string) {
        String[] paragraphs = string.split("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - отсортировать абзацы по количеству предложений, \n" +
                "2 - в каждом предложении отсортировать слова по длине,\n" +
                "3 - отсортировать лексемы в предложении,\n" +
                "0 - выход.");
        while (true) {
            System.out.print("\\nВыберите действие: ");
            int action = scanner.nextInt();
            switch (action) {
                case 1: {
                    sortParagraphs(paragraphs);
                    break;
                }
                case 2: {
                    sortWordsInSentences(string);
                    break;
                }
                case 3: {
                    sortLexemes(string);
                    break;
                }
                case 0: {
                    return;
                }
            }
        }
    }

    private static void sortLexemes(String string) {
        System.out.println("sortLexemes");
    }

    private static void sortWordsInSentences(String string) {
        System.out.println("sortWordsInSentences");
    }

    private static void sortParagraphs(String[] paragraphs) {
        List<ArrayList> newParagraphs = createParagraphsAsArrayList(paragraphs);
        int i = 1;
        while (i < newParagraphs.size()) {
            if (newParagraphs.get(i).size() < newParagraphs.get(i - 1).size()) {
                ArrayList copySentence = newParagraphs.get(i);
                newParagraphs.set(i, newParagraphs.get(i - 1));
                newParagraphs.set(i - 1, copySentence);
                if (i > 1) {
                    i--;
                }
            } else {
                i++;
            }
        }
        if (newParagraphs.size() > 0) {
            System.out.println("Sorted paragraphes :");
            for (ArrayList oneParagraph : newParagraphs) {
                System.out.println(oneParagraph);
            }
        }
    }

    private static List<ArrayList> createParagraphsAsArrayList(String[] paragraphs) {
        String regEx = "[\\dА-ЯЁЎ][\\S\\s]+?(?:[\\S][^А-ЯЁ]){1,}(?:\\.|[?!])+";
        Pattern pattern = Pattern.compile(regEx);
        List<ArrayList> newParagraphs = new ArrayList<>();

        for (String paragraph : paragraphs) {
            Matcher matcher = pattern.matcher(paragraph);
            ArrayList<String> sentences = new ArrayList<>();
            while (matcher.find()) {
                sentences.add(matcher.group());
            }
            newParagraphs.add(sentences);
            System.out.println("newList.size = " + sentences.size() + sentences.toString());
        }
        return newParagraphs;
    }
}