package algorithms.backtrace;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueensTest {

	@Test
	public void test() {
		Queens q = new Queens();
		q.PlaceQueens(0, 8);
	}

}
