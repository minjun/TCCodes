package InterviewQuestions.catalan;

import static org.junit.Assert.*;

import org.junit.Test;

public class CatalanTest {

    @Test
    public void test() {
	Catalan app = new Catalan();
	app.twelvepeople(0, 0);
	assertEquals(132,app.getNumber());
    }

}
