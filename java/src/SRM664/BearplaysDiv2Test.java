package SRM664;

import static org.junit.Assert.*;

import org.junit.Test;

public class BearplaysDiv2Test {

	@Test
	public void testEqualPiles0() {
		BearplaysDiv2 app = new BearplaysDiv2();
		assertEquals(app.equalPiles(10, 15, 35), "possible");
	}

	@Test
	public void testEqualPiles1() {
		BearplaysDiv2 app = new BearplaysDiv2();
		assertEquals(app.equalPiles(1, 1, 2), "impossible");
	}

	@Test
	public void testEqualPiles2() {
		BearplaysDiv2 app = new BearplaysDiv2();
		assertEquals(app.equalPiles(4, 6, 8), "impossible");
	}

	@Test
	public void testEqualPiles3() {
		BearplaysDiv2 app = new BearplaysDiv2();
		assertEquals(app.equalPiles(18, 18, 18), "possible");
	}

	@Test
	public void testEqualPiles4() {
		BearplaysDiv2 app = new BearplaysDiv2();
		assertEquals(app.equalPiles(225, 500, 475), "possible");
	}

}
