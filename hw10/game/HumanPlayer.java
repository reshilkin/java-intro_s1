package game;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner in;

    public HumanPlayer(Scanner in) {
        this.in = in;
    }

    @Override
    public Move makeMove(Position position) {
        System.out.println();
        System.out.println("Current position");
        System.out.println(position.consoleOutput());
        if (position.getVoteForDraw() == 1) {
            System.out.println("The other player offered draw. Do you accept? (Type y if you agree)");
            String ans = in.next();
            if (ans.equalsIgnoreCase("y")) {
                return Move.ACCEPT_DRAW;
            } else {
                return Move.DECLINE_DRAW;
            }
        }
        System.out.println("Enter you move for " + position.getTurn());
        if (position.getVoteForDraw() != -1) {
            System.out.println("To offer draw type -1 -1");
        } else {
            System.out.println("The other player didn't accept draw");
        }
        System.out.println("To forfeit type -2 -2");
        Move move = null;
        do {
            if (move != null) {
                System.out.println("Wrong move, try again");
            }
            String strX = in.next();
            String strY = in.next();
            int x = -1;
            int y = -1;
            try {
                x = Integer.parseInt(strX);
                y = Integer.parseInt(strY);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter two NUMBERS");
                continue;
            }
            if (x == -1 && y == -1) {
                if (position.isValid(Move.ACCEPT_DRAW)) {
                    return Move.ACCEPT_DRAW;
                }
                System.out.println("You can't offer the draw on the same move if the opponent didn't accept it");
            } else if(x == -2 && y == -2) {
                return Move.FORFEIT;
            } else {
                move = new Move(x - 1, y - 1, position.getTurn(), MoveType.MOVE);
            }
        } while (move == null || !position.isValid(move));
        return move;
    }
}
