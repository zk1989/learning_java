package pl.edu.agh.mwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MinesweeperApp {

    public static void main(String[] args) throws IOException {
        boolean isInputCorrect = false;
        do {
            try {
                MinesweeperReader reader = new MinesweeperReader();
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str;
                System.out.println("Podaj liczbe wierszy (wysokosc): ");
                str = br.readLine();
                int height = Integer.parseInt(str);
                System.out.println("Podaj liczbe kolumn (szerokosc): ");
                str = br.readLine();
                int width = Integer.parseInt(str);
                String b1 = "";
                for (int i = 1; i <= height; i++) {
                    System.out.printf("Podaj wiersz nr " + i + ": ");
                    str = br.readLine();
                    if (str.length() != width) {
                        throw new IllegalArgumentException("Wiersz ma inna szerokosc niz zadeklarowana!");
                    }
                    b1 = b1 + str;
                }
                MinesweeperBoard board = reader.read(b1, width, height);
                MinesweeperAnalyser analyser = new MinesweeperAnalyser();
                analyser.fillIn(board);
                System.out.println("Dziekuje. Wypelniona tablica wyglada nastepujaco: \n" + board);
            } catch (IllegalArgumentException i) {
                System.err.println(i);
                System.out.println("Please try again!");
                isInputCorrect = false;
            }
        } while (!isInputCorrect);
    }
}
