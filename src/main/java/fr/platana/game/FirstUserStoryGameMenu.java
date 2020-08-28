package fr.platana.game;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import fr.platana.impl.FirstUserStory;

/**
 * 
 * @author SAFI
 *
 */
public class FirstUserStoryGameMenu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int playerNumber;

		String playerOne = "";
		String playerTwo = "";

		while (StringUtils.isBlank(playerOne)) {
			System.out.println("Player One Name:");
			playerOne = sc.nextLine();
		}
		while (StringUtils.isBlank(playerTwo)) {
			System.out.println("Player Two Name:");
			playerTwo = sc.nextLine();
		}

		FirstUserStory game = new FirstUserStory(playerOne, playerTwo);
		System.out.println(game.getScore());
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
