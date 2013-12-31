package algorithms.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class DijkstraTest {

	@Test
	public void test() {
		Dijkstra app = new Dijkstra();
		assertArrayEquals(
				new int[] { 0, 5, 3, 6, 7, 9 },
				app.shortestPath(new int[][] { 
						{  0,  6,  3, -1, -1, -1 },
						{  6,  0,  2,  5, -1, -1 }, 
						{  3,  2,  0,  3,  4, -1 },
						{ -1,  5,  3,  0,  2,  3 }, 
						{ -1, -1,  4,  2,  0,  5 },
						{ -1, -1, -1,  3,  5,  0 } }, 0));
	};
}
