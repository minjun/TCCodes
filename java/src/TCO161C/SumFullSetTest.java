package TCO161C;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumFullSetTest {

	@Test
	public void test() {
		SumFullSet app = new SumFullSet();
		assertEquals(app.isSumFullSet(new int[]{-1,0,1}),"closed");
	}
	
	@Test
	public void test1() {
		SumFullSet app = new SumFullSet();
		assertEquals(app.isSumFullSet(new int[]{-1,1}),"not closed");
	}
	
	@Test
	public void test2() {
		SumFullSet app = new SumFullSet();
		assertEquals(app.isSumFullSet(new int[]{0,1}),"closed");
	}

	@Test
	public void test3() {
		SumFullSet app = new SumFullSet();
		assertEquals(app.isSumFullSet(new int[]{0,1,1}),"not closed");
	}

	@Test
	public void test4() {
		SumFullSet app = new SumFullSet();
		assertEquals(app.isSumFullSet(new int[]{16,0,43,43,-36,-49,-46,-16,40,34,-43,-24,13,-48,45,19,12,0,43,6,26,-23,50,28,-3,21,46,45,-32,-41,0,-27,42,19,47,-36,-21,-1,5,-21,-28,-43,23,-26,-5,21,-41,16,-37,38}),"not closed");
	}

	@Test
	public void test5() {
		SumFullSet app = new SumFullSet();
		assertEquals(app.isSumFullSet(new int[]{10}),"closed");
	}


}
