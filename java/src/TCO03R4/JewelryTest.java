package TCO03R4;

import static org.junit.Assert.*;

import org.junit.Test;

public class JewelryTest {

/*	@Test
	public void test() {
		assertEquals(new Jewelry().howMany(new int[] { 1, 2, 5, 3, 4, 5 }), 9);
	}

	@Test
	public void test1() {
		assertEquals(
				new Jewelry().howMany(new int[] { 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
						1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
						1000, 1000, 1000 }), 18252025766940L);
	}
*/
	@Test
	public void test2() {
		assertEquals(new Jewelry().howMany(new int[] { 1, 2, 3, 4, 5 }), 4);
	}
/*
	@Test
	public void test3() {
		assertEquals(new Jewelry().howMany(new int[] { 7, 7, 8, 9, 10, 11, 1, 2, 2, 3, 4, 5, 6 }), 607);
	}

	@Test
	public void test4() {
		assertEquals(new Jewelry().howMany(new int[] { 123, 217, 661, 678, 796, 964, 54, 111, 417, 526, 917, 923 }), 0);
	}*/
}
