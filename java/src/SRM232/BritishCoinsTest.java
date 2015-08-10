package SRM232;

import static org.junit.Assert.*;

import org.junit.Test;

public class BritishCoinsTest {

	@Test
	public void test() {
		BritishCoins app = new BritishCoins();
		assertArrayEquals(app.coins(533),new int[]{2,4,5});
	}

}
