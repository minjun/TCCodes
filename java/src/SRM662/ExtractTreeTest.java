package SRM662;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExtractTreeTest {

	@Test
	public void testGetTree() {
		ExtractTree app = new ExtractTree();
		assertEquals(app.getTree(4, 100, 9), 9);
	}

	@Test
	public void testGetTree1() {
		ExtractTree app = new ExtractTree();
		assertEquals(app.getTree(4, 100, 10), 10);
	}

	@Test
	public void testGetTree2() {
		ExtractTree app = new ExtractTree();
		assertEquals(app.getTree(4, 100, 0), -1);
	}

	@Test
	public void testGetTree3() {
		ExtractTree app = new ExtractTree();
		assertEquals(app.getTree(6, 2, 0), 28);
	}

	@Test
	public void testGetTree4() {
		ExtractTree app = new ExtractTree();
		assertEquals(app.getTree(6, 2, 1), 25);
	}

	@Test
	public void testGetTree5() {
		ExtractTree app = new ExtractTree();
		assertEquals(app.getTree(25, 100, 0), 700);
	}

	@Test
	public void testGetTree6() {
		ExtractTree app = new ExtractTree();
		assertEquals(app.getTree(50, 97, 89), 2708);
	}
}
