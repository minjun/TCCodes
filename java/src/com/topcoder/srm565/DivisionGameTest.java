package com.topcoder.srm565;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivisionGameTest {

	@Test
	public void testCountWinningIntervals() {
		DivisionGame divGame = new DivisionGame();
		assertEquals(divGame.countWinningIntervals(9, 10),2);
		assertEquals(divGame.countWinningIntervals(2, 5), 9);
		assertEquals(divGame.countWinningIntervals(2, 6), 13);
		assertEquals(divGame.countWinningIntervals(2, 100), 4345);
		assertEquals(divGame.countWinningIntervals(12566125, 12567777), 1313432);
	}
	@Test
	public void testComputeNimber() {
		DivisionGame divGame = new DivisionGame();
		assertEquals(divGame.computeNimber(2),1);
		assertEquals(divGame.computeNimber(4),2);
		assertEquals(divGame.computeNimber(12),3);
	}
}
