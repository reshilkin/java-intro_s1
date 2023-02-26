package game;

import java.util.Arrays;
import java.util.Map;

public abstract class TicTacToeBoard implements Board, Position {
    protected static final Map<Cell, String> CELL_TO_STRING = Map.of(Cell.E, ".", Cell.X, "X", Cell.O, "0");

    protected Cell turn;
    protected int voteForDraw;
    protected int free;
    protected final int n, m, k;
    protected final Cell[][] field;

    protected TicTacToeBoard(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.free = n * m;
        this.turn = Cell.X;
        this.field = new Cell[n][m];
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
    }

    public TicTacToeBoard(int n, int m, int k, Cell[][] field, Cell turn, int free, int voteForDraw) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.field = new Cell[n][m];
        for (int i = 0; i < n; i++) {
            this.field[i] = Arrays.copyOf(field[i], m);
        }
        this.turn = turn;
        this.free = free;
        this.voteForDraw = voteForDraw;
    }

    @Override
    public Board clone() {
        return null;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public GameResult makeMove(Move move) {
        if (!isValid(move)) {
            return GameResult.LOOSE;
        }
        if (voteForDraw == 0 && move == Move.ACCEPT_DRAW) {
            voteForDraw = 1;
            turn = turn == Cell.X ? Cell.O : Cell.X;
            return GameResult.UNKNOWN;
        } else if (voteForDraw > 0 && move == Move.ACCEPT_DRAW) {
            return GameResult.DRAW;
        } else if (voteForDraw > 0 && move == Move.DECLINE_DRAW) {
            voteForDraw = -1;
            turn = turn == Cell.X ? Cell.O : Cell.X;
            return GameResult.UNKNOWN;
        } else if (move == Move.FORFEIT) {
            return GameResult.LOOSE;
        }
        field[move.getRow()][move.getCol()] = move.getValue();
        voteForDraw = 0;
        free--;
        if (this.checkWin(move.getRow(), move.getCol())) {
            return GameResult.WIN;
        }
        if (free == 0) {
            return GameResult.DRAW;
        }
        turn = turn == Cell.X ? Cell.O : Cell.X;
        return GameResult.UNKNOWN;
    }

    @Override
    public Cell getTurn() {
        return turn;
    }

    @Override
    public boolean isValid(final Move move) {
        return voteForDraw > -1
                  && move.getMoveType() != MoveType.MOVE
                || 0 <= move.getRow()
                  && move.getRow() < n
                  && 0 <= move.getCol()
                  && move.getCol() < m
                  && field[move.getRow()][move.getCol()] == Cell.E
                  && turn == move.getValue()
                  && voteForDraw != 1;
    }

    @Override
    public int getN() {
        return n;
    }

    @Override
    public int getM() {
        return m;
    }

    @Override
    public int getFree() {
        return free;
    }

    @Override
    public int getVoteForDraw() {
        return voteForDraw;
    }

    protected boolean isCurrentPlayerCell(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && field[x][y] == turn;
    }

    protected boolean checkDirection(int x, int y, int dx, int dy) {
        int r = x;
        int c = y;
        if (dx > 0) {
            r -= k;
        } else if (dx < 0) {
            r += k;
        }
        if (dy > 0) {
            c -= k;
        } else if (dy < 0) {
            c += k;
        }
        int cnt = 0;
        for (int i = 0; i < 2 * k; i++) {
            if (isCurrentPlayerCell(r, c)) {
                cnt++;
                if (cnt == k) {
                    return true;
                }
            } else {
                cnt = 0;
            }
            r += dx;
            c += dy;
        }
        return false;
    }
}
