package SRM599.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimilarNames2Test {

    @Test
    public void test() {
	SimilarNames2 app = new SimilarNames2();
	assertEquals(app.count(new String[] { "kenta", "kentaro", "ken" }, 2),
		3);
    }

    @Test
    public void test1() {
	SimilarNames2 app = new SimilarNames2();
	assertEquals(app.count(new String[] { "hideo", "hideto", "hideki",
		"hide" }, 2), 6);
    }

    @Test
    public void test2() {
	SimilarNames2 app = new SimilarNames2();
	assertEquals(
		app.count(new String[] { "aya", "saku", "emi", "ayane",
			"sakura", "emika", "sakurako" }, 3), 24);
    }

    @Test
    public void test3() {
	SimilarNames2 app = new SimilarNames2();
	assertEquals(app.count(new String[] { "taro", "jiro", "hanako" }, 2), 0);
    }

    @Test
    public void test4() {
	SimilarNames2 app = new SimilarNames2();
	assertEquals(app.count(new String[] { "alice", "bob", "charlie" }, 1),
		6);
    }

    @Test
    public void test5() {
	SimilarNames2 app = new SimilarNames2();
	assertEquals(
		app.count(new String[] { "ryota", "ryohei", "ryotaro", "ryo",
			"ryoga", "ryoma", "ryoko", "ryosuke", "ciel", "lun",
			"ryuta", "ryuji", "ryuma", "ryujiro", "ryusuke",
			"ryutaro", "ryu", "ryuhei", "ryuichi", "evima" }, 3),
		276818566);
    }

}
