package InterviewQuestions.PrintMatrixClockwisely;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PrintMatrixTest {

    @Test
    public void test() {
	PrintMatrix app = new PrintMatrix();
	int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
		{ 13, 14, 15, 16 } };
	List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 4, 8, 12,
		16, 15, 14, 13, 9, 5, 6, 7, 11, 10 });
	assertEquals(app.PrintMatrixClockwisely(matrix), list);
    }

}
