package SRM603.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairsOfStringsTest {

    @Test
    public void test() {
	PairsOfStrings app = new PairsOfStrings();
	assertEquals(6, app.getNumber(2, 2));
    }

    @Test
    public void test1() {
	PairsOfStrings app = new PairsOfStrings();
	assertEquals(20, app.getNumber(3, 2));
    }

    @Test
    public void test2() {
	PairsOfStrings app = new PairsOfStrings();
	assertEquals(184, app.getNumber(3, 4));
    }

    @Test
    public void test3() {
	PairsOfStrings app = new PairsOfStrings();
	assertEquals(348, app.getNumber(6, 2));
    }

    @Test
    public void test4() {
	PairsOfStrings app = new PairsOfStrings();
	assertEquals(46519912, app.getNumber(100, 26));
    }

}
