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
}
