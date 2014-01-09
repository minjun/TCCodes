package SRM603.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SplitIntoPairsTest {

    @Test
    public void test() {
	SplitIntoPairs app = new SplitIntoPairs();
	assertEquals(0, app.makepairs(new int[] { 2, -1 }, -1));
    }

    @Test
    public void test1() {
	SplitIntoPairs app = new SplitIntoPairs();
	assertEquals(1, app.makepairs(new int[] { 1, -1 }, -1));
    }

    @Test
    public void test2() {
	SplitIntoPairs app = new SplitIntoPairs();
	assertEquals(2, app.makepairs(new int[] { -5, -4, 2, 3 }, -1));
    }

    @Test
    public void test3() {
	SplitIntoPairs app = new SplitIntoPairs();
	assertEquals(3, app.makepairs(new int[] { 5, -7, 8, -2, -5, 3 }, -7));
    }

    @Test
    public void test4() {
	SplitIntoPairs app = new SplitIntoPairs();
	assertEquals(4, app.makepairs(new int[] { 3, 4, 5, 6, 6, -6, -4, -10,
		-1, -9 }, -2));
    }

    @Test
    public void test5() {
	SplitIntoPairs app = new SplitIntoPairs();
	assertEquals(1, app.makepairs(new int[] { 1000000, 1000000 }, -5));
    }

}
