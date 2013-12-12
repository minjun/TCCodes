package com.topcoder.SRM598;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinPackingTest {

	@Test
	public void test() {
		BinPacking bp = new BinPacking();
		assertEquals(3, bp.minBins(new int[]{150, 150, 150, 150, 150}));
		assertEquals(2, bp.minBins(new int[]{130, 140, 150, 160}));
		assertEquals(3, bp.minBins(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100}));
		assertEquals(4, bp.minBins(new int[]{100, 200, 100, 100, 100, 100, 200, 100, 200}));
		assertEquals(8, bp.minBins(new int[]{157, 142, 167, 133, 135, 157, 143, 160, 141, 123, 162, 159, 165, 137, 138, 152}));
	}

}
