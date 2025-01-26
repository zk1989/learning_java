package zadanie2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Details {

    public static void printFilesDetails(String path) throws IOException {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        System.out.printf("%-25s%-19s%-20s\n", "name", "dir/byte size", "creation time");

        for (File file : listOfFiles) {
            String fileName = file.getName();
            boolean isDirectory = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class).isDirectory();
            FileTime unformattedfileTime = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class).creationTime();
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd mm:ss");
            String fileTime = df.format(unformattedfileTime.toMillis());

            if (isDirectory) {
                System.out.printf("%-30s%-14s%-20s\n", fileName, "DIR", fileTime);
            } else {
                long fileSize = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class).size();
                System.out.printf("%-30s%-14s%-20s\n", fileName, fileSize, fileTime);
            }
        }
    }
}
