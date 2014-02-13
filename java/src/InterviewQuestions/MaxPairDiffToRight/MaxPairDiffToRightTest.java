package InterviewQuestions.MaxPairDiffToRight;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxPairDiffToRightTest {

    @Test
    public void test() {
	MaxPairDiffToRight app = new MaxPairDiffToRight();
	assertEquals(app.MaxDiff(new int[] { 2, 4, 1, 16, 7, 5, 11, 9 }), 11);
    }

}
