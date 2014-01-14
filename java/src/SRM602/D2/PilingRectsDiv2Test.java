package SRM602.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PilingRectsDiv2Test {

    @Test
    public void test() {
	PilingRectsDiv2 app = new PilingRectsDiv2();
	assertEquals(app.getmax(new int[] { 1, 2, 3, 1 }, new int[] { 3, 2, 4,
		4 }, 3), 3);
    }

    @Test
    public void test5() {
	PilingRectsDiv2 app = new PilingRectsDiv2();
	assertEquals(
		app.getmax(new int[] { 121, 168, 86, 106, 36, 10, 125, 97, 53,
			26, 148, 129, 41, 18, 173, 55, 13, 73, 91, 174, 177,
			190, 28, 164, 122, 92, 5, 26, 58, 188, 14, 67, 48, 196,
			41, 94, 24, 89, 54, 117, 12, 6, 155, 103, 200, 128,
			184, 29, 92, 149 }, new int[] { 199, 182, 43, 191, 2,
			145, 15, 53, 38, 37, 61, 45, 157, 129, 119, 123, 177,
			178, 183, 188, 132, 108, 112, 137, 92, 59, 75, 196,
			102, 152, 114, 121, 181, 93, 32, 3, 24, 116, 4, 163,
			96, 159, 196, 43, 59, 150, 79, 113, 20, 146 }, 5345),
		24);
    }

}
