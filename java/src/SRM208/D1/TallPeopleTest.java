package SRM208.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TallPeopleTest {

    @Test
    public void test() {
	TallPeople app = new TallPeople();
	assertArrayEquals(new int[] { 4, 7 },
		app.getPeople(new String[] { "9 2 3", "4 8 7" }));
    }

    @Test
    public void test1() {
	TallPeople app = new TallPeople();
	assertArrayEquals(new int[] { 4, 4 },
		app.getPeople(new String[] { "1 2", "4 5", "3 6" }));
    }

    @Test
    public void test2() {
	TallPeople app = new TallPeople();
	assertArrayEquals(new int[] { 1, 1 },
		app.getPeople(new String[] { "1 1", "1 1" }));
    }

}
