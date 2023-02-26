package game;

public class Move implements ConsolePrintable {
    private final int row;
    private final int col;
    private final Cell value;
    private final MoveType moveType;
    final static Move FORFEIT = new Move(-1, -1, Cell.E, MoveType.FORFEIT);
    final static Move ACCEPT_DRAW = new Move(-1, -1, Cell.E, MoveType.DRAW_ACCEPT);
    final static Move DECLINE_DRAW = new Move(-1, -1, Cell.E, MoveType.DRAW_DECLINE);

    public Move(int row, int col, Cell value, MoveType moveType) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.moveType = moveType;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Cell getValue() {
        return value;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    @Override
    public String consoleOutput() {
        if (this == ACCEPT_DRAW) {
            return "Voted for draw";
        }
        if (this == DECLINE_DRAW) {
            return "Voted against draw";
        }
        if (this == FORFEIT) {
            return "Forfeited";
        }
        return String.format("Move(%s, %d, %d)", value, row + 1, col + 1);
    }
}
