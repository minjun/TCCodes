package SRM663;

import static org.junit.Assert.*;

import org.junit.Test;

public class ABBATest {

	@Test
	public void test() {
		ABBA app = new ABBA();
		assertEquals(app.canObtain("B", "ABBA"), "Possible");
	}

	@Test
	public void test1() {
		ABBA app = new ABBA();
		assertEquals(app.canObtain("AB", "ABB"), "Impossible");
	}

	@Test
	public void test2() {
		ABBA app = new ABBA();
		assertEquals(app.canObtain("BBAB", "ABABABABB"), "Impossible");
	}

	@Test
	public void test3() {
		ABBA app = new ABBA();
		assertEquals(app.canObtain("BBBBABABBBBBBA", "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA"), "Possible");
	}

	@Test
	public void test4() {
		ABBA app = new ABBA();
		assertEquals(app.canObtain("A", "BB"), "Impossible");
	}


}
