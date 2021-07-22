package topic4.part2_Aggregation.task1;

import java.util.Arrays;

/**
 * 1. Создать объект класса Текст, используя классы Предложение, Слово.
 * Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 */

public class Text {
    private Sentence[] text;
    private Sentence[] textTitle;

    public Text(Sentence[] text, Sentence[] textTitle) {
        this.text = text;
        this.textTitle = textTitle;
    }

    public Text(Sentence[] text) {
        this.text = text;
    }

    public void pad(Sentence sentence) {
        Sentence[] newText = Arrays.copyOf(text, text.length + 1);
        newText[text.length] = sentence;
        text = newText;
    }

    public static void main(String[] args) {
        Text basicText = createText();
        createTitle(basicText);
        System.out.println(basicText.toString() + "\n");

        Word[] words = {new Word("Задать"), new Word("критерии"), new Word("выбора"), new Word("данных")};
        basicText.pad(new Sentence(words, Sentence.SentenceType.QUESTION_MARK));

        basicText.printTitle();
        basicText.printText();
    }

    private static void createTitle(Text basicText) {
        Word[] wordsTitle = {new Word("Task"), new Word("10")};
        Sentence[] sentenceTitle = new Sentence[1];
        sentenceTitle[0] = new Sentence(wordsTitle, Sentence.SentenceType.EXCLAMATION_POINT);
        basicText.setTextTitle(sentenceTitle);
    }

    private static Text createText() {
        Sentence[] sentences = new Sentence[3];
        Word[] words = {new Word("Создать"), new Word("класс"), new Word("Airline,"), new Word("спецификация"),
                new Word("которого"), new Word("приведена"), new Word("ниже")};
        sentences[0] = new Sentence(words);
        words = new Word[]{new Word("Определить"), new Word("конструкторы"), new Word("и"), new Word("методы")};
        sentences[1] = new Sentence(words);
        words = new Word[]{new Word("Создать"), new Word("второй"), new Word("класс,"), new Word("агрегирующий"),
                new Word("массив"), new Word("типа"), new Word("Airline")};
        sentences[2] = new Sentence(words);
        return new Text(sentences);
    }

    public void printText() {
        System.out.print(compileText());
    }

    public void printTitle() {
        System.out.print(compileTitle());
    }

    @Override
    public String toString() {
        StringBuilder titleToString = compileTitle();
        StringBuilder textToString = compileText();
        return titleToString.toString() + textToString.toString();
    }

    private StringBuilder compileText() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : text) {
            result.append(sentence.toString().concat(" "));
        }
        return result;
    }

    private StringBuilder compileTitle() {
        StringBuilder result = new StringBuilder();
        for (Sentence title : textTitle) {
            result.append(title.toString());
        }
        if (textTitle.length > 0) {
            result.append("\n");
        }
        return result;
    }

    public Sentence[] getText() {
        return text;
    }

    public void setText(Sentence[] text) {
        this.text = text;
    }

    public Sentence[] getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(Sentence[] textTitle) {
        this.textTitle = textTitle;
    }
}
