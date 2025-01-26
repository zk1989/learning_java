package pl.edu.agh.mwo.java.crawler;

import java.util.ArrayList;
import java.util.List;

public class SentenceByLengthFinder implements SentenceFinder{

    protected int sentenceLength;

    public SentenceByLengthFinder(int sentenceLength) {
        super();
        this.sentenceLength = sentenceLength;
    }

    @Override
    public List<String> findSentences(List<String> sentences) {
        List<String> foundSentences = new ArrayList<>();
        for (String sentence : sentences) {
            if (sentence.length() <= this.sentenceLength) {
                foundSentences.add(sentence);
            }
        }
        return foundSentences;
    }
}
