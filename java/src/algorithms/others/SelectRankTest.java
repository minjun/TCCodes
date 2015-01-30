package algorithms.others;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectRankTest {

    @Test
    public void test() {
	int[] arr = new int[] { 5, 4, 7, 3, 6, 1, 8, 2, 9 };
	SelectRank app = new SelectRank();
	int num = app.getRank(arr, 0, arr.length-1, 3);
	assertEquals(num,3);
    }

}

