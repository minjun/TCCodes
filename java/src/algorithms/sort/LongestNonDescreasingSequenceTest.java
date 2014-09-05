package algorithms.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestNonDescreasingSequenceTest {

	@Test
	public void test() {
		LongestNonDescreasingSequence app = new LongestNonDescreasingSequence();
		assertEquals(app.maxLongestNonDescreasingSequence(new int[] { 5, 3, 4, 8, 6, 7 }), 4);
	}
}
