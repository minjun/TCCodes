package SRM601.D2;

import static org.junit.Assert.*;

import org.junit.Test;

public class WinterAndReindeersTest {

//    @Test
//    public void test() {
//	WinterAndReindeers app = new WinterAndReindeers();
//	assertEquals(1, app.getNumber(new String[] { "X" }, new String[] { "X",
//		"Y" }, new String[] { "X" }));
//    }

    @Test
    public void test1() {
	WinterAndReindeers app = new WinterAndReindeers();
	assertEquals(3, app.getNumber(new String[] { "ABCXD" },
		new String[] { "BCDEF" }, new String[] { "CD" }));
    }

//    @Test
//    public void test2() {
//	WinterAndReindeers app = new WinterAndReindeers();
//	assertEquals(
//		0,
//		app.getNumber(new String[] { "WE", "LOVE" }, new String[] {
//			"WORKING", "FOR", "SANTA" }, new String[] { "JK" }));
//    }
//
//    @Test
//    public void test3() {
//	WinterAndReindeers app = new WinterAndReindeers();
//	assertEquals(2, app.getNumber(new String[] { "ABCDE" },
//		new String[] { "CDEAB" }, new String[] { "B" }));
//    }
//
//    @Test
//    public void test4() {
//	WinterAndReindeers app = new WinterAndReindeers();
//	assertEquals(23, app.getNumber(new String[] {
//		"ABCABDEGAXAHDJBAAHFJDXBB", "ABHFHCDALFDJDBBA", "BABBAXAXXX" },
//		new String[] { "ABLOCBAXBAHAJDXBIJKA", "JBABCDAHKFIUDALPJAH",
//			"AABACX" }, new String[] { "AXBADXBBAB", "CDD" }));
//    }

}
