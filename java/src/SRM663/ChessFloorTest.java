package SRM663;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessFloorTest {

	@Test
	public void test() {
		ChessFloor app = new ChessFloor();
		assertEquals(app.minimumChanges(new String[] { "aba", "bbb", "aba" }), 1);
	}

	@Test
	public void test1() {
		ChessFloor app = new ChessFloor();
		assertEquals(app.minimumChanges(new String[] { "wbwbwbwb", "bwbwbwbw", "wbwbwbwb", "bwbwbwbw", "wbwbwbwb", "bwbwbwbw", "wbwbwbwb", "bwbwbwbw" }), 0);
	}

	@Test
	public void test2() {
		ChessFloor app = new ChessFloor();
		assertEquals(app.minimumChanges(new String[] { "zz", "zz" }), 2);
	}

	@Test
	public void test3() {
		ChessFloor app = new ChessFloor();
		assertEquals(app.minimumChanges(new String[] { "helloand", "welcomet", "osingler", "oundmatc", "hsixhund", "redandsi", "xtythree", "goodluck" }), 56);
	}

	@Test
	public void test4() {
		ChessFloor app = new ChessFloor();
		assertEquals(
				app.minimumChanges(new String[] { "jecjxsengslsmeijrmcx", "tcfyhumjcvgkafhhffed", "icmgxrlalmhnwwdhqerc", "xzrhzbgjgabanfxgabed", "fpcooilmwqixfagfojjq",
						"xzrzztidmchxrvrsszii", "swnwnrchxujxsknuqdkg", "rnvzvcxrukeidojlakcy", "kbagitjdrxawtnykrivw", "towgkjctgelhpomvywyb", "ucgqrhqntqvncargnhhv",
						"mhvwsgvfqgfxktzobetn", "fabxcmzbbyblxxmjcaib", "wpiwnrdqdixharhjeqwt", "xfgulejzvfgvkkuyngdn", "kedsalkounuaudmyqggb", "gvleogefcsxfkyiraabn",
						"tssjsmhzozbcsqqbebqw", "ksbfjoirwlmnoyyqpbvm", "phzsdodppzfjjmzocnge" }), 376);
	}
}
