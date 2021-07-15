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
 */

public class Task1 {
    public static void main(String[] args) {
        String string =
                "На Заметку.\r" +
                        "       Предметом манипуляций становятся ценности человека и его слабые места. Никто не хочет показаться глупым, слабым, бедным, униженным, скупым. Именно такие качества и чувства являются базой для построения манипуляционного воздействия. Манипулирование - это тонкая игра на ваших эмоциях, чувствах, ценностях.\n\r" +
                        "               Манипуляцию можно назвать одним из самых распространенных видов общения. Она необходима для психологического воздействия на человека. Манипуляции в общении – это способ управления, возможность контроля над поведением и чувствами индивида.\n" +
                        "       Сам процесс состоит из субъекта (манипулятора) и объекта (адресата его воздействия). Причем последний не информируется о проведении психологического вмешательства в его личность. Поэтому такое влияние на людей (или группу) часто имеет пренебрежительный или снисходительный подтекст. Психологические манипуляции в общении можно встретить на разных уровнях: в личной дискуссии, в семье, коллективе. Они могут быть использованы как в созидательных целях, так и для деморализации человека. В этом большую роль играет цель, которой стремится достичь манипулятор. Важны и те приемы, с помощью которых он собирается воздействовать.\n";
//                        "А1П1 І Я. Купала, і Я. Коласс пісалі вершы, прысвечаныя праблемам грамадства, бо ў часы \"нашаніўства\" сацыяльнае і нацыянальнае становішча беларусаў было адной з найважнейшых тэм у літаратуры! А1П2 Але і ў творах, прысвечаных «долі беларуса», можна выразна ўбачыць розніцу паміж паэтамі. А1П3 Яна – у настроі вершаў і ў шляхах вырашэння праблемы.\n" +
//                        "А2П1 Колас, ствараючы вельмі падрабязны, наглядны вобраз чалавека і яго жыцця, імкнецца выклікаць шкадаванне да лёсу беларуса. А2П2 Выхад лірычны герой прапануе праз адукацыю, навучанне, якое мусіць узвысіць пакрыўджанага чалавека?\n" +
//                        "А3П1 У вершах Купалы пераважае настрой актыўнага супрацьстаяння, які аўтар распальвае ў сваім чытачу рознымі паэтычнымі сродкамі (звароты, заклікі, паўторы); спосаб пераадолення сітуацыі – гэта змаганне як заканамерны вынік нанесенай крыўды.\n";
        startApp(string);
    }

    private static void startApp(String string) {
        List<ArrayList> paragraphs = createParagraphsAsArrayList(string.split("[\n|\r]+"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - отсортировать абзацы по количеству предложений, \n" +
                "2 - в каждом предложении отсортировать слова по длине,\n" +
                "3 - отсортировать лексемы в предложении,\n" +
                "0 - выход.");
        while (true) {
            System.out.print("\nВыберите действие: ");
            int action = scanner.nextInt();
            switch (action) {
                case 1: {
                    sortParagraphs(paragraphs);
                    break;
                }
                case 2: {
                    sortWordsInSentences(paragraphs);
                    break;
                }
                case 3: {
                    sortLexemes(paragraphs);
                    break;
                }
                case 0: {
                    return;
                }
            }
        }
    }

    private static void sortLexemes(List<ArrayList> paragraphs) {
        System.out.print("Введите один символ: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        char ch = string.charAt(0);
        if (string.length() > 1) {
            System.out.println("Введено больше, чем 1 символ. Заданным символом принимается " + ch);
        }
        System.out.println("Лексемы в предложении, отсортированные по убыванию количества вхождений заданного символа:");
        for (ArrayList paragraph : paragraphs) {
            for (int i = 0; i < paragraph.size(); i++) {
                String[] words = createWords(paragraph, i);
                ArrayList<String> sortedWords = new ArrayList<>();
                sortedWords.add(words[0]);
                for (int j = 1; j < words.length; j++) {
                    sortedWords.add(binarySearchForLexemes(j, words, sortedWords, ch), words[j]);
                }
                ArrayList<String> wordsToABC = new ArrayList<>();
                ArrayList<String> result = new ArrayList<>();
                int chAmount = getCharAmount(sortedWords.get(0), ch);
                for (String sortedWord: sortedWords) {
                    int chAmountJ = getCharAmount(sortedWord, ch);
                    if (chAmount != chAmountJ) {
                        wordsToABCSort(result, wordsToABC);
                        wordsToABC = new ArrayList<>();
                        chAmount = chAmountJ;
                    }
                    wordsToABC.add(sortedWord);
                }
                if (wordsToABC.size() > 0) {
                    wordsToABCSort(result, wordsToABC);
                }
                System.out.println(result.toString());
            }
        }
    }

    private static void wordsToABCSort(ArrayList<String> result, ArrayList<String> wordsToABC) {
        for (int i = 0; i < wordsToABC.size(); i++) {
            for (int j = i + 1; j < wordsToABC.size(); j++) {
                if (wordsToABC.get(i).toLowerCase().compareTo(wordsToABC.get(j).toLowerCase()) > 0) {
                    String copyWord = wordsToABC.get(i);
                    wordsToABC.set(i, wordsToABC.get(j));
                    wordsToABC.set(j, copyWord);
                }
            }
        }
        result.addAll(wordsToABC);
    }

    private static int binarySearchForLexemes(int index, String[] words, ArrayList<String> sortedWords, char ch) {
        int firstIndex = 0;
        int lastIndex = sortedWords.size();
        int midIndex = 0;
        int chAmountWords = getCharAmount(words[index], ch);
        if (chAmountWords > getCharAmount(sortedWords.get(lastIndex - 1), ch)) {
            return lastIndex;
        }
        while (firstIndex < lastIndex) {
            midIndex = firstIndex + (lastIndex - firstIndex) / 2;
            int chAmountSorted = getCharAmount(sortedWords.get(midIndex), ch);
            if (chAmountWords == chAmountSorted) {
                break;
            } else {
                if (chAmountWords < chAmountSorted) {
                    lastIndex = midIndex;
                    midIndex = lastIndex;
                } else {
                    firstIndex = midIndex + 1;
                    midIndex = firstIndex;
                }
            }
        }
        return midIndex;
    }

    private static int getCharAmount(String word, char ch) {
        String regEx = "[^" + ch + "]+";
        return word.replaceAll(regEx, "").length();
    }

    private static String[] createWords(ArrayList paragraph, int i) {
        String sentence = (String) paragraph.get(i);
        sentence = sentence.replaceAll("[\\p{Punct}«»]+", "");
        return sentence.split("[\\s|–]+");
    }

    private static void sortWordsInSentences(List<ArrayList> paragraphs) {
        System.out.println("Предложения с отсортированными по длине словами:");
        for (ArrayList paragraph : paragraphs) {
            for (int i = 0; i < paragraph.size(); i++) {
                String[] words = createWords(paragraph, i);
                ArrayList<String> sortedWords = new ArrayList<>();
                sortedWords.add(words[0]);
                for (int j = 1; j < words.length; j++) {
                    sortedWords.add(binarySearch(j, words, sortedWords), words[j]);
                }
                System.out.println(sortedWords.toString());
            }
        }
    }

    private static int binarySearch(int index, String[] words, ArrayList<String> sortedWords) {
        int firstIndex = 0;
        int lastIndex = sortedWords.size();
        int midIndex = 0;
        if (words[index].length() >= sortedWords.get(lastIndex - 1).length()) {
            return lastIndex;
        }
        while (firstIndex < lastIndex) {
            midIndex = firstIndex + (lastIndex - firstIndex) / 2;
            if (words[index].length() == sortedWords.get(midIndex).length()) {
                break;
            } else {
                if (words[index].length() < sortedWords.get(midIndex).length()) {
                    lastIndex = midIndex;
                    midIndex = lastIndex;
                } else {
                    firstIndex = midIndex + 1;
                    midIndex = firstIndex;
                }
            }
        }
        return midIndex;
    }

    private static void sortParagraphs(List<ArrayList> paragraphs) {
        List<ArrayList> sortedParagraphs = new ArrayList<>(paragraphs);
        int i = 1;
        while (i < sortedParagraphs.size()) {
            if (sortedParagraphs.get(i).size() < sortedParagraphs.get(i - 1).size()) {
                ArrayList paragraph = sortedParagraphs.get(i);
                sortedParagraphs.set(i, sortedParagraphs.get(i - 1));
                sortedParagraphs.set(i - 1, paragraph);
                if (i > 1) {
                    i--;
                }
            } else {
                i++;
            }
        }
        if (sortedParagraphs.size() > 0) {
            System.out.println("Отсортированные абзацы:");
            for (ArrayList oneParagraph : sortedParagraphs) {
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
        }
        return newParagraphs;
    }
}