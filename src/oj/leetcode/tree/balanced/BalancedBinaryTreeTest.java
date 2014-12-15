package oj.leetcode.tree.balanced;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class BalancedBinaryTreeTest {
	
	private final BalancedBinaryTree inst = new BalancedBinaryTree();

	@Test
	public void test() {
		
		TreeNode tree = buildBinaryTree(new String[] { "5", "4", "8", "11",
				"#", "13", "4", "7", "2", "#", "#", "#", "1" });
		boolean is_balanced = inst.isBalanced(tree);
		assertEquals(is_balanced, false);
		
		tree = buildBinaryTree(new String[] {"5", "4", "#"});
		is_balanced = inst.isBalanced(tree);
		assertEquals(is_balanced, true);
		
		tree = buildBinaryTree(new String[] {"5", "#", "4"});
		is_balanced = inst.isBalanced(tree);
		assertEquals(is_balanced, true);
		
		tree = buildBinaryTree(new String[] {"5", "4", "#", "#", "3"});
		is_balanced = inst.isBalanced(tree);
		assertEquals(is_balanced, false);
		
	}
	
	private TreeNode buildBinaryTree(String[] toks) {
		if (toks == null || toks.length == 0) {
			return null;
		}

		if (toks[0].equals("#")) {
			throw new IllegalArgumentException();
		}

		final Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(toks[0]));
		queue.addLast(root);
		for (int i = 1; i < toks.length; i += 2) {
			TreeNode cur = queue.pollFirst();
			if (!toks[i].equals("#")) {
				cur.left = new TreeNode(Integer.parseInt(toks[i]));
				queue.addLast(cur.left);
			}
			if (!toks[i + 1].equals("#")) {
				cur.right = new TreeNode(Integer.parseInt(toks[i + 1]));
				queue.addLast(cur.right);
			}

		}
		return root;
	}

}
