package SRM598.D1;

import static org.junit.Assert.*;
import org.junit.Test;

public class ErasingCharactersTest {
	@Test
	public void test1() {
		ErasingCharacters v = new ErasingCharacters();
		assertEquals(v.simulate("cieeilll"),"cl");
	}
	@Test
	public void test2() {
		ErasingCharacters v = new ErasingCharacters();
		assertEquals(v.simulate("topcoder"),"topcoder");
	}
	@Test
	public void test3() {
		ErasingCharacters v = new ErasingCharacters();
		String s1 = "abcdefghijklmnopqrstuvwxyyxwvutsrqponmlkjihgfedcba";
		String s = "";
		for (int i=0;i<1000;i++) {
			s += s1;
		}
		long t1 = System.currentTimeMillis();
		assertEquals(v.simulate(s),"");
		long t2 = System.currentTimeMillis();
		System.out.println("Execute ts:"+(t2-t1));
	}
	@Test
	public void test4() {
		ErasingCharacters v = new ErasingCharacters();
		assertEquals(v.simulate("bacaabaccbaaccabbcabbacabcbba"),"bacbaca");
	}
	@Test
	public void test5() {
		ErasingCharacters v = new ErasingCharacters();
		assertEquals(v.simulate("eel"),"l");
	}
}
