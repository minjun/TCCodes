package InterviewQuestions.BSTreeToDLList;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void test() {
	BinarySearchTree app = new BinarySearchTree();
	List<Integer> list = Arrays.asList(new Integer[]{10,6,4,8,14,12,16});
	assertEquals(app.convertToList(app.buildTree(list)),list);
    }

}
