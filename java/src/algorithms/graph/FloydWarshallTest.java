package algorithms.graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class FloydWarshallTest {

	@Test
	public void test() {
		FloydWarshall app = new FloydWarshall();
		assertArrayEquals(new int[] { 0, 5, 3, 6, 7, 9 },
				app.shortestPath(new int[][] { 
						{  0,  6,  3, -1, -1, -1 },
						{  6,  0,  2,  5, -1, -1 }, 
						{  3,  2,  0,  3,  4, -1 },
						{ -1,  5,  3,  0,  2,  3 }, 
						{ -1, -1,  4,  2,  0,  5 },
						{ -1, -1, -1,  3,  5,  0 } })[0]);
	}

}
