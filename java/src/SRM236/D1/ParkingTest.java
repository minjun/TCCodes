package SRM236.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParkingTest {

	@Test
	public void test() {
		Parking app = new Parking();
		assertEquals(6,
				app.minTime(new String[] { "C.....P", "C.....P", "C.....P" }));
	}

	@Test
	public void test1() {
		Parking app = new Parking();
		assertEquals(
				16,
				app.minTime(new String[] { "C.X.....", "..X..X..", "..X..X..",
						".....X.P" }));
	}

	@Test
	public void test2() {
		Parking app = new Parking();
		assertEquals(
				5,
				app.minTime(new String[] { "XXXXXXXXXXX", "X......XPPX",
						"XC...P.XPPX", "X......X..X", "X....C....X",
						"XXXXXXXXXXX" }));
	}

	@Test
	public void test3() {
		Parking app = new Parking();
		assertEquals(4,
				app.minTime(new String[] { ".C.", "...", "C.C", "X.X", "PPP" }));
	}

	@Test
	public void test4() {
		Parking app = new Parking();
		assertEquals(-1,
				app.minTime(new String[] { "CCCCC", ".....", "PXPXP" }));
	}

	@Test
	public void test5() {
		Parking app = new Parking();
		assertEquals(-1,
				app.minTime(new String[] { "..X..", "C.X.P", "..X.." }));
	}

}
