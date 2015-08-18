package SRM665;

import static org.junit.Assert.*;

import org.junit.Test;

public class LuckySumTest {

	@Test
	public void testConstruct() {
		LuckySum app = new LuckySum();
		assertEquals(app.construct("?"), 8);
	}

	//@Test
	public void testConstruct1() {
		LuckySum app = new LuckySum();
		assertEquals(app.construct("?1"), 11);
	}

	//@Test
	public void testConstruct2() {
		LuckySum app = new LuckySum();
		assertEquals(app.construct("4?8"), 448);
	}

	//@Test
	public void testConstruct3() {
		LuckySum app = new LuckySum();
		assertEquals(app.construct("2??"), -1);
	}

	//@Test
	public void testConstruct4() {
		LuckySum app = new LuckySum();
		assertEquals(app.construct("??????????????"), 11888888888888L);
	}
}
