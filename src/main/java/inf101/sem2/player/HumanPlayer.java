package inf101.sem2.player;

import inf101.sem2.game.Othello;
import inf101.sem2.game.OthelloMove;

import java.util.Scanner;

public class HumanPlayer extends OthelloPlayer {

    public HumanPlayer(String pName) {
        super(pName);
    }

    @Override
    public void initialize(char pColour) {
        colour = pColour;
    }

    @Override
    public OthelloMove makeMove(Othello game) {
        boolean validInput = false;
        OthelloMove humanMove = null;
        Scanner scanner = new Scanner(System.in);
        int col, row;
        if(!game.anyLegalMoves(colour)) {
            OthelloMove noMove = new OthelloMove(0,0);
            noMove.noLegalmoves();
            System.out.println("Here!! no valid moves!\n");
            return noMove;
        }
        while (!validInput) {
            System.out.println("Enter row col (or -1 to give up): ");
            try {
                row = scanner.nextInt();
                if (row == -1) {
                    OthelloMove gameOver = new OthelloMove(0,0);
                    gameOver.concede();
                    return gameOver;
                }
                else {
                    col = scanner.nextInt();
                    if (game.legalMove(colour,row,col)) {
                        humanMove = new OthelloMove(row, col);
                        validInput = true;
                    }
                    else
                        System.out.println("Invalid move!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }

        return humanMove;
    }
}
