package SRM146.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class BridgeCrossingTest {

	@Test
	public void test() {
		BridgeCrossing app = new BridgeCrossing();
		//assertEquals(app.minTime(new int[] { 1, 2,10}), 13);
		assertEquals(app.minTime(new int[] { 1, 2, 5, 10 }), 17);
	}

	@Test
	public void test1() {
		BridgeCrossing app = new BridgeCrossing();
		assertEquals(app.minTime(new int[] { 1, 2, 3, 4, 5 }), 16);
	}

	@Test
	public void test2() {
		BridgeCrossing app = new BridgeCrossing();
		assertEquals(app.minTime(new int[] { 100 }), 100);
	}

	@Test
	public void test3() {
		BridgeCrossing app = new BridgeCrossing();
		assertEquals(app.minTime(new int[] { 1, 2, 3, 50, 99, 100 }), 162);
	}
}
