package fr.platana.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author SAFI
 *
 */
class SecondUserStoryTest {

	SecondUserStory game;

	@BeforeEach
	public void init() {
		String firstPlayerName = "Amine";
		String secondPlayerName = "Platana";
		this.game = new SecondUserStory(firstPlayerName, secondPlayerName);
	}

	@Test
	void convertScore() {
		String expected1 = "0";
		String actual1 = game.convertScore(0);
		assertEquals(expected1, actual1, "should be 0");

		String expected2 = "15";
		String actual2 = game.convertScore(1);
		assertEquals(expected2, actual2, "should be 15");

		String expected3 = "30";
		String actual3 = game.convertScore(2);
		assertEquals(expected3, actual3, "should be 30");

		String expected4 = "40";
		String actual4 = game.convertScore(3);
		assertEquals(expected4, actual4, "should be 40");

		String expected5 = "ADV";
		String actual5 = game.convertScore(4);
		assertEquals(expected5, actual5, "should be ADV");
	}

	@Test
	void expectExceptionAfterWrongPoint() {
		int point = 8;
		assertThrows(IllegalArgumentException.class, () -> game.convertScore(point));
	}

	@Test
	void gameScoreShouldBeZero() {
		String expected = "0 || 0";
		String actual = game.getScore();
		boolean result = actual.contains(expected);
		assertTrue(result);
	}

	@Test
	void playerOneScores() {
		game.playerOneScores();
		int expected = 15;
		int actual = Integer.valueOf(game.convertScore(game.getPlayerOneGameScore()));
		assertEquals(expected, actual);
	}

	@Test
	void playerTwoScoreShouldBeFifteen() {
		game.playerTwoScores();
		int expected = 15;
		int actual = Integer.valueOf(game.convertScore(game.getPlayerTwoGameScore()));
		assertEquals(expected, actual, "Player Two Score should be 15");
	}

	@Test
	void playerOneScoreShouldBeFourty() {
		for (int i = 0; i < 4; i++) {
			game.playerOneScores();
		}
		int expected = 40;
		int actual = Integer.valueOf(game.convertScore(game.getPlayerOneGameScore()));

		assertEquals(expected, actual, "Player One Score should be 40");
	}

	@Test
	void gameOverAfterOneOfThePlayersWins() {
		// in this test, I have chosen the player two that will wins
		for (int i = 0; i < 4; i++) {
			game.playerTwoScores();
		}
		boolean actual = game.isGameOver();
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	void playersScoresShouldBeEqual() {
		for (int i = 0; i < 2; i++) {
			game.playerOneScores();
			game.playerTwoScores();
		}

		String playerOneActualScore = game.convertScore(game.getPlayerOneGameScore());
		String playerTwoActualScore = game.convertScore(game.getPlayerTwoGameScore());

		// assert for equal score
		assertEquals(playerOneActualScore, playerTwoActualScore);

	}

	@Test
	void playersScoresShouldBeDeuce() {
		for (int i = 0; i < 3; i++) {
			game.playerOneScores();
		}
		for (int i = 0; i < 3; i++) {
			game.playerTwoScores();
		}

		// assert for Deuce
		String output = game.getScore();
		String expected = "Deuce";
		assertTrue(output.contains(expected));
	}

	@Test
	void playerTwoShouldHasAdvantage() {
		for (int i = 0; i < 3; i++) {
			game.playerOneScores();
		}
		for (int i = 0; i < 3; i++) {
			game.playerTwoScores();
		}

		// player two scores to get the advantage after 40-40
		game.playerTwoScores();
		String output = game.getScore();
		String expected = "ADV" + " : " + game.getPlayerTwoName();
		assertTrue(output.contains(expected));
	}

	@Test
	void playerOneScoresAfterAdvantageOfPlayerTwo() {
		for (int i = 0; i < 3; i++) {
			game.playerOneScores();
		}
		for (int i = 0; i < 4; i++) {
			game.playerTwoScores();
		}

		// player one scores to establish the deuce again
		game.playerOneScores();
		String output = game.getScore();
		String expected = "Deuce";
		assertTrue(output.contains(expected));

	}

	@Test
	void advantageFromPlayerOneToPlayerTwo() {
		// player two will get 40
		for (int i = 0; i < 3; i++) {
			game.playerTwoScores();
		}
		// player two will get 40
		for (int i = 0; i < 3; i++) {
			game.playerOneScores();
		}
		// player one will get the advantage now
		game.playerOneScores();
		// player two get back the game to Deuce
		game.playerTwoScores();
		// player two will get the advantage now
		game.playerTwoScores();

		String output = game.getScore();
		String expected = "ADV" + " : " + game.getPlayerTwoName();
		assertTrue(output.contains(expected));
	}
}
