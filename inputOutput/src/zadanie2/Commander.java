package zadanie2;

import java.io.IOException;
import java.util.Scanner;

import static zadanie2.File.makeFile;
import static zadanie2.Folder.makeFolders;
import static zadanie2.Details.printFilesDetails;
import static zadanie2.FolderTree.printTree;
import static zadanie2.List.printFilesSimple;


public class Commander {
	
	public static void main(String[] args) throws IOException {
		String choice = "";

		while (!choice.equals("exit")) {
			System.out.println("\n########## FILE MANAGER v0.1 ##########");
			System.out.println("Select option (list,details,foldertree,addfolder,addfile,exit)");
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextLine();
            switch (choice) {
                case "list" -> {
                    System.out.println("Provide path:");
                    String parameter = scanner.nextLine();
                    printFilesSimple(parameter);
                }
                case "details" -> {
                    System.out.println("Provide path:");
                    String parameter = scanner.nextLine();
                    printFilesDetails(parameter);
                }
                case "foldertree" -> {
                    System.out.println("Provide path:");
                    String parameter = scanner.nextLine();
                    printTree(parameter);
                }
				case "addfolder" -> {
					System.out.println("Provide path and folder name:");
					String parameter = scanner.nextLine();
					makeFolders(parameter);
				}
				case "addfile" -> {
					System.out.println("Provide path and file name:");
					String parameter = scanner.nextLine();
					makeFile(parameter);
				}
            }
		}
	}
}