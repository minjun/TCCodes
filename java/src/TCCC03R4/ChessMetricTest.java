package TCCC03R4;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessMetricTest {

	@Test
	public void test() {
		assertEquals(new ChessMetric().howMany(3, new int[] { 0, 0 }, new int[] { 1, 0 }, 1), 1);
	}

	@Test
	public void test1() {
		assertEquals(new ChessMetric().howMany(3, new int[] { 0, 0 }, new int[] { 1, 2 }, 1), 1);
	}

	@Test
	public void test2() {
		assertEquals(new ChessMetric().howMany(3, new int[] { 0, 0 }, new int[] { 2, 2 }, 1), 0);
	}

	@Test
	public void test3() {
		assertEquals(new ChessMetric().howMany(3, new int[] { 0, 0 }, new int[] { 0, 0 }, 2), 5);
	}

	@Test
	public void test4() {
		assertEquals(new ChessMetric().howMany(100, new int[] { 0, 0 }, new int[] { 0, 99 }, 50), 243097320072600L);
	}

}
