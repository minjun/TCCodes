package SRM233.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SmartWordToyTest {

    @Test
    public void test() {
	SmartWordToy app = new SmartWordToy();
	assertEquals(
		app.minPresses("aaaa", "zzzz", new String[] { "a a a z",
			"a a z a", "a z a a", "z a a a", "a z z z", "z a z z",
			"z z a z", "z z z a" }), 8);
    }

     @Test
     public void test1() {
     SmartWordToy app = new SmartWordToy();
     assertEquals(app.minPresses("aaaa", "bbbb", new String[] {}), 4);
     }
    
     @Test
     public void test3() {
     SmartWordToy app = new SmartWordToy();
     assertEquals(
     app.minPresses("aaaa", "zzzz", new String[] { "bz a a a",
     "a bz a a", "a a bz a", "a a a bz" }), -1);
     }
    
     @Test
     public void test2() {
     SmartWordToy app = new SmartWordToy();
     assertEquals(app.minPresses("aaaa", "mmnn", new String[] {}), 50);
     }
    
     @Test
     public void test4() {
     SmartWordToy app = new SmartWordToy();
     assertEquals(
     app.minPresses("aaaa", "zzzz", new String[] {
     "cdefghijklmnopqrstuvwxyz a a a",
     "a cdefghijklmnopqrstuvwxyz a a",
     "a a cdefghijklmnopqrstuvwxyz a",
     "a a a cdefghijklmnopqrstuvwxyz" }), 6);
     }
    
     @Test
     public void test5() {
     SmartWordToy app = new SmartWordToy();
     assertEquals(
     app.minPresses("aaaa", "bbbb", new String[] { "b b b b" }), -1);
     }
    
     @Test
     public void test6() {
     SmartWordToy app = new SmartWordToy();
     assertEquals(
     app.minPresses("zzzz", "aaaa", new String[] {
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
     "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk" }),
     -1);
     }
}
