package zadanie2;

import java.io.IOException;
import java.io.PrintWriter;

public class File {

    public static void makeFile(String filename) throws IOException {
        PrintWriter pw = new PrintWriter(filename);
        pw.close();
    }
}
