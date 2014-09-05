package TCCC03SEMI3;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZigZagTest {

	@Test
	public void test() {
		ZigZag app = new ZigZag();
		assertEquals(app.longestZigZag(new int[]{ 1, 7, 4, 9, 2, 5 }),2);
	}

}
