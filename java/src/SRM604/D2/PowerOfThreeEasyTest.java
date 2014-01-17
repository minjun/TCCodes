package SRM604.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerOfThreeEasyTest {

    @Test
    public void test() {
	PowerOfThreeEasy app = new PowerOfThreeEasy();
	assertEquals(app.ableToGet(1, 3), "Possible");
    }

    @Test
    public void test1() {
	PowerOfThreeEasy app = new PowerOfThreeEasy();
	assertEquals(app.ableToGet(1, 1), "Impossible");
    }

    @Test
    public void test2() {
	PowerOfThreeEasy app = new PowerOfThreeEasy();
	assertEquals(app.ableToGet(3, 0), "Impossible");
    }

    @Test
    public void test3() {
	PowerOfThreeEasy app = new PowerOfThreeEasy();
	assertEquals(app.ableToGet(1, 9), "Impossible");
    }

    @Test
    public void test4() {
	PowerOfThreeEasy app = new PowerOfThreeEasy();
	assertEquals(app.ableToGet(3, 10), "Possible");
    }

    @Test
    public void test5() {
	PowerOfThreeEasy app = new PowerOfThreeEasy();
	assertEquals(app.ableToGet(1093, 2187), "Possible");
    }

    @Test
    public void test6() {
	PowerOfThreeEasy app = new PowerOfThreeEasy();
	assertEquals(app.ableToGet(0, 0), "Possible");
    }
}
