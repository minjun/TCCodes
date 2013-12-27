package SRM207.D2;

import static org.junit.Assert.*;
import org.junit.Test;

public class CaptureThemAllTest {

	@Test
	public void test() {
		CaptureThemAll app = new CaptureThemAll();
		assertEquals(app.fastKnight("a1", "b3", "c5"), 2);
	}

	@Test
	public void test1() {
		CaptureThemAll app = new CaptureThemAll();
		assertEquals(app.fastKnight("b1", "c3", "a3"), 3);
	}

	@Test
	public void test2() {
		CaptureThemAll app = new CaptureThemAll();
		assertEquals(app.fastKnight("a1", "a2", "b2"), 6);
	}

	@Test
	public void test3() {
		CaptureThemAll app = new CaptureThemAll();
		assertEquals(app.fastKnight("a5", "b7", "e4"), 3);
	}

	@Test
	public void test4() {
		CaptureThemAll app = new CaptureThemAll();
		assertEquals(app.fastKnight("h8", "e2", "d2"), 6);
	}

}
