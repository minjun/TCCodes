package SRM663;

import static org.junit.Assert.*;

import org.junit.Test;

public class ABBADiv1Test {

	@Test
	public void test5() {
		ABBADiv1 app = new ABBADiv1();
		assertEquals(app.canObtain("A", "BABA"), "Possible");
	}

	@Test
	public void test6() {
		ABBADiv1 app = new ABBADiv1();
		assertEquals(app.canObtain("BAAAAABAA", "BAABAAAAAB"), "Possible");
	}

	@Test
	public void test7() {
		ABBADiv1 app = new ABBADiv1();
		assertEquals(app.canObtain("A", "ABBADiv1"), "Impossible");
	}

	@Test
	public void test8() {
		ABBADiv1 app = new ABBADiv1();
		assertEquals(app.canObtain("AAABBADiv1ABB", "BAABAAABAABAABBBAAAAAABBADiv1ABBBBBBBABB"), "Possible");
	}

	@Test
	public void test9() {
		ABBADiv1 app = new ABBADiv1();
		assertEquals(app.canObtain("AAABAAABB", "BAABAAABAABAABBBAAAAAABBADiv1ABBBBBBBABB"), "Impossible");
	}
}
