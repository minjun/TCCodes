package SRM664;

import static org.junit.Assert.*;

import org.junit.Test;

public class BearPlaysTest {

	@Test
	public void testPileSize() {
		BearPlays app  = new BearPlays();
		assertEquals(app.pileSize(4, 7, 2),5);
	}
	@Test
	public void testPileSize1() {
		BearPlays app  = new BearPlays();
		assertEquals(app.pileSize(5, 5, 3),0);
	}
	@Test
	public void testPileSize2() {
		BearPlays app  = new BearPlays();
		assertEquals(app.pileSize(2, 6, 1),4);
	}
	@Test
	public void testPileSize3() {
		BearPlays app  = new BearPlays();
		assertEquals(app.pileSize(2, 8, 2000000000),2);
	}
	@Test
	public void testPileSize4() {
		BearPlays app  = new BearPlays();
		assertEquals(app.pileSize(900000000, 350000000, 3),300000000);
	}


}
