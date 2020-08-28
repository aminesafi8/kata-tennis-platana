package fr.platana.impl;
/**
 * 
 * @author SAFI
 *
 */
public class FirstUserStory {
	private String playerOneName;
	private String playerTwoName;

	private int playerOneGameScore = 0;
	private int playerTwoGameScore = 0;

	private boolean gameOver = false;

	public FirstUserStory(String playerOneName, String playerTwoName) {
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
	}

	public void playerOneScores() {
		if (playerOneGameScore >= 3) {
			System.out.println(playerOneName + " Win the Game!");
			setGameOver(true);
		} else {
			playerOneGameScore++;
			System.out.println(getScore());
		}
	}

	public void playerTwoScores() {
		if (playerTwoGameScore >= 3) {
			System.out.println(playerTwoName + " Win the Game!");
			setGameOver(true);
		} else {
			playerTwoGameScore++;
			System.out.println(getScore());
		}
	}

	public String getScore() {
		return playerOneName + " : " + convertScore(playerOneGameScore) + " || " + convertScore(playerTwoGameScore)
				+ " : " + playerTwoName;
	}

	private String convertScore(int point) {
		switch (point) {
		case 0:
			return "0";
		case 1:
			return "15";
		case 2:
			return "30";
		case 3:
			return "40";
		}
		throw new IllegalArgumentException("Wrong point");
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

}
