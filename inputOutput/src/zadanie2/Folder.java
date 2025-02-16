package zadanie2;

import java.io.File;

public class Folder {
    public static void makeFolders(String pathname) {
        new File(pathname).mkdirs();
    }
}
