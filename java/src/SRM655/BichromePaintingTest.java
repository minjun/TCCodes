package SRM655;

import static org.junit.Assert.*;

import org.junit.Test;

public class BichromePaintingTest {

	@Test
	public void test() {
		BichromePainting app = new BichromePainting();
		String[] arr = { "BBBW", "BWWW", "BWWW", "WWWW" };
		assertEquals(app.isThatPossible(arr, 3), "Possible");
	}

	@Test
	public void test1() {
		BichromePainting app = new BichromePainting();
		String[] arr = { "BW", "WB" };
		assertEquals(app.isThatPossible(arr, 2), "Impossible");
	}

	@Test
	public void test2() {
		BichromePainting app = new BichromePainting();
		String[] arr = { "BWBWBB", "WBWBBB", "BWBWBB", "WBWBBB", "BBBBBB", "BBBBBB" };
		assertEquals(app.isThatPossible(arr, 2), "Possible");
	}

	@Test
	public void test3() {
		BichromePainting app = new BichromePainting();
		String[] arr = { "BWBWBB", "WBWBWB", "BWBWBB", "WBWBWB", "BWBWBB", "BBBBBB" };
		assertEquals(app.isThatPossible(arr, 2), "Impossible");
	}

	@Test
	public void test4() {
		BichromePainting app = new BichromePainting();
		String[] arr = { "BWBWBB", "WBWBWB", "BWBWBB", "WBWBWB", "BWBWBB", "BBBBBB" };
		assertEquals(app.isThatPossible(arr, 1), "Possible");
	}

	@Test
	public void test5() {
		BichromePainting app = new BichromePainting();
		String[] arr = { "BB", "BB" };
		assertEquals(app.isThatPossible(arr, 2), "Possible");
	}

}
