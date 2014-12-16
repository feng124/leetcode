package oj.leetcode.tree.balanced;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;

import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class BalancedBinaryTreeTest {
	
	private final BalancedBinaryTree inst = new BalancedBinaryTree();

	@Test
	public void test() {
		
		TreeNode tree = TreeBuilder.buildBinaryTree(new String[] { "5", "4", "8", "11",
				"#", "13", "4", "7", "2", "#", "#", "#", "1" });
		boolean is_balanced = inst.isBalanced(tree);
		assertEquals(is_balanced, false);
		
		tree = TreeBuilder.buildBinaryTree(new String[] {"5", "4", "#"});
		is_balanced = inst.isBalanced(tree);
		assertEquals(is_balanced, true);
		
		tree = TreeBuilder.buildBinaryTree(new String[] {"5", "#", "4"});
		is_balanced = inst.isBalanced(tree);
		assertEquals(is_balanced, true);
		
		tree = TreeBuilder.buildBinaryTree(new String[] {"5", "4", "#", "#", "3"});
		is_balanced = inst.isBalanced(tree);
		assertEquals(is_balanced, false);
		
	}

}
