package zadanie2;

import java.io.File;

public class List {

    public static void printFilesSimple(String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            System.out.printf(file.getName() + ", ");
        }
    }
}
