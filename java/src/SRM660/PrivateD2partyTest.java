package SRM660;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrivateD2partyTest {

	@Test
	public void test() {
		PrivateD2party app = new PrivateD2party();
		int[] a = { 0, 1 };
		assertEquals(app.getsz(a), 2);
	}

	@Test
	public void test1() {
		PrivateD2party app = new PrivateD2party();
		int[] a = { 1, 0 };
		assertEquals(app.getsz(a), 1);
	}

	@Test
	public void test2() {
		PrivateD2party app = new PrivateD2party();
		int[] a = { 1, 0, 3, 2 };
		assertEquals(app.getsz(a), 2);
	}

	@Test
	public void test3() {
		PrivateD2party app = new PrivateD2party();
		int[] a = { 5, 2, 2, 4, 5, 0 };
		assertEquals(app.getsz(a), 5);
	}

	@Test
	public void test4() {
		PrivateD2party app = new PrivateD2party();
		int[] a = { 3, 2, 1, 0, 5, 4 };
		assertEquals(app.getsz(a), 3);
	}
}
