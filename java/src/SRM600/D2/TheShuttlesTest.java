package SRM600.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TheShuttlesTest {

	@Test
	public void test() {
		TheShuttles app = new TheShuttles();
		assertEquals(app.getLeastCost(new int[] { 9 }, 30, 5), 75);
	}

	@Test
	public void test1() {
		TheShuttles app = new TheShuttles();
		assertEquals(app.getLeastCost(new int[] { 9, 4 }, 30, 5), 150);
	}

	@Test
	public void test2() {
		TheShuttles app = new TheShuttles();
		assertEquals(app.getLeastCost(new int[] { 9, 4 }, 10, 5), 105);
	}

	@Test
	public void test3() {
		TheShuttles app = new TheShuttles();
		assertEquals(app.getLeastCost(new int[] { 51, 1, 77, 14, 17, 10, 80 },
				32, 40), 12096);
	}
}