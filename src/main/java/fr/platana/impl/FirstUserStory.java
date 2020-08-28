package fr.platana.impl;

/**
 * 
 * @author SAFI
 *
 */
public class FirstUserStory {
	/* players names */
	private String playerOneName;
	private String playerTwoName;
	/* players scores */
	private int playerOneGameScore = 0;
	private int playerTwoGameScore = 0;
	/* game status */
	private boolean gameOver = false;

	public FirstUserStory(String playerOneName, String playerTwoName) {
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
	}

	/**
	 * This method will be called when the first player scores
	 */
	public void playerOneScores() {

		if (playerOneGameScore >= 3) {
			/* first player win and set the game to over */
			System.out.println(playerOneName + " Win the Game!");
			setGameOver(true);
		} else {
			/* increment the points of the first player and print the new score */
			playerOneGameScore++;
			System.out.println(getScore());
		}
	}

	/**
	 * This method will be called when the second player scores
	 */
	public void playerTwoScores() {
		if (playerTwoGameScore >= 3) {
			/* second player win and set the game to over */
			System.out.println(playerTwoName + " Win the Game!");
			setGameOver(true);
		} else {
			/* increment the points of the second player and print the new score */
			playerTwoGameScore++;
			System.out.println(getScore());
		}
	}

	/**
	 * Return the actual score with the help of the method convertScore()
	 */
	public String getScore() {
		return playerOneName + " : " + convertScore(playerOneGameScore) + " || " + convertScore(playerTwoGameScore)
				+ " : " + playerTwoName;
	}

	/**
	 * This method will convert the point passed as an argument to the Tennis score
	 * in real life
	 * 
	 * @param point (points are from 0 to 3)
	 * @return the converted point accordingly
	 */
	protected String convertScore(int point) {
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

	/**
	 * @return true or false based on the game status
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * Set a new status to the game
	 * 
	 * @param gameOver a boolean value
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	/**
	 * 
	 * @return player one score in terms of points
	 */
	public int getPlayerOneGameScore() {
		return playerOneGameScore;
	}

	/**
	 * Set the player one score
	 * 
	 * @param playerOneGameScore
	 */
	public void setPlayerOneGameScore(int playerOneGameScore) {
		this.playerOneGameScore = playerOneGameScore;
	}

	/**
	 * 
	 * @return player two score in terms of points
	 */
	public int getPlayerTwoGameScore() {
		return playerTwoGameScore;
	}

	/**
	 * Set the player two score
	 * 
	 * @param playerTwoGameScore
	 */
	public void setPlayerTwoGameScore(int playerTwoGameScore) {
		this.playerTwoGameScore = playerTwoGameScore;
	}

	/**
	 * 
	 * @return the first player name
	 */
	public String getPlayerOneName() {
		return playerOneName;
	}

	/**
	 * Set the first player name
	 * 
	 * @param playerOneName
	 */
	public void setPlayerOneName(String playerOneName) {
		this.playerOneName = playerOneName;
	}

	/**
	 * 
	 * @return the second player name
	 */
	public String getPlayerTwoName() {
		return playerTwoName;
	}

	/**
	 * Set the first player name
	 * 
	 * @param playerOneName
	 */
	public void setPlayerTwoName(String playerTwoName) {
		this.playerTwoName = playerTwoName;
	}

}
