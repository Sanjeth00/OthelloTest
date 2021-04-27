package inf101.sem2.game;

public class OthelloMove {

    private int toRow, toCol;
    private boolean noMove = false;
    private boolean gameOver = false;

    public OthelloMove(int r, int c) {
        toRow = r;
        toCol = c;
    }

    public OthelloMove(OthelloMove c) {
        toRow = c.getRow();
        toCol = c.getCol();
    }

    public int getRow() {
        return toRow;
    }

    public int getCol() {
        return toCol;
    }

    public void concede() {
        noMove = true;
        gameOver = true;
    }

    public void noLegalmoves() {
        noMove = true;
    }

    public boolean gameOver() {
    return gameOver;
    }

    public boolean noMoves() {
        return noMove;
    }
}
