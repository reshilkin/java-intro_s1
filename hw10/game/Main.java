package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int result =
                new TwoPlayerGame(new HexBoard(11, 11, 7),
                        new RandomPlayer(),
                        new HumanPlayer(new Scanner(System.in))).play(true);
        switch (result) {
            case 1:
                System.out.println("First player won");
                break;
            case 2:
                System.out.println("Second player won");
                break;
            case 0:
                System.out.println("Draw");
                break;
            default:
                throw new AssertionError("Unknown result " + result);
        }
    }
}
