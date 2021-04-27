package inf101.sem2.game;

import java.lang.Character;
import java.lang.String;
import java.util.ArrayList;

public class Othello {

    private static final int size = 8;
    private char oBoard[][];
    public static String newline = System.getProperty("line.separator");


    public Othello() {
        oBoard = new char[size+2][size+2];
        reset();
    }

    public Othello(int n, char[][] wBoard) {
        if (n != size+2) {
            System.out.println(" Invalid game board!");
        }
        else
            oBoard = wBoard;
    }

    public Othello(Othello s) {
        oBoard = s.getBoardCopy();
    }

    public void reset() {
        int i,j;
        for (i = 1; i < size + 1; i++)
            for (j = 1; j < size + 1; j++)
                oBoard[i][j] = '.';
        for (i = 0; i < size + 2; i++)
            oBoard[0][i] = oBoard[i][0] = oBoard[size+1][i] = oBoard[i][size+1] = '*';
        i = size/2;
        oBoard[i][i] = oBoard[i+1][i+1] = 'w';
        oBoard[i][i+1] = oBoard[i+1][i] = 'b';
    }

    public char posOccupy(int r, int c) {
        return oBoard[r][c];
    }

    private boolean validPos(int r, int c) {
        boolean valid = true;
        if ((c <= 0 || c > size) || (r <= 0 || r > size))
            valid = false;

        return valid;
    }

    private boolean contain(int r, int c, char symbol) {
        boolean contains = false;
        if (validPos(r, c)) {
            if (oBoard[r][c] == Character.toLowerCase(symbol))
                contains = true;
        }
        return contains;
    }

    public boolean contain(int r ,int c, char symbol, char[][] wBoard) {
        boolean contains = false;
        if (validPos(r, c)) {
            if (wBoard[r][c] == Character.toLowerCase(symbol))
                contains = true;
        }
        return contains;
    }

    public int counter(char symbol) {
        if (Character.isUpperCase(symbol)) {
            symbol = Character.toLowerCase(symbol);
        }
        int count = 0;
        for (int c = 1; c <= size; c++) {
            for (int r = 1; r <= size; r++) {
                if (oBoard[c][r] == symbol) {
                    count++;
                }
            }
        }
        return count;
    }

    public int frontDisk (char player) {
        int dirI[] = {-1,1,0,0,1,-1,1,-1};
        int dirJ[] = {0,0,1,-1,1,-1,-1,1};
        int sum = 0;
        for (int i = 1; i <= size; i++)
            for (int j = 1; j <= size; j ++) {
                if (oBoard[i][j] == player)
                    for (int k = 0; k < 8; k++)
                        if (oBoard[i+dirI[k]][j+dirJ[k]] == player) {
                            sum++;
                            break;
                        }
                }
        return sum;
    }

    public char enemy(char player) {
        if (player == 'b')
            return 'w';
        else
            return 'b';
    }

    public boolean wFlip(char player, int r, int c, int dir) {
        int dirI[] = {-1,1,0,0,1,-1,1,-1};
        int dirJ[] = {0,0,1,-1,1,-1,-1,1};
        int row = r, col = c;
        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            row += dirI[dir];
            col += dirJ[dir];
            if (oBoard[row][col] == enemy(player)) {
                flag = true;
            }
            else if (oBoard[row][col] == player) {
                if (flag)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        return false;
    }

    public void mFlip(char player, int r, int c, int dir) {
        int dirI[] = {-1,1,0,0,1,-1,1,-1};
        int dirJ[] = {0,0,1,-1,1,-1,-1,1};
        if(wFlip(player,r,c,dir)) {
            r += dirI[dir];
            c += dirJ[dir];
            while (oBoard[r][c] != player) {
                oBoard[r][c] = player;
                r += dirI[dir];
                c += dirJ[dir];
            }
        }
    }

    public boolean legalMove(char player, int r, int c) {
        if (oBoard[r][c] == '.') {
            for (int k = 0; k < 8; k++)
                if (wFlip(player,r,c,k)) {
                    return true;
                }
        }
        return false;
    }

    public boolean anyLegalMoves(char player) {
        for (int i = 1; i <= size; i++)
            for (int j = 1; i <= size; j++)
                if (legalMove(player,i,j))
                    return true;
        return false;
    }

    public void makinMoves(char player, OthelloMove m) {
        int r = m.getRow();
        int c = m.getCol();
        if (legalMove(player,r,c)) {
            oBoard[r][c] = player;
            for (int i = 0; i < size; i++) {
                mFlip(player,r,c,i);
            }
        }
    }

    public String boardString() {
        String result = new String();
        result = "  ";
        for (int i = 1; i <= size; i++) {
            result += Integer.toString(i) + " ";
        }
        result += newline;
        for (int y = 1; y <= size; y++) {
            result += Integer.toString(y) + " ";
            for (int x = 1; x <= size; x++) {
                result += Character.toString(oBoard[y][x]) + " ";
            }
            result += newline;
        }
        return result;
    }

    public ArrayList<OthelloMove> generatesMoves(char player) {
        ArrayList<OthelloMove> possibleMoves = new ArrayList<OthelloMove>();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (legalMove(player,i,j)) {
                    OthelloMove aMove = new OthelloMove(i,j);
                    possibleMoves.add(aMove);
                }
            }
        }
        return possibleMoves;
    }

    public char[][] getBoardCopy() {
        char newBoard[][] = new char[size+2][size+2];
        for (int i = 0; i < size+2; i++)
            System.arraycopy(oBoard[i], 0, newBoard[i], 0, size);

        return newBoard;
    }


}
