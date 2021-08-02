package topic4.part2_Aggregation.task1;

public class Action {
    public static StringBuilder compileTitle(Sentence[] textTitle) {
        StringBuilder result = new StringBuilder();
        for (Sentence title : textTitle) {
            result.append(title.toString());
        }
        if (textTitle.length > 0) {
            result.append("\n");
        }
        return result;
    }

    public static StringBuilder compileText(Sentence[] text) {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : text) {
            result.append(sentence.toString().concat(" "));
        }
        return result;
    }
}
