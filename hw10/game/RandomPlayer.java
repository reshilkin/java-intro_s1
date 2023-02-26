package game;

import java.util.Random;

public class RandomPlayer implements Player {
    private final Random random = new Random();

    @Override
    public Move makeMove(Position position) {
        int draw = random.nextInt(5);
        if (position.getVoteForDraw() == 1) {
            if (draw == 0) {
                return Move.ACCEPT_DRAW;
            } else {
                return Move.DECLINE_DRAW;
            }
        } else if (position.getVoteForDraw() == 0 && draw == 0) {
            return Move.ACCEPT_DRAW;
        }
        int num = random.nextInt(position.getFree());
        int r = 0;
        int c = 0;
        while (num > 0 || !position.isValid(new Move(r, c, position.getTurn(), MoveType.MOVE))) {
            if (position.isValid(new Move(r, c, position.getTurn(), MoveType.MOVE))) {
                num--;
            }
            c++;
            if (c == position.getM()) {
                r++;
                c = 0;
            }
        }
        return new Move(r, c, position.getTurn(), MoveType.MOVE);
    }
}
