package topic4.part2_Aggregation.task1;

import java.util.Arrays;

public class Sentence {
    public enum SentenceType {
        COMMA(","),
        DOT("."),
        EXCLAMATION_POINT("!"),
        QUESTION_MARK("?");

        private String sign;

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        SentenceType(String sign) {
            this.sign = sign;
        }
    }

    private Word[] sentence;
    private SentenceType sentenceType;

    public Sentence(Word[] sentence, SentenceType type) {
        this.sentence = sentence;
        this.sentenceType = type;
    }

    public Sentence(Word[] sentence) {
        this.sentence = sentence;
        this.sentenceType = SentenceType.DOT;
    }

    public void pad(Word word) {
        Word[] newSentence = Arrays.copyOf(sentence, sentence.length + 1);
        newSentence[sentence.length] = word;
        sentence = newSentence;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Word word : sentence) {
            result.append(word.toString().concat(" "));
        }
        if (result.length() > 0) {
            result.delete(result.length() - 1, result.length());
        }
        result.append(sentenceType.sign);
        return result.toString();
    }

    public Word[] getSentence() {
        return sentence;
    }

    public void setSentence(Word[] sentence) {
        this.sentence = sentence;
    }

    public SentenceType getSentenceType() {
        return sentenceType;
    }

    public void setSentenceType(SentenceType sentenceType) {
        this.sentenceType = sentenceType;
    }
}
