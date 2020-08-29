package fr.platana.impl;

/**
 * 
 * @author SAFI
 *
 */
public class SecondUserStory {
	private String playerOneName;
	private String playerTwoName;

	private int playerOneGameScore = 0;
	private int playerTwoGameScore = 0;

	private boolean gameOver = false;

	// for the case of 40-40 score or one of the players has the advantage
	private boolean deuceMode = false;

	public SecondUserStory(String playerOneName, String playerTwoName) {
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
	}

	/**
	 * This method will be called when the first player scores
	 */
	public void playerOneScores() {
		if (deuceMode) {
			/*
			 * if deuce mode started, we check if the 1st player already has the advantage
			 * so he will win immediately and the game will ends
			 */
			if (playerOneGameScore == 4) {
				System.out.println(playerOneName + " Win the Game!");
				setGameOver(true);

			} else {
				// player 2 already has the advantage
				if (playerTwoGameScore == 4) {
					/*
					 * set a new value to him to establish Deuce again (40-40) and print the new
					 * score
					 */
					playerTwoGameScore = 3;
					System.out.println(getScore());
				} else {
					/* player one will get the advantage and print the new score */
					playerOneGameScore = 4;
					System.out.println(getScore());
				}
			}

		} else {
			/* we are not in the Deuce mode so the 1st player scores and win the game */
			if (playerOneGameScore == 3) {
				System.out.println(playerOneName + " Win the Game!");
				setGameOver(true);
			} else {
				/* the 1st player scores a new point */
				playerOneGameScore++;
				/* for the case of 40-40 score, deuce mode will be activated */
				if (playerOneGameScore == 3 && playerTwoGameScore == 3)
					deuceMode = true;
				System.out.println(getScore());
			}
		}
	}

	/**
	 * This method will be called when the second player scores
	 */
	public void playerTwoScores() {
		if (deuceMode) {
			/*
			 * if deuce mode started, we check if the 2nd player already has the advantage
			 * so he will win immediately and the game will ends
			 */
			if (playerTwoGameScore == 4) {
				System.out.println(playerTwoGameScore + " Win the Game!");
				setGameOver(true);
			} else {
				// player 1 already has the advantage
				if (playerOneGameScore == 4) {
					/*
					 * set a new value to him to establish Deuce again (40-40) and print the new
					 * score
					 */
					playerOneGameScore = 3;
					System.out.println(getScore());
				} else {
					/* player 2 will get the advantage and print the new score */
					playerTwoGameScore = 4;
					System.out.println(getScore());
				}
			}
		} else {
			/* we are not in the Deuce mode so the 2nd player scores and win the game */
			if (playerTwoGameScore == 3) {
				System.out.println(playerTwoName + " Win the Game!");
				setGameOver(true);
			} else {
				/* the 2nd player scores a new point */
				playerTwoGameScore++;
				/* for the case of 40-40 score, deuce mode will be activated */
				if (playerTwoGameScore == 3 && playerOneGameScore == 3)
					deuceMode = true;
				System.out.println(getScore());
			}
		}
	}

	/**
	 * Return the actual score with the help of the method convertScore()
	 */
	public String getScore() {
		if (playerOneGameScore == 3 && playerOneGameScore == playerTwoGameScore) {
			return "Deuce";
		}
		return playerOneName + " : " + convertScore(playerOneGameScore) + " || " + convertScore(playerTwoGameScore)
				+ " : " + playerTwoName;
	}

	/**
	 * This method will convert the point passed as an argument to the Tennis score
	 * in real life
	 * 
	 * @param point (points are from 0 to 4)
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
		case 4:
			return "ADV";
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
	 * @return true if Deuce mode is started (40-40 or ADV for one of the players)
	 *         false otherwise
	 */
	public boolean isDeuceMode() {
		return deuceMode;
	}

	/**
	 * Set the Deuce mode
	 * 
	 * @param deuceMode
	 */
	public void setDeuceMode(boolean deuceMode) {
		this.deuceMode = deuceMode;
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

}
