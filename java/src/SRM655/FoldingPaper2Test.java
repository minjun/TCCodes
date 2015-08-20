package SRM655;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoldingPaper2Test {

	@Test
	public void testSolve() {
		FoldingPaper2 app = new FoldingPaper2();
		assertEquals(app.solve(5, 3, 12), 1);
	}

	@Test
	public void testSolve1() {
		FoldingPaper2 app = new FoldingPaper2();
		assertEquals(app.solve(2, 2, 3), -1);
	}

	@Test
	public void testSolve2() {
		FoldingPaper2 app = new FoldingPaper2();
		assertEquals(app.solve(4, 4, 1), 4);
	}

	@Test
	public void testSolve3() {
		FoldingPaper2 app = new FoldingPaper2();
		assertEquals(app.solve(127, 129, 72), 8);
	}

	@Test
	public void testSolve4() {
		FoldingPaper2 app = new FoldingPaper2();
		assertEquals(app.solve(1, 10000, 10000), 0);
	}

	@Test
	public void testSolve5() {
		FoldingPaper2 app = new FoldingPaper2();
		assertEquals(app.solve(1, 1, 2), -1);
	}
}
