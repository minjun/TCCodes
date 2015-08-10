package SRM232;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordFindTest {

	@Test
	public void test() {
		WordFind app = new WordFind();
		assertArrayEquals(app.findWords(new String[] { "TEST", "GOAT", "BOAT" }, new String[] { "GOAT", "BOAT", "TEST" }), new String[] { "1 0", "2 0", "0 0" });
	}

	public void test1() {
		WordFind app = new WordFind();
		assertArrayEquals(app.findWords(new String[] { "SXXX", "XQXM", "XXLA", "XXXR" }, new String[] { "SQL", "RAM" }), new String[] { "0 0", "" });
	}

	public void test2() {
		WordFind app = new WordFind();
		assertArrayEquals(
				app.findWords(new String[] { "EASYTOFINDEAGSRVHOTCJYG", "FLVENKDHCESOXXXXFAGJKEO", "YHEDYNAIRQGIZECGXQLKDBI", "DEIJFKABAQSIHSNDLOMYJIN", "CKXINIMMNGRNSNRGIWQLWOG",
						"VOFQDROQGCWDKOUYRAFUCDO", "PFLXWTYKOITSURQJGEGSPGG" }, new String[] { "EASYTOFIND", "DIAG", "GOING", "THISISTOOLONGTOFITINTHISPUZZLE" }), new String[] {
						"0 0", "1 6", "0 22" });
	}
}
