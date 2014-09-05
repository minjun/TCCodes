package SRM148.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MNSTest {

	@Test
	public void test() {
		MNS app = new MNS();
		assertEquals(app.combos(new int[] { 1, 2, 3, 3, 2, 1, 2, 2, 2 }), 18);
	}

	@Test
	public void test1() {
		MNS app = new MNS();
		assertEquals(app.combos(new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4 }), 1);
	}

	@Test
	public void test2() {
		MNS app = new MNS();
		assertEquals(app.combos(new int[] { 1, 5, 1, 2, 5, 6, 2, 3, 2 }), 36);
	}

	@Test
	public void test3() {
		MNS app = new MNS();
		assertEquals(app.combos(new int[] { 1, 2, 6, 6, 6, 4, 2, 6, 4 }), 0);
	}

}
