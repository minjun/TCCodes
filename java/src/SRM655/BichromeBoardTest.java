package SRM655;

import static org.junit.Assert.*;

import org.junit.Test;

public class BichromeBoardTest {

	@Test
	public void testStringReplace() {
		BichromeBoard app = new BichromeBoard();
		assertEquals(app.stringReplace("abc", 0, 'd'), "dbc");
		assertEquals(app.stringReplace("abc", 1, 'd'), "adc");
		assertEquals(app.stringReplace("abc", 2, 'd'), "abd");
	}

	@Test
	public void testAbleToDraw() {

		BichromeBoard app = new BichromeBoard();
		assertEquals(app.ableToDraw(new String[] { "W?W", "??B", "???" }), "Possible");
	}

	@Test
	public void testAbleToDraw1() {
		BichromeBoard app = new BichromeBoard();
		assertEquals(app.ableToDraw(new String[] { "W??W" }), "Impossible");
	}

	@Test
	public void testAbleToDraw2() {
		BichromeBoard app = new BichromeBoard();
		assertEquals(app.ableToDraw(new String[] { "??" }), "Possible");
	}

	@Test
	public void testAbleToDraw3() {
		BichromeBoard app = new BichromeBoard();
		assertEquals(app.ableToDraw(new String[] { "W???", "??B?", "W???", "???W" }), "Possible");
	}

	@Test
	public void testAbleToDraw4() {
		BichromeBoard app = new BichromeBoard();
		assertEquals(app.ableToDraw(new String[] { "W???", "??B?", "W???", "?B?W" }), "Impossible");
	}

	@Test
	public void testAbleToDraw5() {
		BichromeBoard app = new BichromeBoard();
		assertEquals(app.ableToDraw(new String[] { "B" }), "Possible");
	}
}
