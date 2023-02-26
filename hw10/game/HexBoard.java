package game;

public class HexBoard extends TicTacToeBoard {
    protected HexBoard(int n, int m, int k) {
        super(n, m, k);
    }

    public HexBoard(int n, int m, int k, Cell[][] field, Cell turn, int free, int voteForDraw) {
        super(n, m, k, field, turn, free, voteForDraw);
    }

    @Override
    public HexBoard clone() {
        return new HexBoard(n, m, k, field, turn, free, voteForDraw);
    }

    @Override
    public boolean checkWin(int x, int y) {
        return checkDirection(x, y, 1, 0)
                || checkDirection(x, y, 0, 1)
                || checkDirection(x, y, 1, -1);
    }

    @Override
    public String consoleOutput() {
        int colWidth = 1;
        for (int i = Math.max(n, m); i > 0; i /= 10) {
            colWidth++;
        }
        StringBuilder res = new StringBuilder();
        res.append(String.format("%" + colWidth + "s", ""));
        for (int i = 1; i <= m; i++) {
            res.append(String.format("%" + colWidth + "s", i));
        }
        res.append(System.lineSeparator());
        for (int i = 0; i < n; i++) {
            res.append(String.format("%" + (colWidth + i) + "s", i + 1));
            for (Cell cell : field[i]) {
                res.append(String.format("%" + colWidth + "s", CELL_TO_STRING.get(cell)));
            }
            res.append(System.lineSeparator());
        }
        return res.toString();
    }
}
