package algorithms.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void test() {
		int[] arr = new int[] { 5, 4, 7, 3, 6, 1, 8, 2, 9 };
		int[] arrExp = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		QuickSort sort = new QuickSort();
		sort.sort(arr, 0, arr.length-1);
		assertArrayEquals(arr, arrExp);
	}

}
