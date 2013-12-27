package TCO03SEMI4;

import static org.junit.Assert.*;

import org.junit.Test;

public class AvoidRoadsTest {

	@Test
	public void test() {
		AvoidRoads app = new AvoidRoads();
		assertEquals(app.numWays(6, 6, new String[] { "0 0 0 1", "6 6 5 6" }),
				252);
	}

	@Test
	public void test1() {
		AvoidRoads app = new AvoidRoads();
		assertEquals(app.numWays(1, 1, new String[] {}), 2);
	}

	@Test
	public void test2() {
		AvoidRoads app = new AvoidRoads();
		assertEquals(app.numWays(35, 31, new String[] {}), 6406484391866534976L);
	}

	@Test
	public void test3() {
		AvoidRoads app = new AvoidRoads();
		assertEquals(
				app.numWays(2, 2, new String[] { "0 0 1 0", "1 2 2 2",
						"1 1 2 1" }), 0);
	}

}
