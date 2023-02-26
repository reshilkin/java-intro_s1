package game;

public class SequentialPlayer implements Player {
    @Override
    public Move makeMove(Position position) {
        if(position.getVoteForDraw() == 1) {
            return Move.DECLINE_DRAW;
        }
        for (int r = 0; r < position.getN(); r++) {
            for (int c = 0; c < position.getM(); c++) {
                final Move move = new Move(r, c, position.getTurn(), MoveType.MOVE);
                if (position.isValid(move)) {
                    return move;
                }
            }
        }
        throw new AssertionError("No valid moves");
    }
}
