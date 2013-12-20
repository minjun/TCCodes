package SRM598.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TPSTest {

	@Test
	public void test1() {
		TPS app = new TPS();
		String[] data = new String[] { "NYNN", "YNYN", "NYNY", "NNYN" };
		assertEquals(1, app.minimalBeacons(data));
	}

	@Test
	public void test2() {
		TPS app = new TPS();
		String[] data = new String[] { "NYYY", "YNNN", "YNNN", "YNNN" };
		assertEquals(2, app.minimalBeacons(data));
	}

	@Test
	public void test3() {
		TPS app = new TPS();
		String[] data = new String[] { "NNYNNNNNNN", "NNNNNYNNNN",
				"YNNYNNYNNN", "NNYNYNNYNN", "NNNYNYNNYN", "NYNNYNNNNY",
				"NNYNNNNNNN", "NNNYNNNNNN", "NNNNYNNNNN", "NNNNNYNNNN" };
		assertEquals(2, app.minimalBeacons(data));
	}

	@Test
	public void test4() {
		TPS app = new TPS();
		String[] data = new String[] { "NYNYNNYNN", "YNYNYNNYN", "NYNNNYNNY",
				"YNNNNNNNN", "NYNNNNNNN", "NNYNNNNNN", "YNNNNNNNN",
				"NYNNNNNNN", "NNYNNNNNN" };
		assertEquals(3, app.minimalBeacons(data));
	}

	@Test
	public void test5() {
		TPS app = new TPS();
		String[] data = new String[] { "NYYYYYYYYY", "YNNNNNNNNN",
				"YNNNNNNNNN", "YNNNNNNNNN", "YNNNNNNNNN", "YNNNNNNNNN",
				"YNNNNNNNNN", "YNNNNNNNNN", "YNNNNNNNNN", "YNNNNNNNNN" };
		assertEquals(8, app.minimalBeacons(data));
	}

	@Test
	public void test6() {
		TPS app = new TPS();
		String[] data = new String[] { "N" };
		assertEquals(0, app.minimalBeacons(data));
	}

}
