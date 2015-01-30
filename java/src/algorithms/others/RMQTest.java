package algorithms.others;

import static org.junit.Assert.*;

import org.junit.Test;

public class RMQTest {

	@Test
	public void test() {
		RMQ app = new RMQ();
		assertEquals(0,
				app.process(new int[] { 2, 4, 3, 1, 6, 7, 8, 9, 1, 7 }, 1, 1));
	}

}
