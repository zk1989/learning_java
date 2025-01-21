package cwiczenie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		String filename = "res/cwiczenie1/poem.txt";
		System.out.println("Wykorzystanie klasy File i Scanner:");
		scanFile(filename, "was");
		System.out.println("\nWykorzystanie klasy BufferedReader - linie:");
		readFile(filename, "was", "to");
		System.out.println("\nWykorzystanie klasy BufferedReader - znaki:");
		readChars(filename);
		System.out.println("\nWykorzystanie biblioteki java.nio.file.Files i java.nio.file.Paths:");
		printFile(filename);
	}

	private static void scanFile(String filename, String keyword) throws FileNotFoundException {
		File poemFile = new File(filename);
		Scanner scanner = new Scanner(poemFile);
		int foundTokens = 0;
		while (scanner.hasNext()) {
			String currentToken = scanner.next();
			if (currentToken.equals(keyword)) {
				System.out.println(currentToken);
				foundTokens++;
			}
		}
		System.out.println("------------------");
		System.out.println("Found tokens: " + foundTokens);
		System.out.println("File path: " + poemFile.getPath());
		System.out.println("Free space: " + poemFile.getFreeSpace());
		scanner.close();
	}

	private static void readFile(String file, String... keywords) {
		File poemFile = new File(file);
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
			String line = null;
			int lineNumber = 0;
			int foundTokens = 0;
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				for (String keyword : keywords) {
					if (line.contains(keyword)) {
						System.out.println(lineNumber + " " + line);
						foundTokens++;
						break;
					}
				}
			}
			System.out.println("Number of lines where tokens were found: " + foundTokens);
		} catch (IOException x) {
			System.err.format("IOException: %s", x);
		}
	}

	private static void readChars(String filename) {
		File poemFile = new File(filename);
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
			int nextChar = 0;
			int charCount = 0;
			int lineNumber = 0;
			while ((nextChar = reader.read()) != -1) {
				char newLine = '\n';
				if (nextChar == newLine) {
					lineNumber++;
				}
				charCount++;
			}
			System.out.println("Liczba wszystkich znaków: " + charCount);
			System.out.println("Liczba wszystkich linii: " + lineNumber);
		} catch (IOException x) {
			System.err.format("IOException: %s", x);
		}
	}

	private static void printFile(String filename) {
		try {
			String content = Files.readString(Paths.get(filename));
			System.out.println(content);
		} catch (IOException x) {
			System.err.format("IOException: %s", x);
		}
	}
}
