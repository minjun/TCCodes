package SRM599.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindPolygonsTest {

	@Test
	public void test() {
		FindPolygons app = new FindPolygons();
		assertEquals(app.minimumPolygon(4), 0.0, 0);
	}

	@Test
	public void test1() {
		FindPolygons app = new FindPolygons();
		assertEquals(app.minimumPolygon(5), -1.0, 0);
	}

	@Test
	public void test2() {
		FindPolygons app = new FindPolygons();
		assertEquals(app.minimumPolygon(12), 2.0, 0);
	}

	@Test
	public void test3() {
		FindPolygons app = new FindPolygons();
		assertEquals(app.minimumPolygon(4984), 819.0, 0);
	}
}
