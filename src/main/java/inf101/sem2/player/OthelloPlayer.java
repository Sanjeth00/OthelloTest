package inf101.sem2.player;

import inf101.sem2.game.Othello;
import inf101.sem2.game.OthelloMove;

public abstract class OthelloPlayer {

    public String name = "Player";
    public char colour = '.';

    public OthelloPlayer() {
        name = "Player";
        colour = '.';
    }

    public OthelloPlayer(String pName) {
        name = pName;
        colour = '.';
    }

    public abstract void initialize(char pColour);

    public abstract OthelloMove makeMove(Othello game);
}
