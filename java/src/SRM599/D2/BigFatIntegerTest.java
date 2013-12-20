package SRM599.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class BigFatIntegerTest {

	@Test
	public void test() {
		BigFatInteger app = new BigFatInteger();
		assertEquals(app.minOperations(6, 1), 2);
	}

	@Test
	public void test1() {
		BigFatInteger app = new BigFatInteger();
		assertEquals(app.minOperations(162, 1), 4);
	}

	@Test
	public void test2() {
		BigFatInteger app = new BigFatInteger();
		assertEquals(app.minOperations(999983, 9), 5);
	}

	@Test
	public void test3() {
		BigFatInteger app = new BigFatInteger();
		assertEquals(app.minOperations(360, 8), 8);
	}

}
