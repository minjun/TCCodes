package com.topcoder.SRM598;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoxAndFencingTest {

	@Test
	public void test0() {
		FoxAndFencing app = new FoxAndFencing();
		assertEquals("Ciel",app.WhoCanWin(1, 58, 1, 58, 2));
	}
	@Test
	public void test1() {
		FoxAndFencing app = new FoxAndFencing();
		assertEquals("Liss",app.WhoCanWin(2, 1, 1, 100, 50));
	}
	@Test
	public void test2() {
		FoxAndFencing app = new FoxAndFencing();
		assertEquals("Draw",app.WhoCanWin(2, 1, 1, 100, 150));
	}
	@Test
	public void test3() {
		FoxAndFencing app = new FoxAndFencing();
		assertEquals("Draw",app.WhoCanWin(100, 100, 100, 100, 100000000));
	}
	@Test
	public void test4() {
		FoxAndFencing app = new FoxAndFencing();
		assertEquals("Ciel",app.WhoCanWin(100, 1, 100, 1, 100000000));
	}
	@Test
	public void test5() {
		FoxAndFencing app = new FoxAndFencing();
		assertEquals("Draw",app.WhoCanWin(100, 1, 100, 150, 100000000));
	}
	@Test
	public void test6() {
		FoxAndFencing app = new FoxAndFencing();
		assertEquals("Ciel",app.WhoCanWin(100, 1, 100, 150, 100000000));
	}
	@Test
	public void test7() {
		FoxAndFencing app = new FoxAndFencing();
		assertEquals("Ciel",app.WhoCanWin(100, 50, 100, 1, 100000000));
	}
	@Test
	public void test8() {
		FoxAndFencing app = new FoxAndFencing();
		assertEquals("Draw",app.WhoCanWin(100, 150, 100, 1, 100000000));
	}

}
