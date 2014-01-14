package SRM602.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class BlackBoxDiv2Test {

    @Test
    public void test() {
	BlackBoxDiv2 app = new BlackBoxDiv2();
	assertEquals(app.count("BB", "BB"), 7);
    }

    @Test
    public void test1() {
	BlackBoxDiv2 app = new BlackBoxDiv2();
	assertEquals(app.count("...", "....."), 1);
    }

    @Test
    public void test2() {
	BlackBoxDiv2 app = new BlackBoxDiv2();
	assertEquals(app.count("...", "BBB"), 0);
    }

    @Test
    public void test3() {
	BlackBoxDiv2 app = new BlackBoxDiv2();
	assertEquals(app.count("...BB.B....", "B.B.B.B.B"), 16081);
    }

    @Test
    public void test4() {
	BlackBoxDiv2 app = new BlackBoxDiv2();
	assertEquals(app.count(
		"BBBBB.BBBBBBBBB.BBBBBBB.BBBB.B.BB..BB.B.BBBBBBBBBB",
		".B.BBB..BBBBBB.BBBB.B...BBBB.BB.BBBBBBBBBB.....BBB"),
		771030153);
    }

}
