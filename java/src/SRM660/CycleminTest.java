package SRM660;

import static org.junit.Assert.*;

import org.junit.Test;

public class CycleminTest {

	@Test
	public void test() {
		Cyclemin app = new Cyclemin();
		assertEquals(app.bestmod("aba", 1), "aaa");
	}

	@Test
	public void test1() {
		Cyclemin app = new Cyclemin();
		assertEquals(app.bestmod("aba", 0), "aab");
	}

	@Test
	public void test2() {
		Cyclemin app = new Cyclemin();
		assertEquals(app.bestmod("bbb", 2), "aab");
	}

	@Test
	public void test3() {
		Cyclemin app = new Cyclemin();
		assertEquals(app.bestmod("sgsgaw", 1), "aasgsg");
	}

	@Test
	public void test4() {
		Cyclemin app = new Cyclemin();
		assertEquals(app.bestmod("abacaba", 1), "aaaabac");
	}

	@Test
	public void test5() {
		Cyclemin app = new Cyclemin();
		assertEquals(app.bestmod("isgbiao", 2), "aaaisgb");
	}

}
