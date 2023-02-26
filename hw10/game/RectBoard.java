package game;

import java.util.Arrays;
import java.util.Map;

public class RectBoard extends TicTacToeBoard {

    public RectBoard(int n, int m, int k) {
        super(n, m, k);
    }

    private RectBoard(int n, int m, int k, Cell[][] field, Cell turn, int free, int voteForDraw) {
        super(n, m, k, field, turn, free, voteForDraw);
    }

    @Override
    public RectBoard clone() {
        return new RectBoard(n, m, k, field, turn, free, voteForDraw);
    }

    public boolean checkWin(int x, int y) {
        return checkDirection(x, y, 0, 1)
                || checkDirection(x, y, 1, 0)
                || checkDirection(x, y, 1, 1)
                || checkDirection(x, y, 1, -1);
    }

    @Override
    public String consoleOutput() {
        int colWidth = 1;
        for (int i = m; i > 0; i /= 10) {
            colWidth++;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("%" + colWidth + "s", ""));
        for (int i = 0; i < m; i++) {
            sb.append(String.format("%" + colWidth + "s", i + 1));
        }
        sb.append(System.lineSeparator());
        for (int r = 0; r < n; r++) {
            sb.append(String.format("%" + colWidth + "s", r + 1));
            for (Cell cell : field[r]) {
                sb.append(String.format("%" + colWidth + "s", CELL_TO_STRING.get(cell)));
            }
            sb.append(System.lineSeparator());
        }
        sb.setLength(sb.length() - System.lineSeparator().length());
        return sb.toString();
    }
}
