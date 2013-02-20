package com.topcoder.srm565;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonstersValleyTest {
	//@Test
	public void test0() {
		MonstersValley v = new MonstersValley();
		int[] d = {8, 5, 10};
		int[] p = {1, 1, 2};
		int ap = 2;
		assertEquals(v.minimumPrice(d,p),ap);
	}
	//@Test
	public void test1() {
		MonstersValley v = new MonstersValley();
		int[] d = {1, 2, 4, 1000000000};
		int[] p = {1, 1, 1, 2};
		int ap = 5;
		assertEquals(v.minimumPrice(d,p),ap);
	}
	@Test
	public void test2() {
		MonstersValley v = new MonstersValley();
		int[] d = {200, 107, 105, 206, 307, 400};
		int[] p = {1, 2, 1, 1, 1, 2};
		int ap = 2;
		assertEquals(v.minimumPrice(d,p),ap);
	}
	//@Test
	public void test3() {
		MonstersValley v = new MonstersValley();
		int[] d = {5216, 12512, 613, 1256, 66, 17202, 30000, 23512, 2125, 33333};
		int[] p = {2, 2, 1, 1, 1, 1, 2, 1, 2, 1};
		int ap = 5;
		assertEquals(v.minimumPrice(d,p),ap);
	}
}
