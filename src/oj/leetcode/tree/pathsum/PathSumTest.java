package oj.leetcode.tree.pathsum;

import static org.junit.Assert.*;

import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class PathSumTest {

	private final PathSum inst = new PathSum();

	@Test
	public void test() {
		TreeNode root = TreeBuilder.buildBinaryTree(new String[] { "5", "4", "8", "11",
				"#", "13", "4", "7", "2", "#", "#", "#", "1" });
		int sum = 22;
		boolean hasPath = inst.hasPathSum(root, sum);
		assertTrue(hasPath);

		sum = 0;
		hasPath = inst.hasPathSum(root, sum);
		assertFalse(hasPath);
		
		sum = 27;
		hasPath = inst.hasPathSum(root, sum);
		assertTrue(hasPath);
		
		sum = 26;
		hasPath = inst.hasPathSum(root, sum);
		assertTrue(hasPath);
		
		sum = 18;
		hasPath = inst.hasPathSum(root, sum);
		assertTrue(hasPath);
		
		root = TreeBuilder.buildBinaryTree(new String[] {"5"});
		sum = 5;
		hasPath = inst.hasPathSum(root, sum);
		assertTrue(hasPath);
	}

}
