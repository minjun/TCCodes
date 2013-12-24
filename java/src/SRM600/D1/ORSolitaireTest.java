package SRM600.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ORSolitaireTest {

	@Test
	public void test() {
		ORSolitaire app = new ORSolitaire();
		assertEquals(app.getMinimum(new int[] { 1, 2, 4 }, 7), 1);
	}

	@Test
	public void test1() {
		ORSolitaire app = new ORSolitaire();
		assertEquals(app.getMinimum(new int[] { 1, 2, 4, 7, 8 }, 7), 2);
	}

	@Test
	public void test2() {
		ORSolitaire app = new ORSolitaire();
		assertEquals(
				app.getMinimum(new int[] { 12571295, 2174218, 2015120 }, 1), 0);
	}

	@Test
	public void test3() {
		ORSolitaire app = new ORSolitaire();
		assertEquals(app.getMinimum(new int[] { 5, 2, 4, 52, 62, 9, 8, 3, 1,
				11, 6 }, 11), 3);
	}

	@Test
	public void test4() {
		ORSolitaire app = new ORSolitaire();
		assertEquals(
				app.getMinimum(new int[] { 503, 505, 152, 435, 491, 512, 1023,
						355, 510, 500, 502, 255, 63, 508, 509, 511, 60, 250,
						254, 346 }, 510), 5);
	}

}
