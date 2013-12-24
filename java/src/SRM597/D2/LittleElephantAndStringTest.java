package SRM597.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class LittleElephantAndStringTest {

	@Test
	public void test() {
		LittleElephantAndString app = new LittleElephantAndString();
		assertEquals(2, app.getNumber("ABC", "CBA"));
	}

	@Test
	public void test1() {
		LittleElephantAndString app = new LittleElephantAndString();
		assertEquals(-1, app.getNumber("A", "B"));
	}

	@Test
	public void test2() {
		LittleElephantAndString app = new LittleElephantAndString();
		assertEquals(3, app.getNumber("AAABBB", "BBBAAA"));
	}

	@Test
	public void test3() {
		LittleElephantAndString app = new LittleElephantAndString();
		assertEquals(25, app.getNumber("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"ZYXWVUTSRQPONMLKJIHGFEDCBA"));
	}

	@Test
	public void test4() {
		LittleElephantAndString app = new LittleElephantAndString();
		assertEquals(0, app.getNumber("A", "A"));
	}

	@Test
	public void test5() {
		LittleElephantAndString app = new LittleElephantAndString();
		assertEquals(2, app.getNumber("DCABA", "DACBA"));
	}

}
