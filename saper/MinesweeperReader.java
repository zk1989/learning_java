package pl.edu.agh.mwo;


public class MinesweeperReader {

    public MinesweeperBoard read(String textBoard, int width, int height ) {
        textBoard = textBoard.replaceAll("\\s", "");
        char[][] board = new char[height][width];

        if (textBoard.length() != height*width) {
            throw new IllegalArgumentException(
                    String.format("Board does not have the same length. Actual size: %d, expected size: %d", textBoard.length(), height*width));
        }

        assert textBoard.length() == width * height;
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                char c = textBoard.charAt(x*width + y);
                if (c != '*' && c != '.') {
                    throw new IllegalArgumentException("Given board has invalid character: " + c);
                }
                board[x][y] = textBoard.charAt(x*width + y);
            }
        }
        return new MinesweeperBoard(board);
    }
}