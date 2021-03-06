package inf101.sem2.terminal;

import java.util.ArrayList;
import java.util.Scanner;

import inf101.sem2.game.*;
import inf101.sem2.player.*;

public class TerminalMenu {

	public static Game selectGame(ArrayList<Player> players) {

		OthelloPlayer p1 = new HumanPlayer("Human");
		OthelloPlayer p2 = new HumanPlayer("Menneske");


		System.out.println("Which game do you wish to play?");
		System.out.println("Press 1 for TicTacToe, 2 for Connect 4 and 3 for Othello");
		int choice = TerminalInput.readInt(new Scanner(System.in));
		Game game;
		switch (choice) {
			case 1:
				game = new TicTacToe(new TerminalGraphics(), players.get(0), players.get(1));
				break;
			case 2:
				game = new ConnectFour(new TerminalGraphics(), players.get(0), players.get(1));
				break;
			case 3:
				Othello play = new Othello();
				play.playGame(p1,p2,true);
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		return game;
	}

	public static ArrayList<Player> getPlayers() {
		System.out.println("Player 1, what is your name?");
		ArrayList<Player> players = new ArrayList<>();
		players.add(new ConsolePlayer('X'));
		System.out.println("(1) Two players or \n(2) play against computer?");
		int multiplayerChoice = TerminalInput.readInt(new Scanner(System.in));
		switch (multiplayerChoice) {
			case 1:
				players.add(new ConsolePlayer('O'));
				break;
			case 2:
				//players.add(new MiniMaxPlayer('O', 5));
				players.add(new DumbPlayer('O'));
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + multiplayerChoice);
		}
		return players;
	}

	public static boolean isDone() {
		System.out.println("Play again? y/n");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();
		sc.close();
		return !choice.startsWith("y");
	}
}
