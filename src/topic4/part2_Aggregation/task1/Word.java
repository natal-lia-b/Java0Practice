package topic4.part2_Aggregation.task1;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
