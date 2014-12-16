package oj.leetcode.tree.order.symmetric;

import static org.junit.Assert.*;
import oj.leetcode.tree.TreeBuilder;
import oj.leetcode.tree.TreeNode;

import org.junit.Test;

public class SymmetricTreeTest {

	private final SymmetricTree inst = new SymmetricTree();

	@Test
	public void test() {
		TreeNode tree = TreeBuilder.buildBinaryTree(new String[] { "1", "2",
				"2", "3", "4", "4", "3" });
		boolean symmetric = inst.isSymmetric(tree);
		assertTrue(symmetric);

		tree = TreeBuilder.buildBinaryTree(new String[] { "1", "2", "2", "#",
				"4", "4", "#" });
		symmetric = inst.isSymmetric(tree);
		assertTrue(symmetric);

		tree = TreeBuilder.buildBinaryTree(new String[] { "1", "2", "2", "3",
				"#", "#", "3" });
		symmetric = inst.isSymmetric(tree);
		assertTrue(symmetric);

		tree = TreeBuilder.buildBinaryTree(new String[] { "1", "2", "2", "3",
				"4", "4", "#" });
		symmetric = inst.isSymmetric(tree);
		assertFalse(symmetric);

		tree = TreeBuilder.buildBinaryTree(new String[] { "5" });
		symmetric = inst.isSymmetric(tree);
		assertTrue(symmetric);

		tree = TreeBuilder.buildBinaryTree(new String[] { "1", "2", "2", "3",
				"4", "4", "3", "#", "#", "5", "#", "#", "5" });
		symmetric = inst.isSymmetric(tree);
		assertTrue(symmetric);
	}

}
