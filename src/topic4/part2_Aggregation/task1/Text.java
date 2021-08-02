package topic4.part2_Aggregation.task1;

import java.util.Arrays;

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

    public void printText(Sentence[] textTitle) {
        System.out.print(Action.compileText(textTitle));
    }

    public void printTitle(Sentence[] text) {
        System.out.print(Action.compileTitle(text));
    }

    @Override
    public String toString() {
        StringBuilder titleToString = Action.compileTitle(textTitle);
        StringBuilder textToString = Action.compileText(text);
        return titleToString.toString() + textToString.toString();
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
