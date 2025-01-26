package zadanie2;

import java.io.File;

public class AddFolder {

    public static void makeFolders(String pathname) {
        new File(pathname).mkdirs();
    }
}
