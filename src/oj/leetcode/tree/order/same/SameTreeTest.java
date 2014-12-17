package oj.leetcode.tree.order.same;

import static org.junit.Assert.*;
import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class SameTreeTest {
	
	private final SameTree inst = new SameTree();

	@Test
	public void test() {
		TreeNode left = TreeBuilder.buildBinaryTree(new String[] {"1", "2", "3", "#", "4"});
		boolean is_same = inst.isSameTree(left, left);
		assertTrue(is_same);
		
		TreeNode right = TreeBuilder.buildBinaryTree(new String[] {"1", "2", "3", "4", "#"});
		is_same = inst.isSameTree(left, right);
		assertFalse(is_same);
	}

}
