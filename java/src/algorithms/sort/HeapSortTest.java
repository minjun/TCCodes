package algorithms.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapSortTest {

	@Test
	public void test() {
		HeapSort app = new HeapSort();
		assertArrayEquals(app.sort(new int[]{3,2,5,4,6,1}),new int[]{1,2,3,4,5,6});
	}

}
