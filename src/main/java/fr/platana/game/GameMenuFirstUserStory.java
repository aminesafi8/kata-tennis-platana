package fr.platana.game;

import java.util.Scanner;

import fr.platana.impl.FirstUserStory;

/**
 * 
 * @author SAFI
 *
 */
public class GameMenuFirstUserStory {

	public static void main(String[] args) {
		String playerOne = "Safi";
		String playerTwo = "Platana";
		FirstUserStory game = new FirstUserStory(playerOne, playerTwo);
		System.out.println(game.getScore());

		while (game.isGameOver() == false) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Who scores ?");
			int playerNumber = sc.nextInt();
			if (playerNumber == 1)
				game.playerOneScores();
			if (playerNumber == 2)
				game.playerTwoScores();
		}
	}
}
