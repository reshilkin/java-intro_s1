package game;

public interface Position extends ConsolePrintable{
    Cell getTurn();

    boolean isValid(Move move);

    int getN();

    int getM();

    int getFree();

    int getVoteForDraw();

    boolean checkWin(int x, int y);
}
