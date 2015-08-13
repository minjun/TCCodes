package SRM661;

import static org.junit.Assert.*;

import org.junit.Test;

public class BridgeBuildingDiv2Test {

	@Test
	public void testMinDiameter() {
		BridgeBuildingDiv2 app = new BridgeBuildingDiv2();
		assertEquals(
				app.minDiameter(new int[] { 2, 1, 1, 1, 2 }, new int[] { 1, 9,
						1, 9, 1 }, 4), 6);
	}

	@Test
	public void testMinDiameter1() {
		BridgeBuildingDiv2 app = new BridgeBuildingDiv2();
		assertEquals(
				app.minDiameter(new int[] { 50, 10, 15, 31, 20, 23, 7, 48, 5,
						50 }, new int[] { 2, 5, 1, 8, 3, 2, 16, 11, 9, 1 }, 3),
				124);
	}

	@Test
	public void testMinDiameter2() {
		BridgeBuildingDiv2 app = new BridgeBuildingDiv2();
		assertEquals(app.minDiameter(
				new int[] { 2, 4, 10, 2, 2, 22, 30, 7, 28 }, new int[] { 5, 26,
						1, 2, 6, 2, 16, 3, 15 }, 5), 54);
	}
}
