package com.topcoder.SRM598;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoxAndFencingEasyTest {

	@Test
	public void test() {
		FoxAndFencingEasy app = new FoxAndFencingEasy();
		assertEquals("Ciel",app.WhoCanWin(1, 58, 1));
		assertEquals("Draw",app.WhoCanWin(100,100,100000000));
		assertEquals("Draw",app.WhoCanWin(100,150,100000000));
		assertEquals("Liss",app.WhoCanWin(100,250,100000000));
	}

}
