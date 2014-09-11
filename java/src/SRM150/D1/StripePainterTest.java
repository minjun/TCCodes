package SRM150.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StripePainterTest {

	@Test
	public void test() {
		assertEquals(new StripePainter().minStrokes("RGBGR"), 3);
	}

	@Test
	public void test1() {
		assertEquals(new StripePainter().minStrokes("RGRG"), 3);
	}

	@Test
	public void test2() {
		assertEquals(new StripePainter().minStrokes("ABACADA"), 4);
	}

	@Test
	public void test3() {
		assertEquals(new StripePainter().minStrokes("AABBCCDDCCBBAABBCCDD"), 7);
	}

	@Test
	public void test4() {
		assertEquals(new StripePainter().minStrokes("BECBBDDEEBABDCADEAAEABCACBDBEECDEDEACACCBEDABEDADD"), 26);
	}

}
