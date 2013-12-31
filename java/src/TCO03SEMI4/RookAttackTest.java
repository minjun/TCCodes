package TCO03SEMI4;

import static org.junit.Assert.*;

import org.junit.Test;

public class RookAttackTest {

    @Test
    public void test() {
	RookAttack app = new RookAttack();
	assertEquals(8, app.howMany(8, 8, new String[] {}));
    }

    @Test
    public void test1() {
	RookAttack app = new RookAttack();
	assertEquals(0,
		app.howMany(2, 2, new String[] { "0 0", "0 1", "1 1", "1 0" }));
    }

    @Test
    public void test2() {
	RookAttack app = new RookAttack();
	assertEquals(
		2,
		app.howMany(3, 3, new String[] { "0 0", "1 0", "1 1", "2 0",
			"2 1", "2 2" }));
    }

    @Test
    public void test3() {
	RookAttack app = new RookAttack();
	assertEquals(3, app.howMany(3, 3, new String[] { "0 0", "1 2", "2 2" }));
    }

    @Test
    public void test4() {
	RookAttack app = new RookAttack();
	assertEquals(200, app.howMany(200, 200, new String[] {}));
    }

}
