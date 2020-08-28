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

	// for the case of equality or one of the players has an advantage
	private boolean deuceMode = false;

	public SecondUserStory(String playerOneName, String playerTwoName) {
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
	}

	public void playerOneScores() {
		if (deuceMode) {
			if (playerOneGameScore == 4) {
				System.out.println(playerOneName + " Win the Game!");
				setGameOver(true);
			} else {
				// already has the advantage
				if (playerTwoGameScore == 4) {
					// set the value to establish deuce again
					playerTwoGameScore = 3;
					System.out.println(getScore());
				} else {
					playerOneGameScore = 4;
					System.out.println(getScore());
				}
			}

		} else {
			if (playerOneGameScore == 3) {
				System.out.println(playerOneName + " Win the Game!");
				setGameOver(true);
			} else {
				playerOneGameScore++;
				if (playerOneGameScore == 3 && playerTwoGameScore == 3)
					deuceMode = true;
				System.out.println(getScore());
			}
		}
	}

	public void playerTwoScores() {
		if (deuceMode) {
			if (playerTwoGameScore == 4) {
				System.out.println(playerTwoGameScore + " Win the Game!");
				setGameOver(true);
			} else {
				// already has the advantage
				if (playerOneGameScore == 4) {
					// set the value to establish deuce again
					playerOneGameScore = 3;
					System.out.println(getScore());
				} else {
					playerTwoGameScore = 4;
					System.out.println(getScore());
				}
			}
		} else {
			if (playerTwoGameScore == 3) {
				System.out.println(playerTwoName + " Win the Game!");
				setGameOver(true);
			} else {
				playerTwoGameScore++;
				if (playerTwoGameScore == 3 && playerOneGameScore == 3)
					deuceMode = true;
				System.out.println(getScore());
			}
		}
	}

	public String getScore() {
		if (playerOneGameScore == 3 && playerOneGameScore == playerTwoGameScore) {
			return "Deuce";
		}
		return playerOneName + " : " + convertScore(playerOneGameScore) + " || " + convertScore(playerTwoGameScore)
				+ " : " + playerTwoName;
	}

	public String convertScore(int point) {
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

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean isDeuceMode() {
		return deuceMode;
	}

	public void setDeuceMode(boolean deuceMode) {
		this.deuceMode = deuceMode;
	}

	public String getPlayerOneName() {
		return playerOneName;
	}

	public void setPlayerOneName(String playerOneName) {
		this.playerOneName = playerOneName;
	}

	public String getPlayerTwoName() {
		return playerTwoName;
	}

	public void setPlayerTwoName(String playerTwoName) {
		this.playerTwoName = playerTwoName;
	}

	public int getPlayerOneGameScore() {
		return playerOneGameScore;
	}

	public void setPlayerOneGameScore(int playerOneGameScore) {
		this.playerOneGameScore = playerOneGameScore;
	}

	public int getPlayerTwoGameScore() {
		return playerTwoGameScore;
	}

	public void setPlayerTwoGameScore(int playerTwoGameScore) {
		this.playerTwoGameScore = playerTwoGameScore;
	}

}
