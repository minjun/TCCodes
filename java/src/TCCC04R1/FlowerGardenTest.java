package TCCC04R1;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlowerGardenTest {

	@Test
	public void test() {
		FlowerGarden app = new FlowerGarden();
		assertArrayEquals(app.getOrdering(new int[]{}, new int[]{},new int[]{}),new int[]{});
	}

}
