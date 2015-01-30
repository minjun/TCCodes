package algorithms.others;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberTest {

    @Test
    public void test() {
	Number app = new Number();
	assertEquals(101011,app.fromDecimal(43, 2));
    }

}
