package SRM598.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinPackingEasyTest {

	@Test
	public void test() {
		BinPackingEasy bp = new BinPackingEasy();
		assertEquals(bp.minBins(new int[]{150, 150, 150, 150, 150}),3);
		assertEquals(bp.minBins(new int[]{130, 140, 150, 160}),2);
		assertEquals(bp.minBins(new int[]{101, 101, 101, 101, 101, 101, 101, 101, 101}),5);
		assertEquals(bp.minBins(new int[]{101, 200, 101, 101, 101, 101, 200, 101, 200}),6);
		assertEquals(bp.minBins(new int[]{123, 145, 167, 213, 245, 267, 289, 132, 154, 176, 198}),8);
	}
}
