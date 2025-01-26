package cwiczenie3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static String[] stringsToBeWritten = { "Joh Woo 001", "Robert Duval 002", "James Bond 007" };

	public static void main(String[] args) throws Exception {
		saveAgents(stringsToBeWritten, "res/cwiczenie3/special-agents.txt");
		String[] newAgents = { "New Agent 004" };
		addAgents("res/cwiczenie3/special-agents.txt", newAgents);
		makeFolders();
		copyAgents("special-agents.txt", "copied-agents.txt");
		deleteFolder("res/cwiczenie3/agents/missing");
	}

	private static void saveAgents(String[] agents, String filename) throws Exception {
		PrintWriter pw = new PrintWriter(filename);
		for (String agent : agents) {
			pw.println(agent);
		}
		pw.close();
	}

	private static void addAgents(String filename, String[] newAgents) throws Exception {
		PrintWriter pw = new PrintWriter(new FileOutputStream(filename, true), true);
		for (String agent : newAgents) {
			pw.println(agent);
		}
		pw.close();
	}

	private static void makeFolders() {
		new File("res/cwiczenie3/agents/active").mkdirs();
		new File("res/cwiczenie3/agents/missing").mkdirs();
	}

	private static void copyAgents(String sourceFile, String targetFile) {
		Path sourcePath = Paths.get("res/cwiczenie3/" + sourceFile);
		Path destinationPath = Paths.get("res/cwiczenie3/agents/active/" + targetFile);
		try {
			Files.copy(sourcePath, destinationPath);
		} catch (IOException ignored) {}
	}

	private static void deleteFolder(String folderPath) {
		try {
			Path path = new File(folderPath).toPath();
			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
