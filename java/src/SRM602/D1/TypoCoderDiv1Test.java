package SRM602.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TypoCoderDiv1Test {

    @Test
    public void test() {
	TypoCoderDiv1 app = new TypoCoderDiv1();
	assertEquals(app.getmax(new int[] { 100, 200, 100, 1, 1 }, 2000), 3);
    }

    @Test
    public void test1() {
	TypoCoderDiv1 app = new TypoCoderDiv1();
	assertEquals(app.getmax(new int[] { 0, 0, 0, 0, 0 }, 2199), 0);
    }

    @Test
    public void test2() {
	TypoCoderDiv1 app = new TypoCoderDiv1();
	assertEquals(
		app.getmax(new int[] { 90000, 80000, 70000, 60000, 50000,
			40000, 30000, 20000, 10000 }, 0), 1);
    }

    @Test
    public void test3() {
	TypoCoderDiv1 app = new TypoCoderDiv1();
	assertEquals(
		app.getmax(new int[] { 1000000000, 1000000000, 10000, 100000,
			2202, 1 }, 1000), 4);
    }

    @Test
    public void test4() {
	TypoCoderDiv1 app = new TypoCoderDiv1();
	assertEquals(
		app.getmax(new int[] { 2048, 1024, 5012, 256, 128, 64, 32, 16,
			8, 4, 2, 1, 0 }, 2199), 0);
    }

    @Test
    public void test5() {
	TypoCoderDiv1 app = new TypoCoderDiv1();
	assertEquals(
		app.getmax(new int[] { 61, 666, 512, 229, 618, 419, 757, 217,
			458, 883, 23, 932, 547, 679, 565, 767, 513, 798, 870,
			31, 379, 294, 929, 892, 173, 127, 796, 353, 913, 115,
			802, 803, 948, 592, 959, 127, 501, 319, 140, 694, 851,
			189, 924, 590, 790, 3, 669, 541, 342, 272 }, 1223), 29);
    }

    @Test
    public void test6() {
	TypoCoderDiv1 app = new TypoCoderDiv1();
	assertEquals(
		app.getmax(new int[] { 34, 64, 43, 14, 58, 30, 2, 16, 90, 58,
			35, 55, 46, 24, 14, 73, 96, 13, 9, 42, 64, 36, 89, 42,
			42, 64, 52, 68, 53, 76, 52, 54, 23, 88, 32, 52, 28, 96,
			70, 32, 26, 3, 23, 78, 47, 23, 54, 30, 86, 32 }, 1328),
		20);
    }

}
