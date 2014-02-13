package InterviewQuestions.BSTreeToDLList;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    void traverse(BinarySearchTreeNode head, List<Integer> list) {
	if (head == null)
	    return;
	list.add(head.value);
	traverse(head.left, list);
	traverse(head.right, list);
    }

    List<Integer> convertToList(BinarySearchTreeNode head) {
	List<Integer> list = new ArrayList<Integer>();
	traverse(head, list);
	return list;
    }

    BinarySearchTreeNode buildTree(List<Integer> list) {
	BinarySearchTreeNode head = null;
	for (int number : list) {
	    if (head == null) {
		head = new BinarySearchTreeNode();
		head.value = number;
	    } else {
		BinarySearchTreeNode newnode = new BinarySearchTreeNode();
		newnode.value = number;
		BinarySearchTreeNode parent = head;
		// along right path
		while (newnode.value > parent.value && parent.right != null) {
		    parent = parent.right;
		}
		// along left path
		while (newnode.value < parent.value && parent.left != null) {
		    parent = parent.left;
		}
		if (newnode.value < parent.value) {
		    parent.left = newnode;
		} else {
		    parent.right = newnode;
		}
	    }
	}
	return head;
    }

    BinarySearchTreeNode convertToDoubleLinkedList(BinarySearchTreeNode head) {
	if (head == null)
	    return head;
	return null;

    }
}

class BinarySearchTreeNode {
    int value;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;
}
