package SRM603.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphWalkWithProbabilitiesTest {

    @Test
    public void test() {
	GraphWalkWithProbabilities app = new GraphWalkWithProbabilities();
	assertEquals(0.5, app.findprob(new String[] { "1" }, new int[] { 1 },
		new int[] { 1 }, 0), 0.0001);
    }

    @Test
    public void test2() {
	GraphWalkWithProbabilities app = new GraphWalkWithProbabilities();
	assertEquals(0.6, app.findprob(new String[] { "11", "11" }, new int[] {
		60, 40 }, new int[] { 40, 60 }, 0), 0.0001);
    }

    @Test
    public void test3() {
	GraphWalkWithProbabilities app = new GraphWalkWithProbabilities();
	assertEquals(0.4285714285714286, app.findprob(
		new String[] { "11", "11" }, new int[] { 2, 3 }, new int[] { 3,
			4 }, 0), 0.0001);
    }

    @Test
    public void test4() {
	GraphWalkWithProbabilities app = new GraphWalkWithProbabilities();
	assertEquals(
		0.405,
		app.findprob(new String[] { "110", "011", "001" }, new int[] {
			2, 1, 10 }, new int[] { 20, 20, 10 }, 0), 0.0001);
    }

    @Test
    public void test5() {
	GraphWalkWithProbabilities app = new GraphWalkWithProbabilities();
	assertEquals(
		0.5,
		app.findprob(new String[] { "111", "111", "011" }, new int[] {
			100, 1, 1 }, new int[] { 0, 50, 50 }, 2), 0.0001);
    }

}
