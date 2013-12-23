package SRM236.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BusinessTasksTest {

    @Test
    public void test() {
	BusinessTasks app = new BusinessTasks();
	assertEquals("a", app.getTask(new String[] { "a", "b", "c", "d" }, 2));
    }

    @Test
    public void test1() {
	BusinessTasks app = new BusinessTasks();
	assertEquals("d",
		app.getTask(new String[] { "a", "b", "c", "d", "e" }, 3));
    }

    @Test
    public void test2() {
	BusinessTasks app = new BusinessTasks();
	assertEquals(
		"epsilon",
		app.getTask(new String[] { "alpha", "beta", "gamma", "delta",
			"epsilon" }, 1));
    }

    @Test
    public void test3() {
	BusinessTasks app = new BusinessTasks();
	assertEquals("a", app.getTask(new String[] { "a", "b" }, 1000));
    }

    @Test
    public void test4() {
	BusinessTasks app = new BusinessTasks();
	assertEquals(
		"n",
		app.getTask(new String[] { "a", "b", "c", "d", "e", "f", "g",
			"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "y", "z" }, 17));
    }

    @Test
    public void test5() {
	BusinessTasks app = new BusinessTasks();
	assertEquals(
		"fxjqzznvg",
		app.getTask(new String[] { "zlqamum", "yjsrpybmq", "tjllfea",
			"fxjqzznvg", "nvhekxr", "am", "skmazcey", "piklp",
			"olcqvhg", "dnpo", "bhcfc", "y", "h", "fj",
			"bjeoaxglt", "oafduixsz", "kmtbaxu", "qgcxjbfx", "my",
			"mlhy", "bt", "bo", "q" }, 9000000));
    }

}
