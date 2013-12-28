package SRM231.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MixtureTest {

	@Test
	public void test() {
		Mixture app = new Mixture();
		assertEquals(
				app.mix(new int[] { 1, 2, 3 }, new String[] { "1 0 0 1",
						"0 1 0 2", "0 0 1 3" }), 14.0, 0.1);
	}

	@Test
	public void test1() {
		Mixture app = new Mixture();
		assertEquals(
				app.mix(new int[] { 1, 2, 3 }, new String[] { "1 0 0 1",
						"0 1 0 2", "0 0 1 3", "2 2 2 4" }), 10.0, 0.1);
	}

	@Test
	public void test2() {
		Mixture app = new Mixture();
		assertEquals(app.mix(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				new String[] { "10 9 9 9 9 9 9 9 9 10 0",
						"0 10 9 9 9 9 9 9 9 0 0", "0 0 10 9 9 9 9 9 9 0 0",
						"0 0 0 10 9 9 9 9 9 0 0", "0 0 0 0 10 9 9 9 9 0 0",
						"0 0 0 0 0 10 9 9 9 0 0", "0 0 0 0 0 0 10 9 9 0 0",
						"0 0 0 0 0 0 0 10 9 0 0", "0 0 0 0 0 0 0 0 10 1 0",
						"0 0 0 0 0 0 0 0 0 10 1" }), -1.0, 0.1);
	}

	@Test
	public void test3() {
		Mixture app = new Mixture();
		assertEquals(
				app.mix(new int[] { 7, 7, 8, 10 }, new String[] { "9 0 4 8 4",
						"8 8 9 0 1", "0 10 3 10 7", "10 2 2 0 1", "8 9 10 2 6",
						"1 2 5 8 8", "4 7 8 9 6", "2 10 6 8 10", "6 3 9 7 1",
						"3 6 9 9 1" }), 3.5855425945563804, 0.1);
	}

}
