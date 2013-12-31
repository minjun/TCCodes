package algorithms.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxFlowTest {

	@Test
	public void test() {
		MaxFlow app = new MaxFlow();
		assertEquals(3,app.maxFlow(new int[][] {
		{ 0,  3,  1, -1, -1, -1, -1},
		{-1,  0, -1,  3, -1, -1, -1},
		{-1, -1,  0,  5,  4, -1, -1},
		{-1, -1, -1,  0, -1, -1,  2},
		{-1, -1, -1, -1,  0,  2, -1},
		{-1, -1, -1, -1, -1,  0,  3},
		{-1, -1, -1, -1, -1, -1,  0},
		}, 0, 6));
	}

}
