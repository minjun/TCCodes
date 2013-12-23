package SRM209.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MedalTableTest {

    @Test
    public void test() {
	MedalTable app = new MedalTable();
	assertArrayEquals(
		new String[] { "KOR 3 1 0", "ITA 1 0 0", "TPE 0 1 1",
			"CHN 0 1 0", "JPN 0 1 0", "AUS 0 0 1", "GBR 0 0 1",
			"UKR 0 0 1" },
		app.generate(new String[] { "ITA JPN AUS", "KOR TPE UKR",
			"KOR KOR GBR", "KOR CHN TPE" }));
    }

    @Test
    public void test1() {
	MedalTable app = new MedalTable();
	assertArrayEquals(
		new String[] { "USA 1 0 0", "AUT 0 1 0", "ROM 0 0 1" },
		app.generate(new String[] { "USA AUT ROM" }));
    }

    @Test
    public void test2() {
	MedalTable app = new MedalTable();
	assertArrayEquals(
		new String[] { "AUT 1 1 1", "GER 1 1 1", "SUI 1 1 1" },
		app.generate(new String[] { "GER AUT SUI", "AUT SUI GER",
			"SUI GER AUT" }));
    }

}
