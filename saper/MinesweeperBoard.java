package pl.edu.agh.mwo;


public class MinesweeperBoard {

    private char[][] mines;

    public MinesweeperBoard(char[][] mines) {
        this.mines = mines;
    }

    public char[][] getMines() {
        return mines;
    }

    public String toString() {
        String result = "";
        for (char[] mine : mines) {
            for (char c : mine) {
                result += c;
            }
            result += "\n";
        }
        return result;
    }
}
