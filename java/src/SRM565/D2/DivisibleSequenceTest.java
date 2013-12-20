package SRM565.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivisibleSequenceTest {

	@Test
	public void testCount() {
		DivisibleSequence ds = new DivisibleSequence();
		assertEquals(ds.count(5, 3),3);
		assertEquals(ds.count(6, 3),9);
		assertEquals(ds.count(10, 2),4);
		assertEquals(ds.count(1, 1000),1);
		assertEquals(ds.count(30, 4),64);
		assertEquals(ds.count(25883,100000),991000009);
	}

}
