package jhunovis.experiments.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test the computation of the game score of games that have not yet finished,
 * i.e. have rolls open.
 * 
 * @author jhunovis
 * 
 */
public class IncompleteGameScoringTest {

	@Test
	public void allStrikes() {
		BowlingGame game = BowlingGame.fromRolls(new int[] { 10, 10, 10 });
		assertEquals(60, game.getScore());
	}

	@Test
	public void interruptedStrikeStreak() {
		BowlingGame game = BowlingGame.fromRolls(new int[] { 10, 10, 10, 5 });
		assertEquals(75, game.getScore());
	}

	@Test
	public void neitherStrikeNorSpare() {
		BowlingGame game = BowlingGame.fromRolls(new int[] { 1, 2, 3, 4 });
		assertEquals(10, game.getScore());

		game = BowlingGame.fromRolls(new int[] { 3, 7, 2, 8, 1 });
		assertEquals(24, game.getScore());
	}

	@Test
	public void scoreTwoSpares() {
		BowlingGame game = BowlingGame.fromRolls(new int[] { 3, 7, 2, 8, 1 });
		assertEquals(24, game.getScore());
	}

}
