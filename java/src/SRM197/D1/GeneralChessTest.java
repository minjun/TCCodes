package SRM197.D1;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeneralChessTest {

	@Test
	public void test() {
		GeneralChess chess = new GeneralChess();
		assertArrayEquals(chess.attackPositions(new String[] { "0,0" }), new String[] { "-2,-1", "-2,1", "-1,-2",
				"-1,2", "1,-2", "1,2", "2,-1", "2,1" });
	}

	@Test
	public void test1() {
		GeneralChess chess = new GeneralChess();
		assertArrayEquals(chess.attackPositions(new String[] { "2,1", "-1,-2" }), new String[] { "0,0", "1,-1" });
	}

	@Test
	public void test2() {
		GeneralChess chess = new GeneralChess();
		assertArrayEquals(chess.attackPositions(new String[] { "0,0", "2,1" }), new String[] {});
	}

	@Test
	public void test3() {
		GeneralChess chess = new GeneralChess();
		assertArrayEquals(chess.attackPositions(new String[] { "-1000,1000", "-999,999", "-999,997" }),
				new String[] { "-1001,998" });
	}

}
