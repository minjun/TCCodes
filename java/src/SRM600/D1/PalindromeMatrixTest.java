package SRM600.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeMatrixTest {

	@Test
	public void test() {
		PalindromeMatrix app = new PalindromeMatrix();
		assertEquals(1, app.minChange(new String[] { "0000", "1000", "1100",
				"1110" }, 2, 2));
	}

	@Test
	public void test1() {
		PalindromeMatrix app = new PalindromeMatrix();
		assertEquals(3, app.minChange(new String[] { "0000", "1000", "1100",
				"1110" }, 3, 2));
	}

	@Test
	public void test2() {
		PalindromeMatrix app = new PalindromeMatrix();
		assertEquals(1, app.minChange(new String[] { "01", "10" }, 1, 1));
	}

	@Test
	public void test3() {
		PalindromeMatrix app = new PalindromeMatrix();
		assertEquals(0, app.minChange(new String[] { "1110", "0001" }, 0, 0));
	}

	@Test
	public void test4() {
		PalindromeMatrix app = new PalindromeMatrix();
		assertEquals(
				8,
				app.minChange(new String[] { "01010101", "01010101",
						"01010101", "01010101", "01010101", "01010101",
						"01010101", "01010101" }, 2, 3));
	}

	@Test
	public void test5() {
		PalindromeMatrix app = new PalindromeMatrix();
		assertEquals(
				14,
				app.minChange(new String[] { "000000000000", "011101110111",
						"010001010101", "010001010101", "011101010101",
						"010101010101", "010101010101", "011101110111",
						"000000000000", "000000000000" }, 5, 9));
	}

	@Test
	public void test6() {
		PalindromeMatrix app = new PalindromeMatrix();
		assertEquals(
				31,
				app.minChange(new String[] { "11111101001110",
						"11000111111111", "00010101111001", "10110000111111",
						"10000011010010", "10001101101101", "00101010000001",
						"10111010100100", "11010011110111", "11100010110110",
						"00100101010100", "01001011001000", "01010001111010",
						"10100000010011" }, 6, 8));
	}
}
