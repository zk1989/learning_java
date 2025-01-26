package zadanie2;

import java.io.File;

public class FolderTree {

    public static void printTree(String path) {
        File root = new File(path);
        File[] leaves = root.listFiles();

        for (File leaf : leaves) {
            String pathToLeaf = leaf.getPath();
            System.out.println(pathToLeaf);
            if (leaf.listFiles() != null) {
                printTree(pathToLeaf);
            }
        }
    }

}
