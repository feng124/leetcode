package oj.leetcode.tree.mindepth;

import static org.junit.Assert.*;

import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class MinDepthTest {

	private final MinDepth inst = new MinDepth();

	@Test
	public void test() {

		TreeNode tree = TreeBuilder.buildBinaryTree(new String[] { "5", "4", "8", "11",
				"#", "13", "4", "7", "2", "#", "#", "#", "1" });
		int min_depth = inst.minDepth(tree);
		assertEquals(min_depth, 3);

		tree = TreeBuilder.buildBinaryTree(new String[] { "5" });
		min_depth = inst.minDepth(tree);
		assertEquals(min_depth, 1);
		
		tree = TreeBuilder.buildBinaryTree(new String[] {});
		min_depth = inst.minDepth(tree);
		assertEquals(min_depth, 3);
		
	}

}
