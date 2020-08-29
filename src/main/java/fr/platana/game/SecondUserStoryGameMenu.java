package fr.platana.game;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import fr.platana.impl.SecondUserStory;

/**
 * 
 * @author SAFI
 *
 */
public class SecondUserStoryGameMenu {

	public static void main(String[] args) {
		/* to read some data as inputs from the keyboard */
		Scanner sc = new Scanner(System.in);
		/*
		 * each time the user will be asked to type 1 (player one) or 2 (player two) to
		 * score points for the right player
		 */
		int playerNumber;
		/* players names */
		String playerOne = "";
		String playerTwo = "";
		/* read a valid name of the first player */
		while (StringUtils.isBlank(playerOne)) {
			System.out.println("Player One Name:");
			playerOne = sc.nextLine();
		}
		/* read a valid name of the second player */
		while (StringUtils.isBlank(playerTwo)) {
			System.out.println("Player Two Name:");
			playerTwo = sc.nextLine();
		}

		SecondUserStory game = new SecondUserStory(playerOne, playerTwo);
		System.out.println(game.getScore());
		/* start the game */
		while (game.isGameOver() == false) {
			System.out.println("Who scores ?");
			playerNumber = sc.nextInt();
			switch (playerNumber) {
			case 1:
				game.playerOneScores();
				break;
			case 2:
				game.playerTwoScores();
				break;
			default:
				System.out.println("Type a correct player number!");
			}
		}
	}

}
