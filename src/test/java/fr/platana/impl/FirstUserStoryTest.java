package fr.platana.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author SAFI
 *
 */
class FirstUserStoryTest {

	FirstUserStory game;

	@BeforeEach
	public void init() {
		String firstPlayerName = "Amine";
		String secondPlayerName = "Platana";
		this.game = new FirstUserStory(firstPlayerName, secondPlayerName);
	}

	@Test
	void convertScore() {
		String expected1 = "0";
		String actual1 = game.convertScore(0);
		assertEquals(expected1, actual1, "Score should be 0");

		String expected2 = "15";
		String actual2 = game.convertScore(1);
		assertEquals(expected2, actual2, "Score should be 15");

		String expected3 = "30";
		String actual3 = game.convertScore(2);
		assertEquals(expected3, actual3, "Score should be 30");

		String expected4 = "40";
		String actual4 = game.convertScore(3);
		assertEquals(expected4, actual4, "Score should be 40");
	}

	@Test
	void expectExceptionAfterWrongPoint() {
		int point = 4;
		assertThrows(IllegalArgumentException.class, () -> game.convertScore(point));
	}

	
}
