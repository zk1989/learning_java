package pl.edu.agh.mwo.java.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CrawlerStarter {

	public static void main(String[] args) throws IOException
	{

		Crawler c = new Crawler("https://www.interia.pl", new TextExtractor(), new ConsoleResultsPrinter());

		c.addSentenceFinder(new SentenceByWordFinder("Tusk"));
		c.addSentenceFinder(new SentenceByWordFinder("na"));
		c.addSentenceFinder(new SentenceByLastCharFinder("k"));
		c.addSentenceFinder(new SentenceByLengthFinder(30));

		// klasa anonimowa
		c.addSentenceFinder(new SentenceFinder() {
			@Override
			public List<String> findSentences(List<String> sentences) {
				List<String> foundSentences = new ArrayList<>();
				for (String sentence : sentences) {
					String substring = ", ";
					int count = (sentence.length() - sentence.replace(substring, "").length()) / substring.length();
					if (count >= 2) {
						foundSentences.add(sentence);
					}
				}
				return foundSentences;
			}
		});

		// lambda
		c.addSentenceFinder((sentences) -> {
			List<String> foundSentences = new ArrayList<>();
			for (String sentence : sentences) {
				if (sentence.contains("A") && sentence.contains("B")) {
					foundSentences.add(sentence);
				}
			}
			return foundSentences;
		});

		// strumienie
		c.addSentenceFinder(sentences ->
				sentences.stream().filter(sentence -> sentence.length() < 10).collect(Collectors.toList()));

		c.run();

	}
}
